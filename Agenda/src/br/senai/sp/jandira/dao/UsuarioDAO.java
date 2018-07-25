package br.senai.sp.jandira.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Usuario;

public class UsuarioDAO {
	
	private Usuario usuario;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public Usuario autenticar (String email, String senha){
		usuario = null;
		stm = null;
		rs = null;
		
		String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
		
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2,  senha);
			
			rs = stm.executeQuery();
			
			if(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDtNasc(rs.getString("dtNasc"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro em 'autenticar'");
		}
		
		return usuario;
	}
	
	public boolean gravar (Usuario usuario){
		boolean status = true;
		stm = null;
		
		String sql = "INSERT INTO usuarios (nome, dtNasc, cidade, email, senha) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getDtNasc());
			stm.setString(3, usuario.getCidade());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSenha());
			stm.execute();
			stm.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro em 'gravar'");
			status = false;
		}
		
		return status;
	}
	
	public boolean atualizarUsuario (Usuario usuario){
		boolean status = true;
		stm = null;
		
		String sql = "UPDATE usuarios "
				+ "SET nome = ?, dtNasc = ?, cidade = ?, email = ?, senha = ? WHERE id = ?";
		
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getDtNasc());
			stm.setString(3, usuario.getCidade());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSenha());
			stm.setInt(6, usuario.getId());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro em 'atualizarUsuario'");
			status = false;
		}
		
		return status;
	}
}
