/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblCorsi"
    private Label lblCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="cBoxCorsi"
    private ComboBox<Corso> cBoxCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="ckxRiempimento"
    private CheckBox ckxRiempimento; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscriviStudente"
    private Button btnIscriviStudente; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultati"
    private TextArea txtRisultati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

	private Model model;

    @FXML
    void doIscrizione(ActionEvent event) {

    	txtRisultati.clear();
    	
    	try {
    		model.iscriviStudenteAlCorso(txtMatricola.getText(), cBoxCorsi.getValue());
    		txtRisultati.appendText("studente iscritto al corso: " + cBoxCorsi.getValue().getNome());
    	}catch(NullPointerException n) {
    		txtRisultati.appendText(n.getMessage());
    	} catch (Exception e) {
			txtRisultati.appendText(e.getMessage());
		}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	
    	txtRisultati.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	
    }

    @FXML
    void doRicercaCorsiStudente(ActionEvent event) {

    	txtRisultati.clear();
    	
    	if( cBoxCorsi.getValue()!= null){
    		try {
    		if(model.isIscritto(cBoxCorsi.getValue(),txtMatricola.getText())) {
    			txtRisultati.appendText("studente già iscritto al corso!");
    		}else {
    			txtRisultati.appendText("studente non iscritto al corso: "+ cBoxCorsi.getValue().getNome());
    		}
    		}catch(Exception e) {
    			txtRisultati.appendText(e.getMessage());
    		}
    		
    	}
    	
    	else if(cBoxCorsi.getValue() == null) {
    		
    		try {
        		for(Corso c : model.getCorsiStudente(txtMatricola.getText())) {
        			txtRisultati.appendText(c.infoCorso() + "\n");
        		}
        	}catch(NullPointerException n) {
        		txtRisultati.appendText(n.getMessage());
        	} catch (Exception e) {
    			
    			txtRisultati.appendText(e.getMessage());
    		}
    	}
    	
    	
    }

    @FXML
    void doRicercaIscritti(ActionEvent event) {
    	
    	txtRisultati.clear();
    	
    	try {
    		Corso c = cBoxCorsi.getValue();
    		for(Studente s : model.getIscrittiAlCorso(c)) {
    			txtRisultati.appendText(s.toString() + "\n" );
    			
    		}
    	}catch(NullPointerException e) {
    		txtRisultati.appendText(e.getMessage());
    		
    	}
    	
		
		
    	
    }

    @FXML
    void doRiempimento(ActionEvent event) {
    	
    	txtRisultati.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	try {
    		txtNome.appendText(model.getNome(txtMatricola.getText()));
        	txtCognome.appendText(model.getCognome(txtMatricola.getText()));
    	}catch(NullPointerException c) {
    		txtRisultati.appendText(c.getMessage());
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblCorsi != null : "fx:id=\"lblCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cBoxCorsi != null : "fx:id=\"cBoxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ckxRiempimento != null : "fx:id=\"ckxRiempimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscriviStudente != null : "fx:id=\"btnIscriviStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
	}

	public void setCbox() {
		
		cBoxCorsi.getItems().addAll(model.getNomiCorsi());
		cBoxCorsi.getItems().add(0, null);
		
	}
    
}
