package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class DefenseurRecherchePlusMoins extends ModeRecherche {
	
	 private long reponseUse; 
	
	public DefenseurRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefenseurRecherchePlusMoins(String codeSecret, ArrayList<Integer> codeSecretMachineTab,
			ArrayList<Integer> codeSecretUtilisateurTab, ArrayList<Integer> codeSecretPlayerUtilisateurTab,
			ArrayList<Integer> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

	public void playerGame() {
		
		do {
			
			int compteur = 0;
			
			System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
				
			reponseUse = reponse(reponseUse);
			setReponseUtilisateur(String.valueOf(reponseUse));
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
