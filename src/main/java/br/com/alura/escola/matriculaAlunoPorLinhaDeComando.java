package br.com.alura.escola;

import java.util.List;

import br.com.alura.escola.academico.aplicacao.aluno.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.MatricularAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;
import br.com.alura.escola.gamificacao.aplicacao.selo.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.evento.PublicadorDeEventos;

public class matriculaAlunoPorLinhaDeComando {

	public static void main(String[] args) {

		String nome = "Fulano Da Silva";
		String cpf = "123.456.789-00";
		String email = "email_email@domain.com";

		RepositorioDeAlunos repositorioDeAlunoEmMemoria = new RepositorioDeAlunoEmMemoria();
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

		MatricularAluno matricula = new MatricularAluno(repositorioDeAlunoEmMemoria, publicador);
		matricula.executa(new MatricularAlunoDTO(nome, cpf, email));
		
		RepositorioDeSelos resgatados = new RepositorioDeSelosEmMemoria();
		List<Selo> listaDeSelosDoAluno = resgatados.listaDeSelosDoAluno(new CPF(cpf));
		
		for (Selo selo : listaDeSelosDoAluno) {
			System.out.println(selo.getCpfDoAluno().toString());
			System.out.println(selo.getTipo().name());
		}

	}

}
