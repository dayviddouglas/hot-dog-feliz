package com.app.hotdogfeliz.dominio;

public abstract class UsuarioHotDog {
	  private String cpf;
	  private String nome;
	  private String data_nascimento;
	  private String endereco;
	  private String email;
	  
	 public static String convertSql (String palavra) {
			
			return "'"+ palavra + "'";
			
	}
	  
	  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	  
	  
	

}
