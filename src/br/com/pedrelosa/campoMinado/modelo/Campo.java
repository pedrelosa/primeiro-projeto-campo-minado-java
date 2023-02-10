
package br.com.pedrelosa.campoMinado.modelo;


import br.com.pedrelosa.campoMinado.excecao.ExplosaoException;

import java.util.ArrayList;
import java.util.List;


public class Campo {
	
	private final int x;
	private final int y;
	private boolean minado;
	private boolean aberto;
	private boolean marcado;
	private List<Campo> vizinhos = new ArrayList<>();
	
	public Campo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public boolean adicionarVizinho(Campo vizinho) {
		boolean xIsDif = (this.x != vizinho.x);
		boolean yIsDif = (this.y != vizinho.y);
		boolean diagonalIsDif = (xIsDif && yIsDif);
		
		int deltaX = Math.abs(this.x - vizinho.x);
		int deltaY = Math.abs(this.y - vizinho.y);
		int deltaAll = deltaX + deltaY;
		
		if (deltaAll == 1 && ! diagonalIsDif) {
			this.vizinhos.add(vizinho);
			return true;
		}
		if (deltaAll == 2 && diagonalIsDif) {
			this.vizinhos.add(vizinho);
			return true;
			
		}
		return false;
	}
	
	
	public void alternarMarcacao() {
		if (! this.aberto) {
			this.marcado = ! this.marcado;
			
		}
	}
	
	
	public void abrir() {
		if (! this.aberto && ! this.marcado) {
			this.aberto = true;
			
			if (this.minado) {
				throw new ExplosaoException();
				
			}
			
			if (vizinhancaSegura()) {
				this.vizinhos.forEach(Campo::abrir);
				
			}
			
		}
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean vizinhancaSegura() {
		return this.vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	public boolean isMarcado() {
		return this.marcado;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public boolean isAberto() {
		return this.aberto;
	}
	
	public boolean isMinado() {
		return this.minado;
	}
	
	boolean objetivoAlcancado() {
		boolean desvendado = (! this.minado && this.aberto);
		boolean protegido = (this.minado && this.marcado);
		return (desvendado || protegido);
	}
	
	void minar() {
		if (! isMinado()) {
			this.minado = true;
		}
	}
	
	long minasNaVizinhanca() {
		return this.vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.aberto = false;
	}
	
	public String toString() {
		if (isMarcado())
			return "x";
		if (isAberto() && isMinado())
			return "*";
		if (isAberto() && minasNaVizinhanca() > 0L)
			return Long.toString(minasNaVizinhanca());
		if (isAberto()) {
			return "  ";
		}
		return "?";
	}
	
}
