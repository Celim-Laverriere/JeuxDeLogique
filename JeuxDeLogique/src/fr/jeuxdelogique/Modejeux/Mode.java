package fr.jeuxdelogique.Modejeux;

import fr.jeuxdelogique.ordinateurjeux.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mode {

	Scanner sc = new Scanner (System.in);
	
	public Mode() {
		
	}
	
	public Mode(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser, String codeSecret) {
			
	}
	
	
	/*********************** Métode ou est inseret le code du jeu ******************************/
	public abstract void playerGame();

	
	
}



