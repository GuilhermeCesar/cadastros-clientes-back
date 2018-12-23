package com.essencia.dto;

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
