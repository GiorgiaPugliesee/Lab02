package it.polito.tdp.alien;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Dizionario diz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parola = this.txtParola.getText().toLowerCase();
    	
    	String[] parts = parola.split(" ");
    	
    	this.txtResult.clear();
    	
    	if (!parts[0].matches("[a-zA-Z]*") || !parts[1].matches("[a-zA-Z]*")) {
			txtResult.setText("Inserire solo caratteri alfabetici.");
			return;
		}
    	
    	if(parts.length == 1) {
    		
    		List<String> traduzioni = diz.search(parts[0]);
    		
    		if(traduzioni == null) {
    			this.txtResult.setText("La parola che hai inserito non è presente nel nostro dizionario!\n");
    			return;
    		}
    		
    		for (String p : traduzioni) {
    			this.txtResult.appendText(p + "\n");
    		}
    		
    	} else if(parts.length == 2) {
    		
    		diz.add(parts[0], parts[1]);
    		
    	} else {
    		
    		this.txtResult.setText("Non hai inserito nessuna parola!");
    		
    	}

    }
    
    @FXML
    void doClearText(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtParola.clear();
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        this.diz = new Dizionario();

    }

}
