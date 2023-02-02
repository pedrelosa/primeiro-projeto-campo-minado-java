package br.com.pedrelosa.campoMinado.modelo;


import br.com.pedrelosa.campoMinado.excecao.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Tabuleiro {
	private int linhas;
	private int colunas;
	private int minas;
	private final List<Campo> campos = new ArrayList<>();
	
	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		
		
		
		//sortearMinas(0, 0);
	}
	
	
	public void abrir(int linha, int coluna) {
		try {
			this.campos.parallelStream()
					.filter(c -> (c.getX() == linha && c.getY() == coluna))
					.findFirst()
					.ifPresent(Campo::abrir);
		} catch (ExplosaoException e) {
			this.campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	public void primeiroAbrir(int linha, int coluna) {
		sortearMinas(linha, coluna);
		try {
			this.campos.parallelStream()
					.filter(c -> (c.getX() == linha && c.getY() == coluna))
					.findFirst()
					.ifPresent(Campo::abrir);
		} catch (ExplosaoException e) {
			this.campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	
	public void alternarMarcacao(int linha, int coluna) {
		this.campos.parallelStream()
				.filter(c -> (c.getX() == linha && c.getY() == coluna))
				.findFirst()
				.ifPresent(Campo::alternarMarcacao);
	}
	
	private void gerarCampos() {
		for (int linhas = 0; linhas < this.linhas; linhas++) {
			for (int colunas = 0; colunas < this.colunas; colunas++) {
				this.campos.add(new Campo(linhas, colunas));
			}
		}
	}
	
	private void associarVizinhos() {
		for (Campo c1 : this.campos) {
			for (Campo c2 : this.campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}
	
	private void sortearMinas(int linha, int coluna) {
		Predicate<Campo> minado = campo -> campo.isMinado();
		
		for (long minasArmadas = 0L; minasArmadas < this.minas; minasArmadas++) {
			int aleatorio = (int) (Math.random() * this.campos.size());
			if (this.campos.get(aleatorio).getX() != linha && this.campos.get(aleatorio).getY() != coluna){
				this.campos.get(aleatorio).minar();
			}
			minasArmadas = this.campos.stream().filter(Campo::isMinado).count();
		}
		
	}
	
	public boolean objetivoAlcancado() {
		return this.campos.stream().allMatch(Campo::objetivoAlcancado);
	}
	
	public void reiniciar() {
		this.campos.forEach(Campo::reiniciar);
	}
	
	public int getLinhas() {
		return this.linhas;
	}
	
	public int getColunas() {
		return this.colunas;
	}
	
	public String toStringSelecionado(int x, int y) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("   ");
		for (int coluna = 0; coluna < this.colunas; coluna++) {
			stringBuilder.append(" ");
			stringBuilder.append(coluna);
			stringBuilder.append(" ");
			
		}
		
		stringBuilder.append("\n");
		
		int i = 0;
		for (int linha = 0; linha < this.linhas; linha++) {
			
			stringBuilder.append(linha);
			stringBuilder.append(" ");
			
			for (int j = 0; j < this.colunas; j++) {
				
				if (linha == x && j == y) {
					stringBuilder.append("[");
					stringBuilder.append(this.campos.get(i));
					stringBuilder.append("]");
				} else {
					stringBuilder.append(" ");
					stringBuilder.append(this.campos.get(i));
					stringBuilder.append(" ");
				}
				i++;
			}
			stringBuilder.append('\n');
		}
		
		return stringBuilder.toString();
	}
	
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("   ");
		for (int coluna = 0; coluna < this.colunas; coluna++) {
			stringBuilder.append(" ");
			stringBuilder.append(coluna);
			stringBuilder.append(" ");
		}
		
		stringBuilder.append("\n");
		
		int i = 0;
		for (int linha = 0; linha < this.linhas; linha++) {
			
			stringBuilder.append(linha);
			stringBuilder.append(" ");
			
			for (int j = 0; j < this.colunas; j++) {
				
				stringBuilder.append(" ");
				stringBuilder.append(this.campos.get(i));
				stringBuilder.append(" ");
				
				i++;
			}
			stringBuilder.append('\n');
		}
		
		return stringBuilder.toString();
	}
	
}
