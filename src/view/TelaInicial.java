package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 415);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 625, 35);
		contentPane.add(menuBar);
		
		JMenu MenuCadastrar = new JMenu("Cadastrar");
		MenuCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		MenuCadastrar.setForeground(SystemColor.black);
		menuBar.add(MenuCadastrar);
		
		JMenuItem itemMenuProduto = new JMenuItem("Produto");
		itemMenuProduto.setForeground(SystemColor.black);
		itemMenuProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				TelaCadastroProdutos exibirTelaCadastroProdutos = new TelaCadastroProdutos();
				exibirTelaCadastroProdutos.setVisible(true);
				setVisible(false);
				
			}
		});
		itemMenuProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		MenuCadastrar.add(itemMenuProduto);
		
		JMenuItem itemMenuUsuario = new JMenuItem("Usu\u00E1rio");
		itemMenuUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroUsuarios exibirTelaCadastroUsuarios = new TelaCadastroUsuarios();
				exibirTelaCadastroUsuarios.setVisible(true);
				setVisible(false);
				
			}
		});
		itemMenuUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		itemMenuUsuario.setForeground(SystemColor.black);
		MenuCadastrar.add(itemMenuUsuario);
		
		JMenu MenuOpcoes = new JMenu("Op\u00E7\u00F5es");
		MenuOpcoes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		MenuOpcoes.setForeground(SystemColor.black);
		menuBar.add(MenuOpcoes);
		
		JMenuItem itemMenuSair = new JMenuItem("Sair");
		itemMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION) == 0) {
					TelaInicial.this.dispose();
				}
			}
		});
		itemMenuSair.addMouseListener(new MouseAdapter() {
		});
		itemMenuSair.setForeground(SystemColor.black);
		itemMenuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		MenuOpcoes.add(itemMenuSair);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo(a) ao Nosso Sistema!");
		lblNewLabel.setForeground(SystemColor.black);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 55, 625, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblIconLogoMercado = new JLabel("");
		lblIconLogoMercado.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogoMercado.setBounds(0, 103, 625, 140);
		lblIconLogoMercado.setForeground(Color.black);
		contentPane.add(lblIconLogoMercado);
		Image img_logomercado = new ImageIcon(TelaDeAcesso.class.getResource("/icons/logo 2.png")).getImage().getScaledInstance(150, 115, Image.SCALE_SMOOTH);
		lblIconLogoMercado.setIcon(new ImageIcon(img_logomercado));
		
		JLabel nomeMercado = new JLabel("Mercadinho");
		nomeMercado.setForeground(SystemColor.black);
		nomeMercado.setFont(new Font("Tahoma", Font.BOLD, 13));
		nomeMercado.setHorizontalAlignment(SwingConstants.CENTER);
		nomeMercado.setBounds(0, 125, 625, 140);
		contentPane.add(nomeMercado);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanner.setBounds(2, 270, 620, 143);
		contentPane.add(lblBanner);
		Image img_banner = new ImageIcon(TelaDeAcesso.class.getResource("/icons/banner.png")).getImage().getScaledInstance(625, 160, 100);
		lblBanner.setIcon(new ImageIcon(img_banner));
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
