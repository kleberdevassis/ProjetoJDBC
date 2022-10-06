package projeto_java_jdbc.projecto_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.userPosJava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		userPosJava userposjava = new userPosJava();

		
		userposjava.setNome("Paulo");
		userposjava.setEmail("Paulo@gmail.com");

		userPosDao.salvar(userposjava);

	}

	@Test
	public void initList() {
		UserPosDao dao = new UserPosDao();

		try {
			List<userPosJava> list = dao.listar();

			for (userPosJava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------------------");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();

		try {
			userPosJava userposjava = dao.Buscar(4L);

			System.out.println(userposjava);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		try {

			UserPosDao dao = new UserPosDao();
			userPosJava objetoBanco = dao.Buscar(6L);
			
			objetoBanco.setNome("teste Margarido");
			
			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
