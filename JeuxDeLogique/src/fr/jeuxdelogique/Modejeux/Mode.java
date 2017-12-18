package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mode {

	Scanner sc = new Scanner (System.in);
	
	protected ArrayList<Integer> codeSecretOrdi = new ArrayList<Integer>(); 
	protected ArrayList<Integer> codeSecretUser = new ArrayList<Integer> ();
	protected String codeSecret = "";
	
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
		this.codeSecretOrdi = codeSecretOrdi;
	}

	public ArrayList<Integer> getCodeSecretUser() {
		return codeSecretUser;
	}

	public void setCodeSecretUser(ArrayList<Integer> codeSecretUser) {
		this.codeSecretUser = codeSecretUser;
	}

	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	public abstract void playerGame(); 
}



