package com.GetPostApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_DTLS")
public class Student {


	@Id	
   @Column(name="STUDENT_ID")
	private Integer studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@Column(name="STUDENT_EMAIL")
	private String studentEmail;
	
	@Column(name="STUDENT_AGE")
	private Integer studentAge;

public Student(Integer studentId, String studentName, String studentEmail, Integer studentAge) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAge = studentAge;
	}
	
	public Student() {
		
	}

	

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	
	
}
