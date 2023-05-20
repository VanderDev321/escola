package br.com.alura.escola.academico.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.shared.evento.Evento;
import br.com.alura.escola.shared.evento.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

	public void reageAo(Evento evento) {

		String dataEventoFormatada = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

		System.out.println(String.format("Aluno com o CPF %s matriculado em: %s",
				((AlunoMatriculado) evento).getCpfDoAluno(), dataEventoFormatada));

	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
