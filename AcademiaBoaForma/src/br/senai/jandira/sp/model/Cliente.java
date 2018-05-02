package br.senai.jandira.sp.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String sexo;
	private String dtNasc;
	private String atividade;
	private int idade;
	private double altura;
	private double peso;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void idade(){
		LocalDate atual = LocalDate.now();
		
		LocalDate dtBanco = LocalDate.parse(getDtNasc());
		
		if (atual.compareTo(dtBanco) < 0){
			long diferencaAnos = ChronoUnit.YEARS.between(atual, dtBanco);
			System.out.println(diferencaAnos);
		}
	}

}
