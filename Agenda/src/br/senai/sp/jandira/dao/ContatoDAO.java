package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;

	public ContatoDAO() {

	}

	public ContatoDAO(Contato contato) {
		this.contato = contato;
	}

	public ArrayList<Contato> getContatos(int idUsuario) {
		ArrayList<Contato> contatos = new ArrayList<>();

		String sql = "SELECT * FROM contatos WHERE idUsuario = ? ORDER BY nome";

		try {

			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, idUsuario);

			rs = stm.executeQuery();

			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setDtNasc(rs.getString("dtNasc"));
				contato.setLogradouro(rs.getString("logradouro"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setEstado(rs.getString("estado"));
				contato.setCep(rs.getString("cep"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				contato.setSexo(rs.getString("sexo"));
				contato.setIdUsuario(rs.getInt("idUsuario"));
				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contatos;
	}

	public boolean gravarContato() {
		boolean status = true;

		String sql = "INSERT INTO contatos " + "(nome, dtNasc, email, logradouro, " + "bairro, cidade, estado, cep, "
				+ "telefone, celular, sexo, idUsuario) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getLogradouro());
			stm.setString(5, contato.getBairro());
			stm.setString(6, contato.getCidade());
			stm.setString(7, contato.getEstado());
			stm.setString(8, contato.getCep());
			stm.setString(9, contato.getTelefone());
			stm.setString(10, contato.getCelular());
			stm.setString(11, contato.getSexo());
			stm.setInt(12, contato.getIdUsuario());
			stm.execute();
			Conexao.getConexao().close();
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	public Contato getContato(String idContato) {
		String sql = "SELECT * FROM contatos WHERE id = ?";

		try {

			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, idContato);

			rs = stm.executeQuery();

			rs.next();
			contato = new Contato();
			contato.setId(rs.getInt("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setDtNasc(rs.getString("dtNasc"));
			contato.setLogradouro(rs.getString("logradouro"));
			contato.setBairro(rs.getString("bairro"));
			contato.setCidade(rs.getString("cidade"));
			contato.setEstado(rs.getString("estado"));
			contato.setCep(rs.getString("cep"));
			contato.setTelefone(rs.getString("telefone"));
			contato.setCelular(rs.getString("celular"));
			contato.setSexo(rs.getString("sexo"));
			contato.setIdUsuario(rs.getInt("idUsuario"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contato;
	}

	public boolean atualizarContato(String idContato) {
		boolean status = true;

		String sql = "UPDATE contatos "
				+ "SET nome = ?, dtNasc = ?, email = ?, logradouro = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, "
				+ "telefone = ?, celular = ?, sexo = ? WHERE id = ? ";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getLogradouro());
			stm.setString(5, contato.getBairro());
			stm.setString(6, contato.getCidade());
			stm.setString(7, contato.getEstado());
			stm.setString(8, contato.getCep());
			stm.setString(9, contato.getTelefone());
			stm.setString(10, contato.getCelular());
			stm.setString(11, contato.getSexo());
			stm.setString(12, idContato);
			stm.execute();
			Conexao.getConexao().close();
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}
	
	public boolean excluirContato(String idContato){
		boolean status = true;
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, idContato);
			stm.execute();
			Conexao.getConexao().close();
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		
		return status;
	}
}
