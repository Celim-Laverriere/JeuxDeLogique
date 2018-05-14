package fr.jeuxdelogique.mode;

import java.io.Serializable;
import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;


public class ModeMastermind extends Mode {

	private String codeSecret;
	private ArrayList<Byte>  resultatBienPlacePresentUtilisateur = new ArrayList<Byte>();
	private ArrayList<Long> codeSecretOrdinateur = new ArrayList<Long>();
	private ArrayList<Byte> resultatBienPlacePresent = new ArrayList<Byte>();
	private ArrayList<Long> codeSecretUtilisateur = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateur = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerOrdnateur = new ArrayList<Long>();
	private String nombreGenerer = "";
	private String initCodeAvecZero = "";
	private String initalisationZero = "";
	private String nombreMax = "";

	public ModeMastermind() {

		super();
		// TODO Auto-generated constructor stub
	}

	public ModeMastermind(String codeSecret, ArrayList<Byte> resultatBienPlacePresentUtilisateur, ArrayList<Long> codeSecretOrdinateur,
						  ArrayList<Byte> resultatBienPlacePresent, ArrayList<Long> codeSecretUtilisateur, ArrayList<Long> codeSecretUtilisateurTab,
						  ArrayList<Long> codeSecretPlayerUtilisateur, ArrayList<Long> codeSecretPlayerOrdnateur, String nombreGenerer,
						  String initCodeAvecZero, String initalisationZero, String nombreMax) {
		this.codeSecret = codeSecret;
		this.resultatBienPlacePresentUtilisateur = resultatBienPlacePresentUtilisateur;
		this.codeSecretOrdinateur = codeSecretOrdinateur;
		this.resultatBienPlacePresent = resultatBienPlacePresent;
		this.codeSecretUtilisateur = codeSecretUtilisateur;
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
		this.codeSecretPlayerUtilisateur = codeSecretPlayerUtilisateur;
		this.codeSecretPlayerOrdnateur = codeSecretPlayerOrdnateur;
		this.nombreGenerer = nombreGenerer;
		this.initCodeAvecZero = initCodeAvecZero;
		this.initalisationZero = initalisationZero;
		this.nombreMax = nombreMax;
	}


	/********************************** "String" code secret Machine ********************************************/
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	/********************************** "String" Réponse bien placé / présent Utilisateur *****************************************/

	public ArrayList<Byte> getResultatBienPlacePresentUtilisateur() {
		return resultatBienPlacePresentUtilisateur;
	}

	public void setResultatBienPlacePresentUtilisateur(ArrayList<Byte> resultatBienPlacePresentUtilisateur) {
		this.resultatBienPlacePresentUtilisateur = resultatBienPlacePresentUtilisateur;
	}


	public ArrayList<Long> getCodeSecretPlayerUtilisateur() {
		return codeSecretPlayerUtilisateur;
	}

	public void setCodeSecretPlayerUtilisateur(ArrayList<Long> codeSecretPlayerUtilisateur) {
		this.codeSecretPlayerUtilisateur = codeSecretPlayerUtilisateur;
	}

	/********************************** Résultat bien placé et présent *****************************************/
	public ArrayList<Byte> getResultatBienPlacePresent() {
		return resultatBienPlacePresent;
	}

	public void setResultatBienPlacePresent(ArrayList<Byte> resultatBienPlacePresent) {
		this.resultatBienPlacePresent = resultatBienPlacePresent;
	}

	/********************************** "Tableau" code secret Machine ********************************************/

	public ArrayList<Long> getCodeSecretOrdinateur() {
		return codeSecretOrdinateur;
	}

	public void setCodeSecretOrdinateur(ArrayList<Long> codeSecretOrdinateur) {
		this.codeSecretOrdinateur = codeSecretOrdinateur;
	}

	public ArrayList<Long> getCodeSecretUtilisateur() {
		return codeSecretUtilisateur;
	}

	public void setCodeSecretUtilisateur(ArrayList<Long> codeSecretUtilisateur) {
		this.codeSecretUtilisateur = codeSecretUtilisateur;
	}


