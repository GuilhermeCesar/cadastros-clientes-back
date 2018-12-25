package com.essencia.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class CustomerDto implements Serializable {

    private String fullName;
    private String socialId;
    private Integer age;
    private String gener;
    private String civilStatus;
    private String state;
    private Integer dependents;
    private String salary;
    private MultipartFile image;

    public CustomerDto(String fullName, String socialId, Integer age, String gener) {
        this.fullName = fullName;
        this.socialId = socialId;
        this.age = age;
        this.gener = gener;
    }

    public CustomerDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "fullName='" + fullName + '\'' +
                ", socialId='" + socialId + '\'' +
                ", age=" + age +
                ", gener=" + gener +
                ", civilStatus='" + civilStatus + '\'' +
                ", state='" + state + '\'' +
                ", dependents=" + dependents +
                ", salary='" + salary + '\'' +
                '}';
    }
}
