package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;
import java.util.Random;

public class Outils {

	Config configuration = new Config();
	
	public final int CONFIGURATION_NOMBRE = configuration.configNombre(0);
	public final int CONFIGURATION_ESSAIS = configuration.configEssais(0);

	public Outils() {
		// TODO Auto-generated constructor stub
		
	}
	

	
/********** Ci-dessous les m�thodes pour g�n�rer un code secret **********/
	
	public String genererCodeSecret() {
			
			String nbreStr = "";
			
			for (int i = 0; i < CONFIGURATION_NOMBRE; i++) {
				String nbre = "" + nombre(0, 9);
				nbreStr += nbre;
			}
			
			return nbreStr;
		}
	
	public static int nombre (int borneInf, int borneSup) {
			
			Random random = new Random();
			int nb;
			nb = borneInf+random.nextInt(borneSup-borneInf);
			return nb;
		}
	
/********** Repartition du code secret (String) dans un tableau (ArrayList) *********/
	
	public String codeSecret(String code) {
		code = genererCodeSecret();
		return code;
	}
	
	public  ArrayList<Integer> codeSecretAjoutTab (ArrayList<Integer> codeSecretAjoutTab, String codeSecret) {

		for (int i = 0; i < CONFIGURATION_NOMBRE; i++ ) {
			codeSecretAjoutTab.add(((Integer.parseInt( "" + codeSecret.charAt(i)))));
		}
		return codeSecretAjoutTab;	
	}
	
}