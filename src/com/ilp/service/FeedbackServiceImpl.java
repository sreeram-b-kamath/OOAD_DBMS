package com.ilp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.dao.FeedbackDAO;
import com.ilp.entity.Feedback;

public class FeedbackServiceImpl implements FeedbackService {

	@Override
	public void getAllFeedbacksOfEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Enter employee Name");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		try {
			Connection connection = FeedbackDAO.getConnection();
			ArrayList<Feedback> feedbackList = FeedbackDAO.getAllFeedbacksOfEmployee(connection,choice);
			for(Feedback feedback : feedbackList)
			{
				System.out.println("---------------------------------------------------------------------");
				if(feedback.getTrainer() == null)
				{
					System.out.println("Employee Name :" + feedback.getEmployee().getEmpFirstName());
					System.out.println("Program Name :" + feedback.getProgram().getProgramName());
					System.out.println("Feedback :" + feedback.getFeedback());
					System.out.println("Trainer Name :" + "NULL");
				}
				else 
				{
					System.out.println("Employee Name :" + feedback.getEmployee().getEmpFirstName());
					System.out.println("Program Name :" + feedback.getProgram().getProgramName());
					System.out.println("Feedback :" + feedback.getFeedback());
					System.out.println("Trainer Name :" + feedback.getTrainer().getTrainerFirstName());
				}
					
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

	}

	@Override
	public void insertFeedbacks() {
		// TODO Auto-generated method stub
				try {
			Connection connection = FeedbackDAO.getConnection();
			FeedbackDAO.insertFeedbacks(connection);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
		
	}

	@Override
	public void getAllFeedbacksOfTrainers() {
		// TODO Auto-generated method stub
		System.out.println("Enter trainer Name");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		try {
			Connection connection = FeedbackDAO.getConnection();
			ArrayList<Feedback> feedbackList = FeedbackDAO.getAllFeedbacksOfTrainers(connection,choice);
			for(Feedback feedback : feedbackList)
			{
				System.out.println("---------------------------------------------------------------------");
				
					System.out.println("Trainer Name : " +feedback.getTrainer().getTrainerFirstName() );
					System.out.println("Program Name : "+feedback.getProgram().getProgramName() );
					System.out.println("Feedback : "+ feedback.getFeedback());
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
}
