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

    public DefenseurMastermind(String codeSecret, ArrayList<Byte> resultatBienPlacePresentUtilisateur, ArrayList<Long> codeSecretOrdinateur,
                               ArrayList<Byte> resultat_BienPlace_Present, ArrayList<Long> codeSecretUtilisateur, ArrayList<Long> codeSecretUtilisateurTab,
                               ArrayList<Long> codeSecretPlayerUtilisateur, ArrayList<Long> codeSecretPlayerOrdnateur, String nombreGenerer, String initCodeAvecZero,
                               String initalisation_zero, String nombreMax, Long nbre, ArrayList<String> tableauDesPossibilites, ArrayList<Long> tableauTempDeSolution,
                               ArrayList<Byte> resultacompare) {
        super(codeSecret, resultatBienPlacePresentUtilisateur, codeSecretOrdinateur, resultat_BienPlace_Present, codeSecretUtilisateur,
                codeSecretUtilisateurTab, codeSecretPlayerUtilisateur, codeSecretPlayerOrdnateur, nombreGenerer, initCodeAvecZero, initalisation_zero, nombreMax);
        this.nbre = nbre;
        this.tableauDesPossibilites = tableauDesPossibilites;
        this.tableauTempDeSolution = tableauTempDeSolution;
        this.resultacompare = resultacompare;
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

		System.out.println("\n\t**********************************************");
		System.out.println("\t*                 MASTERMIND                 *");
		System.out.println("\t*               MODE DEFENSEUR               *");
		System.out.println("\t**********************************************");

		System.out.print("\nC'est à vous de jouer ! \nEntrez votre code secret de " + outil.CONFIGURATION_NOMBRE
                + " chiffres que l'ordinateur devra trouver en " + outil.CONFIGURATION_ESSAIS + " essais : ");
		setCodeSecretUtilisateur(outil.codeSecretAjoutTab(enterClavier()));
        logger.trace("Code secret genere par l'utilisateur " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
		
		setCodeSecretPlayerOrdnateur(outil.codeSecretAjoutTab(outil.genererCodeSecret( Mastermind.class.getSimpleName())));

		setResultat_BienPlace_Present(resultatMastermind(getCodeSecretPlayerOrdnateur(), getCodeSecretUtilisateur()));
		
		setTableauTempDeSolution(outil.codeSecretAjoutTab(getInitalisation_zero()));

		System.out.print("\nEssai n° " + getCompteurEssai() + " ! ");

		while(!getCodeSecretPlayerOrdnateur().equals(getCodeSecretUtilisateur()) && Long.parseLong(getNombreGenerer()) <= Long.parseLong(getNombreMax())) {
		
			setResultacompare(resultatMastermind(getCodeSecretPlayerOrdnateur(), getTableauTempDeSolution()));
			
			if (getResultat_BienPlace_Present().equals(getResultacompare())) {
				tableauDesPossibilites.add(getInitCodeAvecZero());
			}
			
			setTableauTempDeSolution(outil.codeSecretAjoutTab(genereNombreSolution()));
		}

		System.out.println("\nProposition l'ordinateur: " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " +
				getResultat_BienPlace_Present().get(1) + " Présent !");
        logger.trace("Essai n° " + getCompteurEssai()+ " / " + getResultat_BienPlace_Present().get(0) + " Bien place et " +
                getResultat_BienPlace_Present().get(1) + " Present !");

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

            System.out.print("\nEssai n° " + getCompteurEssai() + " ! ");

			System.out.println("\nProposition de l'ordinateur : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()) + " Réponse : " + getResultat_BienPlace_Present().get(0) + " Bien placé et " +
					getResultat_BienPlace_Present().get(1) + " Présent !");
            logger.trace("Essai n° " + getCompteurEssai()+ " / " + getResultat_BienPlace_Present().get(0) + " Bien place et " +
                    getResultat_BienPlace_Present().get(1) + " Present !");

		}
	
		if (getCodeSecretUtilisateur().equals(getCodeSecretPlayerOrdnateur())) {

            if (getModeDev().equals("developpeur")) {
                System.out.println("\nMode développeur ! Code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));

            logger.trace("L'ordinateur à rouvé : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));

		} else if (getTableauDesPossibilites().get(0).equals(outil.chaineDeCaract(getCodeSecretUtilisateur()))) {

            if (getModeDev().equals("developpeur")) {
                System.out.println("\nMode développeur ! Code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

			System.out.println("\nBravo ! L'ordinateur a trouvé le code secret : " + getTableauDesPossibilites().get(0));

            logger.trace("L'ordinateur à trouvé : " + getTableauDesPossibilites().get(0));

		} else {

            if (getModeDev().equals("developpeur")) {
                System.out.println("\nMode développeur ! Code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateur()));
            }

			System.out.println("\nL'ordinateur n'a pas réussi à trouver votre code secret : " + outil.chaineDeCaract(getCodeSecretUtilisateur()) + " ! ");
            logger.trace("L'ordinateur à perdu : " + outil.chaineDeCaract(getCodeSecretPlayerOrdnateur()));
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
