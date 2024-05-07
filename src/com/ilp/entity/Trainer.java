package com.ilp.entity;

public class Trainer {

	private int trainerId;
    private String trainerFirstName;
    private String trainerLastName;
    private Employee employee;
	public Trainer(int trainerId, String trainerFirstName, String trainerLastName, Employee employee) {
		super();
		this.trainerId = trainerId;
		this.trainerFirstName = trainerFirstName;
		this.trainerLastName = trainerLastName;
		this.employee = employee;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerFirstName() {
		return trainerFirstName;
	}
	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}
	public String getTrainerLastName() {
		return trainerLastName;
	}
	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
}
