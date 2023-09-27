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

public class TelaAlterarCliente extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCpfCliente;
	private JTextField campoNovoEndereco;
	private String getCampoCpfCliente, getCampoNovoEndereco;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaAlterarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelprincipal = new JLabel("Alterar Endereço do Cliente:");
		labelprincipal.setForeground(new Color(160, 82, 45));
		labelprincipal.setFont(new Font("Arial", Font.BOLD, 20));
		labelprincipal.setBounds(75, 11, 267, 24);
		contentPane.add(labelprincipal);
		
		JLabel labelCpfCliente = new JLabel("Cpf do Cliente:");
		labelCpfCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelCpfCliente.setBounds(10, 64, 114, 34);
		contentPane.add(labelCpfCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(134, 72, 107, 24);
		contentPane.add(campoCpfCliente);
		
		JLabel labelNovoEndereco = new JLabel("Novo Endereço:");
		labelNovoEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		labelNovoEndereco.setBounds(10, 118, 124, 34);
		contentPane.add(labelNovoEndereco);
		
		campoNovoEndereco = new JTextField();
		campoNovoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		campoNovoEndereco.setColumns(10);
		campoNovoEndereco.setBounds(134, 124, 191, 24);
		contentPane.add(campoNovoEndereco);
		
		JButton botaoAtualiEndereco = new JButton("Atualizar Endereço");
		botaoAtualiEndereco.setBounds(152, 192, 150, 23);
		contentPane.add(botaoAtualiEndereco);
		botaoAtualiEndereco.addActionListener(this);
		
	
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		getCampoCpfCliente = campoCpfCliente.getText();
		getCampoNovoEndereco = campoNovoEndereco.getText();
		
		   ClienteHotDog client = new ClienteHotDog();
		   try {
			client.atualizarEndCliente(getCampoCpfCliente, getCampoNovoEndereco);
			JOptionPane.showMessageDialog(null,"Cliente atualizado com sucesso!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			TelaMenu telaMenu = new TelaMenu();
			telaMenu.criarTela();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new TelaAlterarCliente();
	}

	

}
