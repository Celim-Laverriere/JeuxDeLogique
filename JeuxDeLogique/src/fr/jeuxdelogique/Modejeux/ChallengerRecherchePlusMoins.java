package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;


public class ChallengerRecherchePlusMoins extends Mode {
	
	public ChallengerRecherchePlusMoins() {
		setCodeSecret(getCodeSecret());
		setCodeSecretOrdi(getCodeSecretOrdi());
		playerGame();
	}
	
	public ChallengerRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
		super(codeSecretOrdi, codeSecretUser, codeSecret);
	
	}
	

	@Override
	public void playerGame() {
		
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecret().length() + " chiffres" );
		
		
		do {
			
			setReponseUser(sc.nextLine());
			setCodeSecretUser(getCodeSecretUser());
			
			int i = 0;
			
			while ( i < getCodeSecretUser().size() && !getCodeSecretUser().equals(getCodeSecretOrdi())) {
				
					if (getCodeSecretUser().get(i) < getCodeSecretOrdi().get(i)) {
						setResultat(getResultat() + "+");
						i++;
					} else if (getCodeSecretUser().get(i) > getCodeSecretOrdi().get(i)) {
						setResultat(getResultat() + "-");
						i++;
					} else {
						setResultat(getResultat() + "=");
						i++;
					}
				}
				
				if (i == getCodeSecretUser().size()) {
					System.out.println(getResultat());
					getCodeSecretUser().removeAll(getCodeSecretUser());
				}
				
			
				if (getCodeSecretUser().equals(getCodeSecretOrdi())) {
					System.out.println("Bravo ! Vous avez trouvé la bonne combinaison : " + getReponseUser());
					
			}
							
		} while (!getCodeSecretUser().equals(getCodeSecretOrdi()));
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
