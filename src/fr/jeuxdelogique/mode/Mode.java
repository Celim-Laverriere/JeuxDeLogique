package fr.jeuxdelogique.mode;

import java.util.Scanner;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.outils.Outils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Mode {

	static final Logger logger = LogManager.getLogger();
	Outils outil = new Outils();
	Scanner sc = new Scanner (System.in);
	
	private int compteurEssai = 1;
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
		setModeDev(modeDev);
	}

	/********************** Métode pour le mode développeur ****************************/
	public static void modeDev(String modeDeveloppeur) {
		modeDev = modeDeveloppeur;
	}

	/*********************** Métode ou est inseret le code du jeu 
	 * @throws CodeInvalideException ******************************/
	public abstract void playerGame() throws CodeInvalideException;


	
		
	


	
	
	
}



