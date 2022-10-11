package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.BeanUserFone;
import model.userPosJava;

public class UserPosDao {

	private Connection connection;

	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(userPosJava userposjava) {

		try {
			String sql = "insert into userposjava (nome,email) values(?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
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

	public void salvarTelefone(Telefone telefone) {

		try {
			String sql = "insert into telefoneuser (numero,tipo,usuariopessoa) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getNumero());
			insert.setString(2, telefone.getTipo());
			insert.setLong(3, telefone.getUsuario());
			insert.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	
	public void deleteFonesPorUser(Long idUser) {
		
		
		String sqlFone = "delete from telefoneuser where usuariopessoa = "+idUser;
		String sqlUser = "delete from userposjava where id = "+ idUser;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlFone);
			statement.executeUpdate();
			connection.commit();
			
		    statement = connection.prepareStatement(sqlUser);
		    statement.executeUpdate();
		    connection.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				e1.printStackTrace();
			}
		}
		
		
	}
	
    public List<BeanUserFone> listaUserFone(Long idUser){
    	
    	List<BeanUserFone> beanUserFones = new ArrayList<>();
    	
    	String sql = "select nome, numero, email from telefoneuser as fone ";
    	sql+= " inner join userposjava as userp ";
    	sql+= " on fone.usuariopessoa = userp.id ";
    	sql+= "where userp.id = " + idUser;
    	
    	try {
			PreparedStatement Statement = connection.prepareStatement(sql);
			ResultSet resultado = Statement.executeQuery();
			
			while(resultado.next()) {
				BeanUserFone beanUserFone = new BeanUserFone();
				beanUserFone.setEmail(resultado.getString("email"));
				beanUserFone.setNome(resultado.getString("nome"));
				beanUserFone.setNumero(resultado.getString("numero"));
				beanUserFones.add(beanUserFone);
				
			}
				
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
    	
    	
    	return  beanUserFones;
    }
	
	

	public List<userPosJava> listar() throws Exception {

		List<userPosJava> list = new ArrayList<>();

		String sql = "select * from userposjava";

		PreparedStatement statment = connection.prepareStatement(sql);

		ResultSet resultado = statment.executeQuery();

		while (resultado.next()) {
			userPosJava userposjava = new userPosJava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			list.add(userposjava);
		}
		return list;

	}

	public userPosJava Buscar(Long id) throws Exception {

		userPosJava retorno = new userPosJava();

		String sql = "select * from userposjava where id = " + id;

		PreparedStatement statment = connection.prepareStatement(sql);

		ResultSet resultado = statment.executeQuery();

		while (resultado.next()) {
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}
		return retorno;

	}

	public void atualizar(userPosJava userposjava) {

		try {
			String sql = "update userposjava set nome = ? WHERE ID = " + userposjava.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());

			statement.execute();
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

	public void delete(Long id) {

		try {

			String sql = "delete from userposjava where id =" + id;
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.execute();
			connection.commit();
		} catch (Exception e) {
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
