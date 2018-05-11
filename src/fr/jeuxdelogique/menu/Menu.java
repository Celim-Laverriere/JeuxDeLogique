package fr.jeuxdelogique.menu;

import fr.jeuxdelogique.invalideException.CodeInvalideException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Menu {

	static final Logger logger = LogManager.getLogger();

	public void getMenu() throws CodeInvalideException;
	
}
