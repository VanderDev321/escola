package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

public class AlunoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontradoException(CPF cpf) {
		super("Aluno não encontrado com o CPF " + cpf.getNumero());
		//
	}

}
