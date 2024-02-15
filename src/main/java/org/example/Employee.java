package org.example;


public class Employee {
    private static int idCounter = 1;
    private int id;
    private String fullName;
    private int department;
    private double salary;


    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Сотрудник{id=" + id + ", Ф.И.О: '" + fullName + '\'' + ", Отдел:"  + department + ", Зарплата: " + salary + '}';
    }
}

