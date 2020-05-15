import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private double j;
    private Artikel Artikel;

    /**
     * Constructor
     */
    public Dienblad(ArrayList<Artikel> artikelen) {
        this.artikelen = artikelen;
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
        for (Artikel artikelen : artikelen){
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
        j = 0;
        for (Artikel artikelen : artikelen){
            j += Artikel.getPrijs();
        }
        return j;
    }
}

