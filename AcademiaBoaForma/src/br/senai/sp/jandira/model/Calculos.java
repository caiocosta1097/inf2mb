package br.senai.sp.jandira.model;

public class Calculos extends Cliente {
	// Atributos da Classe

	private double imc;
	private double tmb;
	private double fcm;
	private String atividade;
	private String respostaImc;

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

	public String getRespostaImc() {
		return respostaImc;
	}

	public void setRespostaImc(String respostaImc) {
		this.respostaImc = respostaImc;
	}

	// Métodos da Classe

	public double imc() {
		imc = getPeso() / (getAltura() / 100 * getAltura() / 100);

		if (imc <= 16.9) {
			respostaImc = "Muito abaixo do peso:\nQueda de cabelo, infertilidade, ausência menstrual.";
		} else if (imc <= 18.4) {
			respostaImc = "Abaixo do peso:\nFadiga, stress, ansiedade.";
		} else if (imc <= 24.9) {
			respostaImc = "Peso normal:\nMenor risco de doenças cardíacas e vasculares.";
		} else if (imc <= 29.9) {
			respostaImc = "Acima do peso:\nFadiga, má circulação, varizes.";
		} else if (imc <= 34.9) {
			respostaImc = "Obesidade Grau I:\nDiabetes, angina, infarto, aterosclerose.";
		} else if (imc <= 40) {
			respostaImc = "Obesidade Grau II:\nApneia do sono, falta de ar.";
		} else if (imc > 40) {
			respostaImc = "Obesidade Grau III:\nRefluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
		}

		return imc;
	}

	public double tmb() {
		if (getSexo() == "Homem") {
			tmb = 66 + (13.7 * getPeso()) + (5 * getAltura()) - (6.8 * getIdade());
		} else if (getSexo() == "Mulher") {
			tmb = 665 + (9.6 * getPeso()) + (1.8 * getAltura()) - (4.7 * getIdade());
		}

		if (atividade == "Sedentário") {
			tmb = tmb * 1.20;
		} else if (atividade == "Levemente Ativo") {
			tmb = tmb * 1.37;
		} else if (atividade == "Moderadamente Ativo") {
			tmb = tmb * 1.55;
		} else if (atividade == "Bastante Ativo") {
			tmb = tmb * 1.72;
		} else if (atividade == "Muito Ativo") {
			tmb = tmb * 1.90;
		}

		return tmb;
	}

	public double fcm() {
		if (getSexo().equals("Homem")) {
			fcm = ((210 - (0.5 * getIdade())) - getPeso() * 1 / 100) + 4;
		} else if (getSexo().equals("Mulher")) {
			fcm = ((210 - (0.5 * getIdade())) - getPeso() * 1 / 100);
		}
		
		return fcm;
	}

}
