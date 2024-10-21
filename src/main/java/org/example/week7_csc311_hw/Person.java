package org.example.week7_csc311_hw;

public class Person {
    private Integer id; // Unique identifier for the person
    private String firstName; // First name of the person
    private String lastName; // Last name of the person
    private String dept; // Department of the person
    private String major; // Major field of study of the person
    private String course; // New field for course
    private String profilePicturePath; // New field for the profile picture path

    // Constructor to initialize Person object
    public Person(Integer id, String firstName, String lastName, String dept, String major, String course, String profilePicturePath) {
        this.id = id; // Set the unique identifier
        this.firstName = firstName; // Initialize first name
        this.lastName = lastName; // Initialize last name
        this.dept = dept; // Initialize department
        this.major = major; // Initialize major
        this.course = course; // Initialize course
        this.profilePicturePath = profilePicturePath; // Initialize profile picture path
    }

    // Getters and setters
    public Integer getId() {
        return id; // Return the unique identifier
    }

    public void setId(Integer id) {
        this.id = id; // Set the unique identifier
    }

    public String getFirstName() {
        return firstName; // Return the first name
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; // Set the first name
    }

    public String getLastName() {
        return lastName; // Return the last name
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; // Set the last name
    }

    public String getMajor() {
        return major; // Return the major field of study
    }

    public void setMajor(String major) {
        this.major = major; // Set the major field of study
    }

    public String getDept() {
        return dept; // Return the department
    }

    public void setDept(String dept) {
        this.dept = dept; // Set the department
    }

    public String getCourse() {
        return course; // New getter for course
    }

    public void setCourse(String course) {
        this.course = course; // New setter for course
    }

    public String getProfilePicturePath() { // Getter for profile picture path
        return profilePicturePath; // Return the profile picture path
    }

    public void setProfilePicturePath(String profilePicturePath) { // Setter for profile picture path
        this.profilePicturePath = profilePicturePath; // Set the profile picture path
    }
}

