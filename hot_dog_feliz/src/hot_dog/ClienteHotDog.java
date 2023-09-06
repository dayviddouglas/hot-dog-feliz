package hot_dog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteHotDog {
   private String cpf;
  private String nome;
  private String data_nascimento;
  private String endereco;
  

   
public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getData_nascimento() {
	return data_nascimento;
}

public void setData_nascimento(String data_nascimento) {
	this.data_nascimento = data_nascimento;
}



  public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}


public String convertSql (String palavra) {
	
	return "'"+ palavra + "'";
	
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
	    	   System.out.println("Cliente inexistente...");
	       }
	      while (rs.next()) {
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
	    conexaoDelet.close();
	    statment.close();
	    if (resultado != 1) {
	    	System.out.println("Houve algum erro na deleção...");
	    }
	    
	    System.out.println("Registro foi deletado com sucesso!");
	  
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
