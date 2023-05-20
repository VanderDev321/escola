package br.com.alura.escola.academico.dominio.aluno;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.evento.Evento;
import br.com.alura.escola.shared.evento.TipoEvento;

public class AlunoMatriculado implements Evento {
	
	private  final CPF CpfDoAluno;
	private final LocalDateTime momento;
	
	

	public AlunoMatriculado(CPF cpfDoAluno) {
		CpfDoAluno = cpfDoAluno;
		momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}
	
	public CPF getCpfDoAluno() {
		return CpfDoAluno;
	}

	@Override
	public TipoEvento tipo() {
		return TipoEvento.ALUNO_MATRICULADO;
	}

	@Override
	public Map<String, Object> informacoes() {
		
		return Map.of("cpf",CpfDoAluno);
	}

}
