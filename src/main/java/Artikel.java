/**
 * class Artikel - In deze klasse staan alle artikelen in opgeslagen.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Artikel {
    private String naam;
    private double prijs;

    /**
     * Constructor van de klasse Artikel.
     */
    public Artikel(String naam, double prijs) {
        setNaam(naam);
        setPrijs(prijs);
}
    /**
     * parameter-loze constructor van de klasse Artikel.
     */
    public Artikel() {
        naam = "Nader te bepalen naam";
        prijs = 0;
    }
    /**
     * Publieke Getter voor de naam van het artikel.
     * @return de naam van het artikel
     */
    public String getNaam() {
        return naam;
    }
    /**
     * Publieke Getter voor de prijs van het artikel
     * @return de prijs van het artikel
     */
    public double getPrijs() {
        return prijs;
    }
    /**
     * Publieke Setter voor de de naam van het artikel.
     * @param naam naam van artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
    /**
     * Publieke Setter voor de prijs van het artikel.
     * @param prijs van artikel.
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
    /**
     * Publieke methode die de naam en prijs opslaat in een String.
     * @return naam en prijs van artikel.
     */
     public String toString(){//overriding the toString() method
        return naam+" "+prijs;
    }
}
