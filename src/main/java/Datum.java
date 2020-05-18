public class Datum {

	private static int dag;
	private static int maand;
	private static int jaar;
	private static int dagenInMaand;


	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar) {
		setDag(dag);
		setMaand(maand);
		setJaar(jaar);
		bestaatDatum(dag, maand, jaar);
	}

	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public static int getDag() {
		return dag;
	}

	public static int getMaand() {
		return maand;
	}

	public static int getJaar() {
		return jaar;
	}

	public static boolean bestaatDatum(int dag, int maand, int jaar) {
		controleDatum();
		if(dag==0 || maand==0 || jaar==0) {
			return false;
		}else
			return true;
	}

	/**
	 * Getter voor Sting weergave van datum.
	 *
	 * @return Geboortedatum
	 */
	public static String getDatumAsString() {
		String strDatum = String.valueOf(dag) + "-"+ String.valueOf(maand) + "-" + String.valueOf(jaar);
		return strDatum;
	}

	public static void controleDatum() {
		/* Controleerd of het dagnummer groter of gelijk aan 1 is. */
		if (getDag() < 1 || (getDag() > dagenInMaand))  {
			dag = 0;
		}

		/* Controleerd of de maand binnen 1 en 12 valt. */
		if (getMaand() < 1 || getMaand() > 12) {
			maand = 0;
		}

		/* Controleerd of het jaar getal binnen 1900 en 2100 is. */
		if (getJaar() < 1900 || getJaar() > 2100) {
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
