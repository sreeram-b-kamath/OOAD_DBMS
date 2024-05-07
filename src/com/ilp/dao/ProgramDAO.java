package com.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProgramDAO {
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
	
	public static void insertProgram(Connection connection)
	{
		PreparedStatement preparedStatement;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter program Name"); 
			String programName = scanner.nextLine();
			System.out.println("Enter program type"); 
			String programType = scanner.nextLine();
			System.out.println("Enter program date"); 
			String programDate = scanner.nextLine();
			System.out.println("Enter Host ID"); 
			int hostId = scanner.nextInt();
			System.out.println("Enter Trainer ID. -1 if not needed"); 
			int trainerIdInput = scanner.nextInt();
			Integer trainerId = null;
		    if (trainerIdInput != -1) { 
		        trainerId = trainerIdInput;
		    }
			preparedStatement = connection.prepareStatement("insert into program(program_name,program_type,program_date,host_id,trainer_id) values (?,?,?,?,?);");
			preparedStatement.setString(1, programName);
			preparedStatement.setString(2, programType);
			preparedStatement.setString(3, programDate);
			preparedStatement.setInt(4, hostId);
			if (trainerId != null) { 
		        preparedStatement.setInt(5, trainerId);
		    } else {
		        preparedStatement.setObject(5, null); 
		    }
			int resultSet=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
