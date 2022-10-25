package entidades;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class Produtos {
	
	private int id_produto;
	private String nome;
	private String preco;
	private String quantidade;
	
	public Produtos(int id_produto) {
		
		this.id_produto = id_produto;
		
	}
	
	public Produtos(String nome, String preco, String quantidade) {
		
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		
	}
	
	public Produtos(int id_produto, String nome, String preco, String quantidade) {
		
		this.id_produto = id_produto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		
	}
	
	public void cadastrar() {
		try {
			
			Connection con = Conexao.fazerConexao();
			
			String sql = "INSERT INTO produtos(nome,preco,quantidade) VALUES (?,?,?)";
			
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, preco);
			stmt.setString(3, quantidade);
			
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizar() {
		
		
		
	}
	
	public void excluir() {
		
		
		
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}
