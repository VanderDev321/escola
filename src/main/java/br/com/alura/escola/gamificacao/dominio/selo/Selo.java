package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

public class Selo {
	private CPF cpfDoAluno;
	private TipoDeSelo tipo;
	
	public Selo(CPF cpfDoAluno, TipoDeSelo tipo) {
		super();
		this.cpfDoAluno = cpfDoAluno;
		this.tipo = tipo;
	}
	
	public CPF getCpfDoAluno() {
		return cpfDoAluno;
	}
	
	public TipoDeSelo getTipo() {
		return tipo;
	}

}
