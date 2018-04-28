package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class ModeRecherche extends Mode {

	private String codeSecret;
	private ArrayList<Long> codeSecretMachineTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerAITab = new ArrayList<Long>();
	private String reponseUtilisateur = "";
	private String resultat = "";
	private long recupeNombreTab;
	
	public ModeRecherche () {
		
	}
	
	public ModeRecherche(String codeSecret, ArrayList<Long> codeSecretMachineTab,ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
						 ArrayList<Long> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		
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
		codeSecret = outil.codeSecret(codeSecret, codeSecret);
		this.codeSecret = codeSecret;
	}

/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Long> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Long> codeSecretMachineTab) {
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
	public ArrayList<Long> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Long> codeSecretUtilisateurTab) {
		codeSecretUtilisateurTab = tableau(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

/********************************** *****************************************/
	public ArrayList<Long> getCodeSecretPlayerUtilisateurTab() {
		return codeSecretPlayerUtilisateurTab;
	}

	public void setCodeSecretPlayerUtilisateurTab(ArrayList<Long> codeSecretPlayerUtilisateurTab) {
		codeSecretPlayerUtilisateurTab = tableau(getCodeSecretPlayerUtilisateurTab(), reponseUtilisateur);
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
	}
	
/**********************************  *****************************************/
	public ArrayList<Long> getCodeSecretPlayerAITab() {
		return codeSecretPlayerAITab;
	}

	public void setCodeSecretPlayerAITab(ArrayList<Long> codeSecretPlayerAITab) {
		codeSecretPlayerAITab = tableau(getCodeSecretPlayerAITab(), codeSecret);
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
	}
	
/********************************** La méthode récupere le nombre du tableau pour le modifier *****************************************/
	public long getRecupeNombreTab() {
		return recupeNombreTab;
	}

	public void setRecupeNombreTab(Long recupeNombreTab, int nbre) {
	
		if (codeSecret.length() == outil.CONFIGURATION_NOMBRE) {
			codeSecret = "";
		}
		
		codeSecret += "" + (recupeNombreTab + (nbre));
		this.recupeNombreTab = recupeNombreTab;
	}

/********************************** get et set résiltat *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	/**
	 * 
	 * @param tab
	 * @param code
	 * @return
	 */
		public ArrayList<Long> tableau (ArrayList<Long> tab, String code) {
			tab = outil.codeSecretAjoutTab(tab, code);
			return tab;
		}
	
	/**
	 * 
	 * @param
	 */
		public void reponse () {
			
			int temp = 0;
			 
			do {
				
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
		
	/**
	 * 
	 */
		@Override
		public void playerGame() {
			// TODO Auto-generated method stub
			
		}

}
