package br.com.alura.escola.academico.aplicacao.aluno;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.Email;
import br.com.alura.escola.shared.dominio.CPF;

public class MatricularAlunoDTO {
	
	private String nome;
	private String cpf;
	private String email;
	
	public MatricularAlunoDTO(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	public Aluno criaAluno() {
		Aluno aluno = new Aluno(new CPF(this.cpf), this.nome, new Email(email));
		return aluno;
	} 
	
	
	
	

}
