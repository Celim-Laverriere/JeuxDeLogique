package fr.jeuxdelogique.Modejeux;

import fr.jeuxdelogique.ordinateurjeux.*;
import java.util.ArrayList;


public class ChallengerRecherchePlusMoins extends Mode {
	
	private String reponseUser;
	private String resultat = "";
	
	public ChallengerRecherchePlusMoins() {
		codeSecret(getCodeSecret());
		codeSecretOrdi(getCodeSecretOrdi());
		playerGame();
	}
	
	public ChallengerRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
		super(codeSecretOrdi, codeSecretUser, codeSecret);
	
	}
	
	public void codeSecretOrdi(ArrayList<Integer> codeSecretOrdi) {

		for (int i = 0; i < codeSecret.length(); i++ ) {
			
			System.out.print(Integer.parseInt( "" + codeSecret.charAt(i)));
			codeSecretOrdi.add(Integer.parseInt( "" + codeSecret.charAt(i)));
			
		}
			
	}
	
	public void codeSecret(String code) {
		GenererCodeSecret genererCode = new GenererCodeSecret();
		code = genererCode.genererCodeSecret();
		System.out.println("\n" + code);
		codeSecret = code;
	}

	@Override
	public void playerGame() {
		
		System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + getCodeSecret().length() + " chiffres" );
		
		
		do {
			
			reponseUser = sc.nextLine();
			
			for (int i = 0; i < reponseUser.length(); i++ ) {
				
				codeSecretUser.add(Integer.parseInt( "" + reponseUser.charAt(i)));

			}
			
		
			int i = 0;
			
			while ( i < codeSecretUser.size() && codeSecretUser.equals(getCodeSecretOrdi()) != true ) {
				
					if (codeSecretUser.get(i) < codeSecretOrdi.get(i)) {
						resultat += "+";
						i++;
					} else if (codeSecretUser.get(i) > codeSecretOrdi.get(i)) {
						resultat += "-";
						i++;
					} else {
						resultat += "=";
						i++;
					}
				}
				
				if (i == codeSecretUser.size()) {
					System.out.println(resultat);
					codeSecretUser.removeAll(codeSecretUser);
				}
				
			
				if (codeSecretUser.equals(codeSecretOrdi)) {
					System.out.println("Bravo ! Vous avez trouvé la bonne combinaison : " + reponseUser);
					
			}
							
		} while (codeSecretUser.equals(getCodeSecretOrdi()) != true);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
