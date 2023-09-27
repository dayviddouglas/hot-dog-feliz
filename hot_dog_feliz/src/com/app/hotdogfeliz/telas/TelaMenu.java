package com.app.hotdogfeliz.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.app.hotdogfeliz.dominio.ClienteHotDog;

public class TelaMenu extends JFrame implements ActionListener {

	
	JLabel labelPrincipal, labelCriarCliente,
	labelconsultCliente,labelAltCliente,labelDelCliente, labelVerClientes, labelAltSenhaFunc,labelSairSistema;
	JTextField campoPrincipal;
	String respostaUsu;
	
	
	
	
	 public void criarLabel( JLabel label,String textoLabel, int largura,int altura,
			 int distanciaX,int distanciaY,int tamanhoFonte, int vermelhoRgb, int verdeRgb, int azulRgb) {
		 label = new JLabel(textoLabel);
		 label.setBounds(distanciaX, distanciaY, largura, altura);
		 label.setFont(new Font("Arial",Font.BOLD,tamanhoFonte));
		 label.setForeground(new Color(vermelhoRgb,verdeRgb,azulRgb));
		 add(label);
	 }
	 
	 public void criarCampoText(JTextField campo, int distanciaX, int distanciaY,int largura , int altura, int tamanhoFonte) {
		 campo = new JTextField();
		 campo.setBounds(distanciaX, distanciaY, largura , altura);
		 campo.setFont(new Font ("Arial",Font.BOLD,tamanhoFonte));
		 add(campo);
	 }
	
	
	
   public void criarTela () {
	   setTitle("Hot Dog Feliz");
		 
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		criarLabel(labelPrincipal, "Menu Principal",350, 50, 210, 20, 20,160, 82,45);
		
		
		
		criarLabel(labelCriarCliente,"1- Cadastrar Cliente.",180, 40, 210,70,16,0,0,0);
		criarLabel(labelconsultCliente,"2- Consultar Cliente.",180, 90, 210,70,16,0,0,0);
		criarLabel(labelAltCliente,"3- Alterar Endereço do Cliente.",250, 140, 210,70,16,0,0,0);
		criarLabel(labelDelCliente,"4- Remover Cliente.",180, 190, 210,70,16,0,0,0);
		criarLabel(labelVerClientes,"5- Exibir todos os clientes.",230, 240, 210,70,16,0,0,0);
		criarLabel(labelAltSenhaFunc,"6- Alterar Senha.",180, 290, 210,70,16,0,0,0);
		criarLabel(labelSairSistema,"9- Sair.",180, 340, 210,70,16,0,0,0);
		
//		criarCampoText(campoPrincipal,210,280, 90,35, 16);
		
		this.campoPrincipal = new JTextField();
		campoPrincipal.setBounds(210,280,90,35);
		campoPrincipal.setFont(new Font("Arial",Font.BOLD,16));
        
        add(campoPrincipal);
		
		
		JButton botaoConfirma = new JButton("Confirmar");
        botaoConfirma.setBounds(400,280,114,35);
        botaoConfirma.setFont(new Font("Arial",Font.BOLD,12));
        botaoConfirma.setForeground(new Color(0,0,0));
        add(botaoConfirma);
        
        botaoConfirma.addActionListener(this);
		
		
		
		
		
		
		setVisible(true);
   }
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		respostaUsu = campoPrincipal.getText();
		
	int respostaFormatada = Integer.parseInt(respostaUsu);
	 
			  
			switch (respostaFormatada) {
			case 1:
				new CadastrarCliente();
				setVisible(false);
				
				break;
			case 2:
				new TelaConsultaCliente();
				setVisible(false);
				break;
			case 3:
				new TelaAlterarCliente();
				setVisible(false);
				break;
				
			case 4:
				new TelaRemoveCliente();
				setVisible(false);
				break;
			case 5:
				   ClienteHotDog client = new ClienteHotDog();
				   try {
					client.listaClientes();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				new TelaAlterarSenha();
				setVisible(false);
				break;
				
			case 9:
				setVisible(false); 
				dispose(); 
				break;	

			default:
				break;
			}
			
			
			
		}catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		TelaMenu telaMenu = new TelaMenu();
		telaMenu.criarTela();
		

	}

	

}
