package br.com.alura.escola.academico.dominio.aluno;


//Aggregate -> Classe que agrega e controla a criação das classes value object 

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.shared.dominio.CPF;

public class Aluno {
	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new ArrayList<>();
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;

	}

	public void adicionarTelefone(String ddd, String telefone) {
		if(telefones.size()==2) {
			throw new LimiteDeTelefoneException("O aluno só pode cadastrar dois telefones - limite atingido");
		}

		Telefone numeroTelefone = new Telefone(ddd, telefone);
		this.telefones.add(numeroTelefone);

	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	public String retornaCpf() {
		return cpf.getNumero();
	}
	
	
}
