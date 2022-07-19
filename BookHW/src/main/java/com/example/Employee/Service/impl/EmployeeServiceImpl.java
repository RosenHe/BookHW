package com.example.Employee.Service.impl;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Entity.EmployeePojo;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final RestTemplate restTemplate;
    private String employeeDataURL = "https://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    public EmployeeServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmployeePojo callRestService() {
        return restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
    }

    @Override
    public List<EmployeePojo> getAllEmployee() {
        EmployeePojo employeePojo = restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
//        List<EmployeePojo> employeePojoList =
        return employeePojoList;
    }
//    @Override
//    public String getAllEmployee() {
//        EmployeePojo employeePojo = restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
//        String res = employeePojo.toString();
//        return res;
//    }

    @Override
    public List<EmployeePojo> getEmployeeAgeLargerThan(int age) {
        return null;
    }
}
