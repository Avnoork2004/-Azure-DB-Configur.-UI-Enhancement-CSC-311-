package org.example.week7_csc311_hw;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    private String major;
    private String course; // New field for course
    private String profilePicturePath; // New field for the profile picture path

    public Person(Integer id, String firstName, String lastName, String dept, String major, String course, String profilePicturePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.major = major;
        this.course = course; // Initialize course
        this.profilePicturePath = profilePicturePath; // Initialize profile picture path
    }


    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCourse() {
        return course; // New getter for course
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProfilePicturePath() { // Getter for profile picture path
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) { // Setter for profile picture path
        this.profilePicturePath = profilePicturePath;
    }
}


