package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.RecherchePlusMoins;


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

	/********************************************** Ci-dessous la m�thode qui lance le jeu
	 * @throws CodeInvalideException **********************************************************/

	@Override
	public void playerGame() throws CodeInvalideException {

		System.out.println("\n\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");

		System.out.print("\n Dans ce mode vous devez trouver la combinaison secr�te g�n�r�e par l'ordinateur !" + " Vous avez " + outil.CONFIGURATION_ESSAIS + " essais !" +
				"\n Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !"
				+ "\n C'est � vous de jouer !\n" );

		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
		logger.trace("Combinaison secr�te g�n�r�e par l'ordinateur " + outil.chaineDeCaract(getCodeSecretMachineTab()));

		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode d�veloppeur ! Combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

		do {

			System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");
			System.out.print("\n Saisissez votre combinaison et tapez sur entr�e pour valider : ");

			reponse();
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			logger.trace("Essai n� " + getCompteurEssai() + " Combinaison utilisateur : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

			int i = 0;

			while ( i < getCodeSecretUtilisateurTab().size()) {

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

			System.out.println(" Proposition : "+ getReponseUtilisateur() + " R�ponse : " + getResultat());

			logger.trace("R�ponse : " + getResultat());

			setResultat("");

			setCompteurEssai(1);

		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

		if (getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())){
			System.out.println("\n Bravo ! Vous avez trouv� la combinaison secr�te de l'ordinateur : " + getReponseUtilisateur());
			logger.trace("L'utilisateur � trouv� : " + getReponseUtilisateur());
		} else {
			System.out.println("\nPerdu ! La combinaison secr�te de l'ordinateur �t� : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("Perdu ! La combinaison secr�te �t� : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


