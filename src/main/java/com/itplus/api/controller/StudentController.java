package com.itplus.api.controller;


import com.itplus.api.exceptions.BindingErrorsResponse;
import com.itplus.api.model.Student;
import com.itplus.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("Duplicates")
@RestController
@RequestMapping(value = "/api/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

    private StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentController() {
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> allStudent = studentService.findAll();
        if (allStudent == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (allStudent.isEmpty())
            return new ResponseEntity<>(allStudent, HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return studentService.findById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-masv/{masv}")
    public ResponseEntity<Student> getStudentByMaSV(@PathVariable String masv) {
        Student student = studentService.findByMasvAllIgnoreCase(masv);
        if (student == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

// Tìm kiếm đầu ra là một mảng
//    @GetMapping("/by-something/{something}")
//    public ResponseEntity<List<Book>> getAllBooksByTopicId(@PathVariable Long[] somethings) {
//        List<Student> allStudentSomeThing = new ArrayList<>();
//        for (Long something : somethings) {
//            List<Student> studentBySomeThing = studentService.findBySomeThing(something);
//            if (!studentBySomeThing.isEmpty())
//                allStudentSomeThing.addAll(studentBySomeThing);
//        }
//        if (allStudentSomeThing.isEmpty())
//            return new ResponseEntity<>(allStudentSomeThing, HttpStatus.NO_CONTENT);
//        return new ResponseEntity<>(allStudentSomeThing, HttpStatus.OK);
//    }


    @PostMapping("")
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student, BindingResult bindingResult,
                                            UriComponentsBuilder uriComponentsBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (student == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        studentService.save(student);
        headers.setLocation(uriComponentsBuilder.path("api/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody @Valid Student student,
                                           BindingResult bindingResult) {
        Optional<Student> currentStudent = studentService.findById(id);
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (student == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
        if (!currentStudent.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        studentService.update(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Optional<Student> bookToDelete = studentService.findById(id);
        if (!bookToDelete.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        studentService.delete(id);
        return new ResponseEntity<>(bookToDelete.get(), HttpStatus.OK);

    }
 }
