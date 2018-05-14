package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.jeux.Mastermind;

public class DuelMastermind extends ModeMastermind {


	private Long nbre = 0L;
	private ArrayList<String> tableauDesPossibilites = new ArrayList<String>();
	private ArrayList<Long> tableauTempDeSolution = new ArrayList<Long>();
	private ArrayList<Byte> resultatAcomparer = new ArrayList<Byte>();

	public DuelMastermind() {
		super();
		// TODO Auto-generated constructor stub
		initalisationNombreMinMax();
		outil.initTableauNombreUtilisable();

	}

	public DuelMastermind(String codeSecret, ArrayList<Byte> resultatBienPlacePresentUtilisateur, ArrayList<Long> codeSecretOrdinateur,
						  ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretUtilisateur, ArrayList<Long> codeSecretUtilisateurTab,
						  ArrayList<Long> codeSecretPlayerUtilisateur, ArrayList<Long> codeSecretPlayerOrdnateur, String nombreGenerer, String initCodeAvecZero,
						  String initalisation_zero, String nombreMax, Long nbre, ArrayList<String> tableauDesPossibilites, ArrayList<Long> tableauTempDeSolution,
						  ArrayList<Byte> resultatAcomparer) {
		super(codeSecret, resultatBienPlacePresentUtilisateur, codeSecretOrdinateur, resultat_BienPlace_Present,
				codeSecretUtilisateur, codeSecretUtilisateurTab, codeSecretPlayerUtilisateur, codeSecretPlayerOrdnateur,
				nombreGenerer, initCodeAvecZero, initalisation_zero, nombreMax);
		this.nbre = nbre;
		this.tableauDesPossibilites = tableauDesPossibilites;
		this.tableauTempDeSolution = tableauTempDeSolution;
		this.resultatAcomparer = resultatAcomparer;
	}

	public Long getNbre() {
		return nbre;
	}

	public void setNbre(Long nbre) {
		this.nbre = nbre;
	}

	public ArrayList<String> getTableauDesPossibilites() {
		return tableauDesPossibilites;
	}

	public void setTableauDesPossibilites(ArrayList<String> tableauDesPossibilites) {
		this.tableauDesPossibilites = tableauDesPossibilites;
	}

	public ArrayList<Long> getTableauTempDeSolution() {
		return tableauTempDeSolution;
	}

	public void setTableauTempDeSolution(ArrayList<Long> tableauTempDeSolution) {
		this.tableauTempDeSolution = tableauTempDeSolution;
	}

	public ArrayList<Byte> getResultatAcomparer() {
		return resultatAcomparer;
	}

	public void setResultatAcomparer(ArrayList<Byte> resultatAcomparer) {
		this.resultatAcomparer = resultatAcomparer;
	}


	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub


		//setNombreUtilisable(outil.initTableauNombreUtilisable());

		System.out.println("\n\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*                 MODE Duel                  *");
		System.out.println("\t**********************************************");

		System.out.print("\n Dans ce mode l'ordinateur et vous jouez tour � tour, le premier � trouver la combinaison secr�te de l'autre a gagn� ! "
				+ "\n Mais attention vous avez chacun "+ outil.CONFIGURATION_ESSAIS + " essais !\n Saisissez votre combinaison secr�te de " + outil.CONFIGURATION_NOMBRE
				+ " chiffres en utilisant les nombres allant de " + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + " � " + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + " !\n");

		/*** lordinateur g�n�re un code que doit trouver l'utilisateur ****/
		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
		logger.trace("Combinaison secr�te g�n�r�e par l'ordinateur " + outil.chaineDeCaract(getCodeSecretOrdinateur()));

		/*** L'utilisateur entre son code secret que l'ordinateur devra trouver *****/
		System.out.print("\n Saisissez la combinaison secr�te que l'ordinateur devra trouver : ");
		setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
		logger.trace("Combinaison secr�te g�n�r�e par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateur()));

		/*********************** Affiche mode d�veloppeur ******************/
		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode d�veloppeur ! Combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}

		/*********************************** premiere partie ( Jeu Utilisateur ) ************************************/

		System.out.println("\n C'est � vous de jouer !" );

