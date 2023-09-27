package com.app.hotdogfeliz.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.app.hotdogfeliz.dominio.ClienteHotDog;

public class TelaConsultaCliente extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCpfCliente;
	private String getcampoCpfCliente;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaConsultaCliente() {
		setTitle("Hot Dog Feliz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPrincipal = new JLabel("Consultar Cliente:");
		labelPrincipal.setForeground(new Color(160, 82, 45));
		labelPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		labelPrincipal.setBounds(117, 11, 170, 44);
		contentPane.add(labelPrincipal);
		
		JLabel labelCpfCliente = new JLabel("Cpf do Cliente:");
		labelCpfCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelCpfCliente.setBounds(39, 68, 114, 34);
		contentPane.add(labelCpfCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(163, 74, 107, 24);
		contentPane.add(campoCpfCliente);
		
		JButton botaoConsultCliente = new JButton("Consultar Cliente");
		botaoConsultCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoConsultCliente.setBounds(141, 124, 145, 23);
		contentPane.add(botaoConsultCliente);
		
		botaoConsultCliente.addActionListener(this);
		
		
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		getcampoCpfCliente = campoCpfCliente.getText();
		  ClienteHotDog cliente = new ClienteHotDog();
		  try {
			  cliente.consultarCliente(getcampoCpfCliente);	
			  setVisible(false);
			  TelaMenu telaMenu = new TelaMenu();
				telaMenu.criarTela();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new TelaConsultaCliente();
	}



	

}
