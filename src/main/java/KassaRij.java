import java.util.*;
/**
 * class KassaRij - Deze klasse houdt de rij bij van de kassa.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */
public class KassaRij {
    private LinkedList<Dienblad> klantRij;

    /**
     * Constructor voor de klasse KassaRij.
     */

    public KassaRij() {
        klantRij = new LinkedList<Dienblad>();
    }

    /**
     * Persoon sluit achter in de rij aan.
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        klantRij.add(klant);
    }



    /**
     * Indien er een rij bestaat, de eerste Klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste Klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if(klantRij.isEmpty()){
            System.out.println("er is geen rij");
            return null;
        }else{
            Dienblad voorstePersoon = klantRij.get(0); //even kijken naar remove
            klantRij.remove(0);
            return voorstePersoon;
        }
    }
    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat.
     */
    public boolean erIsEenRij() {
        return (klantRij.size() > 0);
    }

}
