package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

public abstract class Mode {

	private ArrayList<Integer> codeSecretOrdi = new ArrayList<Integer>(); 
	private ArrayList<Integer> codeSecretUser = new ArrayList<Integer> ();
	private String codeSecret = "";
	
	public abstract void PayerGame(); 
	
	public Mode(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser, String codeSecret) {
		this.setCodeSecretOrdi(codeSecretOrdi);
		this.setCodeSecretUser (codeSecretUser);
		this.setCodeSecret (codeSecret);
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

	
}
