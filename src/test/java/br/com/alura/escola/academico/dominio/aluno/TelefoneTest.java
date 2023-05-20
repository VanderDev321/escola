package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void NaoDeveriaCriarUmTelefoneComDadosInvalidos() {
		assertThrows(IllegalArgumentException.class, ()-> new Telefone(null, null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("invalido", "invalido"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("1", null));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("", "12345678"));

	}
	@Test
	void DeveriaCriarUmTelefoneComDadosValidos() {
		Telefone telefone = new Telefone("61", "912344321");
		
		assertTrue(telefone.getDdd()!= null && telefone.getNumero()!=null);
		
		
	}

}
