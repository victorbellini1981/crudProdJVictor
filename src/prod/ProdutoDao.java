package prod;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class ProdutoDao {

	public void inserir(Produto p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO Produto (descricao, marca, custo, venda, quantidade) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getDescricao());
			prep.setString(2, p.getMarca());
			prep.setDouble(3, p.getCusto());
			prep.setDouble(4, p.getVenda());
			prep.setInt(5, p.getQuantidade());
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public LinkedList<Produto> listar() {
		LinkedList<Produto> lst = new LinkedList<Produto>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT idProduto, descricao, marca, custo, venda, quantidade "
					+ " FROM Produto ORDER BY descricao";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Produto p = new Produto();
				p.setIdProduto(res.getInt("idProduto"));
				p.setDescricao(res.getString("descricao"));
				p.setMarca(res.getString("marca"));
				p.setCusto(res.getDouble("custo"));
				p.setVenda(res.getDouble("venda"));
				p.setQuantidade(res.getInt("quantidade"));
				lst.add(p);
			}
			
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lst;
		
	}
	
	public int getTotalq(LinkedList<Produto> lista) {
		int totalq = 0;
		for (Produto p: lista) {
			totalq = totalq + p.getQuantidade();
		}
		return totalq;
	}

	public double getTotalv(LinkedList<Produto> lista) {
		double totalv = 0;
		for (Produto p: lista) {
			totalv = totalv + (p.getVenda() * p.getQuantidade());
		}
		return totalv;
	}
	
	public double getTotalc(LinkedList<Produto> lista) {
		double totalc = 0;
		for (Produto p: lista) {
			totalc = totalc + (p.getCusto() * p.getQuantidade());
		}
		return totalc;
	}
	
	public double getLucro(LinkedList<Produto> lista) {
		double lucro = 0;
		for (Produto p: lista) {
			lucro = lucro + (p.getVenda() * p.getQuantidade()) - (p.getCusto() * p.getQuantidade());
		}
		return lucro;
	}
	
	public void excluir(int idproduto) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM Produto WHERE idProduto = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, idproduto);
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();

	}
	
	
}
