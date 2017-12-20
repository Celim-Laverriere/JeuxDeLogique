package fr.jeuxdelogique.Modejeux;

import fr.jeuxdelogique.ordinateurjeux.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mode {

	Scanner sc = new Scanner (System.in);
	
	private ArrayList<Integer> codeSecretOrdi = new ArrayList<Integer>(); 
	private ArrayList<Integer> codeSecretUser = new ArrayList<Integer> ();
	private String codeSecret = "";
	private String reponseUser = "";
	private String resultat = "";
	
	public Mode() {
		
	}
	
	public Mode(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser, String codeSecret) {
		this.setCodeSecret (codeSecret);
		this.setCodeSecretOrdi(codeSecretOrdi);
		this.setCodeSecretUser (codeSecretUser);
		
	}
	
	public ArrayList<Integer> getCodeSecretOrdi() {
		return codeSecretOrdi;
	}

	public void setCodeSecretOrdi(ArrayList<Integer> codeSecretOrdi) {
		CodeSecretMachine code = new CodeSecretMachine();
		codeSecretOrdi = code.codeSecretOrdi(getCodeSecretOrdi(), codeSecret);
		this.codeSecretOrdi = codeSecretOrdi;
	}

	public ArrayList<Integer> getCodeSecretUser() {
		return codeSecretUser;
	}

	public void setCodeSecretUser(ArrayList<Integer> codeSecretUser) {
		ReponseUtilisateur code = new ReponseUtilisateur();
		codeSecretUser = code.reponseUser(getCodeSecretUser(), reponseUser);
		this.codeSecretUser = codeSecretUser;
	}

	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		CodeSecret code = new CodeSecret();
		codeSecret = code.codeSecret(codeSecret);
		this.codeSecret = codeSecret;
	}

	public String getReponseUser() {
		return reponseUser;
	}

	public void setReponseUser(String reponseUser) {
		this.reponseUser = reponseUser;
	} 
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
		
	}
	
	public abstract void playerGame();
	
}



