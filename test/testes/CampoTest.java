package testes;

import br.com.pedrelosa.campoMinado.modelo.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo(){
		campo = new Campo(3,3);
	}
	
	@Test
	void testeAdicionarVizinho1Esqueda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1Direita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1Cima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1Baixo() {
		Campo vizinho = new Campo(4,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1DiagonaSuperiorEsqueda() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1DiagonaSuperiorDireita() {
		Campo vizinho = new Campo(2,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1DiagonaInferiorEsqueda() {
		Campo vizinho = new Campo(4,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}@Test
	void testeAdicionarVizinho1DiagonaInferiorDireita() {
		Campo vizinho = new Campo(4,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	
}