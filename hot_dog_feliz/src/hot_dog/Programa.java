package hot_dog;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		ClienteHotDog cli = new ClienteHotDog();
		 int opcaoSelecionada = 0;
		 String nomeCliente,dataNasciCliente,cpfCliente,endeCliente;  
		 
		 do {
          System.out.println("\nSeja Bem vindo ao Hot Dog Feliz!!\n");
			 
			 System.out.println("Digite a sua opção:");
			   
			   
			   System.out.println("1 - Cadastrar Cliente.");
			   System.out.println("2 - Consultar Cliente.");
			   System.out.println("3 - Alterar Cliente.");
			   System.out.println("4 - Remover Cliente.");
			   System.out.println("5 - Exibir todos os clientes.");
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
			
			case 9:
				System.out.println("Você saiu do Sistema. ");
			break;
				

			default:
				break;
			}
			   
			   
		 }while (opcaoSelecionada != 9);
		 
			 
			
		
	
	
         
	}

}
