package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.RecherchePlusMoins;


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

		System.out.println("\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE CHALLENGER              *");
		System.out.println("\t**********************************************");

		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
		logger.trace("Code secret g�n�r� par l'ordinateur " + outil.chaineDeCaract(getCodeSecretMachineTab()));

		if (getModeDev().equals("developpeur")) {
			System.out.println("\n Mode d�veloppeur ! Code secret : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

		System.out.println("\nC'est � vous de jouer ! Vous avez " + outil.CONFIGURATION_ESSAIS + " essais pour trouver le code secret !" );

		do {

			System.out.print("\nEssai n� " + getCompteurEssai() + " ! " + "\nEnter votre nombre � " + outil.CONFIGURATION_NOMBRE + " chiffres : ");

			reponse();
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			logger.trace("Essai n� " + getCompteurEssai() + " Code secret utilisateur : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

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

			System.out.println("Proposition : "+ getReponseUtilisateur() + " R�ponse : " + getResultat());

			logger.trace("R�ponse : " + getResultat());

			setResultat("");

			setCompteurEssai(1);

		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

		if (getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())){
			System.out.println("\nBravo ! Vous avez trouv� la bonne combinaison secrete : " + getReponseUtilisateur());
			logger.trace("L'utilisateur � trouv� : " + getReponseUtilisateur());
		} else {
			System.out.println("\nPerdu ! La combinaison secrete �t� : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("Perdu ! La combinaison �t� � : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}

	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


