package com.example.Employee.Service;


import com.example.BookHW.model.CommonResponse;
import com.example.Employee.Entity.EmployeePojo;

import java.util.List;

public interface EmployeeService {
    EmployeePojo  callRestService();

    CommonResponse getAllEmployee();
//    String getAllEmployee();
    CommonResponse  getEmployeeAgeLargerThan(int age);
}
