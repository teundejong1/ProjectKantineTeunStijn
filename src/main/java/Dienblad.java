import java.util.Iterator;
import java.util.Stack;
/**
 * class Dienblad - Deze klasse houdt alle artikelen bij van een klant die op het dienblad staan.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Dienblad {
    private Stack<Artikel> artikelen;
    public Persoon klant;

    /**
     * Constructor van de objecten van klasse Dienblad.
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }

    /**
     * Constructor van de objecten van klasse Dienblad.
     * @param klant van het type Persoon
     */
    public Dienblad(Persoon klant) {
        this.klant = klant;
        artikelen = new Stack<Artikel>();
    }

    /**
     * Getter voor klant.
     *
     * @return de klant
     */
    public Persoon getKlant() {
        return this.klant;
    }
    /**
     * Setter voor klant.
     * @param klant van het type Persoon.
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen.
     *
     * @param artikel naam van artikel.
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Iterator loopt door de artikelen heen.
     * @return de iterator van artikelen.
     */
    public Iterator<Artikel> artikelIterator() {
        return artikelen.iterator();
    }
}

