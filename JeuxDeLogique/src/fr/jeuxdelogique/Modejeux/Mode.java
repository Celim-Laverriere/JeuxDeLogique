package fr.jeuxdelogique.Modejeux;

import java.util.Scanner;

public abstract class Mode {

	Scanner sc = new Scanner (System.in);
	
	private static String modeDev;
	
	/*********************** M�tode pour le mode d�veloppeur ******************************/
	public static void modeDev(String modeDeveloppeur) {
		setModeDev(modeDeveloppeur);
	}

	/*********************** M�tode ou est inseret le code du jeu ******************************/
	public abstract void playerGame();
	
	public static String getModeDev() {
		return modeDev;
	}

	public static void setModeDev(String modeDev) {
		Mode.modeDev = modeDev;
	}

	
		
	


	
	
	
}



