package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.startjeux.Mastermind;

public class DefenseurMastermind extends ModeMastermind {
	
	String nombreMax = "";
	private Long nbre = 0L;
	private String nombreGenerer = "";
	private String initlocale = "";
	private String initalisation_zero = "";
	private ArrayList<String> tableauDePossibilité = new ArrayList<String>();
	private ArrayList<Long> tableauTempDeSolution = new ArrayList<Long>();
	private ArrayList<Byte> resultat_BienPlace_Present = new ArrayList<Byte>(); 
	private ArrayList<Byte> resultacompare = new ArrayList<Byte>();
	private ArrayList<String> nombreUtilisable = new ArrayList<String>();


	public DefenseurMastermind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefenseurMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretMachineTab,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab) {
		super(codeSecret, reponseUtilisateur, recupeNombreTab, resultat_BienPlace_Present, codeSecretMachineTab,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Byte> getResultaInitiale() {
		return resultat_BienPlace_Present;
	}

	public void setResultaInitiale(ArrayList<Byte> arrayList) {
		this.resultat_BienPlace_Present = arrayList;
	}
	
	public ArrayList<Byte> getResultacompare() {
		return resultacompare;
	}

	public void setResultacompare(ArrayList<Byte> arrayList) {
		this.resultacompare = arrayList;
	}
	
	public ArrayList<Long> getTableauTempDeSolution() {
		return tableauTempDeSolution;
	}

	public void setTableauTempDeSolution(ArrayList<Long> tableauTempDeSolution) {
		this.tableauTempDeSolution = tableauTempDeSolution;
	}

	public ArrayList<String> getTabDesPossibilité() {
		return tableauDePossibilité;
	}

	public void setTabDesPossibilité(ArrayList<String> tabDesPossibilité) {
		this.tableauDePossibilité = tabDesPossibilité;
	}
	
	@Override
	public void playerGame() {

		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE DEFENSEUR               *");
		System.out.println("\t**********************************************");
		
		initalisationNombreMinMax();
		
		init_tableau_nombre_utilisable();
		
		System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
		
		
		enterClavier();
		setCodeSecretUtilisateurTab(outil.codeSecretAjoutTab(getCodeSecretUtilisateurTab(), getReponseUtilisateur()));
		setCodeSecret(outil.codeSecret(getCodeSecret(), Mastermind.class.getSimpleName()));
		setCodeSecretMachineTab(outil.codeSecretAjoutTab(getCodeSecretMachineTab(), getCodeSecret()));
		
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + getCodeSecret());
		}
		
		setResultaInitiale(resultatMastermind(getCodeSecretMachineTab(), getCodeSecretUtilisateurTab()));
		
		while(initalisation_zero.length() == outil.CONFIGURATION_NOMBRE && nombreGenerer.length() <= initalisation_zero.length() && Long.parseLong(nombreGenerer) <= Long.parseLong(nombreMax)) {
			
			genereNombreSolution(); 
			
			setResultacompare(resultatMastermind(getCodeSecretMachineTab(), getTableauTempDeSolution()));
			
			if (getResultacompare().get(0).equals(getResultaInitiale().get(0))) {
				tableauDePossibilité.add(initlocale);
			}		
			
		}
		setCompteurEssai(1);
		nombreGenerer = "";
		
		
		while (!getCodeSecretMachineTab().equals(getCodeSecretUtilisateurTab()) && getTabDesPossibilité().size() != 1 ) {
			
			ArrayList<String> tableauTemp = new ArrayList<String>();
			
			int indiceAuHasard = (int) (Math.random() * (getTabDesPossibilité().size() - 1));
			setCodeSecret(getTabDesPossibilité().get(indiceAuHasard));
			getCodeSecretMachineTab().clear();
			setCodeSecretMachineTab(outil.codeSecretAjoutTab(getCodeSecretMachineTab(), getCodeSecret()));
			
			
			setResultaInitiale(resultatMastermind(getCodeSecretMachineTab(), getCodeSecretUtilisateurTab()));
			
			
			for (int i = 0; i < getTabDesPossibilité().size(); i++) {
								
				setResultacompare(resultatMastermind(getCodeSecretMachineTab(), initialisationTab(getTabDesPossibilité().get(i))));
				
				if (getResultacompare().get(0).equals(getResultaInitiale().get(0))){
					
					tableauTemp.add(getTabDesPossibilité().get(i));
				}
			}	
				
			
			getTabDesPossibilité().clear();
			tableauDePossibilité.addAll(tableauTemp);
			setCompteurEssai(1);
			
			System.out.println("\n Longeure du tableau : " + tableauDePossibilité.size() + " Présent : "+ tableauDePossibilité.contains(getReponseUtilisateur()) +"\n  Essai : " 
			+ getCompteurEssai() + "\n resultat initiale : " + getResultaInitiale() + "\n resultat à comparer : " + getResultacompare() );
		}
	
		if (getCodeSecret().equals(getReponseUtilisateur())) {
			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + getCodeSecret());
		} else {
			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + getTabDesPossibilité());
		}
	}
	
	public String initalisationNombreMinMax() {
		
		for (int i = 0; i < outil.CONFIGURATION_NOMBRE; i++ ) {
			initalisation_zero += "0";
		}
		
		initialisationTab(initalisation_zero);
		
		for (int i = 0; i < initalisation_zero.length(); i++) {
			nombreMax += "" + Integer.parseInt(outil.CONFIGURATION_NOMBRE_UTILISABLE[1]) ;
		}
		
		nombreGenerer = initalisation_zero;
		return initalisation_zero;
	}
	
	
	public void genereNombreSolution() {
		
		do {

			nombreGenerer = "" + (nbre = nbre + 1L);
			
			if (tableauTempDeSolution.get(0) == 0 && verificationNombreUtilisable(nombreGenerer) != true){
				int i = nombreGenerer.length();
				initlocale = initalisation_zero.substring(i, initalisation_zero.length());
				initlocale = initlocale + nombreGenerer;
				setTableauTempDeSolution(initialisationTab(initlocale));
			}
				
			if (tableauTempDeSolution.get(0) != 0 && nombreGenerer.length() <= initalisation_zero.length() && Long.parseLong(nombreGenerer) <= Long.parseLong(nombreMax) && verificationNombreUtilisable(nombreGenerer) != true) {
				initlocale = nombreGenerer;
				setTableauTempDeSolution(initialisationTab(initlocale));
			}
			
		} while (verificationNombreUtilisable(nombreGenerer) != false);
		
	
	}
	
	private ArrayList<Long> initialisationTab(String ini) {
		
		if (initalisation_zero.length() == outil.CONFIGURATION_NOMBRE && nombreGenerer.length() <= initalisation_zero.length()) {
		
			tableauTempDeSolution.clear();
			
			for (int i = 0; i < outil.CONFIGURATION_NOMBRE; i++ ) {
			
				tableauTempDeSolution.add(((Long.parseLong( "" + ini.charAt(i)))));
			}
		}
		
		return tableauTempDeSolution;	
	}
	
	public void init_tableau_nombre_utilisable () {
		
		int nbreMin = Integer.parseInt(outil.CONFIGURATION_NOMBRE_UTILISABLE[0]);
		int nbreMax = Integer.parseInt(outil.CONFIGURATION_NOMBRE_UTILISABLE[1]);
		
		for (int i = 0 ; i < 10; i++) {
		
			if (i > nbreMin && nbreMax < i && i < 10 ) {
				
				nombreUtilisable.add("" + i);
			}		
		}
	}
	
	public boolean verificationNombreUtilisable (String nombre_a_verifier) {
		
		boolean resultat = false;
	
		for (int i = 0; i < nombreUtilisable.size() && resultat == false; i++) {
			
			resultat = nombre_a_verifier.contains(nombreUtilisable.get(i));		
		}
		
		return resultat;
	}
	
}
