package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.ordinateurjeux.OutilsCodeSecret;

public class DefenseurRecherchePlusMoins extends Mode {

	private String codeSecret;
	private ArrayList<Integer> codeSecretMachineTab = new ArrayList<Integer>();
	private ArrayList<Integer> codeSecretUtilisateurTab = new ArrayList<Integer>();
	private String reponseUtilisateur = "";
	private int recupeNombreTab;
	private String resultat = "";
	
	public DefenseurRecherchePlusMoins() {
		playerGame();
	}
	
	public DefenseurRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
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
	}
	
/********************************** "Tableau" code secret Utilisateur *****************************************/
	public ArrayList<Integer> getCodeSecretUtilisateurTab() {
		return codeSecretUtilisateurTab;
	}

	public void setCodeSecretUtilisateurTab(ArrayList<Integer> codeSecretUtilisateurTab) {
		OutilsCodeSecret codeUtilisateur = new OutilsCodeSecret();
		codeSecretUtilisateurTab = codeUtilisateur.codeSecretAjoutTab(getCodeSecretUtilisateurTab(), reponseUtilisateur);
		this.codeSecretUtilisateurTab = codeSecretUtilisateurTab;
	}

/********************************** "String" Réponse Utilisateur *****************************************/
	public String getReponseUtilisateur() {
		return reponseUtilisateur;
	}

	public void setReponseUtilisateur(String reponseUtilisateur) {
		this.reponseUtilisateur = reponseUtilisateur;
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
//	public String getResultat() {
//		return resultat;
//	}
//
//	public void setResultat(String resultat) {
//		this.resultat = resultat;
//	}

/********************************************** Ci-dessous la méthode qui lance le jeu **********************************************************/
	
	@Override
	public void playerGame() {

		do {
			int compteur = 0;
			System.out.println("Entrez votre code secret que l'ordinateur devra trouver :");
			
			setReponseUtilisateur(sc.nextLine());
			setCodeSecretUtilisateurTab(getCodeSecretUtilisateurTab());
			setCodeSecret(getCodeSecret());
			setCodeSecretMachineTab(getCodeSecretMachineTab());
			
			
			do {
				
				int i = 0;
				
				while (i < getCodeSecretUtilisateurTab().size() && !getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab())) {
					
					if (getCodeSecretMachineTab().get(i) < getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), +1); 
						i++;
						
					} else if(getCodeSecretMachineTab().get(i) > getCodeSecretUtilisateurTab().get(i)) {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), -1);
						i++;
					} else {
						setRecupeNombreTab(getCodeSecretMachineTab().get(i), 0);
						i++;
					}
				}
				
				if (i == getCodeSecretUtilisateurTab().size()) {
					compteur++;
					System.out.println("\n\nProposition : " + getCodeSecret() +" Réponse n° : " + compteur);
					
					getCodeSecretMachineTab().removeAll(getCodeSecretMachineTab());
					
					setCodeSecretMachineTab(getCodeSecretMachineTab());
				}
				
			} while(!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
			
			if (getCodeSecretMachineTab().equals(getCodeSecretUtilisateurTab())) {
				System.out.println("\nVotre ordinateur à trouvé en " + compteur  + " coups votre combinaison : " + getCodeSecret()  );
			}
			
		} while (!getCodeSecretUtilisateurTab().equals(getCodeSecretMachineTab()));
		
	}

}
