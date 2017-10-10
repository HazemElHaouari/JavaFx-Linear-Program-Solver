package TP_RO.HZH.view;

import java.util.ArrayList;

import TP_RO.HZH.MainProgLin;
import TP_RO.HZH.model.ProgrammeLineaire;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResolutionController {
	@FXML Label fSaisie;
	@FXML Label fCanonique;
	@FXML Label fStandard;
	@FXML
	private void initialize(){
		fSaisie.setText(afficheProgLin(MainProgLin.progLin));
		manipVarDec(MainProgLin.progLin);
		fCanonique.setText(afficheProgLin(formeCano(MainProgLin.progLin)));
		fStandard.setText(afficheProgLin(formeStand(MainProgLin.progLin)));

	}
	private String afficheProgLin(ProgrammeLineaire progLin){
		String aff;
		
		aff=progLin.but+" "+progLin.coefFoncObj.get(0)+" X"+1;
		
		for(int i=1;i<progLin.coefFoncObj.size();i++){
			
				if(progLin.coefFoncObj.get(i)>1){
					aff=aff+"+"+progLin.coefFoncObj.get(i)+" X"+(i+1);
				}
				else if(progLin.coefFoncObj.get(i)==1){
					aff=aff+"+"+" X"+(i+1);
				}
				else if(progLin.coefFoncObj.get(i)<0){
					if(progLin.coefFoncObj.get(i)==(-1)){
						aff=aff+"-"+" X"+(i+1);
					}
					else aff=aff+progLin.coefFoncObj.get(i)+" X"+(i+1);
				}
						
		}
		
		for(int k=0;k<progLin.signIn.size();k++){
			aff=aff+"\n"+(progLin.coefCont.get(k).get(0))+" X"+(1);
			for(int j=1;j<progLin.coefFoncObj.size();j++){
			
					if(progLin.coefCont.get(k).get(j)>1){
						aff=aff+"+"+(progLin.coefCont.get(k).get(j))+" X"+(j+1);

					}
					else if(progLin.coefCont.get(k).get(j)==1){
						aff=aff+"+"+" X"+(j+1);
					}
					else if(progLin.coefCont.get(k).get(j)<0){
						if(progLin.coefCont.get(k).get(j)==(-1))
							aff=aff+"-"+" X"+(j+1);
						else	aff=aff+(progLin.coefCont.get(k).get(j))+" X"+(j+1);
					}
				
			}
			
			aff=aff+progLin.signIn.get(k)+" ";
			aff=aff+progLin.bornes.get(k);
		}
		return(aff);
	}
	
	private void ajoutVar(int indVar,ProgrammeLineaire progLin){
		progLin.coefFoncObj.add(indVar+1,-1*progLin.coefFoncObj.get(indVar));
		for(int i=0;i<progLin.bornes.size();i++){
			progLin.coefCont.get(i).add(indVar+1,(-1)*progLin.coefCont.get(i).get(indVar));
		}
		
	}
	private void inverseVar(int indVar,ProgrammeLineaire progLin){
		progLin.coefFoncObj.set(indVar,-1*progLin.coefFoncObj.get(indVar));
		for(int i=0;i<progLin.bornes.size();i++){
			progLin.coefCont.get(i).set(indVar,(-1)*progLin.coefCont.get(i).get(indVar));
		}
	}
	private void manipVarDec(ProgrammeLineaire progLin){
		int i=0;
		while(i<progLin.signVar.size()){
			if(progLin.signVar.get(i).equals("R-")){
				inverseVar(i,progLin);
				i++;
			}
			else if(progLin.signVar.get(i).equals("R")){
				ajoutVar(i,progLin);
				progLin.signVar.add(i+1, "R+");
				i+=2;
			}
			else i++;
		}
		
	}
	private ProgrammeLineaire formeCano(ProgrammeLineaire progLin){
		ProgrammeLineaire formeCan=progLin;
		if(formeCan.but.equals("Max")){
			int i=0;
			while(i<formeCan.signIn.size()){
				if(formeCan.signIn.get(i).equals(">=")){
					formeCan.bornes.set(i, -1*formeCan.bornes.get(i));
					for(int j=0;j<formeCan.coefFoncObj.size();j++){
						formeCan.coefCont.get(i).set(j, -1*formeCan.coefCont.get(i).get(j));
					}
				}
				else if(formeCan.signIn.get(i).equals("=")){
					formeCan.signIn.add(i+1,">=");
					formeCan.bornes.add(i+1,formeCan.bornes.get(i));
					formeCan.coefCont.add(i+1, new ArrayList<Integer>());
					for(int j=0;j<formeCan.coefFoncObj.size();j++){
						formeCan.coefCont.get(i+1).add(j, formeCan.coefCont.get(i).get(j));
					}
				}
				formeCan.signIn.set(i, "<=");
				i++;
			}
		}
		else if(formeCan.but.equals("Min")){
			int i=0;
			while(i<formeCan.signIn.size()){
				if(formeCan.signIn.get(i).equals("<=")){
					formeCan.bornes.set(i, -1*formeCan.bornes.get(i));
					for(int j=0;j<formeCan.coefFoncObj.size();j++){
						formeCan.coefCont.get(i).set(j, -1*formeCan.coefCont.get(i).get(j));
					}
				}
				else if(formeCan.signIn.get(i).equals("=")){
					formeCan.signIn.add(i+1,"<=");
					formeCan.bornes.add(i+1,formeCan.bornes.get(i));
					formeCan.coefCont.add(i+1, new ArrayList<Integer>());
					for(int j=0;j<formeCan.coefFoncObj.size();j++){
						formeCan.coefCont.get(i+1).add(j, formeCan.coefCont.get(i).get(j));
					}
				}
				formeCan.signIn.set(i, ">=");
				i++;
			}
			
		}
		return(formeCan);
	}
	private ProgrammeLineaire formeStand(ProgrammeLineaire progLin){
		ProgrammeLineaire formeStand=progLin;
		for(int i=0;i<formeStand.signIn.size();i++){
			if(formeStand.signIn.get(i).equals("<=")){
				formeStand.coefFoncObj.add(0);
				for(int j=0;j<formeStand.signIn.size();j++){
					if(j==i)
						formeStand.coefCont.get(j).add(1);
					else 
						formeStand.coefCont.get(j).add(0);
				}
			}
			else if(formeStand.signIn.get(i).equals(">=")){
				formeStand.coefFoncObj.add(0);
				for(int j=0;j<formeStand.signIn.size();j++){
					if(j==i)
						formeStand.coefCont.get(j).add(-1);
					else 
						formeStand.coefCont.get(j).add(0);
				}			}
			formeStand.signIn.set(i, "=");
			
		}
		return(formeStand);
	}

}
