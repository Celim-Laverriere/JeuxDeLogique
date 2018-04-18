package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

public class ChallengerRecherchePlusMoins extends ModeRecherche {
		
	
public ChallengerRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengerRecherchePlusMoins(String codeSecret, ArrayList<Integer> codeSecretMachineTab,
			ArrayList<Integer> codeSecretUtilisateurTab, ArrayList<Integer> codeSecretPlayerUtilisateurTab,
			ArrayList<Integer> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/
	
	@Override
	public void playerGame() {
		
		setCodeSecret(getCodeSecret());
		setCodeSecretMachineTab(getCodeSecretMachineTab());
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
		}
	
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
