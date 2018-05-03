package fr.jeuxdelogique.Modejeux;

import java.io.Serializable;
import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;


public class ModeMastermind extends Mode {

	private String codeSecret;
	private String reponseUtilisateur = "";
	private int recupeNombreTab;
	private ArrayList<Long> codeSecretOrdinateur = new ArrayList<Long>();
	private ArrayList<Byte> resultat_BienPlace_Present = new ArrayList<Byte>(); 
	private ArrayList<Long> codeSecretUtilisateur = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateur = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerOrdnateur = new ArrayList<Long>();
//	private ArrayList<String> nombreUtilisable = new ArrayList<String>();
	private String nombreGenerer = "";
	private String initCodeAvecZero = "";
	private String initalisation_zero = "";	
	private String nombreMax = "";

	
	public ModeMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Long> codeSecretOrdinateur, ArrayList<Byte> resultat_BienPlace_Present,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String nombreGenerer, String initCodeAvecZero,
			String initalisation_zero, String nombreMax) {
		super();
		this.codeSecret = codeSecret;
		this.reponseUtilisateur = reponseUtilisateur;
		this.recupeNombreTab = recupeNombreTab;
		this.codeSecretOrdinateur = codeSecretOrdinateur;
		this.resultat_BienPlace_Present = resultat_BienPlace_Present;
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
		this.codeSecretPlayerUtilisateur = codeSecretPlayerUtilisateurTab;
		this.setCodeSecretPlayerOrdnateur(codeSecretPlayerAITab);
		this.nombreGenerer = nombreGenerer;
		this.initCodeAvecZero = initCodeAvecZero;
		this.initalisation_zero = initalisation_zero;
		this.nombreMax = nombreMax;
	}

/********************************** "String" code secret Machine ********************************************/
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}
	
/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}
	
	/********************************** Résultat bien placé et présent *****************************************/
	public ArrayList<Byte> getResultat_BienPlace_Present() {
		return resultat_BienPlace_Present;
	}

	public void setResultat_BienPlace_Present(ArrayList<Byte> resultat_BienPlace_Present) {
		this.resultat_BienPlace_Present = resultat_BienPlace_Present;
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

	public String getInitalisation_zero() {
		return initalisation_zero;
	}

	public void setInitalisation_zero(String initalisation_zero) {
		this.initalisation_zero = initalisation_zero;
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

/**
 * @return 
 * @throws CodeInvalideException ******************************************************************************/
	
	
	public String enterClavier () throws CodeInvalideException{
		
		String enterClavier = "";
		
		int temp;
		 
		do {
			
			temp = 0;
			
			try {
	
				enterClavier = sc.nextLine();
				
				if (enterClavier.length() != outil.CONFIGURATION_NOMBRE) {
					throw new CodeInvalideException("Votre saissi est incorrecte, entrez de nouveau votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");
				}
				
				if (!outil.verificationNombreUtilisable(enterClavier) != true ) {
					throw new CodeInvalideException("\nAttention le nombre contient des valeurs interdites suivantes.  " + outil.getNombreUtilisable() 
					+ " \n \"Merci de saisir un nombre compris entre \" + outil.CONFIGURATION_NOMBRE_UTILISABLE[0] + \" et \" + outil.CONFIGURATION_NOMBRE_UTILISABLE[1] + \" !");
				}
				
				for (int i = 0; i < enterClavier.length(); i++) {
					
					if (!Character.isDigit(enterClavier.charAt(i))) {
						throw new CodeInvalideException("\nAttention votre saisie n'est pas un nombre ! \nMerci de renterez un nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");
					}
				}
	
			} catch (CodeInvalideException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getLocalizedMessage());
				
				temp = 1;
			}
			
		} while (temp == 1);
		
		return enterClavier;
	}
	
	/* Cette methode compare les deux nombres secret et renvois les bien plcés et les présents */
	
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
	
//	/* Les deux méthodes, ci-dessous vérifient les nombres générés par l'ordinateur ou l'utilisateur et renvoient un booléen pour indiquer 
//	de ne pas prendre un nombre qui n'est pas admis dans la fourchette donné par la config */
//	
//	public boolean verificationNombreUtilisable (String nombre_a_verifier) {
//		
//		boolean resultat = false;
//	
//		for (int i = 0; i < nombreUtilisable.size() && resultat == false; i++) {
//			
//			resultat = nombre_a_verifier.contains(nombreUtilisable.get(i));		
//		}
//		
//		return resultat;
//	}
	
	/* Cette métode initialise la variable "initalisation_zero" du zéro selon la longueure de case demandé 
	 * et initialise la variable "nombreMax" qui correspond au nombre le plus grand du selon la config selectionné*/
	public void initalisationNombreMinMax() {
		
		for (int i = 0; i < outil.CONFIGURATION_NOMBRE; i++ ) {
			initalisation_zero += "0";
			nombreMax += "" + Integer.parseInt(outil.CONFIGURATION_NOMBRE_UTILISABLE[1]);
		}
		
		setInitCodeAvecZero(initalisation_zero);
		setNombreGenerer(initalisation_zero);
	}
	
	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub

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
	

}
