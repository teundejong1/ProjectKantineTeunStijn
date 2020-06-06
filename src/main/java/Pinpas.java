public class Pinpas extends Betaalwijze {

    private double kredietlimiet = 500; //zet kredietlimiet op 500.

    /**
     * Publieke Methode om kredietlimiet te zetten
     * @param kredietlimiet van het type double.
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Publieke Methode om betaling af te handelen
     * @throws TeWeinigGeldException wanneer het niet lukt.
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (tebetalen > kredietlimiet) {
            throw new TeWeinigGeldException("Met de pinpas betalen is niet gelukt, omdat het kredietlimiet is overschreden!"); //kredietlimiet.
        } else if (tebetalen > saldo) {
            throw new TeWeinigGeldException("Met de pinpas betalen is niet gelukt, omdat het saldo niet toereikend is!"); //niet genoeg saldo.
        } else if (tebetalen <= saldo) {
            saldo -= tebetalen; //Goede betaling.
        } else {
            throw new TeWeinigGeldException("Met de pinpas betalen is niet gelukt!"); //iets anders fout gegaan.
        }
    }
}
