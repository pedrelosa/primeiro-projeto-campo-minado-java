package br.com.pedrelosa.campoMinado.imports;

import javax.swing.*;


public class EntradaESaidaGrafico {
	public static int converssaoInt(int min, int max, String texto) {
		int x = 0;
		boolean itsOk = false;
		String y = "valor inicial";
		while (! itsOk) {
			try {
				y = JOptionPane.showInputDialog(texto);
				x = Integer.parseInt(y);
				if (x <= max && x >= min) {
					itsOk = true;
					continue;
				}
				JOptionPane.showMessageDialog(null, "O valor digitado está fora dos parametros normais!! Tente novamente");
				
			} catch (NumberFormatException a) {
				
				if (y == null) {
					System.exit(0);
					continue;
				}
				JOptionPane.showMessageDialog(null, "Você digitou errado!! Tente novamente");
			}
		}
		
		
		return x;
	}
	
	
	public static double converssaoDouble(double min, double max, String texto) {
		double x = 0.0D;
		boolean itsok = false;
		String y = "valor inicial";
		while (! itsok) {
			try {
				y = JOptionPane.showInputDialog(texto);
				x = Double.parseDouble(y);
				if (x <= max && x >= min) {
					itsok = true;
					continue;
				}
				JOptionPane.showMessageDialog(null, "O valor digitado está fora dos parametros normais!! Tente novamente");
				
			} catch (NumberFormatException a) {
				
				if (y == null) {
					System.exit(0);
					continue;
				}
				JOptionPane.showMessageDialog(null, "Você digitou errado!! Tente novamente");
			}
		}
		
		
		return x;
	}
	
	
	public static String converssaoString(String texto, String... opcoesaceitaveis) {
		boolean escreveuCerto = false;
		String stringRecebida = "valor inicial";
		String retorno = "";
		
		while (! escreveuCerto) {
			try {
				stringRecebida = JOptionPane.showInputDialog(texto);
				
				for (String s : opcoesaceitaveis) {
					
					if (stringRecebida.equals(s)) {
						retorno = stringRecebida;
						escreveuCerto = true;
						break;
					}
				}
				
				if (! escreveuCerto) {
					JOptionPane.showMessageDialog(null, "Você digitou errado!! Tente novamente");
				}
			} catch (Exception e) {
				if (stringRecebida == null) {
					System.exit(0);
					continue;
				}
				JOptionPane.showMessageDialog(null, "Você digitou errado!! Tente novamente");
			}
		}
		
		return retorno;
	}
}