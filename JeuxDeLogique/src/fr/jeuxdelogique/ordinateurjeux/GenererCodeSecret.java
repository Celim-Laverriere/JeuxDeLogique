package fr.jeuxdelogique.ordinateurjeux;

import java.util.Random;

public class GenererCodeSecret {

	int configNombre = 4;
	
	public GenererCodeSecret() {
		
	}
	
	public String genererCodeSecret() {
		
		String nbreStr = "";
		
		for (int i = 0; i < configNombre; i++) {
			String nbre = "" + generer(1, 10);
			nbreStr += nbre;
		}
		
		return nbreStr;
	}

	public static int generer (int borneInf, int borneSup) {
		
		Random random = new Random();
		int nb;
		nb = borneInf+random.nextInt(borneSup-borneInf);
		return nb;
	}
}