package com.example.Employee.Entity;


import java.util.List;

public class EmployeePojo {
    public String status;
    public List<Employee> data;
    public String message;

    public EmployeePojo(String status, List<Employee> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public EmployeePojo() {
    }

    @Override
    public String toString() {
        return "EmployeePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
