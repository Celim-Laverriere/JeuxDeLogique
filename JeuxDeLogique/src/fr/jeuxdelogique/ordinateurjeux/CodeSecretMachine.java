package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;

public class CodeSecretMachine implements BoiteAOutils {

	public CodeSecretMachine () {
		
	}
	
	public  ArrayList<Integer> codeSecretOrdi (ArrayList<Integer> codeSecretOrdi, String codeSecret) {

		for (int i = 0; i < codeSecret.length(); i++ ) {
			System.out.print(Integer.parseInt( "" + codeSecret.charAt(i)));
			codeSecretOrdi.add(((Integer.parseInt( "" + codeSecret.charAt(i)))));
		}
		return codeSecretOrdi;	
	}

	
	
}
