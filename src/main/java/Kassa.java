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
    private int afgerekendeArtikelen;
    private String naamBetaler;


    /**
     * Constructor voor de klasse Kassa.
     */
    public Kassa(KassaRij kassarij) {
        this.kassaRij = kassarij;
        resetKassa();
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     * @param klant die moet afrekenen, type Dienblad.
     */
    public void rekenAf(Dienblad klant) {
        int artOpDienblad = 0; //zet artikelen op het dienblad op 0.
        double bedragVanKlant = 0; //bedrag van de klant op 0.
        double kortings = 0; //korting op 0.
        double subtotaal;
        Iterator<Artikel> itr = klant.artikelIterator(); //Iterator voor de artikelen van de klant op het dienblad.
        StringBuilder artikelNamen = new StringBuilder(); //Lege string voor de artikelen en prijs van de artikelen.
        while (itr.hasNext()) { //Zo lang de iterator een volgende heeft
            Artikel nextArtikel = itr.next(); // Werken we met dit artikel.
            //System.out.println(rondAf(nextArtikel.getPrijs()));
            artikelNamen.append(nextArtikel.getNaam()).append(": €").append(nextArtikel.getPrijs()).append("\n"); //Naam en prijs.
            bedragVanKlant += nextArtikel.getPrijs(); //tel de prijs van de artikelen op bij het te betalen bedrag van de klant.
            this.gepasseerdeArtikelen++;
            artOpDienblad++; //Aantal artikelen en artikelen op dienblad +1.

        }
        //Bonnetje aanmaken voor de klant.
        System.out.println("------------------");
        System.out.println("Nieuwe klant: \t" + klant.getKlant().toString()); //Type klant
        subtotaal = rondAf(bedragVanKlant); //subtotaal
        System.out.println("Aantal artikelen op dienblad: " + artOpDienblad); //aantal artikelen
        System.out.println(artikelNamen); //naam + prijs van de artikelen
        System.out.println("Subtotaal : €" + subtotaal); //subtotaal printen
        System.out.println("Manier van betalen: " + klant.getKlant().getBetaalwijze().toString()); //Manier van betalen printen
        try { //het volgende stuk code uitvoeren .
            if (klant.getKlant() instanceof KortingskaartHouder) { //als de klant een kortingskaart heeft.

                double kortingsBedrag = bedragVanKlant * ((KortingskaartHouder) klant.getKlant()).geefKortingsPercentage();
                if (((KortingskaartHouder) klant.getKlant()).heeftMaximum()) { //Wanneer er een maximala korting is (docent).
                    double maxKorting = (((KortingskaartHouder) klant.getKlant()).geefMaximum());
                    if (kortingsBedrag > maxKorting) {//Wanneer het kortingsbedrag groter zou zijn dan de maximale korting is de korting maximale korting.
                        kortings = maxKorting; //sla korting op.
                        bedragVanKlant -= maxKorting; //Af te rekenen bedrag - korting.
                    } else {//Wanneer de korting niet groter is dan de maximale korting.
                        kortings = kortingsBedrag; //sla korting op.
                        bedragVanKlant -= kortingsBedrag; //Af te rekenen bedrag - korting.
                    }
                } else { //Zonder maximale korting (KantineMedewerker).
                    bedragVanKlant -= kortingsBedrag; //af te rekenen bedrag - korting.
                    kortings = kortingsBedrag; //sla korting op.
                }
            }

            klant.getKlant().getBetaalwijze().betaal(bedragVanKlant); //betaling van de klant
            this.hoeveelheidKassa += bedragVanKlant; //betaling optellen bij de kassa
            String stringKorting = String.valueOf(rondAf(kortings)); // korting in een String zetten
            if (stringKorting.equals("0.0")) { //wanneer er geen korting is, is de String "Geen korting".
                stringKorting = "Geen korting";
            } else {
                stringKorting = "€" + stringKorting; //Anders is de String een euroteken + de korting.
            }
            System.out.println("Korting: " + stringKorting); //Print de Korting
            System.out.println("Het te betalen bedrag: €" + rondAf(bedragVanKlant) + "\n"); //print het te betalen bedrag.
            afgerekendeArtikelen += artOpDienblad; //Hou afgerekende artikelen bij.
            System.out.println("Betaling geslaagd");
        } catch (TeWeinigGeldException teWeinigGeldException) { //Bij een niet gelukte betaling
            naamBetaler = klant.getKlant().getAchternaam() + ", " + klant.getKlant().getVoornaam() + " - "; //sla de naam van de betaler op
            System.out.println(naamBetaler + "is het niet gelukt om te betalen"); //print de naam van de betaler + heeft niet betaald.
            
        } finally { // Voer dit stuk altijd uit.
            System.out.println("Einde transactie");
        }
    }


    /**
     * Publieke methode.
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen, type int.
     */
    public int aantalArtikelen() {
        return this.gepasseerdeArtikelen;
    }

    /**
     * Publieke methode.
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa, type double.
     */

    public double hoeveelheidGeldInKassa() {
        return this.hoeveelheidKassa;
    }

    /**
     * Publike getter van de afgerekende artikelen.
     * @return de afgerekende artikelen, type int.
     */
    public int getAfgerekendeArtikelen() {
        return afgerekendeArtikelen;
    }

    /**
     * Publieke methode.
     * Reset de waarden van het aantal gepasseerde en afgerekende artikelen én de totale hoeveelheid geld in de
     * kassa naar 0.
     */
    public void resetKassa() {
        this.hoeveelheidKassa = 0;
        this.gepasseerdeArtikelen = 0;
        this.afgerekendeArtikelen = 0;
    }

    /**
     * Private afrondmethode om de doubles beter weer te geven.
     * @param afTeRonden type double
     * @return het nieuwe, afgeronde bedrag.
     */
    private double rondAf(double afTeRonden) {
        return Math.round(afTeRonden * 100.0) / 100.0;
    }
}
