package prod;

import java.util.LinkedList;

public class Lista {
	private static LinkedList<Produto> lista = new LinkedList<Produto>();
	
	
	public void inserir(Produto p) {
		lista.add(p);
	}
	
	public LinkedList<Produto> listar(){
		return lista;
	}

	public int getTotalq(LinkedList<Produto> lista) {
		int totalq = 0;
		for (Produto p: lista) {
			totalq = totalq + p.getQuantidade();
		}
		return totalq;
	}

	public double getTotalv() {
		double totalv = 0;
		for (Produto p: lista) {
			totalv = totalv + (p.getVenda() * p.getQuantidade());
		}
		return totalv;
	}
	
	public double getTotalc() {
		double totalc = 0;
		for (Produto p: lista) {
			totalc = totalc + (p.getCusto() * p.getQuantidade());
		}
		return totalc;
	}
	
	public double getLucro() {
		double lucro = 0;
		for (Produto p: lista) {
			lucro = lucro + (p.getVenda() * p.getQuantidade()) - (p.getCusto() * p.getQuantidade());
		}
		return lucro;
	}
}	
	