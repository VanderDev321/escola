package br.com.alura.escola.academico.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoNaoEncontradoException;
import br.com.alura.escola.academico.dominio.aluno.Email;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.aluno.Telefone;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {
	
	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(Connection connection) {
	
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {	
		try {
			String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf().toString());
			ps.setString(2, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES(? ,?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		
		try {
			String sql = "SELECT * FROM ALUNO WHERE cpf = ? ";
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, cpf.getNumero());
			
			ResultSet rs = pstm.executeQuery();
			boolean encontrou = rs.next();
			if(!encontrou) {
				throw new AlunoNaoEncontradoException(cpf);
			}
			String numeroCpf = rs.getNString("numeroCpf");
			CPF cpfBuscado = new CPF(numeroCpf);
			String nome = rs.getNString("nomeAluno");
			String email = rs.getNString("emailAluno");
			Email emailBuscado = new Email(email);
			Aluno alunoBuscado = new Aluno(cpfBuscado,nome ,emailBuscado);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			pstm = connection.prepareStatement(sql);
			pstm.setLong(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				String ddd = rs.getString("ddd");
				String numero = rs.getString("numero");
				alunoBuscado.adicionarTelefone(ddd, numero);
			}
			
			return alunoBuscado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Aluno> listarTodosOsAlunosMatriculados() {
		List<Aluno> resultado = new ArrayList<>();
		try {
			String sql = "SELECT * FROM ALUNO";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				CPF cpfBuscado = new CPF(rs.getNString("numeroCpf"));
				String nomeBuscado = rs.getString("nomeAluno");
				Email emailBuscado = new Email(rs.getNString("emailAluno"));
				
				Aluno alunoBuscado = new Aluno(cpfBuscado, nomeBuscado, emailBuscado);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setLong(1, id);
				ResultSet rs2 = ps.executeQuery();
				while(rs2.next()) {
					String ddd = rs2.getString("ddd");
					String numero = rs2.getString("numero");
					
					alunoBuscado.adicionarTelefone(ddd, numero);
				}
								
				resultado.add(alunoBuscado);
				
			}
			
			
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}
		return resultado;
	}

}
