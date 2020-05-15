public class Datum {

	private int dag;
	private int maand;
	private int jaar;
	private int dagenInMaand = 0;

	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar) {
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
		bestaatDatum();
	}

	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
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

	public int getDag() {
		return dag;
	}

	public int getMaand() {
		return maand;
	}

	public int getJaar() {
		return jaar;
	}


	public boolean bestaatDatum(int dag, int maand, int jaar) {
		// TODO
		return false;
	}

	/**
	 * Getter voor Sting weergave van datum.
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}

	public void bestaatDatum() {
		/* Controleerd of het dagnummer groter of gelijk aan 1 is. */
		if (!(getDag() >= 1)) {
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
