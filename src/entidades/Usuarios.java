package entidades;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class Usuarios {
	
	private int id_usuario;
	private String nome;
	private String senha;
	
	public Usuarios(int id_usuario) {
		
		this.id_usuario = id_usuario;
		
	}
	
	public Usuarios(String nome, String senha) {
		
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public Usuarios(int id_usuario, String nome, String senha) {
		
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public void cadastrar() {
		try {
			
			Connection con = Conexao.fazerConexao();
			
			String sql = "INSERT INTO usuarios(nome,senha) VALUES (?,?)";
			
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizar() {
		
		
		
	}
	
	public void excluir() {
		
		
		
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
