package com.example.Employee.Service;


import com.example.Employee.Entity.EmployeePojo;

import java.util.List;

public interface EmployeeService {
    EmployeePojo  callRestService();

    List<EmployeePojo> getAllEmployee();
//    String getAllEmployee();
    List<EmployeePojo>  getEmployeeAgeLargerThan(int age);
}
