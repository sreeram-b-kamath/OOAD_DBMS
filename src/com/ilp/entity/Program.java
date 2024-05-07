package com.ilp.entity;

import java.sql.Date;

public class Program {
	
	private int programId;
    private String programName;
    private String programType;
    private Date programDate;
    private int hostId;
    private Trainer trainer;
	public Program(int programId, String programName, String programType, Date programDate, int hostId,
			Trainer trainer) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.programType = programType;
		this.programDate = programDate;
		this.hostId = hostId;
		this.trainer = trainer;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public Date getProgramDate() {
		return programDate;
	}
	public void setProgramDate(Date programDate) {
		this.programDate = programDate;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

    
    

}
