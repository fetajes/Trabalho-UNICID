package br.edu.unicid.bean;

import java.util.Date;

public class Aluno {
	
	//Atributos
	private int rgm;
	private String nome;
	private String email;
	private Date dataNascimento;
	private String endereco;

	//Construtor
	public Aluno(int rgm, String nome, String email, Date dataNascimento, String endereco) {
		
		this.rgm = rgm;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	
	//Gets e Sets
	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

		
		
		
}