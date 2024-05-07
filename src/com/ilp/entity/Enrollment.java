package com.ilp.entity;

import java.sql.Date;

public class Enrollment {
	
	private Program program;
    private Employee employee;
    private String attendance;
    private Date enrollmentDate;
	public Enrollment(Program program, Employee employee, String attendance, Date enrollmentDate) {
		super();
		this.program = program;
		this.employee = employee;
		this.attendance = attendance;
		this.enrollmentDate = enrollmentDate;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
    

}
