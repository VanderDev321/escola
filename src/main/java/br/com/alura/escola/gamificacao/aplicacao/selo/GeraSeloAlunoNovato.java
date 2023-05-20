package br.com.alura.escola.gamificacao.aplicacao.selo;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.dominio.selo.TipoDeSelo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.evento.Evento;
import br.com.alura.escola.shared.evento.Ouvinte;
import br.com.alura.escola.shared.evento.TipoEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

	private final RepositorioDeSelos repositorio;

	public GeraSeloAlunoNovato(RepositorioDeSelos repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	protected void reageAo(Evento evento) {

		CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
		Selo novo = new Selo(cpfDoAluno,TipoDeSelo.NOVATO);
		repositorio.salvarSelo(novo);

	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoEvento.ALUNO_MATRICULADO;
	}

}
