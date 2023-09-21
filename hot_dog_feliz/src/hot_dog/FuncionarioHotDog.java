package hot_dog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionarioHotDog extends UsuarioHotDog {

    private String login;
    private String senha;
    private String cpfUsuario;
    
    
    public FuncionarioHotDog() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    public FuncionarioHotDog(UsuarioHotDog usuario) {
       this.cpfUsuario = usuario.getCpf();
    		
	}
    
    public FuncionarioHotDog(String cpfFuncio, String nomeFuncio,String dataNascFuncio, String endeFuncio, String emailFuncio ) {
		setCpf(cpfFuncio);
		setNome(nomeFuncio);
		setData_nascimento(dataNascFuncio);
		setEndereco(endeFuncio);
		setEmail(emailFuncio);
	}
    
    
    
	
	public String getCpfUsuario() {
		return cpfUsuario;
	}




	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}




	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public void criarFuncionario (String cpfFunc, String nomeFunc, String emailFunc, String dataNascFunc ) throws Exception {
		setCpf(cpfFunc);
		setNome(nomeFunc);
		setEmail(emailFunc);
		setData_nascimento(dataNascFunc);
		String cpfSql,nomeSql,emailSql,dataNascSql;
		
		 cpfSql = convertSql(cpfFunc);
		 nomeSql = convertSql(nomeFunc);
		 emailSql = convertSql(emailFunc);
		 dataNascSql = convertSql(dataNascFunc);
		
		
		Connection connUserCreate = Conexao.abrir();
		 Statement stm = connUserCreate.createStatement();
		 int result = stm.executeUpdate("insert into funcionario (cpf,nome,email,dataNasc) values ("+ cpfSql+ "," + nomeSql + "," + emailSql
				 + "," + dataNascSql + ")");
		 
		 if(result != 1) {
			 System.out.println("Ocorreu algum problema na inserção.");
		 }
		 
		 System.out.println("Funcionario criado com sucesso!");
		 
		 connUserCreate.close();
		 stm.close();
		 
	}
	 
	public void criarLoginFuncionario (String cpfFuncio, String dataNasciFuncio, String emailFuncio) {
		
		      Scanner entrada = new Scanner(System.in);
		      
		      String loginUsuario = null, senhaUsuario = null;
			   
		       if (!getCpf().equalsIgnoreCase(cpfFuncio)&&!getData_nascimento().equalsIgnoreCase(dataNasciFuncio)&& !getEmail().equalsIgnoreCase(emailFuncio)) {
		    	   System.out.println("Os dados não correspondem...");
		       }else {
		    	   System.out.println("Digite o seu login:");
			        loginUsuario = entrada.nextLine();
			       
			       System.out.println("Digite sua senha:");
			         senhaUsuario = entrada.nextLine();
		       }
		    		  
		
		      String loginSql= convertSql(loginUsuario);
		      String senhaSql = convertSql(senhaUsuario);
		      String cpfSql = convertSql(cpfFuncio);
		      
		      
		      
	try {
		
		Connection connLoginCreate = Conexao.abrir();
		  Statement statmet = connLoginCreate.createStatement();
		  int resultLogin = statmet.executeUpdate("update funcionario set login ="+ loginSql + " where cpf="+cpfSql+";");
		  int resultSenha = statmet.executeUpdate("update funcionario set senha ="+ senhaSql + " where cpf="+cpfSql+";");
		  if (resultLogin == 1 && resultSenha == 1) {
			  System.out.println("O login foi feito com sucesso!"); 
		  }
		  
		  connLoginCreate.close();
		  statmet.close();
		
		}catch (Exception e) {
			e.getMessage();
		}
	 
	
	}
	
	public boolean verificarLogin(String loginFunc, String senhaFunc) {
		
		String queryLogin = null, loginBanco = null, senhaBanco = null;
		boolean confirm = false;
		
		try {
			Connection connec = Conexao.abrir();
			Statement stm = connec.createStatement();
			queryLogin = "select login, senha from funcionario";
			ResultSet resul = stm.executeQuery(queryLogin);
			    
			     while (resul.next()) {
			    	 loginBanco = resul.getString("login");
					 senhaBanco = resul.getString("senha");
			     }

			  if (loginFunc.equals(loginBanco) && senhaFunc.equals(senhaBanco)) {
				 confirm = true;
			  }
			  
			  connec.close();
			  stm.close();
			  
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return confirm;
		
		
	}
	
	
	public String alterarSenha (String cpfFuncio, String novaSenha) {
		
		String cpfFormatado =  convertSql(cpfFuncio), senhaFormatada = convertSql(novaSenha),retorno = null; 
		try {
			Connection conex = Conexao.abrir();
			Statement state = conex.createStatement();
			int resultado = state.executeUpdate("update funcionario set senha =" + senhaFormatada+ "where cpf ="+ cpfFormatado);
			
			conex.close();
			state.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		retorno = "Senha alterada com sucesso!";
		
		return retorno;
		
	}
	
	
	
    
    
}
