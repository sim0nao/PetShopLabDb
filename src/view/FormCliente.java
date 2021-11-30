package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ClienteDAO;
import model.Cliente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FormCliente extends JFrame {

	private static final long serialVersionUID = 6627616056999905821L;
	private JFrame Me = this;
	
	private JTextField textoCpf;
	private JTextField textoNome;
	private JTextField textoEndereco;
	private JTextField textoTelefone;
	private JTextField textoDataNascimento;
	private JComboBox<String> comboSexo;
	
	/* ---------------------------------------------------------------- */
	
	public FormCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setTitle("Cadastro de Clientes");
		
		initComponents();
		
		setVisible(true);
	}
	
	/* ---------------------------------------------------------------- */
	
	private void initComponents() {
		JPanel p = new JPanel();
		
		textoCpf = new JTextField();
		textoNome = new JTextField();
		textoEndereco = new JTextField();
		textoTelefone = new JTextField();
		textoDataNascimento = new JTextField();
		
		String[] sexo = { "M", "F", "O" };
		comboSexo = new JComboBox<>(sexo);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new BotaoCadastrar());
		
		JButton botaoFechar = new JButton("Fechar");
		botaoFechar.addActionListener(new BotaoFechar());
		
		p.setLayout(new GridLayout(7, 2));
		
		p.add(new JLabel("CPF"));
		p.add(textoCpf);
		p.add(new JLabel("Nome"));
		p.add(textoNome);
		p.add(new JLabel("Endereco"));
		p.add(textoEndereco);
		p.add(new JLabel("Telefone"));
		p.add(textoTelefone);
		p.add(new JLabel("Data de nascimento"));
		p.add(textoDataNascimento);
		p.add(new JLabel("Sexo"));
		p.add(comboSexo);
		p.add(botaoCadastrar);
		p.add(botaoFechar);
		
		this.add(p);
	}
	
	/* ---------------------------------------------------------------- */
	
	private class BotaoCadastrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Cliente c = new Cliente();
			c.setCpf(textoCpf.getText());
			c.setNome(textoNome.getText());
			c.setEndereco(textoEndereco.getText());
			c.setTelefone(textoTelefone.getText());
			c.setDataNascimento(LocalDate.parse(textoDataNascimento.getText()));
			c.setSexo(comboSexo.getSelectedItem().toString()); 
			
			boolean b = ClienteDAO.insert(c);
			
			if (b) {
				JOptionPane.showMessageDialog(Me, "Cadastro realizado com sucesso!", "Confirmacao", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(Me, "Erro ao cadastrar!", "Confirmacao", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/* ---------------------------------------------------------------- */
	
	private class BotaoFechar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Me.dispose();
		}
	}
}
