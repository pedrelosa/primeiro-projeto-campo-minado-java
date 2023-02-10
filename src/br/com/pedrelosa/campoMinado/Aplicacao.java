
 package br.com.pedrelosa.campoMinado;


 import br.com.pedrelosa.campoMinado.modelo.Tabuleiro;
 import br.com.pedrelosa.campoMinado.visao.TabuleiroConsole;

 

 public class Aplicacao {

     public static int vez = 0;
     
   public static void main(String[] args) {
     Tabuleiro tabuleiro = new Tabuleiro(6, 6, 5);
     
     new TabuleiroConsole(tabuleiro);
   }
 }