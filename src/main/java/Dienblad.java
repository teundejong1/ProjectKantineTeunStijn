import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private double prijs;
    private Artikel Artikel;
    public Persoon klant;
    /**
     * Constructor
     */
    public Dienblad(ArrayList<Artikel> artikelen) {
        this.artikelen = artikelen;
    }

    public Dienblad(Persoon klant) {
        this.klant = klant;
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel description
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        int i = 0;
        for (Artikel value : artikelen){
            i++;
        }
        return i;
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        prijs = 0;
        for (Artikel value : artikelen){ // artikelen in value veranderd,ook hierboven
            prijs += value.getPrijs(); //Hier hetzelfde
        }
        return prijs;
    }
}

