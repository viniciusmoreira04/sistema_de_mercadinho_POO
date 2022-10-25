package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import conexao.Conexao;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAcesso frame = new TelaDeAcesso();
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
	public TelaDeAcesso() {
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 446);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(179, 186, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.setBounds(10, 11, 170, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblIconUser = new JLabel("");
		lblIconUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUser.setBounds(204, 0, 46, 40);
		panel.add(lblIconUser);
		Image img_user = new ImageIcon(TelaDeAcesso.class.getResource("/icons/businessman.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		lblIconUser.setIcon(new ImageIcon(img_user));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(179, 237, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(null);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSenha.setBounds(10, 11, 170, 20);
		panel_1.add(txtSenha);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(204, 0, 46, 40);
		panel_1.add(lblIconPassword);
		Image img_icon = new ImageIcon(TelaDeAcesso.class.getResource("/icons/lock.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		lblIconPassword.setIcon(new ImageIcon(img_icon));
		Image img_entrar = new ImageIcon(TelaDeAcesso.class.getResource("/icons/key.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(179, 31, 250, 102);
		contentPane.add(lblIconLogo);
		Image img_logo = new ImageIcon(TelaDeAcesso.class.getResource("/icons/locksmith.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblNewLabel_1 = new JLabel("Tela de Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.black);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(179, 144, 250, 24);
		contentPane.add(lblNewLabel_1);
		Image img_sair = new ImageIcon(TelaDeAcesso.class.getResource("/icons/exit 2.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Connection con = Conexao.fazerConexao();
					
					String sql = "SELECT *FROM usuarios WHERE nome=? and senha=?";
					
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(txtSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						
						TelaInicial exibirTelaInicial = new TelaInicial();
						exibirTelaInicial.setVisible(true);
						
						setVisible(false);
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos!");
						
					}
					
					stmt.close();
					con.close();
					
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				btnEntrar.setForeground(Color.WHITE);
			}
		});
		btnEntrar.setBackground(new Color(60, 179, 113));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEntrar.setBounds(179, 303, 250, 50);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION) == 0) {
					TelaDeAcesso.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setForeground(Color.WHITE);
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBackground(new Color(220, 20, 60));
		btnSair.setBounds(179, 364, 250, 50);
		contentPane.add(btnSair);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
