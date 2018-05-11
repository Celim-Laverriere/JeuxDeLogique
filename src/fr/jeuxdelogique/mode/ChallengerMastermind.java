package fr.jeuxdelogique.mode;

import java.util.ArrayList;
import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.Mastermind;

public class ChallengerMastermind extends ModeMastermind {

	public ChallengerMastermind() {
		super();
		// TODO Auto-generated constructor stub
		outil.initTableauNombreUtilisable();
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

		System.out.println("\n\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");

		System.out.print("\n Dans ce mode vous devez trouver la combinaison secr�te g�n�r�e par l'ordinateur !" + " Vous avez " + outil.CONFIGURATION_ESSAIS + " essais !" +
				"\n Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE
				+ " chiffres en utilisant les nombres allant de " + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + " � " + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + " !"
				+ "\n C'est � vous de jouer !\n" );

		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
		logger.trace("Combinaison g�n�r�e par l'ordinateur " + outil.chaineDeCaract(getCodeSecretOrdinateur()));

		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode d�veloppeur ! Combinaison : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}

		do {

			System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");
			System.out.print("\n Saisissez votre combinaison et tapez sur entr�e pour valider : ");

			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));
			logger.trace("Combinaison g�n�r�e par l'utilisateur " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));

			setResultatBienPlacePresent(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));

			System.out.println("\n Proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " R�ponse : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");
			logger.trace("Joureur ! Essai n� " + getCompteurEssai()+ " : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");

			setCompteurEssai(1);

		} while (!getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS );

		if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretOrdinateur())){

			System.out.println("\n Bravo ! Vous avez trouv� la combinaison secr�te de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
			logger.trace("L'utilisateur � trouv� : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
		} else {

			System.out.println("\n Perdu ! La combinaison secr�te de l'odrdinateur �t� : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
			logger.trace("Perdu ! La combinaison �t� : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	}

}
