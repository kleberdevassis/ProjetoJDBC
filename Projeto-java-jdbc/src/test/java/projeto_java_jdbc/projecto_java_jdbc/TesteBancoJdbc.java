package projeto_java_jdbc.projecto_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.userPosJava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		userPosJava userposjava = new userPosJava();

		userposjava.setNome("Vanessa");
		userposjava.setEmail("vanessa@gmail.com");

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

	@Test
	public void initDeletar() {

		try {

			UserPosDao dao = new UserPosDao();
			dao.delete(6L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void salvarTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(11)98887775");
		telefone.setTipo("celular");
		telefone.setUsuario(45L);
		
		UserPosDao userPosDao = new UserPosDao();
		userPosDao.salvarTelefone(telefone);

	}
	
	@Test
	public void testeCarregaFoneUsers() {
		UserPosDao dao = new UserPosDao();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(8L);
		
		for(BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("----------------------------------------------------------");
		}
		
	}
	
    @Test
    public void testeDeleteUserFone() {
    	UserPosDao dao = new UserPosDao();
    	dao.deleteFonesPorUser(3L);
    	
    }

}
