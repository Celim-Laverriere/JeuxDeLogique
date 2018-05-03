package fr.jeuxdelogique.Modejeux;

import java.util.Scanner;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.outils.Outils;

public abstract class Mode {

	
	Outils outil = new Outils();
	Scanner sc = new Scanner (System.in);
	
	private int compteurEssai;
	private static String modeDev;
	
	public Mode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompteurEssai() {
		return compteurEssai;
	}

	public void setCompteurEssai(int compteurEssai) {
		this.compteurEssai += compteurEssai;
	}
	
	public static String getModeDev() {
		return modeDev;
	}

	public static void setModeDev(String modeDev) {
		Mode.modeDev = modeDev;
	}

	/*********************** Métode pour le mode développeur ******************************/
	public static void modeDev(String modeDeveloppeur) {
		setModeDev(modeDeveloppeur);
	}

	/*********************** Métode ou est inseret le code du jeu 
	 * @throws CodeInvalideException ******************************/
	public abstract void playerGame() throws CodeInvalideException;


	
		
	


	
	
	
}



