package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.Mastermind;


public class DefenseurMastermind extends ModeMastermind {


    private Long nbre = 0L;

    private ArrayList<String> tableauDesPossibilites = new ArrayList<String>();
    private ArrayList<Long> tableauTempDeSolution = new ArrayList<Long>();
    private ArrayList<Byte> resultacompare = new ArrayList<Byte>();



    public DefenseurMastermind() {
        super();
        // TODO Auto-generated constructor stub

        initalisationNombreMinMax();
        outil.initTableauNombreUtilisable();

    }

    public DefenseurMastermind(String codeSecret, ArrayList<Byte> resultatBienPlacePresentUtilisateur, ArrayList<Long> codeSecretOrdinateur,
                               ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretUtilisateur, ArrayList<Long> codeSecretUtilisateurTab,
                               ArrayList<Long> codeSecretPlayerUtilisateur, ArrayList<Long> codeSecretPlayerOrdnateur, String nombreGenerer, String initCodeAvecZero,
                               String initalisation_zero, String nombreMax, Long nbre, ArrayList<String> tableauDesPossibilites, ArrayList<Long> tableauTempDeSolution,
                               ArrayList<Byte> resultacompare) {
        super(codeSecret, resultatBienPlacePresentUtilisateur, codeSecretOrdinateur, resultat_BienPlace_Present, codeSecretUtilisateur,
                codeSecretUtilisateurTab, codeSecretPlayerUtilisateur, codeSecretPlayerOrdnateur, nombreGenerer, initCodeAvecZero, initalisation_zero, nombreMax);
        this.nbre = nbre;
        this.tableauDesPossibilites = tableauDesPossibilites;
        this.tableauTempDeSolution = tableauTempDeSolution;
        this.resultacompare = resultacompare;
    }

    public ArrayList<Byte> getResultacompare() {
        return resultacompare;
    }

    public void setResultacompare(ArrayList<Byte> arrayList) {
        this.resultacompare = arrayList;
    }

    public ArrayList<Long> getTableauTempDeSolution() {
        return tableauTempDeSolution;
    }

    public void setTableauTempDeSolution(ArrayList<Long> tableauTempDeSolution) {
        this.tableauTempDeSolution = tableauTempDeSolution;
    }

    public ArrayList<String> getTableauDesPossibilites() {
        return tableauDesPossibilites;
    }

    public void setTableauDesPossibilites(ArrayList<String> tableauDesPossibilites) {
        this.tableauDesPossibilites = tableauDesPossibilites;
    }


    @Override
    public void playerGame() throws CodeInvalideException {

        System.out.println("\n\t**********************************************");
        System.out.println("\t*                 MASTERMIND                 *");
        System.out.println("\t*               MODE DEFENSEUR               *");
        System.out.println("\t**********************************************");

        System.out.print("\n Dans ce mode l'ordinateur doit trouver votre combinaison secr�te en " + outil.CONFIGURATION_ESSAIS + " essais !\n Entrez votre combinaison de " + outil.CONFIGURATION_NOMBRE
                + " chiffres en utilisant les nombres allant de " + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + " � " + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + " !"
                + "\n C'est � vous de jouer !\n" );

        System.out.print("\n Saisissez votre combinaison secr�te et tapez sur entr�e pour le valider : ");

        // L'utilisateur entre sa combinaison secr�te que l'ordinateur devra trouver
        setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
        logger.trace("Combinaison secr�te g�n�r�e par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateur()));

        // L'ordinateur g�n�re un nombre al�atoire compris dans l'intervalle des chiffres utilisables
        setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(outil.genererCodeSecret( Mastermind.class.getSimpleName())));

        // Appelle de la m�thode resultatMastermind et compare les deux combinaisons
        setResultatBienPlacePresent(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));

        // Initialisation de la plus petite combinaison possible en fonction de la configuration
        setTableauTempDeSolution(outil.codeSecretAjoutTab(getInitalisationZero()));

        System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");

        /*Partie 1 : premier traitement
        * Nous entrons dans notre boucle et nous testons notre premi�re possibilit� initialis�e plus haut
        * puis nous allons g�n�rer toutes les possibilit�es, les comparer et sauvegarder les combinaisons
        * potentiellement solution dans un tableau.
        * */

