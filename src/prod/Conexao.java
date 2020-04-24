package prod;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private Connection conexao;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://34.95.251.219/cloud?useTimezone=true&serverTimezone=UTC";
			conexao = DriverManager.getConnection(url,"root","45D2zelBzz0f7lyp");
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}
	
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
}

