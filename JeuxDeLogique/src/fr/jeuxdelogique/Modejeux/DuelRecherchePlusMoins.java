package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

public class DuelRecherchePlusMoins extends ModeRecherche {



	public DuelRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuelRecherchePlusMoins(String codeSecret, ArrayList<Integer> codeSecretMachineTab,
			ArrayList<Integer> codeSecretUtilisateurTab, ArrayList<Integer> codeSecretPlayerUtilisateurTab,
			ArrayList<Integer> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/

	@Override
	public void playerGame() {
		
		int compteur = 0;
		
		/*********** Code générer par l'ordinateur ***********/
		setCodeSecret(getCodeSecret());
		setCodeSecretMachineTab(getCodeSecretMachineTab());	
		
		/*********** Code générer par l'utilisateur ***********/
		System.out.println("\nEntrez votre code secret que l'ordinateur devra trouver :");
		
		setReponseUtilisateur(sc.nextLine());
		setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
		setCodeSecret(getCodeSecret());
		setCodeSecretPlayerAITab(getCodeSecretPlayerAITab());
	
	do {
		
		int i = 0;
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecretMachineTab().size()+ " chiffres" );
			
			setReponseUtilisateur(sc.nextLine());
			setCodeSecretPlayerUtilisateurTab(getCodeSecretPlayerUtilisateurTab());
			
		do {	
			
			while ( i < getCodeSecretPlayerUtilisateurTab().size() && !getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
				
					if (getCodeSecretPlayerUtilisateurTab().get(i) < getCodeSecretMachineTab().get(i)) {
						setResultat(getResultat() + "+");
						break;
					} else if (getCodeSecretPlayerUtilisateurTab().get(i) > getCodeSecretMachineTab().get(i)) {
						setResultat(getResultat() + "-");
						break;
					} else {
						setResultat(getResultat() + "=");
						break;
					}
				}
				
				if (i == getCodeSecretPlayerUtilisateurTab().size()) {
					System.out.println("\n\nProposition : "+ getCodeSecretPlayerUtilisateurTab().toString() +" Réponse : " + getResultat());
					setResultat("");
					getCodeSecretPlayerUtilisateurTab().removeAll(getCodeSecretPlayerUtilisateurTab());
				}
							
			while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
						
					if (getCodeSecretPlayerAITab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), +1); 
							break;
							
					} else if(getCodeSecretPlayerAITab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), -1);
							break;
						} else {
							setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), 0);
							break;
						}
					}
					
					if (i == getCodeSecretUtilisateurTab().size()) {
						compteur++;
						System.out.println("\n\nProposition : " + getCodeSecret() + " Réponse n° : " + compteur);
						getCodeSecretPlayerAITab().removeAll(getCodeSecretPlayerAITab());
						setCodeSecretPlayerAITab(getCodeSecretPlayerAITab());
					}
		
					if (getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
						System.out.println("\nVotre ordinateur à trouvé en " + compteur  + " coups votre combinaison : " + getCodeSecret());
						break;
					}
					
					if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
						System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + getCodeSecretPlayerUtilisateurTab());
						break;
					}
						
					i++;
						
		} while (i <= getCodeSecretUtilisateurTab().size() || i <= getCodeSecretPlayerUtilisateurTab().size());		
						
	} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab()) && !getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab()));
		
			
	}

}


