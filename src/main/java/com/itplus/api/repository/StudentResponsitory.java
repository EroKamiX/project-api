package com.itplus.api.repository;

import com.itplus.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentResponsitory extends JpaRepository<Student, Long> {

    Student findByMasvAllIgnoreCase(String masv);

    @Query("SELECT st FROM Student st JOIN st.course c JOIN st.department d")
    List<Student> findAll();
}
