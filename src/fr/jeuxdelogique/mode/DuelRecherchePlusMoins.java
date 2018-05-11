package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.RecherchePlusMoins;


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

    /********************************************** Ci-dessous la m�thode qui lance le jeu
     * @throws CodeInvalideException **********************************************************/

    @Override
    public void playerGame() throws CodeInvalideException {

        System.out.println("\t**********************************************");
        System.out.println("\t*                RECHERCHE +/-               *");
        System.out.println("\t*                  MODE DUEL                 *");
        System.out.println("\t**********************************************");

        System.out.print("\n Dans ce mode l'ordinateur et vous jouez tour � tour,le premier � trouver la combinaison secr�te de l'autre a gagn� ! "
                + "\n Mais attention vous avez chacun " + outil.CONFIGURATION_ESSAIS + " essais !\n Saisissez votre combinaison secr�te de " + outil.CONFIGURATION_NOMBRE
                + " chiffres !\n");

        int compteur = 0;

        /*********** Code g�n�rer par l'ordinateur ***********/
        setCodeSecretMachineTab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));
        logger.trace("Combinaison secr�te g�n�r�e par l'ordinateur " + outil.chaineDeCaract(getCodeSecretMachineTab()));

        if (getModeDev().equals("-dev")) {
            System.out.println("\n Mode d�veloppeur ! Combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
        }

        /*********** Code g�n�rer par l'utilisateur ***********/
        System.out.print("\n Saisissez la combinaison secr�te que l'ordinateur devra trouver : ");
        reponse();
        setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
        logger.trace("Combinaison secr�te g�n�r� par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));

        setCodeSecretPlayerAITab(outil.codeSecretAjoutTab(outil.genererCodeSecret(RecherchePlusMoins.class.getSimpleName())));

        System.out.println("\n C'est � vous de jouer !" );

        do {

            System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");
            System.out.print("\n Saisissez votre combinaison et tapez sur entr�e pour valider : ");

            getCodeSecretPlayerUtilisateurTab().removeAll(getCodeSecretPlayerUtilisateurTab());
            reponse();
            setCodeSecretPlayerUtilisateurTab(getCodeSecretPlayerUtilisateurTab());

            if (!getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {

                for (int i = 0; i < getCodeSecretPlayerUtilisateurTab().size() ; i++ ) {

                    if (getCodeSecretPlayerUtilisateurTab().get(i) < getCodeSecretMachineTab().get(i)) {
                        setResultat(getResultat() + "+");

                    } else if (getCodeSecretPlayerUtilisateurTab().get(i) > getCodeSecretMachineTab().get(i)) {
                        setResultat(getResultat() + "-");

                    } else {
                        setResultat(getResultat() + "=");
                    }
                }

                System.out.println(" Votre proposition : " + getReponseUtilisateur() + " R�ponse : " + getResultat());
                logger.trace("Essai n� " + getCompteurEssai() + " Combinaison secr�te de l'utilisateur : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));
                logger.trace("R�ponse de l'utilisateur : " + getResultat());
            }

            if (!getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {

                for (int i =0; i < getCodeSecretUtilisateurTab().size(); i++) {

                    if (getCodeSecretPlayerAITab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
                        setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), +1);

                        if(Long.parseLong(String.valueOf(getCodeSecret().charAt(i))) == getCodeSecretUtilisateurTab().get(i)) {
                            setResultatOrdinateur(getResultatOrdinateur() + "=");
                        } else {
                            setResultatOrdinateur(getResultatOrdinateur() + "+");
                        }

                    } else if(getCodeSecretPlayerAITab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
                        setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), -1);

                        if(Long.parseLong(String.valueOf(getCodeSecret().charAt(i))) == getCodeSecretUtilisateurTab().get(i)) {
                            setResultatOrdinateur(getResultatOrdinateur() + "=");
                        } else {
                            setResultatOrdinateur(getResultatOrdinateur() + "-");
                        }

                    } else {
                        setRecupeNombreTab(getCodeSecretPlayerAITab().get(i), 0);
                        setResultatOrdinateur(getResultatOrdinateur() + "=");
                    }
                }

                getCodeSecretPlayerAITab().removeAll(getCodeSecretPlayerAITab());
                setCodeSecretPlayerAITab(outil.codeSecretAjoutTab(getCodeSecret()));

                System.out.println(" Proposition de l'ordinateur : " + getCodeSecret() + " R�ponse : " + getResultatOrdinateur());
                logger.trace("Essai n� " + getCompteurEssai() + " Combinaison secr�te de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerAITab()));
                logger.trace("R�ponse de L'ordinateur : " + getResultatOrdinateur());
            }

            if (getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
                System.out.println("\n L'ordinateur � trouv� votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretPlayerAITab()));
                logger.trace("L'ordinateur � trouv� : " + outil.chaineDeCaract(getCodeSecretPlayerAITab()));
            } else if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
                System.out.println("\n BRAVO ! Vous avez trouv� la combinaison secr�te de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " !");
                logger.trace("L'utilisateur � trouv� : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) );
            } else {

                setResultat("");
                setCodeSecret("");
                setResultatOrdinateur("");
            }

            setCompteurEssai(1);

        } while (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab()) && !getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS);

        if (!getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab())) {
            System.out.println("\n PERDU ! La combinaison secr�te de l'ordinateur �t� : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
        }
        if (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab())){
            System.out.println(" L'ordinateur n'a pas r�ussi � trouv� votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));
        }
        if (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab()) && !getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab())){
            System.out.println("\n Vous ainsi que l'ordinateur avait �t� dans l'incapacit� de trouver la combinaison secr�te de l'un et de l'autre !");
            System.out.println(" Combinaison secr�te que devait trouve l'ordinateur : " + outil.chaineDeCaract(getCodeSecretUtilisateurTab()));
            System.out.println(" Combinaison secr�te que deviait trouver l'utilisateur : " + outil.chaineDeCaract(getCodeSecretMachineTab()));
        }
    }
}


