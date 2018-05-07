package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.RecherchePlusMoins;


public class DefenseurRecherchePlusMoins extends ModeRecherche {

	public DefenseurRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefenseurRecherchePlusMoins(String codeSecret, ArrayList<Long> codeSecretMachineTab,
									   ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
									   ArrayList<Long> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {
		super(codeSecret, codeSecretMachineTab, codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab,
				reponseUtilisateur, resultat, recupeNombreTab);
		// TODO Auto-generated constructor stub
	}

	/********************************************** Ci-dessous la m?thode qui lance le jeu 
	 * @throws CodeInvalideException **********************************************************/

	public void playerGame() throws CodeInvalideException {

		System.out.println("\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*               MODE DEFENSEUR               *");
		System.out.println("\t**********************************************");



		int compteur = 0;

		System.out.print("\nC'est à vous de jouer ! \nEntrez votre code secret de " + outil.CONFIGURATION_NOMBRE
				+ " chiffres que l'ordinateur devra trouver en " + outil.CONFIGURATION_ESSAIS + " essais : ");

		reponse();
		setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
		logger.trace("Code secret généré par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));

		if (getModeDev().equals("developpeur")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
		}


		do {

			int i = 0;

			while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {

				if (getCodeSecretMachineTab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), +1);
					setResultat(getResultat() + "+");
					i++;

				} else if(getCodeSecretMachineTab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), -1);
					setResultat(getResultat() + "-");
					i++;
				} else {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), 0);
					setResultat(getResultat() + "=");
					i++;
				}
			}

			System.out.print("\nEssai n° " + getCompteurEssai() + " ! ");
			System.out.println("\nProposition : " + outil.chaineDeCaract(getCodeSecretMachineTab()) + " Réponse : " + getResultat());
			logger.trace("Essai n° " + getCompteurEssai() + " Code secret ordinateur : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("Réponse : " + getResultat());

			getCodeSecretMachineTab().removeAll(getCodeSecretMachineTab());
			setCodeSecretMachineTab(outil.codeSecretAjoutTab(getCodeSecret()));
			setCodeSecret("");
			setResultat("");

			setCompteurEssai(1);

		} while(!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

		if (getCodeSecretMachineTab().equals(getCodeSecretUtilisateurTab())) {
			System.out.println("\nVotre ordinateur à trouvé votre combinaison : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("L'ordinateur à trouvé : " + outil.chaineDeCaract(getCodeSecretMachineTab()));

		} else  {
			System.out.println("\nL'ordinateur n'a pas réussi à trouver votre code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()) + " ! ");
			logger.trace("L'ordinateur à perdu : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}



	}


}
