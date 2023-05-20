package br.com.alura.escola.shared.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void NaoDeveriaCriarUmCPFComDadosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF("cpfInvalido"));
		
	}
	
	@Test
	void DeveriaCriarUmCPFComDadosValidos() {
		CPF cpf = new CPF("111.222.333-44");
		assertTrue(cpf.getNumero()!= null);
		
	}

}
