package com.ilp.entity;

public class Feedback {

	private int feedbackId;
    private Program program;
    private Employee employee;
    private Trainer trainer;
    private String feedback;
	public Feedback(int feedbackId, Program program, Employee employee, String feedback, Trainer trainer) {
		super();
		this.feedbackId = feedbackId;
		this.program = program;
		this.employee = employee;
		this.feedback = feedback;
		this.trainer = trainer;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
    
    
}
