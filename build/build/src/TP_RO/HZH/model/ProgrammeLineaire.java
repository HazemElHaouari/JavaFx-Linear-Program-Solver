package TP_RO.HZH.model;

import java.util.ArrayList;

public class ProgrammeLineaire {
	public String but;
	public Integer nombreVariables;
	public Integer nombreContraintes;
	public ArrayList<Integer> coefFoncObj= new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> coefCont= new ArrayList<ArrayList<Integer>>();
	public ArrayList<Integer> bornes= new ArrayList<Integer>();
	public ArrayList<String> signIn= new ArrayList<String>();
	public ArrayList<String> signVar= new ArrayList<String>();
	
	public ProgrammeLineaire(Integer nombreVariables,Integer nombreContraintes){
		this.nombreVariables=nombreVariables;
		this.nombreContraintes=nombreContraintes;
	}

}