		do {

			System.out.print("\n Essai n� " + getCompteurEssai() + " ! ");
			System.out.print("\n Saisissez votre combinaison et tapez sur entr�e pour valider : ");

			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));

			setResultatBienPlacePresentUtilisateur(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));

//			System.out.println("\n\nVotre proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " R�ponse : " + getResultat_BienPlace_Present().get(0) + " Bien plac� et " +
//			getResultat_BienPlace_Present().get(1) + " Pr�sent !");
//

			/******* Seconde partie ( Jeu Ordinateur **********/

			if (getCompteurEssai() <= 1 ) {

				/******** L'ordinateur g�nere sa premiere solution de chiffre ******************/

				setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab( outil.genererCodeSecret(Mastermind.class.getSimpleName())));

				/********** Premier test qui compare le nombre de l'utilisateur et celui de l'ordinateur et renvoie un resultat ********/
				setResultatBienPlacePresent(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));

				/***** Initialisation du tableau qui va stocker temporairement les solutions ********/
				setTableauTempDeSolution(outil.codeSecretAjoutTab(getInitalisationZero()));

				while(!getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax())) {

					setResultatAcomparer(resultatMastermind(getCodeSecretPlayerOrdnateur(), getTableauTempDeSolution()));

					if (getResultatAcomparer().equals(getResultatBienPlacePresent())) {
						tableauDesPossibilites.add(getInitCodeAvecZero());
					}

					setTableauTempDeSolution(outil.codeSecretAjoutTab(genereNombreSolution()));
				}

				setNombreGenerer("");
			}

			if (!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) && getTableauDesPossibilites().size() > 0 && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS && getCompteurEssai() >= 2) {

				ArrayList<String> tableauTemp = new ArrayList<String>();
				int indiceAuHasard = (int) (Math.random() * (getTableauDesPossibilites().size() - 1));
				getCodeSecretPlayerOrdnateur().clear();
				setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(getTableauDesPossibilites().get(indiceAuHasard)));

				setResultatBienPlacePresent(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));


				for (int i = 0; i < getTableauDesPossibilites().size(); i++) {

					getTableauTempDeSolution().clear();
					setResultatAcomparer(resultatMastermind(getCodeSecretPlayerOrdnateur(), outil.codeSecretAjoutTab(getTableauDesPossibilites().get(i))));

					if (getResultatBienPlacePresent().equals(getResultatAcomparer())){
						tableauTemp.add(getTableauDesPossibilites().get(i));
					}
				}

				getTableauDesPossibilites().clear();
				getTableauDesPossibilites().addAll(tableauTemp);
			}

			System.out.println("\n Votre proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " R�ponse : " + getResultatBienPlacePresentUtilisateur().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresentUtilisateur().get(1) + " Pr�sent(s) !");

			logger.trace("Joureur ! Essai n� " + getCompteurEssai()+ " : " + getResultatBienPlacePresentUtilisateur().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresentUtilisateur().get(1) + " Pr�sent(s) !");

			System.out.println(" Proposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " R�ponse : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");

			logger.trace("Ordinateur ! Essai n� " + getCompteurEssai()+ " : " + getResultatBienPlacePresent().get(0) + " Bien plac�(s) et " +
					getResultatBienPlacePresent().get(1) + " Pr�sent(s) !");

			setCompteurEssai(1);

		} while (!getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur())) && !getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())
				&& !getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS );

		if (getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())) {

			System.out.println("\n Bravo ! Vous avez trouv� la combinaison secr�te de l'ordinateur : " + outil.chaineDeCaract((getCodeSecretOrdinateur())));
			logger.trace("L'utilisateur � trouv� : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));

		} else if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) || getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur()))) {

			System.out.println("\n Perdu ! L'ordinateur a trouv� votre combinaison secr�te : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
			logger.trace("L'ordinateur � trouv� : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));

		} else {

			System.out.println("\n Vous ainsi que l'ordinateur avait �t� dans l'incapacit� de trouver la combinaison secr�te de l'un et de l'autre !");
			System.out.println(" Combinaison secr�te que devait trouve l'ordinateur : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
			System.out.println(" Combinaison secr�te que deviait trouver l'utilisateur : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	}

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
