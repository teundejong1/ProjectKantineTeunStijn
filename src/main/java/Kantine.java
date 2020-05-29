/**
 * class Kantine  - Deze klasse is verantwoordelijk voor de kantine.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 24/05/2020.
 */
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor voor de klasse Kantine.
     * */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }
    /**
     * Methode voor het pakken van artikelen op het dienblad en vervolgens achteraan sluiten bij de kassarij.
     * @param dienblad dienblad van de persoon.
     * @param artikelnamen namen van de artikelen op het dienblad.
     */

    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {


        //System.out.println("Deze persoon heeft " + artikelnamen.length + " artikelen gekocht.");

        for (int i =0; i <= artikelnamen.length-1; i++) {
        //    System.out.println(artikelnamen[i]); //Deze kan later weg, is voor het weergeven van de artikelen.
            dienblad.voegToe(kantineAanbod.getArtikel(artikelnamen[i]));
        }
            kassarij.sluitAchteraan(dienblad);
    }


    /**
     * getter voor de klasse kassa
     * @return kassa van het type kassa.
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode handelt de rij voor de kassa af via de rekenAf methode.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
             }
    }
    /**
     * Getter om het aanbod van de kantine op te halen.
     * @return het huidige kantineaanbod.
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    /**
     *Setter voor de artikelen die de kantine aanbied.
     * @param kantineAanbod het huidige kantineaanbod.
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }


}
