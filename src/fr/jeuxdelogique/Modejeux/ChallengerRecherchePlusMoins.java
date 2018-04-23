package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class ChallengerRecherchePlusMoins extends ModeRecherche {
		
	public ChallengerRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengerRecherchePlusMoins(String codeSecret, ArrayList<Long> codeSecretMachineTab,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

/********************************************** Ci-dessous la m�thode qui lance le jeu **********************************************************/
	
	@Override
	public void playerGame() {
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");
		
		setCodeSecret(getCodeSecret());
		setCodeSecretMachineTab(getCodeSecretMachineTab());
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode d�veloppeur ! \n Code secret : " + this.getCodeSecret());
		}
		
		do {
			
			System.out.println("\nC'est � vous de jouer : Entrer votre nombre � " + getCodeSecret().length() + " chiffres" );
				 
			reponse();
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
					System.out.println("\n\nProposition : "+ getReponseUtilisateur() +" R�ponse : " + getResultat());
					setResultat("");
					getCodeSecretUtilisateurTab().removeAll(getCodeSecretUtilisateurTab());
				}
							
		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
		System.out.println("\nBravo ! Vous avez trouv� la bonne combinaison : " + getReponseUtilisateur());
	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


