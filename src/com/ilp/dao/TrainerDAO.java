package com.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TrainerDAO {
	
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
	
	public static void insertTrainers(Connection connection)
	{
		PreparedStatement preparedStatement;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter trainer first name"); 
			String trainerFirstName = scanner.nextLine();
			System.out.println("Enter trainer last name"); 
			String trainerLastName = scanner.nextLine();
			System.out.println("Enter Trainer Employee ID(optional)"); 
			int trainerIdInput = scanner.nextInt();
			Integer trainerId = null;
		    if (trainerIdInput != -1) { 
		        trainerId = trainerIdInput;
		    }
			preparedStatement = connection.prepareStatement("insert into trainer (trainer_firstname,trainer_lastname,emp_id) values(?,?,?);");
			preparedStatement.setString(1, trainerFirstName);
			preparedStatement.setString(2, trainerLastName);
			if (trainerId != null) { 
		        preparedStatement.setInt(3, trainerId);
		    } else {
		        preparedStatement.setObject(3, null); 
		    }
			int resultSet=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