        while(!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax())) {

            setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), getTableauTempDeSolution()));

            if (getResultatBienPlacePresent().equals(getResultacompare())) {
                tableauDesPossibilites.add(getInitCodeAvecZero());
            }

            setTableauTempDeSolution(outil.codeSecretAjoutTab(genereNombreSolution()));
        }

        // On Affiche la prosition de l'ordinateur !
        System.out.println("\n Proposition l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " R�ponse : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
                getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");
        logger.trace("Essai n� " + getCompteurEssai()+ " : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
                getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");

        setNombreGenerer("");

        /*Partie 2 : Deuxi�me traitement
        * Dans cette deuxi�me partie, on va r�cup�rer le tableau des solutions potentielles et, prendre au hasard
        * une combinaison dedans. Comme sur le principe pr�c�dent nous comparons cette combinaison � celle de
        * l'utilisateur puis chaque combinaison du tableau avec la combinaison prise au hasard.
        * Et on affiche la prosition de l'ordinateur !
        * Nous r�it�rons ce processus jusqu'�, soit que l'ordinateur trouve la combinaison ou que le nombre d'essais soit ateind
        **/

        while (!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur())
                && getTableauDesPossibilites().size() > 1 && getCompteurEssai() < outil.CONFIGURATION_ESSAIS) {

            ArrayList<String> tableauTemp = new ArrayList<String>();

            int indiceAuHasard = (int) (Math.random() * (getTableauDesPossibilites().size() - 0));
            getCodeSecretPlayerOrdnateur().clear();
            setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(getTableauDesPossibilites().get(indiceAuHasard)));

            setResultatBienPlacePresent(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));

            for (int i = 0; i < getTableauDesPossibilites().size(); i++) {

                getTableauTempDeSolution().clear();
                setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), outil.codeSecretAjoutTab(getTableauDesPossibilites().get(i))));

                if (getResultatBienPlacePresent().equals(getResultacompare())){
                    tableauTemp.add(getTableauDesPossibilites().get(i));
                }
            }

            getTableauDesPossibilites().clear();
            getTableauDesPossibilites().addAll(tableauTemp);

            setCompteurEssai(1);

            System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");

            System.out.println("\n Proposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " R�ponse : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
                    getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");
            logger.trace("Essai n� " + getCompteurEssai()+ " : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
                    getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");
        }

        if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur())) {

            if (getModeDev().equals("-dev")) {
                System.out.println("\n Mode d�veloppeur ! Combinaison : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

            System.out.println("\n L'ordinateur � trouver votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
            logger.trace(" L'ordinateur � trouver : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));

        } else if (getTableauDesPossibilites().get(0).equals(outil.chaineDeCaract(getCodeSecretUtilisateur()))) {

            if (getModeDev().equals("-dev")) {
                System.out.println("\n Mode d�veloppeur ! Combinaison : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

            System.out.println("\n L'ordinateur � trouver votre combinaison secr�te : " + getTableauDesPossibilites().get(0));
            logger.trace("L'ordinateur � trouver : " + getTableauDesPossibilites().get(0));

        } else {

            if (getModeDev().equals("-dev")) {
                System.out.println("\n Mode d�veloppeur ! Combinaison : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

            System.out.println("\n L'ordinateur n'a pas r�ussi � trouver votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretUtilisateur()) + " ! ");
            logger.trace("L'ordinateur � perdu : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
        }
    }

    /********************************************************************************************/

    public String genereNombreSolution() {

        do {

            setNombreGenerer("" + (nbre = nbre + 1L));

            if (tableauTempDeSolution.get(0) == 0 && outil.verificationNombreUtilisable(getNombreGenerer()) != true){
                int i = getNombreGenerer().length();
                setInitCodeAvecZero(getInitalisationZero().substring(i, getInitalisationZero().length()));
                setInitCodeAvecZero(getInitCodeAvecZero() + getNombreGenerer());
            }

            if (tableauTempDeSolution.get(0) != 0 && outil.verificationNombreUtilisable(getNombreGenerer()) != true) {
                int i = getNombreGenerer().length();
                setInitCodeAvecZero(getInitalisationZero().substring(i, getInitalisationZero().length()));
                setInitCodeAvecZero(getInitCodeAvecZero() + getNombreGenerer());
            }

        } while (!outil.verificationNombreUtilisable(getNombreGenerer()) != true && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax()));

        getTableauTempDeSolution().clear();

        return getInitCodeAvecZero();
    }



}
