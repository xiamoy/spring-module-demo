package com.example.web.demo.entity;

public class User {
    String name;
    double salary;
    int age;
    boolean newEmployee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(boolean newEmployee) {
        this.newEmployee = newEmployee;
    }
}
