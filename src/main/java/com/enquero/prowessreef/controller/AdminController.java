package com.enquero.prowessreef.controller;

import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/")
public class AdminController {


  @Autowired
  EmployeeService employeeService;

  @PostMapping("employee")
  public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
    employeeService.createUser(employee);
    return new ResponseEntity<>(HttpStatus.OK);
  }



  @DeleteMapping("{emp_id}/or/{name}")
  public ResponseEntity<Void> remove(@PathVariable("emp_id") Integer userId, @PathVariable("name") String name) {
    employeeService.removeUser(userId, name);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}
