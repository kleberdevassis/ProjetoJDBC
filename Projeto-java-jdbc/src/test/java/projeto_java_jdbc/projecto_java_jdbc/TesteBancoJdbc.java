package projeto_java_jdbc.projecto_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.userPosJava;

public class TesteBancoJdbc {
	
	
	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		userPosJava userposjava = new userPosJava();
		
		userposjava.setId(6L);
		userposjava.setNome("Paulo");
		userposjava.setEmail("Paulo@gmail.com");
		
		userPosDao.salvar(userposjava);
		
		
		
	}

}
