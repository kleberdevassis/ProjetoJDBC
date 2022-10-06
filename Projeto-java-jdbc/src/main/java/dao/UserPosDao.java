package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.userPosJava;

public class UserPosDao {
	
	private Connection connection;
	
	
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(userPosJava userposjava) {
		
		try {
			String sql = "insert into userposjava (id,nome,email) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail()); 
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
