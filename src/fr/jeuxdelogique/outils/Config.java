package fr.jeuxdelogique.outils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config  { 

	Properties p = new Properties(); 
	
	public Config ()  { 
		
		try {
			
			InputStream is = new FileInputStream("./ressources/config.properties");
			p.load(is);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	public int configNombre () {
		return Integer.parseInt(p.getProperty("nombre_de_case"));
	}

	public int configEssais() {	
		 return Integer.parseInt(p.getProperty("nombre_essais"));	
	}
	
	public String nombreUtilisable() {
		return p.getProperty("chiffre_utilisabble");
	}

	public String modeDevelloppeur () {
		return  p.getProperty("mode_developpeur");
	}
	
}
