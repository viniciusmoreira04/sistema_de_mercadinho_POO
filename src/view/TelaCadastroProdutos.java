package view;

import java.awt.BorderLayout;

import conexao.Conexao;
import entidades.Produtos;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;


import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JTextField txtEditarProduto;
	private JTable tbProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdutos frame = new TelaCadastroProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 695);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Produto");
		lblNewLabel.setBounds(0, 107, 687, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblIconProduto = new JLabel("");
		lblIconProduto.setBounds(0, 23, 687, 93);
		lblIconProduto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIconProduto);
		Image img_iconProduto = new ImageIcon(TelaDeAcesso.class.getResource("/icons/product.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		lblIconProduto.setIcon(new ImageIcon(img_iconProduto));
		
		JLabel lblNewLabel_1 = new JLabel("ID do Produto:");
		lblNewLabel_1.setBounds(25, 186, 113, 30);
		lblNewLabel_1.setForeground(Color.black);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 158, 667, 3);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setBounds(241, 186, 58, 30);
		lblNewLabel_1_1.setForeground(Color.black);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_1_1_1.setBounds(25, 239, 58, 30);
		lblNewLabel_1_1_1.setForeground(Color.black);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quantidade:");
		lblNewLabel_1_1_1_1.setBounds(282, 239, 99, 30);
		lblNewLabel_1_1_1_1.setForeground(Color.black);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtId = new JTextField();
		txtId.setBounds(138, 187, 86, 30);
		txtId.setForeground(Color.black);
		txtId.setEditable(false);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(294, 186, 364, 30);
		txtNome.setColumns(10);
		contentPane.add(txtNome);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(78, 241, 192, 30);
		txtPreco.setForeground(Color.black);
		txtPreco.setColumns(10);
		contentPane.add(txtPreco);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(377, 239, 281, 30);
		txtQuantidade.setForeground(Color.black);
		txtQuantidade.setColumns(10);
		contentPane.add(txtQuantidade);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(251, 369, 407, 70);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(238, 238, 238)), "Editar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1_1.setBackground(SystemColor.info);
		contentPane.add(panel_1_1);
		
		txtEditarProduto = new JTextField();
		txtEditarProduto.setBounds(26, 21, 209, 34);
		txtEditarProduto.setForeground(Color.black);
		panel_1_1.add(txtEditarProduto);
		txtEditarProduto.setColumns(10);
		
		JButton btnEditarProduto = new JButton("Editar Produto");
		btnEditarProduto.setBackground(SystemColor.textHighlight);
		btnEditarProduto.setForeground(Color.black);
		btnEditarProduto.setBounds(234, 21, 144, 34);
		panel_1_1.add(btnEditarProduto);
		btnEditarProduto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(txtEditarProduto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID do produto!");
				}else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "SELECT *FROM produtos WHERE id_produto=?";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtEditarProduto.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						
						txtId.setText(rs.getString("id_produto"));
						txtNome.setText(rs.getString("nome"));
						txtPreco.setText(rs.getString("preco"));
						txtQuantidade.setText(rs.getString("quantidade"));
						
					}
					
					rs.close();
					con.close();
					
					txtEditarProduto.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnEditarProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial exibirTelaInicial = new TelaInicial();
				exibirTelaInicial.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnVoltar.setBounds(418, 617, 240, 48);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnVoltar);
		
		JButton btnListarDados = new JButton("Listar/Atualizar Todos os Produtos na Tabela");
		btnListarDados.setForeground(Color.black);
		btnListarDados.setBackground(new Color(255, 127, 80));
		btnListarDados.setBounds(25, 617, 356, 48);
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "SELECT *FROM produtos";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbProduto.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next()) {
						
						modelo.addRow(new Object[] {rs.getString("id_produto"), rs.getString("nome"),
													rs.getString("preco"), rs.getString("quantidade")
													});

					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnListarDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnListarDados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 474, 633, 132);
		contentPane.add(scrollPane);
		
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID do Produto", "Nome", "Pre\u00E7o", "Quantidade"
			}
		));
		tbProduto.getColumnModel().getColumn(0).setPreferredWidth(89);
		scrollPane.setViewportView(tbProduto);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setForeground(Color.black);
		btnCadastrarProduto.setBackground(new Color(0, 255, 127));
		btnCadastrarProduto.setBounds(25, 292, 633, 40);
		contentPane.add(btnCadastrarProduto);
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(txtNome.getText().equals("") || txtPreco.getText().equals("") || txtQuantidade.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente para cadastrar um produto!");
					
				}else {
				
					Produtos prod = new Produtos(txtNome.getText(), txtPreco.getText(), txtQuantidade.getText());
					prod.cadastrar();
					
					txtNome.setText("");
					txtPreco.setText("");
					txtQuantidade.setText("");
					
				}
				
			}
		});
		btnCadastrarProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.black);
		btnExcluir.setBackground(new Color(220, 20, 60));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o ID para excluir o produto!");
				}
				else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "DELETE FROM produtos WHERE id_produto=?";
					
					// Prepara os Dados
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtId.getText());
					
					stmt.execute();
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Produto Excluído com Sucesso!");
					
					txtNome.setText("");
					txtPreco.setText("");
					txtQuantidade.setText("");
					txtId.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnExcluir.setBounds(25, 414, 216, 34);
		contentPane.add(btnExcluir);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.black);
		btnAtualizar.setBackground(new Color(255, 215, 0));
		btnAtualizar.setBounds(25, 369, 216, 34);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o ID do produto!");
				}else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "UPDATE produtos SET nome=?, preco=?, quantidade=? WHERE id_produto=?";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtPreco.getText());
					stmt.setString(3, txtQuantidade.getText());
					stmt.setString(4, txtId.getText());
					
					stmt.execute();
					
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso!");
					
					txtNome.setText("");
					txtPreco.setText("");
					txtQuantidade.setText("");
					txtId.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
