package com.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Employee;
import com.ilp.entity.Feedback;
import com.ilp.entity.Program;
import com.ilp.entity.Trainer;

public class FeedbackDAO {

	public static Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/feedback?useSSL=false";
		String userName = "root";
		String passWord = "Veena@1234";
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connectionString, userName, passWord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Feedback> getAllFeedbacksOfEmployee(Connection connection, String Name )
	{
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("select employee.emp_firstname, program.program_name, feedback.feedback,  trainer.trainer_firstname from feedback inner join employee on feedback.emp_id = employee.emp_id inner join program on program.program_id = feedback.program_id left outer join trainer on\r\n"
					+ "trainer.trainer_id = program.trainer_id where employee.emp_firstname = ?;");
			preparedStatement.setString(1, Name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String empFirstName = resultSet.getString(1);
				String programName = resultSet.getString(2);
				String feedback = resultSet.getString(3);
				String trainerFirstName = resultSet.getString(4);
				
				Employee employee = new Employee(0, null, null, null);
				employee.setEmpFirstName(empFirstName);
				Trainer trainer = new Trainer(0, null, null, null);
				trainer.setTrainerFirstName(trainerFirstName);
				Program program = new Program(0,null,null,null, 0, null);
				program.setProgramName(programName);
				Feedback feedback1 = new Feedback(0, program, employee, feedback, trainer);
				feedbackList.add(feedback1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feedbackList;
		
	}
	
	public static void insertFeedbacks(Connection connection)
	{
		PreparedStatement preparedStatement;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter program ID"); 
			int programId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter employee ID"); 
			int empId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Feedback"); 
			String feedback = scanner.nextLine();
			preparedStatement = connection.prepareStatement("insert into feedback (program_id,emp_id,feedback) values (?,?,?);");
			preparedStatement.setInt(1, programId);
			preparedStatement.setInt(2, empId);
			preparedStatement.setString(3, feedback);
			int resultSet=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	public static ArrayList<Feedback> getAllFeedbacksOfTrainers(Connection connection, String Name)
	{
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(" select trainer.trainer_firstname, program.program_name, feedback.feedback from feedback inner join program on feedback.program_id = program.program_id inner join trainer on trainer.trainer_id = program.trainer_id where trainer.trainer_firstname = ?;");
			preparedStatement.setString(1, Name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String trainerFirstName = resultSet.getString(1);
				String programName = resultSet.getString(2);
				String feedback = resultSet.getString(3);

				Trainer trainer = new Trainer(0, null, null, null);
				trainer.setTrainerFirstName(trainerFirstName);
				Program program = new Program(0,null,null,null, 0, null);
				program.setProgramName(programName);
				Feedback feedback1 = new Feedback(0, program, null, feedback, trainer);
				feedbackList.add(feedback1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feedbackList;
		
	}
}
