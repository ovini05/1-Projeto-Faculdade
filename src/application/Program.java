package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ArquivoManager;
import entities.Produto;
import entities.ProdutoManager;
import entities.Venda;

public class Program {

	public static void main(String[] args) {

		ProdutoManager produtoManager = new ProdutoManager();
		Scanner scanner = new Scanner(System.in);

		// Cadastro de alguns produtos iniciais
		produtoManager.cadastrarProduto(new Produto(1, "Caderno", 15.0));
		produtoManager.cadastrarProduto(new Produto(2, "Caneta", 8.0));
		produtoManager.cadastrarProduto(new Produto(3, "Lapis", 5.0));

		List<Produto> carrinho = new ArrayList<>();

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println("1) Adicionar produto ao carrinho");
			System.out.println("2) Remover produto do carrinho");
			System.out.println("3) Finalizar compra e calcular total");
			System.out.println("0) Sair");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			if (opcao == 1) {
				System.out.print("Digite o ID do produto: ");
				int id = scanner.nextInt();
				Produto produto = produtoManager.buscarProdutoPorId(id);
				if (produto != null) {
					carrinho.add(produto);
					System.out.println("Produto adicionado ao carrinho.");
				} else {
					System.out.println("Produto não encontrado.");
				}
			} else if (opcao == 2) {
				System.out.print("Digite o ID do produto a remover: ");
				int id = scanner.nextInt();
				Produto produtoRemover = null;
				for (Produto p : carrinho) {
					if (p.getId() == id) {
						produtoRemover = p;
						break;
					}
				}
				if (produtoRemover != null) {
					carrinho.remove(produtoRemover);
					System.out.println("Produto removido do carrinho.");
				} else {
					System.out.println("Produto não encontrado no carrinho.");
				}
			} else if (opcao == 3) {
				System.out.print("Digite o percentual de desconto: ");
				double desconto = scanner.nextDouble();
				Venda venda = new Venda(carrinho, desconto);
				double total = venda.calcularTotal();
				System.out.println(venda.toString());

				// Salvar dados da venda em um arquivo
				List<String> dadosVenda = new ArrayList<>();
				dadosVenda.add(venda.toString());
				try {
					ArquivoManager.salvar(dadosVenda, "venda.txt");
					System.out.println("Dados da venda salvos em venda.txt");
				} catch (IOException e) {
					System.out.println("Erro ao salvar dados da venda: " + e.getMessage());
				}
				break;
			} else if (opcao == 0) {
				System.out.println("Saindo...");
				break;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

		scanner.close();
	}

}
