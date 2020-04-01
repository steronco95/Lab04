package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String matricola = rs.getString("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

//				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				Studente s = new Studente(matricola,cognome,nome,cds);
				studenti.add(s);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public List<Corso> getCorsiDelloStudente(String matricola){
		
		final String sql = "SELECT c.codins, c.nome, c.crediti, c.pd FROM corso c, studente s, iscrizione i WHERE s.matricola = ? AND s.matricola = i.matricola AND c.codins = i.codins";

		List<Corso> corsiDelloStudente = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				Corso c = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsiDelloStudente.add(c);
				
			}

			conn.close();
			
			return corsiDelloStudente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	public boolean iscritto(String matricola) {
		
		Studente s = null;
		
		for(Studente temp : this.getTuttiGliStudenti()) {
			if(temp.getMatricola().equals(matricola)) {
				return true;
			}
		}
		
		return false;
	}
	public Studente getStudente(String matricola) {
		Studente tempS = null;
		
		for(Studente temp : this.getTuttiGliStudenti()) {
			if(temp.getMatricola().equals(matricola)) {
				tempS = temp;
				break;
			}
		}
		
		return tempS;
	}
	
}
