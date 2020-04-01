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
		
		Corso tempCorso = corso;
		
		if(tempCorso == null) throw new NullPointerException("corso non selezionato!");
		
		return this.corso.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiStudente(String matricola) throws Exception {
	
		if(matricola == null) {
			throw new NullPointerException("matricola vuota, inserirne una valida!");
		}
		if(!studente.iscritto(matricola)) throw new Exception("studente non presente nel database!");
		
		return studente.getCorsiDelloStudente(matricola);
	}

	public boolean isIscritto(Corso corso, String matricola) throws Exception {
		
		boolean iscritto = false;
		
		if(!studente.iscritto(matricola)) throw new Exception("studente non presente nel database!");
		if(matricola == null) {
			throw new NullPointerException("matricola vuota, inserirne una valida!");
		}
		
		for(Corso c : this.getCorsiStudente(matricola)) {
			if(c.getCodice().equals(corso.getCodice())) {
				iscritto = true;
				break;
			}
		}
		
//		return this.getCorsiStudente(matricola).contains(corso);
		return iscritto;	
		
	}
	
	public boolean iscriviStudenteAlCorso(String matricola,Corso c) throws Exception {
		
		if(matricola == null) throw new NullPointerException("matricola vuota!");
		if(c == null) throw new NullPointerException("corso non selezionato!");
		if(studente.getStudente(matricola) == null) throw new  NullPointerException("studente inesistente!");
		if(this.isIscritto(c, matricola)) throw new Exception("studente gia iscritto al corso");
		
		return corso.inscriviStudenteACorso(studente.getStudente(matricola), c);
	}
	
	
}
