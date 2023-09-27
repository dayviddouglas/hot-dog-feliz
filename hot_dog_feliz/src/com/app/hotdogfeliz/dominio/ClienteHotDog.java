package com.app.hotdogfeliz.dominio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.app.hotdogfeliz.conexao.Conexao;
import com.app.hotdogfeliz.exception.ClienteInexistenteException;

public class ClienteHotDog extends UsuarioHotDog{
  
  private String cpfUsuario;
  
	
	public String getCpfUsuario() {
	return cpfUsuario;
}

public void setCpfUsuario(String cpfUsuario) {
	this.cpfUsuario = cpfUsuario;
}

	public ClienteHotDog() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteHotDog(UsuarioHotDog usuario) {
		this.cpfUsuario = usuario.getCpf();
		
	}

public void criarCliente (String nomeCliente, String dataNascCliente, String cpfCliente, String EndeCliente) throws Exception {
	  
	  setCpf(cpfCliente);
	  setNome(nomeCliente);
	  setData_nascimento(dataNascCliente);
	  setEndereco(EndeCliente);
	  
      Connection conn = Conexao.abrir();
	  Statement stmt = conn.createStatement();
	  String queryInsert = "insert into cliente (nome,data_nascimento,cpf, endereco) values("+ convertSql(nomeCliente)+","
	  + convertSql(dataNascCliente)+","+ convertSql(cpfCliente)+","+convertSql(EndeCliente)+")";
	   int rs =stmt.executeUpdate(queryInsert);
	  conn.close();
	  stmt.close();
	  if (rs==1) {
		  System.out.println("Cliente inserido com sucesso!");
	  }else {
		  System.out.println("Houve algum problema...");
	  }
	     
	  
  }
  
  public String atualizarEndCliente (String cpfCliente, String novoEndereco) throws Exception {
	  String novoEnd = convertSql(novoEndereco);
	   String cpfFormatado= convertSql(cpfCliente); 
	   
	  Connection connUpdate = Conexao.abrir();
	  
	  Statement stmt = connUpdate.createStatement();
	  
	  String queryUpdate = "UPDATE cliente set endereco="+novoEnd+"where cpf ="+cpfFormatado+ ";";
	  int resultado = stmt.executeUpdate(queryUpdate);
	  
	  connUpdate.close();
	  stmt.close();
	  
	  String confirmacao = (resultado == 1)? "Dados atualizados com sucesso!" : "Houve algum erro...";
	   return confirmacao;
  }
  
  
  public void consultarCliente (String cpfCliente) throws Exception {
	  String cpfSql = convertSql(cpfCliente);
	  Connection conexaoSeletCli = Conexao.abrir();
	  Statement stment = conexaoSeletCli.createStatement();
	  ResultSet rs = stment.executeQuery("Select * from cliente where cpf =" + cpfSql);
	      
	       if (!rs.isBeforeFirst()) {
	    	   throw new ClienteInexistenteException();
	       }
	      while (rs.next()) {
	    	  JOptionPane.showMessageDialog(null," Dados do cliente: \n cpf do Cliente: "+ rs.getString("cpf")+
	    			   ", nome do cliente: "+ rs.getString("nome")+ ", data de nascimento: "
					   + rs.getString("data_nascimento")+ ", endereço: " + rs.getString("endereco"), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
	    	  System.out.println(" Dados do cliente: \n cpf do Cliente: "+ rs.getString("cpf")+
	    			   ", nome do cliente: "+ rs.getString("nome")+ ", data de nascimento: "
	    					   + rs.getString("data_nascimento")+ ", endereço: " + rs.getString("endereco") );
	      }
	        
	      rs.close();
	      stment.close();
	      conexaoSeletCli.close();
  }
  
  
  public void deletarCliente (String cpfCliente) throws Exception {
	  String cpfSql = convertSql(cpfCliente);
	  Connection conexaoDelet = Conexao.abrir();
	   Statement statment = conexaoDelet.createStatement();
	   String queryDelete = "DELETE FROM cliente where cpf ="+cpfSql+";";
	    int resultado = statment.executeUpdate(queryDelete);
	    
	    if (resultado != 1) {
	    	System.out.println("Houve algum erro na deleção...");
	    }
	    
	    System.out.println("Registro foi deletado com sucesso!");
	    conexaoDelet.close();
	    statment.close();
	  
  }
  
  public void listaClientes () throws Exception {
	  
	  Connection conexaoSelect = Conexao.abrir();
	  Statement stment = conexaoSelect.createStatement();
	  String querySelect = "Select * from cliente";
	  ResultSet rs = stment.executeQuery(querySelect);
	  
	  if (!rs.isBeforeFirst()) {
		  System.out.println("Não existe nenhum cliente cadastrado...");
	  }else {
		  
		  System.out.println(" Esses são todos os clientes:\n");
		  while (rs.next()) {
			  JOptionPane.showMessageDialog(null,"cpf do Cliente: "+ rs.getString("cpf")+
			   ", nome do cliente: "+ rs.getString("nome")+ ", data de nascimento: "
					   + rs.getString("data_nascimento")+ ", endereço: " + rs.getString("endereco"), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			  
			  
			   System.out.println("cpf do Cliente: "+ rs.getString("cpf")+
			   ", nome do cliente: "+ rs.getString("nome")+ ", data de nascimento: "
					   + rs.getString("data_nascimento")+ ", endereço: " + rs.getString("endereco") );	
			}
		  
	  }
	   
	  
	  rs.close();
	  stment.close();
	  conexaoSelect.close();
	  
	  
	  
	  
  }
  
  
}