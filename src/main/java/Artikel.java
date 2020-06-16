/**
 * class Artikel - In deze klasse staan alle artikelen in opgeslagen.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Artikel {
    private String naam;
    private double prijs;
    private double korting;

    /**
     * Constructor van de klasse Artikel.
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
        korting = 0;
    }

    /**
     * Constructor van de klasse Artikel met korting.
     */
    public Artikel(String naam, double prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    /**
     * parameter-loze constructor van de klasse Artikel.
     */
    public Artikel() {
        naam = "Nader te bepalen naam";
        prijs = 0;
        korting = 0;
    }

    /**
     * Publieke Getter voor de naam van het artikel.
     *
     * @return de naam van het artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Publieke Setter voor de de naam van het artikel.
     *
     * @param naam naam van artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Publieke Getter voor de prijs van het artikel
     *
     * @return de prijs van het artikel
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Publieke Setter voor de prijs van het artikel.
     *
     * @param prijs van artikel.
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * Publieke methode die de naam en prijs opslaat in een String.
     *
     * @return naam en prijs van artikel.
     */
    public String toString() {//overriding the toString() method
        return naam + " " + prijs;
    }

    /**
     * Publieke methode die de korting van een Artikel ophaalt
     *
     * @return korting, type int.
     */
    public double getKorting() {
        return korting;
    }

    /**
     * Publieke methode die de korting van een Artikel zet.
     *
     * @param korting, type int.
     */
    public void setKorting(double korting) {
        this.korting = korting;
    }
}
