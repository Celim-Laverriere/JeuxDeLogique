package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.RecherchePlusMoins;


public class DuelRecherchePlusMoins extends ModeRecherche {

	public DuelRecherchePlusMoins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuelRecherchePlusMoins(String codeSecret, ArrayList<Long> codeSecretMachineTab,
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
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                RECHERCHE +/-               *");
		System.out.println("\t*                  MODE DUEL                 *");
		System.out.println("\t**********************************************");
		
		int compteur = 0;
			
		/*********** Code générer par l'ordinateur ***********/
		setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
		}
		
		/*********** Code générer par l'utilisateur ***********/
		System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
		
		reponse();
		setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());

		setCodeSecretPlayerAITab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
	
		do {
		
		int i = 0;
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres" );
			
		reponse();
		setCodeSecretPlayerUtilisateurTab(getCodeSecretPlayerUtilisateurTab());
			
		do {	
			
				while ( i < getCodeSecretPlayerUtilisateurTab().size() && !getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
					
						if (getCodeSecretPlayerUtilisateurTab().get(i) < getCodeSecretMachineTab().get(i)) {
							setResultat(getResultat() + "+");
							break;
						} else if (getCodeSecretPlayerUtilisateurTab().get(i) > getCodeSecretMachineTab().get(i)) {
							setResultat(getResultat() + "-");
							break;
						} else {
							setResultat(getResultat() + "=");
							break;
						}
					}
				
				if (i == getCodeSecretPlayerUtilisateurTab().size()) {
					System.out.println("\n\nProposition : "+ getReponseUtilisateur() +" Réponse : " + getResultat());
					setResultat("");
					getCodeSecretPlayerUtilisateurTab().removeAll(getCodeSecretPlayerUtilisateurTab());
				}
							
				while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
							
						if (getCodeSecretPlayerAITab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
							setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), +1); 
								break;
								
						} else if(getCodeSecretPlayerAITab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
							setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), -1);
								break;
							} else {
								setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), 0);
								break;
							}
					}
					
					if (i == getCodeSecretUtilisateurTab().size()) {
						compteur++;
						System.out.println("\n\nProposition de l'ordinateur : " + getCodeSecret() + " Réponse n° : " + compteur);
						getCodeSecretPlayerAITab().removeAll(getCodeSecretPlayerAITab());
						setCodeSecretPlayerAITab(getCodeSecretPlayerAITab());
					}
		
					if (getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
						System.out.println("\nVotre ordinateur à trouvé en " + compteur  + " coups votre combinaison : " + getCodeSecret());
						break;
					}
					
					if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
						System.out.println("\t****************************************************************");
						System.out.println("\t*\t\t\t     BRAVO !                           *");
						System.out.println("\t*\t Vous avez trouvé la bonne combinaison : " + getReponseUtilisateur() + "        *");						
						System.out.println("\t****************************************************************");
						break;
					}
						
					i++;
						
			} while (i <= getCodeSecretUtilisateurTab().size() || i <= getCodeSecretPlayerUtilisateurTab().size());		
						
		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab()) && !getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab()));
		
			
	}

}


