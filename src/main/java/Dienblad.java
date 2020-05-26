import java.util.ArrayList;
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
    private Iterator<Artikel> artIt;

    /**
     * Constructor van de objecten van klasse Dienblad.
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }

    /**
     * Constructor van de objecten van klasse Dienblad.
     */

    public Dienblad(Persoon klant) {
        this.klant = klant;
        artikelen = new Stack<Artikel>();
    }

    /**
     * Getter voor klant.
     */
    public Persoon getKlant() {
        return this.klant;
    }
    /**
     * Setter voor klant.
     * @param klant de klant.
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
     * Iterator loop door de artikelen heen.
     * @return het huidige product
     */

    public Iterator<Artikel> artikelIterator(){
            artIt = artikelen.iterator();
            return this.artIt;
          }

//    /**
//     * Methode om aantal artikelen op dienblad te tellen.
//     *
//     * @return Het aantal artikelen.
//     */
//    public int getAantalArtikelen() {
//        return artikelen.size();
//    }
//
//    /**
//     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen.
//     *
//     * @return De totaalprijs.
//     */
//    public double getTotaalPrijs() {
//        double prijs = 0;
//        for (Artikel waarde : this.artikelen){
//            prijs += waarde.getPrijs();
//        }
//        return prijs;
//    }
}

