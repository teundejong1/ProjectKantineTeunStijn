import java.util.ArrayList;
import java.util.Iterator;

public class Kassa {
    private ArrayList<Artikel> artikelen;
    private double prijs;
    private Artikel Artikel;
    private int teller =0;
    private double hoeveelheidKassa =0;
    private KassaRij KassaRij;
    /**
     * Constructor
     */

    public Kassa(KassaRij kassaRij) {

        this.KassaRij=kassaRij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        aantalArtikelen();
        hoeveelheidGeldInKassa();
        resetKassa();
        // method body omitted
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
                for (Artikel artikelen : artikelen)
            teller++;
        return teller;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
               for (Artikel artikelen : artikelen)
            hoeveelheidKassa += Artikel.getPrijs();
        return hoeveelheidKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        hoeveelheidKassa = 0;
        teller = 0;
    }
}
