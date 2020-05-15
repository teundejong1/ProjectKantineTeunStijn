public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar) {
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
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

	public int getDag () {
			return dag;
		}

	public int getMaand () {
			return maand;
		}

	public int getJaar () {
			return jaar;
		}


	public boolean bestaatDatum ( int dag, int maand, int jaar){
			// TODO
			return false;
		}

		/**
		 * Getter voor Sting weergave van datum
		 *
		 * @return Geboortedatum
		 */
	public String getDatumAsString () {
			// TODO
			return "";
		}


	}
