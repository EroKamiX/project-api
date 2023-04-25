package com.itplus.api.service;

import com.itplus.api.model.Department;
import com.itplus.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DepartmentService implements Services<Department> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void delete(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
