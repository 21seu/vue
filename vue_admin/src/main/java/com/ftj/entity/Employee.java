package com.ftj.entity;

public class Employee {

    private long id;
    private String name;
    private double salary;
    private int age;
    private String desc;

    public Employee() {
    }

    public Employee(long id, String name, double salary, int age, String desc) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
