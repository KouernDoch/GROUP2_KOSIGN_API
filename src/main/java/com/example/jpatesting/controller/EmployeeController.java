package com.example.jpatesting.controller;

import com.example.jpatesting.entity.EmployeeEntity;
import com.example.jpatesting.service.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeEntity> findAllEmployee(){
        return employeeService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeByid(@PathVariable("id") int id){
        return employeeService.findByid(id);
    }
    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity){
     return employeeService.saveEmployee(employeeEntity);
    }
    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.updateEmployee(employeeEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
         employeeService.deleteEmployee(id);
    }
}
