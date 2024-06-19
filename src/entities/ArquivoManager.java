package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoManager {
	public static void salvar(List<String> dados, String caminhoArquivo) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
			for (String dado : dados) {
				writer.write(dado);
				writer.newLine();
			}
		}
	}

	public static List<String> recuperar(String caminhoArquivo) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
			List<String> dados = new ArrayList<>();
			String linha;
			while ((linha = reader.readLine()) != null) {
				dados.add(linha);
			}
			return dados;
		}
	}
}
