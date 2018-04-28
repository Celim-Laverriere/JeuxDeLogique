package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class ModeMastermind extends Mode {

	private String codeSecret;
	private String reponseUtilisateur = "";
	private int recupeNombreTab;
	private ArrayList<Byte> resultat_BienPlace_Present = new ArrayList<Byte>(); 
	private ArrayList<Long> codeSecretMachineTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerAITab = new ArrayList<Long>();
	
		


	public ModeMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretMachineTab,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab) {
		super();
		this.codeSecret = codeSecret;
		this.reponseUtilisateur = reponseUtilisateur;
		this.recupeNombreTab = recupeNombreTab;
		this.resultat_BienPlace_Present = resultat_BienPlace_Present;
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
		this.codeSecret = codeSecret;
	}
	
/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}
	
	/********************************** Résultat bien placé et présent *****************************************/
	public ArrayList<Byte> getResultat_BienPlace_Present() {
		return resultat_BienPlace_Present;
	}

	public void setResultat_BienPlace_Present(ArrayList<Byte> resultat_BienPlace_Present) {
		this.resultat_BienPlace_Present = resultat_BienPlace_Present;
	}
	
/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Long> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Long> codeSecretMachineTab) {
		this.codeSecretMachineTab = codeSecretMachineTab;
	}
	
/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Long> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Long> codeSecretUtilisateurTab) {
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

/********************************************************************************/
	
	
	public void enterClavier () {
		
		int temp;
		 
		do {
			
			temp = 0;
			
			try {
				
				Long.parseLong(reponseUtilisateur = (sc.nextLine()));
				
				if (reponseUtilisateur.length() != outil.CONFIGURATION_NOMBRE) {
					System.out.println("Votre saissi est incorrecte, entrez de nouveau votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");
					
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Attention votre saisie n'est pas une  nombre : ");
				System.out.println("Merci de renterez un nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");
				temp = 1;
			}
			
		} while (reponseUtilisateur.length() != outil.CONFIGURATION_NOMBRE || temp == 1);
		
	}
	
	public ArrayList<Byte> resultatMastermind (ArrayList<Long> codeSecretOrdinateur, ArrayList<Long> codeSecretUtilisateur) {
		
		ArrayList<Long> codeSecretCopieTab = new ArrayList<Long>(codeSecretOrdinateur);
		ArrayList<Byte> resultat = new ArrayList<Byte>();
			
		byte compteurBienPlace = 0;
		byte compteurPresent = 0;
		byte nombreDeTour = 0;
			
		while ( nombreDeTour < codeSecretUtilisateur.size() && !codeSecretUtilisateur.equals(codeSecretOrdinateur)) {
		
		
			for (nombreDeTour = 0; nombreDeTour < codeSecretUtilisateur.size(); nombreDeTour++) {
			
				if (codeSecretOrdinateur.get(nombreDeTour).equals(codeSecretUtilisateur.get(nombreDeTour))) {
					compteurBienPlace += 1;
					codeSecretCopieTab.set(nombreDeTour, null);
				}	
			}
			
			if (compteurBienPlace == 0) {
				compteurBienPlace = 0;
			}
			
			for (nombreDeTour = 0; nombreDeTour < codeSecretUtilisateur.size(); nombreDeTour++) {
				
				if (codeSecretCopieTab.contains(codeSecretUtilisateur.get(nombreDeTour)) ) {
					compteurPresent += 1;	
				}
			}		
			
			if (compteurPresent == 0) {
				compteurPresent = 0;
			}
		}		
		
		resultat.add(compteurBienPlace);
		resultat.add(compteurPresent);
				
		return resultat;	
	}
	
	@Override
	public void playerGame() {
		// TODO Auto-generated method stub

	}



}
