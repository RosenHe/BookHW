package com.example.Employee.Controller;

import com.example.BookHW.model.CommonResponse;
import com.example.Employee.Entity.EmployeePojo;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<String> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
//
//    @GetMapping
//    public ResponseEntity<List<EmployeePojo>> getEmployeeAtAge(@RequestBody int age){
//        return new ResponseEntity<>(employeeService.getEmployeeAgeLargerThan(age), HttpStatus.OK);
//    }

}
