package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

public class ChallengerRecherchePlusMoins extends Mode {

	public ChallengerRecherchePlusMoins(ArrayList<Integer> codeSecretOrdi, ArrayList<Integer> codeSecretUser,String codeSecret) {
		super(codeSecretOrdi, codeSecretUser, codeSecret);
		this.setCodeSecret(codeSecret);
	}
	
	public void setCodeSecret(String codeSecret) {
		
		this.setCodeSecret (codeSecret);
	}

	@Override
	public void PayerGame() {
		// TODO Auto-generated method stub
		
	}


}
