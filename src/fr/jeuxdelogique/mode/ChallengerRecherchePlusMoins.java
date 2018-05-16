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

	/********************************************** Ci-dessous la méthode qui lance le jeu
	 * @throws CodeInvalideException **********************************************************/

	@Override
	public void playerGame() throws CodeInvalideException {

		System.out.println("\n\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");

		System.out.print("\n Dans ce mode vous devez trouver la combinaison secrète générée par l'ordinateur !" + " Vous avez " + outil.CONFIGURATION_ESSAIS + " essais !" +
				"\n Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !"
				+ "\n C'est à vous de jouer !\n" );

		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
		logger.trace("Combinaison secrète générée par l'ordinateur " + outil.chaineDeCaract(getCodeSecretMachineTab()));

		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode développeur ! Combinaison secrète : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

		do {

			System.out.print("\n Essai n° " + getCompteurEssai() + " ! ");
			System.out.print("\n Saisissez votre combinaison et tapez sur entrée pour valider : ");

			reponse();
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			logger.trace("Essai n° " + getCompteurEssai() + " Combinaison utilisateur : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

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

			System.out.println(" Proposition : "+ getReponseUtilisateur() + " Réponse : " + getResultat());

			logger.trace("Réponse : " + getResultat());

			setResultat("");

			setCompteurEssai(1);

		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

		if (getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())){
			System.out.println("\n Bravo ! Vous avez trouvé la combinaison secrète de l'ordinateur : " + getReponseUtilisateur());
			logger.trace("L'utilisateur à trouvé : " + getReponseUtilisateur());
		} else {
			System.out.println("\nPerdu ! La combinaison secrète de l'ordinateur été : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("Perdu ! La combinaison secrète été : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


