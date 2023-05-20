package br.com.alura.escola.academico.aplicacao.aluno;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.evento.PublicadorDeEventos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	private final PublicadorDeEventos publicador;

	public MatricularAluno(RepositorioDeAlunos repositorio,PublicadorDeEventos publicador) {
		
		this.repositorio = repositorio;
		this.publicador = publicador;
	}
	
	public void executa(MatricularAlunoDTO dados) {
		
		Aluno novo = dados.criaAluno();		
		repositorio.matricular(novo);
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicador.publicar(evento);
		
	}
	
	

}
