package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaExibirClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoClientes;

	
	

	/**
	 * Create the frame.
	 */
	public TelaExibirClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelClientes = new JLabel("Clientes:");
		labelClientes.setForeground(new Color(160, 82, 45));
		labelClientes.setFont(new Font("Arial", Font.BOLD, 20));
		labelClientes.setBounds(170, 11, 92, 24);
		contentPane.add(labelClientes);
		
		campoClientes = new JTextField();
		campoClientes.setFont(new Font("Arial", Font.PLAIN, 12));
		campoClientes.setBounds(10, 55, 414, 195);
		contentPane.add(campoClientes);
		campoClientes.setColumns(10);
		
		setVisible(true);
	}

	
		
		
	
	
	public static void main(String[] args) {
		new TelaExibirClientes();
	}

}
