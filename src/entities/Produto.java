package entities;

public class Produto {

	private int id;
	private String nome;
	private double preco;

	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return id + "," + nome + "," + preco;
	}

	public static Produto fromString(String str) {
		String[] parts = str.split(",");
		int id = Integer.parseInt(parts[0]);
		String nome = parts[1];
		double preco = Double.parseDouble(parts[2]);
		return new Produto(id, nome, preco);
	}

}
