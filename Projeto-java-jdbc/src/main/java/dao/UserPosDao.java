package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosDao {
	
	private Connection connection;
	
	
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

}
