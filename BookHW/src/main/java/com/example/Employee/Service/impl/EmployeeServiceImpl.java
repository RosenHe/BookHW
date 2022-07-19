package com.example.Employee.Service.impl;

import com.example.BookHW.model.CommonResponse;
import com.example.Employee.Entity.Employee;
import com.example.Employee.Entity.EmployeePojo;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final RestTemplate restTemplate;
    private final String  employeeDataURL = "https://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    public EmployeeServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmployeePojo callRestService() {
        return restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
    }

    @Override
    public CommonResponse getAllEmployee() {
        CommonResponse response = new CommonResponse();
        EmployeePojo employeePojo = restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
        response.setData(employeePojo.data);
        return response;
    }


    @Override
    public CommonResponse getEmployeeAgeLargerThan(int age) {
        CommonResponse response = new CommonResponse();
        System.out.println("Print out age222222222: "+ age);
        EmployeePojo employeePojo = restTemplate.getForObject(employeeDataURL, EmployeePojo.class);
        List<Employee> employeeList = employeePojo.data.stream().filter(employee ->
            employee.getEmployee_age() > age
        ).collect(Collectors.toList());
        response.setData(employeeList);
//        List<Employee> employeeList = employeePojo.data.stream().toList();
//        List<Employee> employees = new ArrayList<>();
//        for(Employee employee : employeeList){
//            if(employee.getEmployee_age() > age){
//                employees.add(employee);
//            }
//        }
//        response.setData(employees);
        return response;
    }
}