	/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Long> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Long> codeSecretUtilisateurTab) {
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

	/***********************************************************/

	public String getInitalisationZero() {
		return initalisationZero;
	}

	public void setInitalisationZero(String initalisationZero) {
		this.initalisationZero = initalisationZero;
	}

	public String getNombreMax() {
		return nombreMax;
	}

	public void setNombreMax(String nombreMax) {
		this.nombreMax = nombreMax;
	}

	public String getNombreGenerer() {
		return nombreGenerer;
	}

	public void setNombreGenerer(String nombreGenerer) {
		this.nombreGenerer = nombreGenerer;
	}

	public String getInitCodeAvecZero() {
		return initCodeAvecZero;
	}

	public void setInitCodeAvecZero(String initCodeAvecZero) {
		this.initCodeAvecZero = initCodeAvecZero;
	}

	public ArrayList<Long> getCodeSecretPlayerUtilisateurTab() {
		return codeSecretPlayerUtilisateur;
	}

	public void setCodeSecretPlayerUtilisateurTab(ArrayList<Long> codeSecretPlayerUtilisateurTab) {
		this.codeSecretPlayerUtilisateur = codeSecretPlayerUtilisateurTab;
	}

	public ArrayList<Long> getCodeSecretPlayerOrdnateur() {
		return codeSecretPlayerOrdnateur;
	}

	public void setCodeSecretPlayerOrdnateur(ArrayList<Long> codeSecretPlayerOrdnateur) {
		this.codeSecretPlayerOrdnateur = codeSecretPlayerOrdnateur;
	}


	public String enterClavier () throws CodeInvalideException{

		String entrerClavier = "";

		int temp;

		do {

			temp = 0;

			try {

				entrerClavier = sc.nextLine();

				for (int i = 0; i < entrerClavier.length(); i++) {

					if (!Character.isDigit(entrerClavier.charAt(i))) {
						logger.error("Caractére non valide : " + entrerClavier);
						throw new CodeInvalideException("\n Attention votre saisie n'est pas un nombre !");
					}
				}

				if (entrerClavier.length() > outil.CONFIGURATION_NOMBRE) {
					logger.error("Nombre trop long ! Configuration : " + outil.CONFIGURATION_NOMBRE + " chiffres");
					throw new CodeInvalideException("\n Attention votre saisie contient trop de chiffre ! Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !");

				}

				if (entrerClavier.length() < outil.CONFIGURATION_NOMBRE) {
					logger.error("Nombre trop court ! Configuration : " + outil.CONFIGURATION_NOMBRE + " chiffres");
					throw new CodeInvalideException("\n Attention votre saisie ne contient pas assez de chiffre ! Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !");

				}

				if (!outil.verificationNombreUtilisable(entrerClavier) != true ) {
					logger.error("Valeurs interdites : " + outil.getNombreUtilisable() + " !");
					throw new CodeInvalideException("\n Attention le nombre contient des valeurs interdites suivantes.  " + outil.getNombreUtilisable()
							+ " \n Merci de saisir un nombre dont les valeur sont comprises entre " + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + " et " + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + " !");
				}

			} catch (CodeInvalideException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getLocalizedMessage());
				System.out.print(" Saisissez votre combinaison et tapez sur entrée pour valider : ");
				temp = 1;
			}

		} while (temp == 1);

		return entrerClavier;
	}

	/* Cette methode compare les deux combinaisons et renvoie les bien placés et les présents */

	public ArrayList<Byte> resultatMastermind (ArrayList<Long> codeSecretOrdinateur, ArrayList<Long> codeSecretUtilisateur) {

		ArrayList<Serializable> copieCodeSecretOrdinateur = new ArrayList<Serializable>(codeSecretOrdinateur);
		ArrayList<Serializable> copieCodeSecretUtilisateur = new ArrayList<Serializable>(codeSecretUtilisateur);
		ArrayList<Byte> resultat = new ArrayList<Byte>();

		byte compteurBienPlace = 0;
		byte compteurPresent = 0;
		byte nombreDeTour = 0;

		while ( nombreDeTour < codeSecretUtilisateur.size()) {


			for (nombreDeTour = 0; nombreDeTour < codeSecretUtilisateur.size(); nombreDeTour++) {

				if (codeSecretOrdinateur.get(nombreDeTour).equals(codeSecretUtilisateur.get(nombreDeTour))) {
					compteurBienPlace += 1;
					copieCodeSecretOrdinateur.set(nombreDeTour, '#');
					copieCodeSecretUtilisateur.set(nombreDeTour, '&');
				}
			}

			for (nombreDeTour = 0; nombreDeTour < codeSecretUtilisateur.size(); nombreDeTour++) {

				for (int i = 0; i < copieCodeSecretOrdinateur.size(); i++) {

					if (copieCodeSecretOrdinateur.get(nombreDeTour).equals(copieCodeSecretUtilisateur.get(i))) {
						copieCodeSecretOrdinateur.set(nombreDeTour, '#');
						compteurPresent += 1;
					}
				}

			}

		}

		resultat.add(compteurBienPlace);
		resultat.add(compteurPresent);

		return resultat;
	}

	/* Cette métode initialise la variable "initalisation_zero" du zéro selon la longueure de case demandé
	 * et initialise la variable "nombreMax" qui correspond au nombre le plus grand du selon la config selectionné*/
	public void initalisationNombreMinMax() {

		for (int i = 0; i < outil.CONFIGURATION_NOMBRE; i++ ) {
			initalisationZero += outil.CONFIGURATION_NOMBRE_UTILISABLE[0];
			nombreMax += "" + Integer.parseInt(outil.CONFIGURATION_NOMBRE_UTILISABLE[1]);
		}

		setInitCodeAvecZero(initalisationZero);
		setNombreGenerer(initalisationZero);
	}

	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub

	}




}
