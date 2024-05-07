package com.ilp.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ilp.dao.FeedbackDAO;
import com.ilp.dao.ProgramDAO;
import com.ilp.dao.TrainerDAO;

public class TrainerServiceImpl implements TrainerService {

	@Override
	public void insertTrainers() {
		// TODO Auto-generated method stub
		try {
			Connection connection = TrainerDAO.getConnection();
			TrainerDAO.insertTrainers(connection);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
		
	}

}
