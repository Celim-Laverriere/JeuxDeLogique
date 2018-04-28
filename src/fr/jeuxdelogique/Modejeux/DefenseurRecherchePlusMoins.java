package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class DefenseurRecherchePlusMoins extends ModeRecherche {
	
	public DefenseurRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefenseurRecherchePlusMoins(String codeSecret, ArrayList<Long> codeSecretMachineTab,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

	/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/
	
	public void playerGame() {
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE DEFENSEUR               *");
		System.out.println("\t**********************************************");
		
		do {
			
			int compteur = 0;
			
			System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
				
			reponse();
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			setCodeSecret(getCodeSecret());
			setCodeSecretMachineTab(getCodeSecretMachineTab());
			
			if (getModeDev().equals("Dev")) {
				System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
			}
			
			
			do {
				
				int i = 0;
				
				while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
					
					if (getCodeSecretMachineTab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), +1); 
						i++;
						
					} else if(getCodeSecretMachineTab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), -1);
						i++;
					} else {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), 0);
						i++;
					}
				}
				
				if (i == getCodeSecretUtilisateurTab().size()) {
					compteur++;
					System.out.println("\n\nProposition : " + getCodeSecret() +" Réponse n° : " + compteur);
					getCodeSecretMachineTab().removeAll(getCodeSecretMachineTab());
					setCodeSecretMachineTab(getCodeSecretMachineTab());
				}
				
			} while(!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
			
			if (getCodeSecretMachineTab().equals(getCodeSecretUtilisateurTab())) {
				System.out.println("\nVotre ordinateur à trouvé en " + compteur  + " coups votre combinaison : " + getCodeSecret()  );
			}
			
		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
	}

	
}
