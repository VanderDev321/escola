package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

	private List<Selo> selosGuardados = new ArrayList<>();

	@Override
	public void salvarSelo(Selo selo) {
		this.selosGuardados.add(selo);
	}

	@Override
	public List<Selo> listaDeSelosDoAluno(CPF cpf) {
		return this.selosGuardados.stream()
				.filter(s -> s.getCpfDoAluno().equals(cpf))
				.collect(Collectors.toList());
	}

}
