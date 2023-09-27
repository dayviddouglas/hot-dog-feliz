package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.app.hotdogfeliz.dominio.FuncionarioHotDog;

public class TelaLogin extends JFrame implements ActionListener {
	
	JTextField campoLogin, campoSenha;
	JLabel labelPrincipal,labelLogin,labelSenha;
	String loginUsuario, senhaUsuario;
	boolean confirm = false;



	public JTextField getCampoLogin() {
		return campoLogin;
	}


	public void setCampoLogin(JTextField campoLogin) {
		this.campoLogin = campoLogin;
	}


	public JTextField getCampoSenha() {
		return campoSenha;
	}


	public void setCampoSenha(JTextField campoSenha) {
		this.campoSenha = campoSenha;
	}


	public JLabel getLabelPrincipal() {
		return labelPrincipal;
	}


	public void setLabelPrincipal(JLabel labelPrincipal) {
		this.labelPrincipal = labelPrincipal;
	}


	public JLabel getLabelLogin() {
		return labelLogin;
	}


	public void setLabelLogin(JLabel labelLogin) {
		this.labelLogin = labelLogin;
	}


	public JLabel getLabelSenha() {
		return labelSenha;
	}


	public void setLabelSenha(JLabel labelSenha) {
		this.labelSenha = labelSenha;
	}


	public TelaLogin() {
		setTitle("Hot Dog Feliz");
		 
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
        JButton botaoEnviar = new JButton("Logar");
        botaoEnviar.setBounds(100,200,150,60);
        botaoEnviar.setFont(new Font("Arial",Font.BOLD,12));
        botaoEnviar.setForeground(new Color(0,0,0));
        botaoEnviar.setBackground(new Color(244,164,96));
        add(botaoEnviar);
        
        botaoEnviar.addActionListener(this);
        
        
        this.campoLogin = new JTextField();
        campoLogin.setBounds(100,100,100,40);
        campoLogin.setFont(new Font("Arial",Font.BOLD,12));
        
        add(campoLogin);
        
        this.campoSenha = new JTextField();
        campoSenha.setBounds(220,100,100,40);
        campoSenha.setFont(new Font("Arial",Font.BOLD,12));
        
        add(campoSenha);
        
        
        this.labelPrincipal = new JLabel("Bem vindo ao Hot Dog Feliz !!");
        labelPrincipal.setBounds(150, 20, 350, 50);
        labelPrincipal.setFont(new Font("Arial",Font.BOLD,20));
        labelPrincipal.setForeground(new Color(160,82,45));
        add(labelPrincipal);
        
        
        
        this.labelLogin = new JLabel();
        labelLogin.setText("Login:");
        labelLogin.setBounds(105, 70, 80, 40);
        labelLogin.setFont(new Font("Arial",Font.BOLD,12));
        add(labelLogin);
        
        this.labelSenha = new JLabel();
        labelSenha.setText("Senha:");
        labelSenha.setBounds(225, 70, 80, 40);
        labelSenha.setFont(new Font("Arial",Font.BOLD,12));
        add(labelSenha);
        
        setVisible(true);
        
        
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		   loginUsuario = campoLogin.getText();
		   senhaUsuario = campoSenha.getText();
		   
		   FuncionarioHotDog funcionario = new FuncionarioHotDog();
		   
		   confirm =funcionario.verificarLogin(loginUsuario, senhaUsuario);
		   if (confirm == true) {
			   JOptionPane.showMessageDialog(null,"Logado com sucesso!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			   setVisible(false);
			  
			  TelaMenu telaMenu = new TelaMenu();
				telaMenu.criarTela();
		   }else {
			   JOptionPane.showMessageDialog(null,"Login ou senha incorretos.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
		   }
		   
		   
		   
		   
		
		
	}
	
	
	public static void main(String[] args) {
		new TelaLogin();
	}


	


	

}


