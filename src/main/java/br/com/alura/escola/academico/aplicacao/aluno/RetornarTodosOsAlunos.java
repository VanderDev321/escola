package br.com.alura.escola.academico.aplicacao.aluno;

import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

public class RetornarTodosOsAlunos {
	
	private final RepositorioDeAlunos repositorio;

	public RetornarTodosOsAlunos(RepositorioDeAlunos repositorio) {
		
		this.repositorio = repositorio;
	}
	
	public List<Aluno> executa() {
		List<Aluno>alunosMatriculados = repositorio.listarTodosOsAlunosMatriculados();
		
		return alunosMatriculados;	
		
	}
	
	

}
