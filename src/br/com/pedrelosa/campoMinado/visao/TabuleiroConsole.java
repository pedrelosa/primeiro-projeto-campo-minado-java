
package br.com.pedrelosa.campoMinado.visao;


import br.com.pedrelosa.campoMinado.excecao.ExplosaoException;
import br.com.pedrelosa.campoMinado.excecao.SairException;
import br.com.pedrelosa.campoMinado.imports.EntradaESaidaGrafico;
import br.com.pedrelosa.campoMinado.modelo.Tabuleiro;

import javax.swing.*;


public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		execultarJogo();
	}
	
	
	private void execultarJogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				String resposta = EntradaESaidaGrafico.converssaoString("Outra partida? (S/n) ", new String[]{"S", "s", "n", "N"});
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
					continue;
				}
				this.tabuleiro.reiniciar();
				
			}
			
			
		} catch (SairException e) {
			JOptionPane.showMessageDialog(null, "Tchau!!");
		}
		
	}
	
	
	private void cicloDoJogo() {
		try {
			while (! this.tabuleiro.objetivoAlcancado()) {
				JOptionPane.showMessageDialog(null, this.tabuleiro);
				
				int linha = EntradaESaidaGrafico.converssaoInt(0, this.tabuleiro.getLinhas(), String.valueOf(this.tabuleiro) +
						"\n digite o valor de linha:");
				int coluna = EntradaESaidaGrafico.converssaoInt(0, this.tabuleiro.getColunas(), String.valueOf(this.tabuleiro) +
						"\n digite o valor de coluna:");
				
				
				String opcaoEscolhida = EntradaESaidaGrafico.converssaoString(this.tabuleiro.toStringSelecionado(linha, coluna) +
						"\nQual operação deseja fazer:\n"+
						"Abrir - 1\n"+
						"Marcar ou desmarcar - 2\n",
						"1", "2");
				
				
				if ("1".equals(opcaoEscolhida)) {
					this.tabuleiro.abrir(linha, coluna);
					continue;
				}
				if ("2".equals(opcaoEscolhida)) {
					this.tabuleiro.alternarMarcacao(linha, coluna);
				}
				
			}
			JOptionPane.showMessageDialog(null, this.tabuleiro);
			JOptionPane.showMessageDialog(null, "Você ganhou!!!");
		} catch (ExplosaoException e) {
			JOptionPane.showMessageDialog(null, this.tabuleiro);
			JOptionPane.showMessageDialog(null, "Você perdeu!");
		}
		
	}
	
}