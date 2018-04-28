package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.startjeux.Mastermind;


public class ChallengerMastermind extends ModeMastermind {

	public ChallengerMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengerMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretMachineTab,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab) {
		super(codeSecret, reponseUtilisateur, recupeNombreTab, resultat_BienPlace_Present, codeSecretMachineTab,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerGame() {
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");
		
		setCodeSecret(outil.codeSecret(getCodeSecret(), Mastermind.class.getSimpleName()));
		setCodeSecretMachineTab(outil.codeSecretAjoutTab(getCodeSecretMachineTab(), getCodeSecret()));
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
		}
	
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecret().length() + " chiffres" );
		
		
		do {
			
			setCompteurEssai(1);
			
			enterClavier();
			getCodeSecretUtilisateurTab().clear();
			setCodeSecretUtilisateurTab(outil.codeSecretAjoutTab(getCodeSecretUtilisateurTab(), getReponseUtilisateur()));

			setResultat_BienPlace_Present(resultatMastermind(getCodeSecretMachineTab(), getCodeSecretUtilisateurTab()));
				
			System.out.println("\n\nProposition : " + getReponseUtilisateur() + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " + 
			getResultat_BienPlace_Present().get(1) + " Présent !" + "\n Nombre d'aisé : " + getCompteurEssai());
				
			} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() != outil.CONFIGURATION_ESSAIS );
		
		if (getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())){
			
			System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + getReponseUtilisateur());
			
		} else {
			
			System.out.println("\nPerdu ! La combinaison été : " + getCodeSecret());
		}
	}

}
