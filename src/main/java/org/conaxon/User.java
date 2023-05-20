package org.conaxon;

import java.time.LocalDate;

public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private LocalDate birthDate;
    private int height;
    private int weight;
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String eyeColor;

    // Constructors, getters, and setters
    public User() {
    }

    public User(String userId, String password, String firstName, String lastName, String middleInitial,
                LocalDate birthDate, int height, int weight, int zipCode, String address, String city,
                String state, String eyeColor) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.eyeColor = eyeColor;
    }

    // Getters and setters for the fields

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
}

