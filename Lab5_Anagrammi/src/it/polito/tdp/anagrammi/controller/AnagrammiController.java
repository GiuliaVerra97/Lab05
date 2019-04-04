package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import in.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResultCorrette;

    @FXML
    private TextArea txtResultErrate;
    
    
    private Model model;

    
    

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {

    	txtResultCorrette.clear();
    	txtResultErrate.clear();
    	
    	String parola=txtParola.getText();
    	List<String> lista=model.cercaAnagrammi(parola);
    	String paroleCorrette="";
    	String paroleErrate="";
    	for(String s: lista) {
    		if(model.isCorrect(s)==true) {
    			if(!paroleCorrette.contains(s)) {
    			paroleCorrette=paroleCorrette+" "+s;
    			}
    		}else {
    			if(!paroleErrate.contains(s)) {		//se nella lista soluzioni ci sono due parole uguali perchè magari ci sono delle doppie nella parola, le cancello
    			paroleErrate=paroleErrate+" "+s;
    			}
    		}
    	}
    	
    	txtResultCorrette.appendText(paroleCorrette);
    	txtResultErrate.appendText(paroleErrate);	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResultCorrette.clear();
    	txtResultErrate.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultCorrette != null : "fx:id=\"txtResultCorrette\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultErrate != null : "fx:id=\"txtResultErrate\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    

	public void setModel(Model m) {
		this.model=m;
	}
    
    
    
}

