package com.itplus.api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tenKhoa")
    private String tenKhoa;

    @Column(name = "status")
    private int status;

    @Column(name = "created_by")
    private long created_by;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp()")
    private Date created_at;

    @Column(name = "updated_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()")
    private Date updated_at;

    @JsonBackReference
    @OneToMany(cascade = {CascadeType.MERGE , CascadeType.PERSIST}, mappedBy = "department")
    private Set<Student> student = new HashSet<>();

    public Department() {
    }


    @Autowired
    public Department(long id, String tenKhoa, int status, long created_by, Date created_at, Date updated_at, Set<Student> student) {
        this.id = id;
        this.tenKhoa = tenKhoa;
        this.status = status;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(long created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }
}
