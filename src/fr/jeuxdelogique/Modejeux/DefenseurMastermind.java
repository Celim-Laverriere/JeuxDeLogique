package fr.jeuxdelogique.Modejeux;

import java.util.ArrayList;

import fr.jeuxdelogique.outils.CodeInvalideException;
import fr.jeuxdelogique.startjeux.Mastermind;

public class DefenseurMastermind extends ModeMastermind {
	
	
	private Long nbre = 0L;
	
	private ArrayList<String> tableauDesPossibilites = new ArrayList<String>();
	private ArrayList<Long> tableauTempDeSolution = new ArrayList<Long>();
	private ArrayList<Byte> resultacompare = new ArrayList<Byte>();
	


	public DefenseurMastermind() {
		super();
		// TODO Auto-generated constructor stub
		
		initalisationNombreMinMax();
		outil.init_tableau_nombre_utilisable();
		
	}

	public DefenseurMastermind(String codeSecret, String reponseUtilisateur, int recupeNombreTab,
			ArrayList<Long> codeSecretOrdinateur, ArrayList<Byte> resultat_BienPlace_Present,
			ArrayList<Long> codeSecretUtilisateurTab, ArrayList<Long> codeSecretPlayerUtilisateurTab,
			ArrayList<Long> codeSecretPlayerAITab, String nombreGenerer, String initCodeAvecZero,
			String initalisation_zero, String nombreMax) {
		super(codeSecret, reponseUtilisateur, recupeNombreTab, codeSecretOrdinateur, resultat_BienPlace_Present,
				codeSecretUtilisateurTab, codeSecretPlayerUtilisateurTab, codeSecretPlayerAITab, nombreGenerer,
				initCodeAvecZero, initalisation_zero, nombreMax);
		// TODO Auto-generated constructor stub
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

	public ArrayList<String> getTableauDesPossibilites() {
		return tableauDesPossibilites;
	}

	public void setTableauDesPossibilites(ArrayList<String> tableauDesPossibilites) {
		this.tableauDesPossibilites = tableauDesPossibilites;
	}

	
	@Override
	public void playerGame() throws CodeInvalideException {

		System.out.println("\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE DEFENSEUR               *");
		System.out.println("\t**********************************************");
		
		System.out.println(outil.CONFIGURATION_NOMBRE_UTILISABLE[1].toString());
		
		
		
		System.out.println("Entrez votre code secret de " + outil.CONFIGURATION_NOMBRE + " chiffres que l'ordinateur devra trouver :");
		setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
		
		setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(outil.genererCodeSecret( Mastermind.class.getSimpleName())));
		
		
		if (getModeDev().equals("Dev")) {
			System.out.println("\n Mode développeur ! \n Code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
		}
		
		setResultat_BienPlace_Present(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));
		
		setTableauTempDeSolution(outil.codeSecretAjoutTab(getInitalisation_zero()));
		
		while(!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax())) {
			
			setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), getTableauTempDeSolution()));
			
			
			if (getResultat_BienPlace_Present().equals(getResultacompare())) {
				tableauDesPossibilites.add(getInitCodeAvecZero());
			}
			
			setTableauTempDeSolution(outil.codeSecretAjoutTab(genereNombreSolution()));
		}
		
		setNombreGenerer("");
		
		
		while (!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) 
				&& getTableauDesPossibilites().size() > 1 && getCompteurEssai() < outil.CONFIGURATION_ESSAIS) {
			
			ArrayList<String> tableauTemp = new ArrayList<String>();
	
			int indiceAuHasard = (int) (Math.random() * (getTableauDesPossibilites().size() - 0));
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
			
			setCompteurEssai(1);
			
			System.out.println("\n Longeure du tableau : " + tableauDesPossibilites.size() + " Présent : "+ tableauDesPossibilites.contains(outil.chaineDeCaract(getCodeSecretUtilisateur())) +"\n  Essai : " 
			+ getCompteurEssai() + "\n resultat initiale : " + getResultat_BienPlace_Present() + "\n resultat à comparer : " + getResultacompare() );
		}
	
		if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur()) || getTableauDesPossibilites().get(0).equals(outil.chaineDeCaract(getCodeSecretUtilisateur())) ) {
			
			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
			
		} else {
			
			System.out.println("\nBravo ! L'ordinateur n'a pas trouvé le code secret : " + tableauDesPossibilites.contains(outil.chaineDeCaract(getCodeSecretUtilisateur())) 
			+ "  " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
		}
	}

	/********************************************************************************************/
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
