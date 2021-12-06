package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainForm extends JFrame {

	private static final long serialVersionUID = -3155516309403288519L;

	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenu menuCadastro;
	
	private JMenuItem menuArquivoSair;
	private JMenuItem menuCadastroCliente;
	
	
	/* ---------------------------------------------------------------- */
	
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("PetShop Lab");
		initComponents();
		setVisible(true);
	}
	
	/* ---------------------------------------------------------------- */
	
	private void initComponents() {
		menuBar = new JMenuBar();
		
		menuArquivo = new JMenu("Arquivo");
		menuCadastro = new JMenu("Cadastro");
		
		menuArquivoSair = new JMenuItem("Sair");
		menuCadastroCliente = new JMenuItem("Cliente");
		
		menuArquivo.add(menuArquivoSair);
		menuCadastro.add(menuCadastroCliente);
		
		menuBar.add(menuArquivo);
		menuBar.add(menuCadastro);
		
		setJMenuBar(menuBar);
	}
	
	/* ---------------------------------------------------------------- */
	
	
}
