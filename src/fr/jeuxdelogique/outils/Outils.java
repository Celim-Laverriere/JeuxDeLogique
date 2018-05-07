package fr.jeuxdelogique.outils;

import java.util.ArrayList;


public class Outils {

	private Config configuration = new Config();

	public final int CONFIGURATION_NOMBRE = configuration.configNombre();
	public final int CONFIGURATION_ESSAIS = configuration.configEssais();
	public final String [] CONFIGURATION_NOMBRE_UTILISABLE = configuration.nombreUtilisable().substring(1, 4).split(";");
	private ArrayList<String> nombreUtilisable = new ArrayList<String>();

	public Outils() {
		// TODO Auto-generated constructor stub

	}

	public ArrayList<String> getNombreUtilisable() {
		return nombreUtilisable;
	}

	public void setNombreUtilisable(ArrayList<String> nombreUtilisable) {
		this.nombreUtilisable = nombreUtilisable;
	}

	/********** Repartition du code secret (String) dans un tableau (ArrayList) *********/

	public String codeSecret(String code, String jeu) {
		code = genererCodeSecret(jeu);
		return code;
	}

	/********** Ci-dessous les méthodes pour générer un code secret **********/

	public String genererCodeSecret(String jeu) {

		String nbreStr = "";

		if (jeu.equals("RecherchePlusMoins")) {

			for (int i = 0; i < CONFIGURATION_NOMBRE; i++) {

				nbreStr += "" + nombre(0,9);
			}
		}

		if (jeu.equals("Mastermind")) {

			for (int i = 0; i < CONFIGURATION_NOMBRE; i++) {

				nbreStr += "" + nombre(Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[0]), Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[1]));
			}
		}

		return nbreStr;
	}	

	public int nombre (int borneInf, int borneSup) {

		int nb = borneInf + (int)(Math.random() * ((borneSup - borneInf) + 1));
		return nb;
	}

	/********** Ci-dessous les méthodes pour générer un tableau **********/
	public  ArrayList<Long> codeSecretAjoutTab (String codeSecret) {

		ArrayList<Long> codeSecretAjoutTab = new ArrayList<Long>();

		for (int i = 0; i < CONFIGURATION_NOMBRE; i++ ) {
			codeSecretAjoutTab.add(((Long.parseLong( "" + codeSecret.charAt(i)))));
		}
		return codeSecretAjoutTab;	
	}

	/********************* Ci-dessous la methode génére un tableau des nombre "NON" utilisables pour le mastermind ***************/	
	public ArrayList<String> init_tableau_nombre_utilisable () {

		//ArrayList<String> nombreUtilisable = new ArrayList<String>();

		int nbreMin = Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[0]);
		int nbreMax = Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[1]);

		for (int i = 0 ; i < 10; i++) {

			if (i > nbreMin && nbreMax < i && i < 10 ) {

				nombreUtilisable.add("" + i);
			}		
		}

		return nombreUtilisable;
	}

	/* Les deux méthodes, ci-dessous vérifient les nombres générés par l'ordinateur ou l'utilisateur et renvoient un booléen pour indiquer 
	de ne pas prendre un nombre qui n'est pas admis dans la fourchette donné par la config */

	public boolean verificationNombreUtilisable (String nombre_a_verifier) {

		boolean resultat = false;

		for (int i = 0; i < nombreUtilisable.size() && resultat == false; i++) {

			resultat = nombre_a_verifier.contains(nombreUtilisable.get(i));		
		}

		return resultat;
	}

	/**** Creer une chaine de caractère, prend un tabelau en parametre ************/
	public String chaineDeCaract (ArrayList<Long> tableau) {

		String str = "";

		for (int i = 0; i < tableau.size(); i++) {

			str += String.valueOf(tableau.get(i));
		}

		return str;	
	}

	/**** Methode exception ****/
	public void TestCodeIvalide(String code) throws CodeInvalideException {


		if (code.length() != CONFIGURATION_NOMBRE) {
			throw new CodeInvalideException("Votre saissi est incorrecte, entrez de nouveau votre nombre à " + CONFIGURATION_NOMBRE + " chiffres");
		}

		if (!verificationNombreUtilisable(code) != true ) {
			throw new CodeInvalideException("Attention le nombre contient des valeurs interdites suivantes.  " + getNombreUtilisable() 
			+ " \n \"Merci de saisir un nombre compris entre \" + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + \" et \" + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + \" !");
		}

		for (int i = 0; i < code.length(); i++) {

			if (!Character.isDigit(code.charAt(i))) {
				System.out.println("Attention votre saisie n'est pas un nombre : \n Merci de renterez un nombre à " + CONFIGURATION_NOMBRE + " chiffres");
			}
		}

	}

	public void codeDigit (int nbre) throws CodeInvalideException{

		for (int i = 0; i < nbre; i++) {

			if (!Character.isDigit(nbre)) {
				System.out.println("Attention votre saisie n'est pas une  nombre : \n Merci de renterez un nombre à " + nbre + " chiffres");
			}
		}
	}


}
