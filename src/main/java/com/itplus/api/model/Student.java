package com.itplus.api.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "masv",unique = true)
	private String masv;

	@Column(name = "tenSV")
	private String tenSV;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phone_number;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Department.class)
	@JoinColumn(name = "id_department")
	private Department department;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity =  Course.class)
	@JoinColumn(name = "id_course")
	private Course course;

	@Column(name = "quequan")
	private String quequan;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "status")
	private int status;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "created_by")
	private long created_by;

	@Column(name = "created_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp()")
	private Date created_at;

	@Column(name = "updated_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()")
	private Date updated_at;

	@Autowired
	public Student(long id, String masv, String tenSV, String email, String phone_number, Department department, Course course, String quequan, String avatar, int status, Date birthday, long created_by, Date created_at, Date updated_at) {
		this.id = id;
		this.masv = masv;
		this.tenSV = tenSV;
		this.email = email;
		this.phone_number = phone_number;
		this.department = department;
		this.course = course;
		this.quequan = quequan;
		this.avatar = avatar;
		this.status = status;
		this.birthday = birthday;
		this.created_by = created_by;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Student() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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


}
