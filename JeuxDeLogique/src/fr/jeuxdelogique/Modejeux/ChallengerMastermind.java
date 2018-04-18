package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

public class ChallengerMastermind extends ModeMastermind {

	private ArrayList<Integer> codeSecretCopieTab = new ArrayList<Integer>();

	public ChallengerMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengerMastermind(String codeSecret, String reponseUtilisateur, String resultat, int recupeNombreTab, ArrayList<Integer> codeSecretMachineTab, ArrayList<Integer> codeSecretUtilisateurTab,
								ArrayList<Integer> codeSecretPlayerUtilisateurTab, ArrayList<Integer> codeSecretPlayerAITab) {
		super(codeSecret, reponseUtilisateur, resultat, recupeNombreTab, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab);
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Integer> getCodeSecretCopieTab() {
		return codeSecretCopieTab;
	}

	public void setCodeSecretCopieTab(ArrayList<Integer> codeSecretCopieTab) {
		codeSecretCopieTab.addAll(getCodeSecretMachineTab());
		this.codeSecretCopieTab = codeSecretCopieTab;
	}

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
				
				setCodeSecretCopieTab(getCodeSecretCopieTab());
				
				String reponsePresent = "";
				String reponseBienPlace = "";
				int conpteurBienPlace = 1;
				int compteurPresent = 1;
				int i = 0;
				
				while ( i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
					
						if (codeSecretCopieTab.contains(getCodeSecretUtilisateurTab().get(i)) && getCodeSecretMachineTab().get(i).equals(getCodeSecretUtilisateurTab().get(i))) {
							reponseBienPlace = conpteurBienPlace++ + " Bien placé";
							codeSecretCopieTab.set(i, null);
						} 
						
						i++;
					}	
				
				i = 0;
				
				while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
					
						if (codeSecretCopieTab.contains(getCodeSecretUtilisateurTab().get(i)) && !getCodeSecretMachineTab().get(i).equals(getCodeSecretUtilisateurTab().get(i))) {
							reponsePresent = ", " + compteurPresent++ + " présent";
							
						} 
						
						i++;
					}
					
					setResultat(reponseBienPlace + "" + reponsePresent);
					
					if (i == getCodeSecretUtilisateurTab().size()) {
						System.out.println("\n\nProposition : "+ getReponseUtilisateur() + " Réponse : " + getResultat());
						setResultat("");
						getCodeSecretUtilisateurTab().removeAll(getCodeSecretUtilisateurTab());
					}
								
			} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
		System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + getReponseUtilisateur());
	}

}
