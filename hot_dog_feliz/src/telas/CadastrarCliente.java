package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.app.hotdogfeliz.dominio.ClienteHotDog;

public class CadastrarCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCpfCliente;
	private JTextField campoNomeCliente;
	private JTextField campoDataNascCliente;
	private JTextField campoEndCliente;
	
	private String getCampoCpfCliente,getCampoNomeCliente,getCampoDataNascCliente,getCampoEndCliente;
	


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CadastrarCliente() {
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(0, 0, 0));
		setTitle("Hot Dog Feliz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPrincipal = new JLabel("Cadastrar Cliente:");
		labelPrincipal.setBounds(117, 11, 171, 24);
		labelPrincipal.setForeground(new Color(160, 82, 45));
		labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(labelPrincipal);
		
		JLabel labelCadrastCliente = new JLabel("Cpf do Cliente:");
		labelCadrastCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelCadrastCliente.setBounds(28, 46, 114, 34);
		contentPane.add(labelCadrastCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoCpfCliente.setBounds(152, 52, 107, 24);
		contentPane.add(campoCpfCliente);
		campoCpfCliente.setColumns(10);
		
		JLabel labelNomeCliente = new JLabel("Nome do Cliente:");
		labelNomeCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelNomeCliente.setBounds(28, 91, 136, 34);
		contentPane.add(labelNomeCliente);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(162, 97, 191, 24);
		contentPane.add(campoNomeCliente);
		
		JLabel labelDataNascCliente = new JLabel("Data de Nascimento:");
		labelDataNascCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelDataNascCliente.setBounds(28, 140, 148, 34);
		contentPane.add(labelDataNascCliente);
		
		campoDataNascCliente = new JTextField();
		campoDataNascCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoDataNascCliente.setColumns(10);
		campoDataNascCliente.setBounds(186, 146, 86, 24);
		contentPane.add(campoDataNascCliente);
		
		JLabel labelEndCliente = new JLabel("Endereço do Cliente:");
		labelEndCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelEndCliente.setBounds(28, 185, 148, 34);
		contentPane.add(labelEndCliente);
		
		campoEndCliente = new JTextField();
		campoEndCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoEndCliente.setColumns(10);
		campoEndCliente.setBounds(182, 191, 242, 24);
		contentPane.add(campoEndCliente);
		
		JButton botaoCadastCliente = new JButton("Cadastrar Cliente");
		botaoCadastCliente.setFont(new Font("Arial", Font.BOLD, 12));
		botaoCadastCliente.setBounds(152, 227, 136, 23);
		contentPane.add(botaoCadastCliente);
		
		botaoCadastCliente.addActionListener(this);
		
		
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)  {
		
		getCampoCpfCliente = campoCpfCliente.getText();
		System.out.println(getCampoCpfCliente);
		getCampoDataNascCliente = campoDataNascCliente.getText();
		getCampoNomeCliente = campoNomeCliente.getText();
		getCampoEndCliente = campoEndCliente.getText();
		
		ClienteHotDog cli = new ClienteHotDog();
		
		
			try {
				cli.criarCliente(getCampoNomeCliente, getCampoDataNascCliente, getCampoCpfCliente, getCampoEndCliente);
				JOptionPane.showMessageDialog(null,"Cliente criado com sucesso!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.criarTela();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		
		
	}
	
	
	
	
		public static void main(String[] args) {
		new CadastrarCliente();
	}




		

		
	
	
	
}
