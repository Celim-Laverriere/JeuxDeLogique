package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;
import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.Mastermind;

public class ChallengerMastermind extends ModeMastermind {

	public ChallengerMastermind() {
		super();
		// TODO Auto-generated constructor stub
		outil.init_tableau_nombre_utilisable();
	}

	public ChallengerMastermind(String codeSecret, ArrayList<Byte> resultatBienPlacePresentUtilisateur, ArrayList<Long> codeSecretOrdinateur,
								ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretUtilisateur, ArrayList<Long> codeSecretUtilisateurTab,
								ArrayList<Long> codeSecretPlayerUtilisateur, ArrayList<Long> codeSecretPlayerOrdnateur, String nombreGenerer, String initCodeAvecZero,
								String initalisation_zero, String nombreMax) {
		super(codeSecret, resultatBienPlacePresentUtilisateur, codeSecretOrdinateur, resultat_BienPlace_Present, codeSecretUtilisateur,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateur, codeSecretPlayerOrdnateur, nombreGenerer, initCodeAvecZero, initalisation_zero, nombreMax);
	}

	@Override
	public void playerGame() throws CodeInvalideException {

		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");

		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
		logger.trace("Code secret genere par l'ordinateur " + outil.chaineDeCaract(getCodeSecretOrdinateur()));

		if (getModeDev().equals("developpeur")) {
			System.out.println("\n Mode développeur ! Code secret : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}

		System.out.println("\nC'est à vous de jouer ! Vous avez " + outil.CONFIGURATION_ESSAIS + " essais pour trouver le code secret !" );

		do {

			System.out.print("\nEssai n° " + getCompteurEssai() + " ! " + "\nEnter votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres : ");

			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));
			logger.trace("Code secret généré par l'utilisateur " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));

			setResultat_BienPlace_Present(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));
			logger.trace(getResultat_BienPlace_Present().get(0) + " Bien place et " +
					getResultat_BienPlace_Present().get(1) + " Present !");

			System.out.println("\nProposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " +
					getResultat_BienPlace_Present().get(1) + " Présent !");

			setCompteurEssai(1);
		} while (!getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS );

		if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur())){

			System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
			logger.trace("L'utilisateur à trouvé : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
		} else {

			System.out.println("\nPerdu ! La combinaison été : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
			logger.trace("Perdu ! La combinaison été é : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	}

}
