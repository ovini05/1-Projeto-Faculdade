package entities;

import java.util.ArrayList;
import java.util.List;

public class ProdutoManager {

	private List<Produto> produtos = new ArrayList<>();

	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);
	}

	public Produto buscarProdutoPorId(int id) {
		return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
