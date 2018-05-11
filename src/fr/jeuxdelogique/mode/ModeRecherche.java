package fr.jeuxdelogique.mode;

import java.util.ArrayList;

import fr.jeuxdelogique.invalideException.CodeInvalideException;


public class ModeRecherche extends Mode {

	private String codeSecret = "";
	private ArrayList<Long> codeSecretMachineTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerAITab = new ArrayList<Long>();
	private String reponseUtilisateur = "";
	private String resultat = "";
	private String resultatOrdinateur = "";
	private long recupeNombreTab;

	public ModeRecherche () {

	}

	public ModeRecherche(String codeSecret, ArrayList<Long> codeSecretMachineTab,ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
						 ArrayList<Long> codeSecretPlayerAITab, String reponseUtilisateur, String resultat, int recupeNombreTab) {

		super();
		this.codeSecret = codeSecret;
		this.codeSecretMachineTab = codeSecretMachineTab;
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
		this.reponseUtilisateur = reponseUtilisateur;
		this.resultat = resultat;
		this.recupeNombreTab = recupeNombreTab;
	}

	/********************************** "String" code secret Machine ********************************************/
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		codeSecret = "";
		codeSecret = outil.codeSecret(codeSecret, codeSecret);
		this.codeSecret = codeSecret;
	}

	/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Long> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Long> codeSecretMachineTab) {
		this.codeSecretMachineTab = codeSecretMachineTab;
	}

	/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}

	/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Long> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Long> codeSecretUtilisateurTab) {
		codeSecretUtilisateurTab = tableau(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

	/********************************** *****************************************/
	public ArrayList<Long> getCodeSecretPlayerUtilisateurTab() {
		return codeSecretPlayerUtilisateurTab;
	}

	public void setCodeSecretPlayerUtilisateurTab(ArrayList<Long> codeSecretPlayerUtilisateurTab) {
		codeSecretPlayerUtilisateurTab = tableau(getCodeSecretPlayerUtilisateurTab(), reponseUtilisateur);
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
	}

	/**********************************  *****************************************/
	public ArrayList<Long> getCodeSecretPlayerAITab() {
		return codeSecretPlayerAITab;
	}

	public void setCodeSecretPlayerAITab(ArrayList<Long> codeSecretPlayerAITab) {
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
	}

	/********************************** La méthode récupere le nombre du tableau pour le modifier *****************************************/
	public long getRecupeNombreTab() {
		return recupeNombreTab;
	}

	public void setRecupeNombreTab(Long recupeNombreTab, int nbre) {

		codeSecret += "" + (recupeNombreTab + (nbre));

		this.recupeNombreTab = recupeNombreTab;
	}

	/********************************** get et set résiltat *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	/********************************** get et set résiltat ordinateur *****************************************/
	public String getResultatOrdinateur() {
		return resultatOrdinateur;
	}

	public void setResultatOrdinateur(String resultatOrdinateur) {
		this.resultatOrdinateur = resultatOrdinateur;
	}

	public ArrayList<Long> tableau (ArrayList<Long> tab, String code) {
		tab = outil.codeSecretAjoutTab(code);
		return tab;
	}

	public void reponse () throws CodeInvalideException {

		int temp;

		do {

			temp = 0;

			try {

				reponseUtilisateur = sc.nextLine();

				for (int i = 0; i < reponseUtilisateur.length(); i++) {

					if (!Character.isDigit(reponseUtilisateur.charAt(i))) {
						logger.error("Caractére non valide : " + reponseUtilisateur);
						throw new CodeInvalideException("\n Attention votre saisie n'est pas un nombre ! ");
					}
				}

				if (reponseUtilisateur.length() > outil.CONFIGURATION_NOMBRE) {
					logger.error("Nombre trop long ! Configuration : " + outil.CONFIGURATION_NOMBRE + " chiffres");
					throw new CodeInvalideException("\n Attention votre saisie contient trop de chiffre ! Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !");
				}

				if (reponseUtilisateur.length() < outil.CONFIGURATION_NOMBRE) {
					logger.error("Nombre trop court ! Configuration : " + outil.CONFIGURATION_NOMBRE + " chiffres");
					throw new CodeInvalideException("\n Attention votre saisie ne contient pas assez de chiffre ! Vous devez saisir une combinaison de " + outil.CONFIGURATION_NOMBRE + " chiffres !");
				}

			} catch (CodeInvalideException e) {
				System.out.println(e.getLocalizedMessage());
				System.out.print(" Saisissez votre combinaison et tapez sur entrée pour valider : ");
				temp = 1;
			}

		} while (temp == 1);

	}

	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub
	}
}
