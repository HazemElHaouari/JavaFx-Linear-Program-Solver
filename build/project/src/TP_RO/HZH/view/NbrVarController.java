package TP_RO.HZH.view;

import TP_RO.HZH.MainProgLin;
import TP_RO.HZH.model.ProgrammeLineaire;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NbrVarController {
	@FXML private TextField nbrVar, nbrCont;
	@FXML private Button continuer;
	public NbrVarController(){
		
	}
	
	@FXML
	public void initialize(){
		nbrVar.textProperty().addListener(new ChangeListener<String>() {
		    @FXML
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {
		    	
				try {
		            for(int k=0;k<newValue.length();k++)
		            	if(newValue.charAt(k)<'0'||newValue.charAt(k)>'9') 
		            		nbrVar.setText(oldValue);
		            
		        } catch (Exception e) {
		            
		        }
		        
		    
		    }
		});
		nbrCont.textProperty().addListener(new ChangeListener<String>() {
		    @FXML
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {
		    	
				try {
		            for(int k=0;k<newValue.length();k++)
		            	if(newValue.charAt(k)<'0'||newValue.charAt(k)>'9') 
		            		nbrCont.setText(oldValue);
		            
		        } catch (Exception e) {
		            
		        }
		        
		    
		    }
		});
		
	}
	@FXML
	private void continuer(){
		MainProgLin.progLin= new ProgrammeLineaire(Integer.valueOf(nbrVar.getText()),Integer.valueOf(nbrCont.getText()));
		MainProgLin.showProgLin();
	}

}
