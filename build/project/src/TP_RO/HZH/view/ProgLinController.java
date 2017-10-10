package TP_RO.HZH.view;

import java.util.ArrayList;

import TP_RO.HZH.MainProgLin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ProgLinController {
	@FXML ComboBox<String> but;
	@FXML BorderPane paneFnObj;
	@FXML BorderPane paneSignObj;
	@FXML BorderPane paneCont;
	@FXML ArrayList<TextField> tFCoefObj= new ArrayList<TextField>();
	@FXML ArrayList<ComboBox<String>> cSignVar= new ArrayList<ComboBox<String>>();
	@FXML ArrayList<ArrayList<TextField>> tCoefCont= new ArrayList<ArrayList<TextField>>();
	@FXML ArrayList<TextField> tBornes= new ArrayList<TextField>();
	@FXML ArrayList<ComboBox<String>> cSignIn= new ArrayList<ComboBox<String>>();
	@FXML Button retour;
	@FXML Button continuer;

	public ProgLinController(){
		
	}
	@FXML
	public void initialize(){
		but.getItems().addAll("Max","Min");
		paneFnObj.setCenter(addFlowPane());
		paneSignObj.setCenter(addFlowCom());
		paneCont.setCenter(addGridPane());
		
	}
	public FlowPane addFlowPane(){
		FlowPane flow= new FlowPane();
		for(int i=0;i<MainProgLin.progLin.nombreVariables;i++){
			Label l = new Label();
			tFCoefObj.add(new TextField());
			tFCoefObj.get(i).setPrefWidth(40);
			flow.getChildren().add(tFCoefObj.get(i));
			if(i!=MainProgLin.progLin.nombreVariables-1)
			l.setText("X"+(i+1)+"+");
			else l.setText("X"+(i+1));
			flow.getChildren().add(l);
		}
		return(flow);
	}
	public FlowPane addFlowCom(){
		FlowPane flow= new FlowPane();
		for(int i=0;i<MainProgLin.progLin.nombreVariables;i++){
			ComboBox<String> cSign=new ComboBox<String>();
			cSign.getItems().addAll("R","R+","R-");
			cSign.setPromptText("R");
			cSignVar.add(cSign);
			flow.getChildren().add(cSignVar.get(i));
			
		}
		return(flow);

	}
	public GridPane addGridPane(){
		GridPane grid= new GridPane();
		for(int i=0;i<MainProgLin.progLin.nombreContraintes;i++){
			ComboBox<String> c= new ComboBox<String>();
			c.getItems().addAll("=","<=",">=");
			c.setPromptText("<=");
			tCoefCont.add(new ArrayList<TextField>());
			int k=0;
			for(int j=0;j<(2*MainProgLin.progLin.nombreVariables+1);j+=2){
				Label l=new Label();
				
				if(j<2*MainProgLin.progLin.nombreVariables-2){
					tCoefCont.get(i).add(new TextField());
					tCoefCont.get(i).get(k).setPrefWidth(40);
					grid.add(tCoefCont.get(i).get(k), j, i);
					l.setText("X"+(k+1)+"+");
					grid.add(l, j+1, i);
				}
				else if(j==2*MainProgLin.progLin.nombreVariables-2){
					tCoefCont.get(i).add(new TextField());
					tCoefCont.get(i).get(k).setPrefWidth(40);
					grid.add(tCoefCont.get(i).get(k), j, i);
					l.setText("X"+(k+1));
					grid.add(l, j+1, i);
				}
				else{
					cSignIn.add(c);
					tBornes.add(new TextField());
					tBornes.get(i).setPrefWidth(40);
					grid.add(cSignIn.get(i), j, i);
					grid.add(tBornes.get(i), j+1, i);
				}
				k++;
			}
		}
		return(grid);
	}
	@FXML
	private void retNbrVar(){
		MainProgLin.showNbrVar();
	}
	@FXML
	private void continSol(){
		MainProgLin.progLin.but= but.getValue();
		if(MainProgLin.progLin.but==null){
			MainProgLin.progLin.but="Max";
		}
		for(int i=0;i<MainProgLin.progLin.nombreVariables;i++){
			MainProgLin.progLin.coefFoncObj.add(Integer.valueOf(tFCoefObj.get(i).getText()));
			MainProgLin.progLin.signVar.add(cSignVar.get(i).getValue());
			if(MainProgLin.progLin.signVar.get(i)==null){
				MainProgLin.progLin.signVar.set(i,"R");
			}
		}

		for(int j=0;j<MainProgLin.progLin.nombreContraintes;j++){
			MainProgLin.progLin.signIn.add(cSignIn.get(j).getValue());
			if(MainProgLin.progLin.signIn.get(j)==null){
				MainProgLin.progLin.signIn.set(j, "<=");
			}
			MainProgLin.progLin.bornes.add(Integer.valueOf(tBornes.get(j).getText()));
			MainProgLin.progLin.coefCont.add(j,new ArrayList<Integer>());
			for(int i=0;i<MainProgLin.progLin.nombreVariables;i++){
				MainProgLin.progLin.coefCont.get(j).add(i,Integer.valueOf(tCoefCont.get(j).get(i).getText()));
			}
		}
		MainProgLin.showResolution();
		
	}

}
