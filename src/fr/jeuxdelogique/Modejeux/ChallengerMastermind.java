package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.Mastermind;


public class ChallengerMastermind extends ModeMastermind {

	public ChallengerMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengerMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Long> codeSecretOrdinateur, ArrayList<Byte> resultat_BienPlace_Present,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String nombreGenerer, String initCodeAvecZero,
			String initalisation_zero, String nombreMax) {
		super(codeSecret, reponseUtilisateur, recupeNombreTab, codeSecretOrdinateur, resultat_BienPlace_Present,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab, nombreGenerer,
				initCodeAvecZero, initalisation_zero, nombreMax);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerGame() throws CodeInvalideException {
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");
		
		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
				
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres" );
		
		
		do {
			
			setCompteurEssai(1);
			
			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));

			setResultat_BienPlace_Present(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));
				
			System.out.println("\n\nProposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " + 
			getResultat_BienPlace_Present().get(1) + " Présent !" + "\n Nombre d'aisé : " + getCompteurEssai());
				
		} while (!getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur()) && getCompteurEssai() < outil.CONFIGURATION_ESSAIS );
		
		if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur())){
			
			System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
			
		} else {
			
			System.out.println("\nPerdu ! La combinaison été : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	}

}
