package br.senai.sp.jandira.model;

public class Calculos extends Cliente {
	// Atributos
	private double imc;
	private double tmb;
	private double fcm;
	private String atividade;
	
	// Métodos Getters e Setters
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public double getTmb() {
		return tmb;
	}
	public void setTmb(double tmb) {
		this.tmb = tmb;
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm(double fcm) {
		this.fcm = fcm;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	
}
