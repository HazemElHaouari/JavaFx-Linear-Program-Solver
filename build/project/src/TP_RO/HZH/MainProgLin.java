package TP_RO.HZH;

import java.io.IOException;

import TP_RO.HZH.model.ProgrammeLineaire;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainProgLin extends Application{
	static Stage primaryStage;
	public static ProgrammeLineaire progLin;

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainProgLin.primaryStage=primaryStage;
		MainProgLin.primaryStage.setTitle("Résolution d'un Programme Linéaire");
		showNbrVar();
		
				
	}

	
	public static void showNbrVar(){
         try {
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainProgLin.class.getResource("view/NbrVar.fxml"));
			AnchorPane nbrVar = (AnchorPane) loader.load();
			Scene scene = new Scene(nbrVar);
            primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
	public static void showProgLin(){
		try {
       	 FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainProgLin.class.getResource("view/ProgLin.fxml"));
			AnchorPane progLin = (AnchorPane) loader.load();
			Scene scene = new Scene(progLin);
            primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void showResolution(){
		try {
	       	 FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainProgLin.class.getResource("view/Resolution.fxml"));
				AnchorPane resolution = (AnchorPane) loader.load();
				Scene scene = new Scene(resolution);
	            primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 public Stage getPrimaryStage() {
	        return primaryStage;
	    }
		public static void main(String[] args) {
			launch(args);
		}

}
