package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Usuarios;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdUsuario;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JTextField txtEditarUsuario;
	private JTable tbUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuarios frame = new TelaCadastroUsuarios();
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
	public TelaCadastroUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 727);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("ID do Usu\u00E1rio:");
		lblIdUsuario.setForeground(Color.black);
		lblIdUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdUsuario.setBounds(29, 187, 110, 29);
		contentPane.add(lblIdUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Usu\u00E1rio");
		lblNewLabel_1.setForeground(Color.black);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 102, 677, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIconUsuario = new JLabel("");
		lblIconUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsuario.setBounds(0, 30, 687, 80);
		contentPane.add(lblIconUsuario);
		Image img_iconUsuario = new ImageIcon(TelaDeAcesso.class.getResource("/icons/businessman.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		lblIconUsuario.setIcon(new ImageIcon(img_iconUsuario));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 157, 667, 3);
		contentPane.add(panel);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setBounds(138, 189, 513, 29);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.black);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(29, 227, 59, 29);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.black);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(29, 267, 59, 29);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(138, 229, 513, 29);
		txtNome.setForeground(Color.black);
		contentPane.add(txtNome);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(138, 267, 513, 29);
		contentPane.add(txtSenha);
		
		JButton btnNewButton = new JButton("Cadastrar Usu\u00E1rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().equals("") || txtSenha.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente para cadastrar um usuário!");
					
				}else {
				
					Usuarios user = new Usuarios(txtNome.getText(), txtSenha.getText());
					user.cadastrar();
					
					txtNome.setText("");
					txtSenha.setText("");
				
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 127));
		btnNewButton.setForeground(Color.black);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(29, 317, 622, 40);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.black);
		panel_1.setBackground(SystemColor.info);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(238, 238, 238)), "Editar Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBounds(254, 381, 397, 90);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtEditarUsuario = new JTextField();
		txtEditarUsuario.setBounds(21, 30, 207, 38);
		panel_1.add(txtEditarUsuario);
		txtEditarUsuario.setColumns(10);
		
		JButton btnEditarUsuario = new JButton("Editar Usu\u00E1rio");
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtEditarUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o ID do usuário!");
				}else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "SELECT *FROM usuarios WHERE id_usuario=?";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtEditarUsuario.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						
						txtIdUsuario.setText(rs.getString("id_usuario"));
						txtNome.setText(rs.getString("nome"));
						txtSenha.setText(rs.getString("senha"));
						
					}
					
					rs.close();
					con.close();
					
					txtEditarUsuario.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnEditarUsuario.setBackground(new Color(30, 144, 255));
		btnEditarUsuario.setForeground(Color.black);
		btnEditarUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditarUsuario.setBounds(227, 30, 145, 38);
		panel_1.add(btnEditarUsuario);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtIdUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o ID do usuário!");
				}else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "UPDATE usuarios SET nome=?, senha=? WHERE id_usuario=?";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtSenha.getText());
					stmt.setString(3, txtIdUsuario.getText());
					
					stmt.execute();
					
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Usuário Atualizado com Sucesso!");
					
					txtNome.setText("");
					txtSenha.setText("");
					txtIdUsuario.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnAtualizar.setBackground(new Color(255, 215, 0));
		btnAtualizar.setForeground(Color.black);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtualizar.setBounds(29, 381, 200, 34);
		contentPane.add(btnAtualizar);
		
		JButton btnEditarUsuario_1_1 = new JButton("Excluir");
		btnEditarUsuario_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtIdUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o ID para excluir o usuário!");
				}
				else {
				
				try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "DELETE FROM usuarios WHERE id_usuario=?";
					
					// Prepara os Dados
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtIdUsuario.getText());
					
					stmt.execute();
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Usuário Excluído com Sucesso!");
					
					txtNome.setText("");
					txtSenha.setText("");
					txtIdUsuario.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnEditarUsuario_1_1.setBackground(new Color(220, 20, 60));
		btnEditarUsuario_1_1.setForeground(Color.black);
		btnEditarUsuario_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditarUsuario_1_1.setBounds(29, 437, 200, 34);
		contentPane.add(btnEditarUsuario_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 492, 622, 126);
		contentPane.add(scrollPane);
		
		tbUsuarios = new JTable();
		tbUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID do Usuario", "Nome", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbUsuarios);
		
		JButton btnListarUsuarios = new JButton("Listar/Atualizar Todos os Usu\u00E1rios na Tabela");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
					
					Connection con = Conexao.fazerConexao();
					
					String sql = "SELECT *FROM usuarios";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbUsuarios.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next()) {
						
						modelo.addRow(new Object[] {rs.getString("id_usuario"), rs.getString("nome"),
													rs.getString("senha")
													});

					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnListarUsuarios.setBackground(new Color(255, 140, 0));
		btnListarUsuarios.setForeground(Color.black);
		btnListarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarUsuarios.setBounds(29, 639, 353, 51);
		contentPane.add(btnListarUsuarios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial exibirTelaInicial = new TelaInicial();
				exibirTelaInicial.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setForeground(Color.black);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(414, 639, 237, 51);
		contentPane.add(btnVoltar);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
