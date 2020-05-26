/**
 * class Datum - Deze klasse is voor de controle en zetten van de tijd(datum).
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Datum {

	private int dag;
	private int maand;
	private int jaar;
	private int dagenInMaand;


	/**
	 * Constructor van de klasse Datum.
	 * @param dag de dag.
	 * @param maand de maand.
	 * @param jaar het jaar.
	 */
	public Datum(int dag, int maand, int jaar) {
		setDag(dag);
		setMaand(maand);
		setJaar(jaar);
		bestaatDatum(dag, maand, jaar);
	}
	/**
	 * parameter-loze constructor van de klasse Datum.
	 */
	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}
	/**
	 * Setter voor de dag.
	 * @param dag de dag.
	 */
	public void setDag(int dag) {
		this.dag = dag;
	}
	/**
	 * Setter voor de maand.
	 * @param maand	de maand
	 */
	public void setMaand(int maand) {
		this.maand = maand;
	}
	/**
	 * Setter voor het jaar.
	 * @param jaar het jaar.
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	/**
	 * Getter voor de dag.
	 * @return de dag.
	 */
	public int getDag() {
		return dag;
	}
	/**
	 * Getter voor de maand.
	 * @return de maand.
	 */
	public int getMaand() {
		return maand;
	}
	/**
	 * Getter voor het jaar.
	 * @return het jaar.
	 */
	public int getJaar() {
		return jaar;
	}
	/**
	 * Controle of de datum bestaat.
	 * @param dag de dag.
	 * @param maand	de maand.
	 * @param jaar	het jaar.
	 * @return of de datum valide is.
	 */
	public boolean bestaatDatum(int dag, int maand, int jaar) {
		controleDatum();
		return dag != 0 && maand != 0 && jaar != 0;
	}

	/**
	 * Getter voor Sting weergave van datum.
	 *
	 * @return Geboortedatum.
	 */
	public String getDatumAsString() {
		String strDatum = String.valueOf(dag) + "-"+ String.valueOf(maand) + "-" + String.valueOf(jaar);
		return strDatum;
	}
	/**
	 * Controleert of de datum valide is.
	 */
	public void controleDatum() {
		/* Controleert of het dagnummer groter of gelijk aan 1 is. */
		if (dag < 1 || (dag > dagenInMaand)) {
			dag = 0;
			maand = 0;
			jaar = 0;

		}

		/* Controleert of de maand binnen 1 en 12 valt. */
		if (maand < 1 || maand > 12) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}

		/* Controleert of het jaar getal binnen 1900 en 2100 is. */
		if (jaar < 1900 || jaar > 2100) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}

		switch (getMaand()) {
			case 1:
			case 3:
			case 5:             //maanden met 31 dagen
			case 7:
			case 8:
			case 10:
			case 12:
				dagenInMaand =31;
				break;
			case 4:
			case 6:              //maanden met 30 dagen
			case 9:
			case 11:
				dagenInMaand = 30;
				break;

			case 2:
				if (((getJaar() % 4 == 0) && !(getJaar() % 100 == 0)) || (getJaar() % 400 == 0)) {
					dagenInMaand = 29;}

					else{
					dagenInMaand = 28;
					break;
				}
			if (getDag() > dagenInMaand){
				dag = 0;
			}
		}

	}


}
