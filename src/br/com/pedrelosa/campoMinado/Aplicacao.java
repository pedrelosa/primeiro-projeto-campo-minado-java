
 package br.com.pedrelosa.campoMinado;


 import br.com.pedrelosa.campoMinado.modelo.Tabuleiro;
 import br.com.pedrelosa.campoMinado.visao.TabuleiroConsole;

 

 public class Aplicacao {

   public static void main(String[] args) {
     Tabuleiro tabuleiro = new Tabuleiro(3, 3, 2);
     
     new TabuleiroConsole(tabuleiro);
   }
 }