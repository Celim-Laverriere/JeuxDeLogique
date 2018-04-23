package fr.jeuxdelogique.ordinateurjeux;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config  { 

	Properties p = new Properties(); 
	
	public Config ()  { 
		
	}
		
	public int configNombre (int config) {
		
		try {
			
			InputStream is = new FileInputStream("config.properties");
			p.load(is);
			
			config = Integer.parseInt(p.getProperty("nombre_de_case"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return config;
		
	}

	public int configEssais(int config) {

		try {
			
			InputStream is = new FileInputStream("config.properties");
			p.load(is);
			
			config = Integer.parseInt(p.getProperty("nombre_essais"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return config;
	}
	
	
}
