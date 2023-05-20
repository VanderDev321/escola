package br.com.alura.escola.academico.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.evento.PublicadorDeEventos;

class MatricularAlunoTest {

	@Test
	void DeveriaPersistirUmAlunoNoBanco() {
		
		RepositorioDeAlunoEmMemoria repositorio = new RepositorioDeAlunoEmMemoria();
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		
		
		MatricularAluno matricularAluno = new MatricularAluno(repositorio,publicador);
		matricularAluno.executa(new MatricularAlunoDTO("fulano", "111.222.333-44", "email@domain.com"));
		
		Aluno alunoBuscado = repositorio.buscarPorCPF(new CPF("111.222.333-44"));
		
		
		assertEquals("fulano",alunoBuscado.getNome());
		 assertEquals("111.222.333-44", alunoBuscado.getCpf().toString()); 
		assertEquals("email@domain.com", alunoBuscado.getEmail());
	}

}
