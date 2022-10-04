package projeto_java_jdbc.projecto_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
