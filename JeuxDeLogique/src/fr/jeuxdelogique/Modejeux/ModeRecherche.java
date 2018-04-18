package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;
import fr.jeuxdelogique.ordinateurjeux.Outils;


public class ModeRecherche extends Mode {

	private String codeSecret;
	private ArrayList<Integer> codeSecretMachineTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerAITab = new ArrayList<Integer>();
	private String reponseUtilisateur = "";
	private String resultat = "";
	private int recupeNombreTab;
	
	public ModeRecherche () {
		
	}
	
	public ModeRecherche(String codeSecret, ArrayList<Integer> codeSecretMachineTab,ArrayList<Integer> codeSecretUtilisateurTab, ArrayList<Integer> codeSecretPlayerUtilisateurTab,
						 ArrayList<Integer> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		
		super();
		this.codeSecret = codeSecret;
		this.codeSecretMachineTab = codeSecretMachineTab;
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
		this.reponseUtilisateur = reponseUtilisateur;
		this.resultat = resultat;
		this.recupeNombreTab = recupeNombreTab;
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

/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Integer> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Integer> codeSecretMachineTab) {
		codeSecretMachineTab = tableau(getCodeSecretMachineTab(), codeSecret);
		this.codeSecretMachineTab = codeSecretMachineTab;
		
	}
	
/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}
	
/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Integer> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Integer> codeSecretUtilisateurTab) {
		codeSecretUtilisateurTab = tableau(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

/********************************** *****************************************/
	public ArrayList<Integer> getCodeSecretPlayerUtilisateurTab() {
		return codeSecretPlayerUtilisateurTab;
	}

	public void setCodeSecretPlayerUtilisateurTab(ArrayList<Integer> codeSecretPlayerUtilisateurTab) {
		codeSecretPlayerUtilisateurTab = tableau(getCodeSecretPlayerUtilisateurTab(), reponseUtilisateur);
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
	}
	
/**********************************  *****************************************/
	public ArrayList<Integer> getCodeSecretPlayerAITab() {
		return codeSecretPlayerAITab;
	}

	public void setCodeSecretPlayerAITab(ArrayList<Integer> codeSecretPlayerAITab) {
		codeSecretPlayerAITab = tableau(getCodeSecretPlayerAITab(), codeSecret);
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
	}
	
/********************************** La méthode récupere le nombre du tableau pour le modifier *****************************************/
	public int getRecupeNombreTab() {
		return recupeNombreTab;
	}

	public void setRecupeNombreTab(int recupeNombreTab, int nbre) {
	
		if (codeSecret.length() == 4) {
			codeSecret = "";
		}
		
		codeSecret += "" + (recupeNombreTab + (nbre));
		this.recupeNombreTab = recupeNombreTab;
	}

/********************************** get et set non utilisés *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
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
