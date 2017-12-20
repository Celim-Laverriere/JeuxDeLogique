package fr.jeuxdelogique.ordinateurjeux;

import java.util.ArrayList;

public class CodeSecret implements BoiteAOutils{

	public CodeSecret () {
		
	}
	
	public String codeSecret(String code) {
		GenererCodeSecret genererCode = new GenererCodeSecret();
		code = genererCode.genererCodeSecret();
		System.out.println("\n" + code);
		return code;
	}
}
