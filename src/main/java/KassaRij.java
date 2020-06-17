import java.util.LinkedList;

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
        klantRij = new LinkedList<>();
    }

    /**
     * Publieke methode.
     * Persoon sluit achter in de rij aan.
     *
     * @param klant Dienblad van de klant.
     */
    public void sluitAchteraan(Dienblad klant) {
        klantRij.add(klant);
    }


    /**
     * Publieke Methode die kijkt of er een rij bestaat, de eerste Klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste Klant in de rij (type Dienblad) of null
     */
    public Dienblad eerstePersoonInRij() {
        if (klantRij.isEmpty()) { //Wanneer er geen rij is.
            System.out.println("er is geen rij");
            return null;
        } else {
            Dienblad voorstePersoon = klantRij.get(0); //Anders pak de voorste persoon in de rij.
            klantRij.remove(0);
            return voorstePersoon;
        }
    }

    /**
     * Publieke Methode kijkt of er personen in de rij staan.
     *
     * @return true als er een rij bestaat, anders false.
     */
    public boolean erIsEenRij() {
        return (klantRij.size() > 0);
    }

}
