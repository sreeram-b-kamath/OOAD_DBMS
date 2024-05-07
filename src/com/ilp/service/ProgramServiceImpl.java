package com.ilp.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ilp.dao.FeedbackDAO;
import com.ilp.dao.ProgramDAO;

public class ProgramServiceImpl implements ProgramService {

	@Override
	public void insertProgram() {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
					try {
				Connection connection = FeedbackDAO.getConnection();
				ProgramDAO.insertProgram(connection);
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

		}
			
		}

	
}
