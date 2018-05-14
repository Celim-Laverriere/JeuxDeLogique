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

		System.out.print("\n Dans ce mode l'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné ! "
				+ "\n Mais attention vous avez chacun "+ outil.CONFIGURATION_ESSAIS + " essais !\n Saisissez votre combinaison secrète de " + outil.CONFIGURATION_NOMBRE
				+ " chiffres en utilisant les nombres allant de " + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + " à " + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + " !\n");

		/*** lordinateur génére un code que doit trouver l'utilisateur ****/
		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
		logger.trace("Combinaison secrète générée par l'ordinateur " + outil.chaineDeCaract(getCodeSecretOrdinateur()));

		/*** L'utilisateur entre son code secret que l'ordinateur devra trouver *****/
		System.out.print("\n Saisissez la combinaison secrète que l'ordinateur devra trouver : ");
		setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
		logger.trace("Combinaison secrète générée par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateur()));

		/*********************** Affiche mode développeur ******************/
		if (getModeDev().equals("-dev")) {
			System.out.println("\n Mode développeur ! Combinaison secrète : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}

		/*********************************** premiere partie ( Jeu Utilisateur ) ************************************/

		System.out.println("\n C'est à vous de jouer !" );

		do {

			System.out.print("\n Essai n° " + getCompteurEssai() + " ! ");
			System.out.print("\n Saisissez votre combinaison et tapez sur entrée pour valider : ");

			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));

			setResultatBienPlacePresentUtilisateur(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));

//			System.out.println("\n\nVotre proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " +
//			getResultat_BienPlace_Present().get(1) + " Présent !");
//

			/******* Seconde partie ( Jeu Ordinateur **********/

			if (getCompteurEssai() <= 1 ) {

				/******** L'ordinateur génere sa premiere solution de chiffre ******************/

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

			System.out.println("\n Votre proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " Réponse : " + getResultatBienPlacePresentUtilisateur().get(0) + " Bien placé(s) et " +
					getResultatBienPlacePresentUtilisateur().get(1) + " Présent(s) !");

			logger.trace("Joureur ! Essai n° " + getCompteurEssai()+ " : " + getResultatBienPlacePresentUtilisateur().get(0) + " Bien placé(s) et " +
					getResultatBienPlacePresentUtilisateur().get(1) + " Présent(s) !");

			System.out.println(" Proposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " Réponse : " + getResultatBienPlacePresent().get(0) + " Bien placé(s) et " +
					getResultatBienPlacePresent().get(1) + " Présent(s) !");

			logger.trace("Ordinateur ! Essai n° " + getCompteurEssai()+ " : " + getResultatBienPlacePresent().get(0) + " Bien placé(s) et " +
					getResultatBienPlacePresent().get(1) + " Présent(s) !");

			setCompteurEssai(1);

		} while (!getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur())) && !getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())
				&& !getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS );

		if (getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())) {

			System.out.println("\n Bravo ! Vous avez trouvé la combinaison secrète de l'ordinateur : " + outil.chaineDeCaract((getCodeSecretOrdinateur())));
			logger.trace("L'utilisateur à trouvé : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()));

		} else if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) || getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur()))) {

			System.out.println("\n Perdu ! L'ordinateur a trouvé votre combinaison secrète : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
			logger.trace("L'ordinateur à trouvé : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));

		} else {

			System.out.println("\n Vous ainsi que l'ordinateur avait été dans l'incapacité de trouver la combinaison secrète de l'un et de l'autre !");
			System.out.println(" Combinaison secrète que devait trouve l'ordinateur : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
			System.out.println(" Combinaison secrète que deviait trouver l'utilisateur : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
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
