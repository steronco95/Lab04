package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	CorsoDAO corso = new CorsoDAO();
	StudenteDAO studente = new StudenteDAO();
	
	public List<Corso> getNomiCorsi() {
		
		
		return corso.getTuttiICorsi();
	}
	
	public String getNome(String matricola) {
		
		String nome = null;
		
		for(Studente s : studente.getTuttiGliStudenti()) {
			if(s.getMatricola().equals(matricola)) {
				nome = s.getNome();
				break;
			}
		}
		if(nome == null) {
			throw new NullPointerException("studente non presente nel database!");
			
		}
		
		return nome;
	}

	public String getCognome(String matricola) {
		
		String cognome = null;
		
		for(Studente s : studente.getTuttiGliStudenti()) {
			if(s.getMatricola().equals(matricola)) {
				cognome = s.getCognome();
				break;
			}
		}
		if(cognome == null) {
			throw new NullPointerException("studente non presente nel database!");
		}
		
		return cognome;
	}
	public List<Studente> getIscrittiAlCorso(Corso corso) {
		
		return this.corso.getStudentiIscrittiAlCorso(corso);
	}
	
	
}
