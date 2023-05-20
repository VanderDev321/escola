package br.com.alura.escola.gamificacao.dominio.selo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.Email;
import br.com.alura.escola.shared.dominio.CPF;

class SeloTest {
	private Aluno aluno;
	
	
	@BeforeEach
	void setup() {
		this.aluno = new Aluno(new CPF("333.333.333-33"), "Ciclano da Silva", new Email("domain@domain.com"));
	}

	@Test
	void DeveriaCriarUmSeloAUmAluno() {
		
		Selo selo = new Selo(this.aluno.getCpf(), TipoDeSelo.NOVATO);
		
		assertEquals("333.333.333-33", selo.getCpfDoAluno().toString());
		assertEquals(TipoDeSelo.NOVATO, selo.getTipo());
	}

}
