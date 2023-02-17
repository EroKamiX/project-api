package com.itplus.api.service;

import com.itplus.api.model.Student;
import com.itplus.api.repository.StudentResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private StudentResponsitory studentResponsitory;

    public StudentService() {
    }

    @Autowired
    public StudentService(StudentResponsitory studentResponsitory) {
        this.studentResponsitory = studentResponsitory;
    }

    public Optional<Student> findById(long id) {
        return  studentResponsitory.findById(id);
    }

    public void save(Student st){
        studentResponsitory.save(st);
    }

    public void update(Student st){
        studentResponsitory.save(st);
    }

    public void delete(long id){
       studentResponsitory.deleteById(id);
    }

    public Student findByMasvAllIgnoreCase(String masv){
       return this.studentResponsitory.findByMasvAllIgnoreCase(masv);
    }

    public List<Student> findAll(){
        return studentResponsitory.findAll();
    }
}
