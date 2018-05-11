package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.RecherchePlusMoins;


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

		System.out.print("\n Dans ce mode l'ordinateur doit trouver votre combinaison secr�te en " + outil.CONFIGURATION_ESSAIS + " essais !\n Entrez votre combinaison secr�te de " + outil.CONFIGURATION_NOMBRE
				+ " chiffres ! \n C'est � vous de jouer !\n" );

		int compteur = 0;

		System.out.print("\n Saisissez votre combinaison secr�te et tapez sur entr�e pour le valider : ");
		reponse();
		setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
		logger.trace("Combinaison secr�te g�n�r�e par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));

		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode d�veloppeur ! \n Combinaison secr�tet : " + getCodeSecret());
		}

		do {

			int i = 0;

			while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {

				if (getCodeSecretMachineTab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), +1);

					if(Long.parseLong(String.valueOf(getCodeSecret().charAt(i))) == getCodeSecretUtilisateurTab().get(i)) {
						setResultatOrdinateur(getResultatOrdinateur() + "=");
					} else {
						setResultatOrdinateur(getResultatOrdinateur() + "+");
					}

					i++;

				} else if(getCodeSecretMachineTab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), -1);

					if(Long.parseLong(String.valueOf(getCodeSecret().charAt(i))) == getCodeSecretUtilisateurTab().get(i)) {
						setResultatOrdinateur(getResultatOrdinateur() + "=");
					} else {
						setResultatOrdinateur(getResultatOrdinateur() + "-");
					}

					i++;

				} else {
					setRecupeNombreTab(getCodeSecretMachineTab().get(i), 0);
					setResultatOrdinateur(getResultatOrdinateur() + "=");
					i++;
				}
			}

			getCodeSecretMachineTab().removeAll(getCodeSecretMachineTab());
			setCodeSecretMachineTab(outil.codeSecretAjoutTab(getCodeSecret()));

			System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");
			System.out.println("\n Proposition : " + outil.chaineDeCaract(getCodeSecretMachineTab()) + " R�ponse : " + getResultatOrdinateur());
			logger.trace("Essai n� " + getCompteurEssai() + " Combinaison secr�te de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
			logger.trace("R�ponse : " + getResultatOrdinateur());

			if (getCodeSecretMachineTab().equals(getCodeSecretUtilisateurTab())) {
				System.out.println("\n Votre ordinateur � trouv� votre Combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
				logger.trace("L'ordinateur � trouv� : " + outil.chaineDeCaract(getCodeSecretMachineTab()));

			} else {

				setCodeSecret("");
				setResultatOrdinateur("");
			}

			setCompteurEssai(1);

		} while(!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

		if (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
			System.out.println("\n L'ordinateur n'a pas r�ussi � trouver votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()) + " ! ");
			logger.trace("L'ordinateur � perdu : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
		}
	}
}
