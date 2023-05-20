package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void NaoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, () ->new Email(null));
		assertThrows(IllegalArgumentException.class, () ->new Email(""));
		assertThrows(IllegalArgumentException.class, () ->new Email("invalido"));
	}
	
	@Test
	void DeveriaCriarUmEmailComDadosValidos() {
		Email emailTest = new Email("teste@domain.com");
		
		assertTrue(emailTest.getEndereco()!=null);
		
	}
	
}
