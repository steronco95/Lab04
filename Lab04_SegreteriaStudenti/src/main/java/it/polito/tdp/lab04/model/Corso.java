package it.polito.tdp.lab04.model;

public class Corso {

	private String codice;
	private int numeroCrediti;
	private String nome;
	private int periodoDidattico;

	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		this.codice = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	public String getCodice() {
		return codice;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	

}
