import java.util.ArrayList;
import java.util.Iterator;
/**
 * class Kassa - Deze klasse is verantwoordelijk voor de kassa.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */
public class Kassa {
    private KassaRij kassaRij;
    private double hoeveelheidKassa;
    private int gepasseerdeArtikelen;

     /**
     * Constructor voor de klasse Kassa.
     */

    public Kassa(KassaRij kassarij) {
        this.kassaRij = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     * @param klant die moet afrekenen.
     */
    public void rekenAf(Dienblad klant) {
        double prijsTotaal = klant.getTotaalPrijs();
        int hoeveelheidArtikelen = klant.getAantalArtikelen();
        this.hoeveelheidKassa += prijsTotaal;
        this.gepasseerdeArtikelen += hoeveelheidArtikelen;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen.
     */
    public int aantalArtikelen() {
        return gepasseerdeArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa.
     */

    public double hoeveelheidGeldInKassa() {
        return hoeveelheidKassa;
    }


    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        hoeveelheidKassa = 0;
        gepasseerdeArtikelen = 0;
    }

}
