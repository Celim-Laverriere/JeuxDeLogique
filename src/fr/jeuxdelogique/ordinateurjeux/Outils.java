package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;
import java.util.Random;

public class Outils {

	private Config configuration = new Config();
	
	public final int CONFIGURATION_NOMBRE = configuration.configNombre();
	public final int CONFIGURATION_ESSAIS = configuration.configEssais();
	public final String [] CONFIGURATION_NOMBRE_UTILISABLE = configuration.nombreUtilisable().split(";");
	
	public Outils() {
		// TODO Auto-generated constructor stub
		
	}

/********** Repartition du code secret (String) dans un tableau (ArrayList) *********/
	
	public String codeSecret(String code, String jeu) {
		code = genererCodeSecret(jeu);
		return code;
	}
	
/********** Ci-dessous les méthodes pour générer un code secret **********/
	
	public String genererCodeSecret(String jeu) {

		String nbreStr = "";
		
		if (jeu.equals("recherche")) {
			
			for (int i = 0; i < CONFIGURATION_NOMBRE; i++) {
				
				nbreStr += "" + nombre(0,9);
			}
		}
		
		if (jeu.equals("Mastermind")) {

			for (int i = 0; i < CONFIGURATION_NOMBRE; i++) {
				
				nbreStr += "" + nombre(Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[0]), Integer.parseInt(CONFIGURATION_NOMBRE_UTILISABLE[1]));
			}
		}
		
		return nbreStr;
	}	
	
	public static int nombre (int borneInf, int borneSup) {
			
			//Random random = new Random();
			//int nb = borneInf+random.nextInt(borneSup-borneInf);
			int nb = borneInf + (int)(Math.random() * ((borneSup - borneInf) + 1));
			return nb;
		}
	
/********** Ci-dessous les méthodes pour générer un tableau **********/
	public  ArrayList<Long> codeSecretAjoutTab (ArrayList<Long> codeSecretAjoutTab, String codeSecret) {

		for (int i = 0; i < CONFIGURATION_NOMBRE; i++ ) {
			codeSecretAjoutTab.add(((Long.parseLong( "" + codeSecret.charAt(i)))));
		}
		return codeSecretAjoutTab;	
	}
	
}
