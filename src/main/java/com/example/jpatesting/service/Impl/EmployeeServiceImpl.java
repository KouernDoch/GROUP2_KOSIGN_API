package com.example.jpatesting.service.Impl;

import com.example.jpatesting.entity.EmployeeEntity;
import com.example.jpatesting.repository.EmployeeRepository;
import com.example.jpatesting.service.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private  final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public Optional<EmployeeEntity> findByid(int id) {
        return employeeRepository.findById((long) id);
    }
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {

        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(int id) {
     employeeRepository.deleteById((long) id);
    }
}
