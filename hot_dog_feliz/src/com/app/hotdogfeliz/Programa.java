package com.app.hotdogfeliz;

import java.util.Scanner;

import com.app.hotdogfeliz.dominio.ClienteHotDog;
import com.app.hotdogfeliz.dominio.FuncionarioHotDog;

public class Programa {

	public static void main(String[] args) throws Exception {
		
		boolean confirmacao = false;
		 int opcaoSelecionada = 0;
		String nomeCliente,dataNasciCliente,cpfCliente,endeCliente,loginAcesso,senhaAcesso; 
		
		Scanner entrada = new Scanner(System.in);
		
		FuncionarioHotDog func = new FuncionarioHotDog();
		
		ClienteHotDog cli = new ClienteHotDog();
		 
		 while (confirmacao == false) {
		 System.out.println("\nSeja Bem vindo ao Hot Dog Feliz!!\n");
		 
		 System.out.println("Pagina de Login\n");
		 
		 System.out.println("Digite seu login");
		 loginAcesso = entrada.nextLine();
		 
		 System.out.println("Digite sua senha");
		 senhaAcesso = entrada.nextLine();
            	if (!func.verificarLogin(loginAcesso, senhaAcesso)) {
            		System.out.println("Login ou senha incorretos...");
            	}else {
            		System.out.println("Logado com sucesso");
        	      confirmacao = true;
            	}
                     	
        }
		 
		 do {
          System.out.println("\nSeja Bem vindo ao Hot Dog Feliz!!\n");
			 
			 System.out.println("Digite a sua opção:");
			   
			   
			   System.out.println("1 - Cadastrar Cliente.");
			   System.out.println("2 - Consultar Cliente.");
			   System.out.println("3 - Alterar Cliente.");
			   System.out.println("4 - Remover Cliente.");
			   System.out.println("5 - Exibir todos os clientes.");
			   System.out.println("6 - Alterar senha");
			   System.out.println("9 - Sair do sistema. ");
			   
			   opcaoSelecionada = entrada.nextInt();
			   entrada.nextLine();
			   
			   switch (opcaoSelecionada) {
			case 1:
				System.out.println("Digite o cpf do Cliente: (000.000.000-00)");
				 cpfCliente = entrada.nextLine();
				 
				 System.out.println("Digite o nome do Cliente");
				 nomeCliente = entrada.nextLine();
				 
				 System.out.println("Digite a data de nascimento: (ano-mês-dia):");
				 dataNasciCliente = entrada.nextLine();
				 
				 System.out.println("Digite o endereço do Cliente:");
				 endeCliente = entrada.nextLine();
				 
				 cli.criarCliente(nomeCliente, dataNasciCliente, cpfCliente, endeCliente);
				break;
				
			case 2:
					
					System.out.println("Digite o cpf do cliente: (000.000.000-00)");
					cpfCliente = entrada.nextLine();
					cli.consultarCliente(cpfCliente);
					
			break;
			case 3:
				
				System.out.println("Digite o cpf do cliente: (000.000.000-00)");
				cpfCliente = entrada.nextLine();
				
				System.out.println("Digite o novo Endereço do Cliente");
				endeCliente = entrada.nextLine();
				
				cli.atualizarEndCliente(cpfCliente, endeCliente);
				
			break;
			
			case 4:
				
				System.out.println("digite o cpf do cliente que irá ser removido: (000.000.000-00)");
				 cpfCliente = entrada.nextLine();
				 
				 cli.deletarCliente(cpfCliente);
				 
			
			break;
			
			case 5:
				
				cli.listaClientes();
				
			break;
			case 6:
				
				System.out.println("Digite o seu cpf:");
				String cpfUsu = entrada.nextLine();
				
				System.out.println("Digite a sua nova senha:");
				String senhaUsu = entrada.nextLine();
				
				func.alterarSenha(cpfUsu, senhaUsu);
				
			break;
			
			case 9:
				System.out.println("Você saiu do Sistema. ");
			break;
				

			default:
				break;
			}
			   
			   
		 }while (opcaoSelecionada != 9);
		 
		 entrada.close();
		 
			 
			
		
	
	
         
	}

}
