package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;


public class ModeRecherche extends Mode {

	private String codeSecret = "";
	private ArrayList<Long> codeSecretMachineTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerUtilisateurTab = new ArrayList<Long>();
	private ArrayList<Long> codeSecretPlayerAITab = new ArrayList<Long>();
	private String reponseUtilisateur = "";
	private String resultat = "";
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

	/**
	 *
	 * @param tab
	 * @param code
	 * @return
	 */
	public ArrayList<Long> tableau (ArrayList<Long> tab, String code) {
		tab = outil.codeSecretAjoutTab(code);
		return tab;
	}

	/**
	 *
	 * @param
	 */
	public void reponse () throws CodeInvalideException {

		int temp;

		do {

			temp = 0;

			try {

				reponseUtilisateur = sc.nextLine();

				if (reponseUtilisateur.length() != outil.CONFIGURATION_NOMBRE) {
					throw new CodeInvalideException("Votre saissi est incorrecte, entrez de nouveau votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");

				}

				for (int i = 0; i < reponseUtilisateur.length(); i++) {

					if (!Character.isDigit(reponseUtilisateur.charAt(i))) {
						throw new CodeInvalideException("\nAttention votre saisie n'est pas un nombre ! \nMerci de renterez un nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres");
					}
				}

			} catch (CodeInvalideException e) {
				System.out.println(e.getLocalizedMessage());
				temp = 1;
			}

		} while (temp == 1);

	}

	/**
	 * @throws CodeInvalideException
	 *
	 */
	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub

	}

}
