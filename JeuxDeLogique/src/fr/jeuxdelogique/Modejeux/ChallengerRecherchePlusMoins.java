package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.ordinateurjeux.OutilsCodeSecret;


public class ChallengerRecherchePlusMoins extends Mode {
	
	private String codeSecret;
	private ArrayList<Integer> codeSecretMachineTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretUtilisateurTab = new ArrayList<Integer>();
	private String reponseUtilisateur = "";
	private String resultat = "";
	
	
	public ChallengerRecherchePlusMoins() {
		playerGame();
	}
	
	public ChallengerRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
		super(codeSecretOrdi, codeSecretUser, codeSecret);
	
	}
	
/********************************** "String" code secret Machine ********************************************/
	
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		OutilsCodeSecret code = new OutilsCodeSecret();
		codeSecret = code.codeSecret(codeSecret);
		this.codeSecret = codeSecret;
	}
	
/********************************** "Tableau" code secret Machine ********************************************/
	
	public ArrayList<Integer> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Integer> codeSecretMachineTab) {
		OutilsCodeSecret codeMachine = new OutilsCodeSecret();
		codeSecretMachineTab = codeMachine.codeSecretAjoutTab(getCodeSecretMachineTab(), codeSecret);
		this.codeSecretMachineTab = codeSecretMachineTab;
	}

/********************************** "Tableau" code secret Utilisateur *****************************************/
	
	public ArrayList<Integer> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Integer> codeSecretUtilisateurTab) {
		OutilsCodeSecret codeUtilisateur = new OutilsCodeSecret();
		codeSecretUtilisateurTab = codeUtilisateur.codeSecretAjoutTab(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}
	
/********************************** "String" Réponse Utilisateur *****************************************/
	
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}
	
/********************************** "String" Affiche le résultat ( + ou - ou = ) *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/
	
	@Override
	public void playerGame() {
		
		setCodeSecret(getCodeSecret());
		setCodeSecretMachineTab(getCodeSecretMachineTab());
		
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecret().length() + " chiffres" );
		
		
		do {
			
			setReponseUtilisateur(sc.nextLine());
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			
			int i = 0;
			
			while ( i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
				
					if (getCodeSecretUtilisateurTab().get(i) < getCodeSecretMachineTab().get(i)) {
						setResultat(getResultat() + "+");
						i++;
					} else if (getCodeSecretUtilisateurTab().get(i) > getCodeSecretMachineTab().get(i)) {
						setResultat(getResultat() + "-");
						i++;
					} else {
						setResultat(getResultat() + "=");
						i++;
					}
				}
				
				if (i == getCodeSecretUtilisateurTab().size()) {
					System.out.println("\n\nProposition : "+ getReponseUtilisateur() +" Réponse : " + getResultat());
					setResultat("");
					getCodeSecretUtilisateurTab().removeAll(getCodeSecretUtilisateurTab());
				}
							
		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
		System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + getReponseUtilisateur());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
