public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan() {
        Datum datumFrank = new Datum(1, 2, 1993);
        Persoon Frank = new Persoon (12345, "Frank", "de Boer", datumFrank, 'M' );
        Dienblad dienbladFrank = new Dienblad(Frank);
        Artikel cola = new Artikel("Cola", 4.95);
        Artikel hamburger = new Artikel("Hamburger", 5.95);
        dienbladFrank.voegToe(cola);
        dienbladFrank.voegToe(hamburger);
        kassarij.sluitAchteraan(dienbladFrank);
    }

    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
             }
    }

//    /**
//     * Deze methode telt het geld uit de kassa
//     *
//     * @return hoeveelheid geld in kassa
//     */
//    public double hoeveelheidGeldInKassa() {
//        return this.kassa.hoeveelheidGeldInKassa();
//    }
//
//    /**
//     * Deze methode geeft het aantal gepasseerde artikelen.
//     *
//     * @return het aantal gepasseerde artikelen
//     */
//    public int aantalArtikelen() {
//        return this.kassa.aantalArtikelen();
//    }
//
//    /**
//     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
//     * de kassa.
//     */
//    public void resetKassa() {
//        this.kassa.resetKassa();
//    }
}
