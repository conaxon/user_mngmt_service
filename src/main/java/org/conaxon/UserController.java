package org.conaxon;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.PartitionKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CosmosClient cosmosClient;
    private final CosmosContainer container;

    public UserController() {
        cosmosClient = new CosmosClientBuilder()
                .endpoint("YOUR_COSMOS_DB_ENDPOINT")
                .key("YOUR_COSMOS_DB_KEY")
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();

        CosmosDatabase database = cosmosClient.getDatabase("YOUR_COSMOS_DB_NAME");
        container = database.getContainer("YOUR_CONTAINER_NAME");
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (user.getUserId() == null || user.getUserId().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getFirstName() == null || user.getFirstName().isEmpty() ||
                user.getLastName() == null || user.getLastName().isEmpty()) {
            return ResponseEntity.badRequest().body("User ID, password, first name, and last name are required.");
        }

        try {
            User existingUser = container.readItem(user.getUserId(), new PartitionKey(user.getUserId()), User.class).getItem();
            if (existingUser != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User with the same ID already exists.");
            }

            CosmosItemResponse<User> response = container.createItem(user);
            if (response.getStatusCode() == HttpStatus.CREATED.value()) {
                return ResponseEntity.ok("User created successfully.");
            }
        } catch (CosmosException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user.");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
        if (userId == null || userId.isEmpty() ||
                updatedUser.getUserId() == null || updatedUser.getUserId().isEmpty() ||
                updatedUser.getPassword() == null || updatedUser.getPassword().isEmpty() ||
                updatedUser.getFirstName() == null || updatedUser.getFirstName().isEmpty() ||
                updatedUser.getLastName() == null || updatedUser.getLastName().isEmpty()) {
            return ResponseEntity.badRequest().body("User ID, password, first name, and last name are required.");
        }

        if (!userId.equals(updatedUser.getUserId())) {
            return ResponseEntity.badRequest().body("User ID cannot be changed.");
        }

        try {
            CosmosItemResponse<User> response = container.upsertItem(updatedUser);
            if (response.getStatusCode() == HttpStatus.OK.value()) {
                return ResponseEntity.ok("User updated successfully.");
            }
        } catch (CosmosException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user.");
    }
}

