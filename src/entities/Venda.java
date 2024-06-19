package entities;

import java.util.List;

public class Venda {

	private List<Produto> produtos;
	private double desconto;

	public Venda(List<Produto> produtos, double desconto) {
		this.produtos = produtos;
		this.desconto = desconto;
	}

	public double calcularTotal() {
		double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
		return total - (total * (desconto / 100));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Produtos:\n");
		for (Produto produto : produtos) {
			sb.append(produto.getNome()).append(" - ").append(produto.getPreco()).append("\n");
		}
		sb.append("Desconto: ").append(desconto).append("%\n");
		sb.append("Total: ").append(calcularTotal()).append("\n");
		return sb.toString();
	}

}
