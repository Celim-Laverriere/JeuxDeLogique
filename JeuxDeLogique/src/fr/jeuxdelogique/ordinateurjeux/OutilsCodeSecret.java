package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;
import java.util.Random;

public class OutilsCodeSecret {

	int configNombre = 4;

	public OutilsCodeSecret() {
		// TODO Auto-generated constructor stub
	}
	
	public int getConfigNombre() {
		return configNombre;
	}

	public void setConfigNombre(int configNombre) {
		this.configNombre = configNombre;
	}
	
/********** Ci-dessous les méthodes pour générer un code secret **********/
	
	public String genererCodeSecret() {
			
			String nbreStr = "";
			
			for (int i = 0; i < configNombre; i++) {
				String nbre = "" + nombre(1, 10);
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
		System.out.println("\n" + code);
		return code;
	}
	
	public  ArrayList<Integer> codeSecretAjoutTab (ArrayList<Integer> codeSecretAjoutTab, String codeSecret) {

		for (int i = 0; i < codeSecret.length(); i++ ) {
			System.out.print(Integer.parseInt( "" + codeSecret.charAt(i)));
			codeSecretAjoutTab.add(((Integer.parseInt( "" + codeSecret.charAt(i)))));
		}
		return codeSecretAjoutTab;	
	}

	
}
