package com.app.hotdogfeliz.telas;

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

public class TelaRemoveCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCpfCliente;
	private String getCampoCpfCliente;

	
	

	/**
	 * Create the frame.
	 */
	public TelaRemoveCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPrincipal = new JLabel("Remover Cliente:");
		labelPrincipal.setForeground(new Color(160, 82, 45));
		labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		labelPrincipal.setBounds(120, 11, 171, 24);
		contentPane.add(labelPrincipal);
		
		JLabel labelCpfCliente = new JLabel("Cpf do Cliente:");
		labelCpfCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelCpfCliente.setBounds(29, 100, 114, 34);
		contentPane.add(labelCpfCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(162, 106, 107, 24);
		contentPane.add(campoCpfCliente);
		
		JButton botaoRemoveCli = new JButton("Remover Cliente");
		botaoRemoveCli.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoRemoveCli.setBounds(293, 107, 131, 23);
		contentPane.add(botaoRemoveCli);
		
		botaoRemoveCli.addActionListener(this);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		getCampoCpfCliente = campoCpfCliente.getText();
		
		ClienteHotDog cli = new ClienteHotDog();
		try {
			cli.deletarCliente(getCampoCpfCliente);
			JOptionPane.showMessageDialog(null,"Cliente removido com sucesso!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			TelaMenu telaMenu = new TelaMenu();
			telaMenu.criarTela();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new TelaRemoveCliente();
	}

	

}
