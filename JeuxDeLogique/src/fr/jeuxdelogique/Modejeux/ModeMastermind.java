package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.ordinateurjeux.Outils;

public class ModeMastermind extends Mode {

	private String codeSecret;
	private String reponseUtilisateur = "";
	private String resultat = "";
	private int recupeNombreTab;
	private ArrayList<Integer> codeSecretMachineTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerAITab = new ArrayList<Integer>();
	
		
	public ModeMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeMastermind(String codeSecret, String reponseUtilisateur, String resultat, int recupeNombreTab, ArrayList<Integer> codeSecretMachineTab, ArrayList<Integer> codeSecretUtilisateurTab,
						  ArrayList<Integer> codeSecretPlayerUtilisateurTab, ArrayList<Integer> codeSecretPlayerAITab) {
			super();
			this.codeSecret = codeSecret;
			this.reponseUtilisateur = reponseUtilisateur;
			this.resultat = resultat;
			this.recupeNombreTab = recupeNombreTab;
			this.codeSecretMachineTab = codeSecretMachineTab;
			this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
			this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
			this.codeSecretPlayerAITab = codeSecretPlayerAITab;
		}

/********************************** "String" code secret Machine ********************************************/
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		codeSecret = "";
		Outils code = new Outils();
		codeSecret = code.codeSecret(codeSecret);
		this.codeSecret = codeSecret;
	}
	
/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}

/********************************** Resultat *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Integer> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Integer> codeSecretMachineTab) {
		codeSecretMachineTab = tableau(getCodeSecretMachineTab(), codeSecret);
		this.codeSecretMachineTab = codeSecretMachineTab;
	}
	
/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Integer> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Integer> codeSecretUtilisateurTab) {
		codeSecretUtilisateurTab = tableau(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

/********************************************************************************/
	public ArrayList<Integer> tableau (ArrayList<Integer> tab, String code) {
		Outils outilTableau = new Outils();
		tab = outilTableau.codeSecretAjoutTab(tab, code);
		return tab;
	}
	
	@Override
	public void playerGame() {
		// TODO Auto-generated method stub

	}

}
