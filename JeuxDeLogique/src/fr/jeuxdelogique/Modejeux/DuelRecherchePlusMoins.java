package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.ordinateurjeux.OutilsCodeSecret;

public class DuelRecherchePlusMoins extends Mode {

	private String codeSecret;
	private ArrayList<Integer> codeSecretMachineTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerUtilisateurTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretPlayerAITab = new ArrayList<Integer>();
	private String reponseUtilisateur = "";
	private String resultat = "";
	private int recupeNombreTab;
	
	public DuelRecherchePlusMoins() {
		initialisationJeu();
		playerGame();
	}
	
	public DuelRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
		super(codeSecretOrdi, codeSecretUser, codeSecret);
		// TODO Auto-generated constructor stub
	}

	/********************************** "String" code secret Machine ********************************************/
	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		OutilsCodeSecret code = new OutilsCodeSecret();
		codeSecret = code.codeSecret(codeSecret);
		this.codeSecret = codeSecret;
	}

/********************************** "Tableau" code secret Machine ********************************************/
	public ArrayList<Integer> getCodeSecretMachineTab() {
		return codeSecretMachineTab;
	}

	public void setCodeSecretMachineTab(ArrayList<Integer> codeSecretMachineTab) {
		OutilsCodeSecret codeMachine = new OutilsCodeSecret();
		codeSecretMachineTab = codeMachine.codeSecretAjoutTab(getCodeSecretMachineTab(), codeSecret);
		this.codeSecretMachineTab = codeSecretMachineTab;
		codeSecret = "";
	}
	
/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Integer> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Integer> codeSecretUtilisateurTab) {
		OutilsCodeSecret codeUtilisateur = new OutilsCodeSecret();
		codeSecretUtilisateurTab = codeUtilisateur.codeSecretAjoutTab(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
		reponseUtilisateur = "";
	}

/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
	}
	
/********************************** *****************************************/
	public ArrayList<Integer> getCodeSecretPlayerUtilisateurTab() {
		return codeSecretPlayerUtilisateurTab;
	}

	public void setCodeSecretPlayerUtilisateurTab(ArrayList<Integer> codeSecretPlayerUtilisateurTab) {
		OutilsCodeSecret codeUtilisateur = new OutilsCodeSecret();
		codeSecretPlayerUtilisateurTab = codeUtilisateur.codeSecretAjoutTab(getCodeSecretPlayerUtilisateurTab(), reponseUtilisateur);
		this.codeSecretPlayerUtilisateurTab = codeSecretPlayerUtilisateurTab;
		reponseUtilisateur = "";
	}
	
/**********************************  *****************************************/
	public ArrayList<Integer> getCodeSecretPlayerAITab() {
		return codeSecretPlayerAITab;
	}

	public void setCodeSecretPlayerAITab(ArrayList<Integer> codeSecretPlayerAITab) {
		OutilsCodeSecret codeMachine = new OutilsCodeSecret();
		codeSecretPlayerAITab = codeMachine.codeSecretAjoutTab(getCodeSecretPlayerAITab(), codeSecret);
		this.codeSecretPlayerAITab = codeSecretPlayerAITab;
	}
	
/********************************** La méthode récupere le nombre du tableau pour le modifier *****************************************/
	public int getRecupeNombreTab() {
		return recupeNombreTab;
	}

	public void setRecupeNombreTab(int recupeNombreTab, int nbre) {
	
		if (codeSecret.length() == 4) {
			codeSecret = "";
		}
		
		codeSecret += "" + (recupeNombreTab + (nbre));
		this.recupeNombreTab = recupeNombreTab;
	}

/********************************** get et set non utilisés *****************************************/
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

/********************************** Initialisation du jeu*****************************************/	
	public void initialisationJeu () {
		
		/*********** Code générer par l'ordinateur ***********/
		setCodeSecret(getCodeSecret());
		setCodeSecretMachineTab(getCodeSecretMachineTab());	
		
		/*********** Code générer par l'utilisateur ***********/
		System.out.println("\nEntrez votre code secret que l'ordinateur devra trouver :");
		
		setReponseUtilisateur(sc.nextLine());
		setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
		setCodeSecret(getCodeSecret());
		setCodeSecretPlayerAITab(getCodeSecretPlayerAITab());
	}
/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/

	@Override
	public void playerGame() {
		
		int compteur = 0;
		
	
	do {
		
		int i = 0;
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecretMachineTab().size()+ " chiffres" );
			
			setReponseUtilisateur(sc.nextLine());
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
					System.out.println("\n\nProposition : "+ getCodeSecretPlayerUtilisateurTab().toString() +" Réponse : " + getResultat());
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
						System.out.println("\n\nProposition : " + getCodeSecret() +" Réponse n° : " + compteur);
						getCodeSecretPlayerAITab().removeAll(getCodeSecretPlayerAITab());
						setCodeSecretPlayerAITab(getCodeSecretPlayerAITab());
					}
		
					if (getCodeSecretPlayerAITab().equals(getCodeSecretUtilisateurTab())) {
						System.out.println("\nVotre ordinateur à trouvé en " + compteur  + " coups votre combinaison : " + getCodeSecret());
						break;
					}
					
					if (getCodeSecretPlayerUtilisateurTab().equals(getCodeSecretMachineTab())) {
						System.out.println("\nBravo ! Vous avez trouvé la bonne combinaison : " + getCodeSecretPlayerUtilisateurTab());
						break;
					}
						
					i++;
						
		} while (i <= getCodeSecretUtilisateurTab().size() || i <= getCodeSecretPlayerUtilisateurTab().size());		
						
	} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretPlayerAITab()) && !getCodeSecretMachineTab().equals(getCodeSecretPlayerUtilisateurTab()));
		
			
	}

}


