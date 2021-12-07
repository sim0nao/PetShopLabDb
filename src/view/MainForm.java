package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

	private static final long serialVersionUID = -3155516309403288519L;

	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenu menuCadastro;
	
	private JMenuItem menuArquivoSair;
	private JMenuItem menuCadastroCliente;
	private JFrame Me;
	
	
	/* ---------------------------------------------------------------- */
	
	public MainForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("PetShop Lab");
		Me = this;
		initComponents();
		setVisible(true);
	}
	
	/* ---------------------------------------------------------------- */
	
	private void initComponents() {
		menuBar = new JMenuBar();
		
		menuArquivo = new JMenu("Arquivo");
		menuCadastro = new JMenu("Cadastro");
		
		menuArquivoSair = new JMenuItem("Sair");
		menuArquivoSair.addActionListener(new MenuArquivoSair_Click());
		
		menuCadastroCliente = new JMenuItem("Cliente");
		menuCadastroCliente.addActionListener(new MenuCadastroCliente_Click());
		
		menuArquivo.add(menuArquivoSair);
		menuCadastro.add(menuCadastroCliente);
		
		menuBar.add(menuArquivo);
		menuBar.add(menuCadastro);
		
		setJMenuBar(menuBar);
	}
	
	/* ---------------------------------------------------------------- */
	
	private class MenuArquivoSair_Click implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
/* ---------------------------------------------------------------- */
	
	private class MenuCadastroCliente_Click implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Me.add(new FormCliente());
		}
	}
}
