package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.shared.dominio.CPF;

class AlunoTest {
	private Aluno aluno; 
	private Email email;
	private CPF cpf;
	
	@BeforeEach
	void setup(){
		this.cpf = new CPF("111.222.333-44");
		this.email = new Email("aluno@email.com");
		this.aluno = new Aluno(cpf, "Fulano", email);
	}
	
	@Test
	void DeveriaCadastrarUmUnicoNumeroDeTelefoneAoAluno() {
		this.aluno.adicionarTelefone("15", "88889999");
		
		assertEquals(1,this.aluno.getTelefones().size());
	}
	
	@Test
	void DeveriaCadastrarDoisNumerosDeTelefoneAoAluno() {

		this.aluno.adicionarTelefone("11", "77775555");
		this.aluno.adicionarTelefone("15", "77776666");
		
		assertEquals(2,this.aluno.getTelefones().size());
	}

	@Test
	void NaoDeveriaCadastrarMaisDeDoisTelefones() {
			
			aluno.adicionarTelefone("61", "99998888");
			aluno.adicionarTelefone("15", "11112222");
			
			assertThrows(LimiteDeTelefoneException.class, () -> aluno.adicionarTelefone("15", "11112222"));
		
	}

}
