package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.Mastermind;

public class DuelMastermind extends ModeMastermind {

	
	private Long nbre = 0L;
	private ArrayList<String> tableauDesPossibilites = new ArrayList<String>();
	private ArrayList<Long> tableauTempDeSolution = new ArrayList<Long>();
	private ArrayList<Byte> resultacompare = new ArrayList<Byte>();
	
	public DuelMastermind() {
		super();
		// TODO Auto-generated constructor stub
		initalisationNombreMinMax();
		outil.init_tableau_nombre_utilisable();
		
	}
	
	public DuelMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Long> codeSecretOrdinateur, ArrayList<Byte> resultat_BienPlace_Present,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String nombreGenerer, String initCodeAvecZero,
			String initalisation_zero, String nombreMax) {
		super(codeSecret, reponseUtilisateur, recupeNombreTab, codeSecretOrdinateur, resultat_BienPlace_Present,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab, nombreGenerer,
				initCodeAvecZero, initalisation_zero, nombreMax);
		// TODO Auto-generated constructor stub
	}

	public Long getNbre() {
		return nbre;
	}

	public void setNbre(Long nbre) {
		this.nbre = nbre;
	}

	public ArrayList<String> getTableauDesPossibilites() {
		return tableauDesPossibilites;
	}

	public void setTableauDesPossibilites(ArrayList<String> tableauDesPossibilites) {
		this.tableauDesPossibilites = tableauDesPossibilites;
	}

	public ArrayList<Long> getTableauTempDeSolution() {
		return tableauTempDeSolution;
	}

	public void setTableauTempDeSolution(ArrayList<Long> tableauTempDeSolution) {
		this.tableauTempDeSolution = tableauTempDeSolution;
	}

	public ArrayList<Byte> getResultacompare() {
		return resultacompare;
	}

	public void setResultacompare(ArrayList<Byte> resultacompare) {
		this.resultacompare = resultacompare;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void playerGame() throws CodeInvalideException {
		// TODO Auto-generated method stub
		
		
		//setNombreUtilisable(outil.init_tableau_nombre_utilisable());
		
		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*                 MODE Duel                  *");
		System.out.println("\t**********************************************");
		
		/*** lordinateur génére un code que doit trouver l'utilisateur ****/
		
		setCodeSecretOrdinateur(outil.codeSecretAjoutTab(outil.genererCodeSecret(Mastermind.class.getSimpleName())));
		
		/*** L'utilisateur entre son code secret que l'ordinateur devra trouver *****/
		System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
		setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
		
		/*********************** Affiche mode développeur ******************/
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	
		setCompteurEssai(1);
		
		/*********************************** premiere partie ( Jeu Utilisateur ) ************************************/
		do {
			
			System.out.println("\nC'est à vous de jouer : Enter votre nombre à " + outil.CONFIGURATION_NOMBRE + " chiffres" );
			
			getCodeSecretPlayerUtilisateurTab().clear();
			setCodeSecretPlayerUtilisateurTab(outil.codeSecretAjoutTab(enterClavier()));

			setResultat_BienPlace_Present(resultatMastermind(getCodeSecretOrdinateur(), getCodeSecretPlayerUtilisateurTab()));
				
			System.out.println("\n\nVotre proposition : " + outil.chaineDeCaract(getCodeSecretPlayerUtilisateurTab()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " + 
			getResultat_BienPlace_Present().get(1) + " Présent !" + "\n Nombre d'aisé : " + getCompteurEssai());
				
			
			/******* Seconde partie ( Jeu Ordinateur **********/
			
			if (getCompteurEssai() <= 1 && !getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())) {
			
				/******** L'ordinateur génere sa premiere solution de chiffre ******************/
			
				setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab( outil.genererCodeSecret(Mastermind.class.getSimpleName())));
				
				/********** Premier test qui compare le nombre de l'utilisateur et celui de l'ordinateur et renvoie un resultat ********/
				setResultat_BienPlace_Present(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));
				
				/***** Initialisation du tableau qui va stocker temporairement les solutions ********/
				setTableauTempDeSolution(outil.codeSecretAjoutTab(getInitalisation_zero()));
				
				while(!getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax())) {
					
					setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), getTableauTempDeSolution()));
					
					if (getResultacompare().equals(getResultat_BienPlace_Present())) {
						tableauDesPossibilites.add(getInitCodeAvecZero());
					}		
					
					setTableauTempDeSolution(outil.codeSecretAjoutTab(genereNombreSolution()));
				}
				
				System.out.println("\n\nProposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " + 
				getResultat_BienPlace_Present().get(1) + " Présent !" + "\n Nombre d'aisé : " + getCompteurEssai());
				
				setNombreGenerer("");
			}
			
			if (!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) && getTableauDesPossibilites().size() > 0 && getCompteurEssai() <= outil.CONFIGURATION_ESSAIS && getCompteurEssai() >= 2) {
				
				ArrayList<String> tableauTemp = new ArrayList<String>();
				int indiceAuHasard = (int) (Math.random() * (getTableauDesPossibilites().size() - 1));
				getCodeSecretPlayerOrdnateur().clear();
				setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(getTableauDesPossibilites().get(indiceAuHasard)));
				
				
				setResultat_BienPlace_Present(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));
				
				
				for (int i = 0; i < getTableauDesPossibilites().size(); i++) {
					
					getTableauTempDeSolution().clear();
					setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), outil.codeSecretAjoutTab(getTableauDesPossibilites().get(i))));
					
					if (getResultat_BienPlace_Present().equals(getResultacompare())){
						tableauTemp.add(getTableauDesPossibilites().get(i));
					}	
				}	
					
				getTableauDesPossibilites().clear();
				getTableauDesPossibilites().addAll(tableauTemp);
				
				System.out.println("\n\nProposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " + 
				getResultat_BienPlace_Present().get(1) + " Présent !" + "\n Nombre d'aisé : " + getCompteurEssai());
			}
		
			setCompteurEssai(1);
			
		} while (!getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur())) && !getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab()) 
				&& !getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) && getCompteurEssai() < outil.CONFIGURATION_ESSAIS );
		
		if (getCodeSecretOrdinateur().equals(getCodeSecretPlayerUtilisateurTab())) {
			
			System.out.println("\nBravo ! Vous avez trouvé le code secret de l'ordinateur : " + outil.chaineDeCaract((getCodeSecretOrdinateur())));
			
		} else if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) || getTableauDesPossibilites().equals(outil.chaineDeCaract(getCodeSecretUtilisateur()))) {
			
			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
			
		} else {
			
			System.out.println("Vous ainsi que l'ordinateur a été dans l'incapassité de trouver le code de l'un et de l'autre !");
			System.out.println("Code secret que devait trouve l'ordinateur : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
			System.out.println("Code secret que deviait trouver l'utilisateur : " + outil.chaineDeCaract(getCodeSecretOrdinateur()));
		}
	}

	public String genereNombreSolution() {
	
		do {
	
			setNombreGenerer("" + (nbre = nbre + 1L));
			
			if (tableauTempDeSolution.get(0) == 0 && outil.verificationNombreUtilisable(getNombreGenerer()) != true){
				int i = getNombreGenerer().length();
				setInitCodeAvecZero(getInitalisation_zero().substring(i, getInitalisation_zero().length()));
				setInitCodeAvecZero(getInitCodeAvecZero() + getNombreGenerer());
			}
				
			if (tableauTempDeSolution.get(0) != 0 && outil.verificationNombreUtilisable(getNombreGenerer()) != true) {
				setInitCodeAvecZero(getNombreGenerer());
			}
			 
		} while (!outil.verificationNombreUtilisable(getNombreGenerer()) != true && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax()));
		
		getTableauTempDeSolution().clear();
		
		return getInitCodeAvecZero();
	}


}
