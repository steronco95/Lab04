package it.polito.tdp.lab04.model;

public class Studente {

	private String matricola;
	private String cognome;
	private String nome;
	private String cds;

	public Studente(String matricola, String cognome, String nome, String cds) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
	
	}

	public String getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCds() {
		return cds;
	}
	
	public String toString() {
		
		return matricola + " " + cognome + " " + nome + " " + cds;
	}
	

}
