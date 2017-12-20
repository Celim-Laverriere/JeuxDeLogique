package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;

public class ReponseUtilisateur implements BoiteAOutils {

	public ReponseUtilisateur () {
		
	}
	
	public ArrayList<Integer> reponseUser (ArrayList<Integer> codeSecretUser, String reponse) {
		
		for (int i = 0; i < reponse.length(); i++ ) {
			codeSecretUser.add((Integer.parseInt( "" + reponse.charAt(i))));
		}
		return codeSecretUser;
	}
	
}
