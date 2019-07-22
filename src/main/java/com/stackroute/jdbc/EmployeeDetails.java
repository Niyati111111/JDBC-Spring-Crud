package com.stackroute.jdbc;

public class EmployeeDetails {

    String name;
    int id;
    int salary;
    String gender;

    public EmployeeDetails() {

    }

    public EmployeeDetails(String name, int id, int salary, String gender) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
