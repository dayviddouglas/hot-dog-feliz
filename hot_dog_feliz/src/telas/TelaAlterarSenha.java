package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.app.hotdogfeliz.dominio.FuncionarioHotDog;

public class TelaAlterarSenha extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoSenha;
	private JFormattedTextField campoCpf;
    private String getCampoSenha, getCampoCpf;
	
	

	/**
	 * Create the frame.
	 */
	public TelaAlterarSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelCpfCliente = new JLabel("digite seu CPF:");
		labelCpfCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelCpfCliente.setBounds(10, 93, 106, 14);
		contentPane.add(labelCpfCliente);
		
		JLabel labelSenhaCliente = new JLabel("digite a nova senha:");
		labelSenhaCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelSenhaCliente.setBounds(10, 140, 142, 14);
		contentPane.add(labelSenhaCliente);
		
		JButton botaoAlterarSenha = new JButton("Alterar senha");
		botaoAlterarSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoAlterarSenha.setBounds(162, 227, 114, 23);
		contentPane.add(botaoAlterarSenha);
		
		
		botaoAlterarSenha.addActionListener(this);
		
		JLabel labelAlterarSenha = new JLabel("Alterar senha:");
		labelAlterarSenha.setForeground(new Color(160, 82, 45));
		labelAlterarSenha.setFont(new Font("Arial", Font.BOLD, 20));
		labelAlterarSenha.setBounds(143, 11, 133, 20);
		contentPane.add(labelAlterarSenha);
		
		campoCpf = new JFormattedTextField();
		campoCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		campoCpf.setBounds(162, 91, 130, 20);
		contentPane.add(campoCpf);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		campoSenha.setBounds(162, 138, 130, 20);
		contentPane.add(campoSenha);
		campoSenha.setColumns(10);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		getCampoCpf = campoCpf.getText();
		getCampoSenha = campoSenha.getText();
		
		   FuncionarioHotDog func = new FuncionarioHotDog();
		   func.alterarSenha(getCampoCpf,getCampoSenha);
		   JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		   setVisible(false);
		   TelaMenu telaMenu = new TelaMenu();
			telaMenu.criarTela();		
	}
	
	public static void main(String[] args) {
		new TelaAlterarSenha();
	}

	
}
