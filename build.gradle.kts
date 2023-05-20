plugins {
    id("java")
}

group = "org.conaxon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Azure Cosmos DB SDK
    implementation ("com.azure:azure-cosmos:4.20.0")
    implementation("junit:junit:4.13.2")
    testImplementation("junit:junit:4.13.2")
    implementation("com.microsoft.azure:azure-storage:8.6.6")
    implementation ("org.springframework.boot:spring-boot-starter-web:2.5.0")
    implementation ("com.azure:azure-storage-blob:12.13.0")
    implementation ("commons-io:commons-io:2.11.0")
    implementation ("org.springframework:spring-webmvc:5.3.9")
    implementation ("org.springframework:spring-web:5.3.9")
    testImplementation("org.testng:testng:7.4.0")
    implementation("org.testng:testng:7.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    implementation("com.azure:azure-cosmos:4.19.1")
    implementation("org.springframework.boot:spring-boot-starter-data-cosmosdb")
    implementation("com.azure:azure-cosmos-bridge:4.18.0")
}

tasks.test {
    useJUnitPlatform()
}