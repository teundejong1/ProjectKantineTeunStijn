import javax.persistence.EntityManager;

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
    private EntityManager manager;

    /**
     * Constructor voor de klasse Kantine.
     */
    public Kantine(EntityManager entityManager) {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij, entityManager);
    }

    /**
     * Publieke Methode voor het pakken van artikelen op het dienblad en vervolgens achteraan sluiten bij de kassarij.
     *
     * @param dienblad     dienblad van de persoon.
     * @param artikelnamen namen van de artikelen op het dienblad.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        for (int i = 0; i <= artikelnamen.length - 1; i++) {
            dienblad.voegToe(kantineAanbod.getArtikel(artikelnamen[i])); // Voeg artikelen toe aan het dienblad.
        }
        kassarij.sluitAchteraan(dienblad);
    }


    /**
     * Publieke getter voor de klasse kassa
     *
     * @return kassa van het type kassa.
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze Publieke methode handelt de rij voor de kassa af via de rekenAf methode.
     */
    public void verwerkRijVoorKassa(int i) {
        while (this.kassarij.erIsEenRij()) {
            try {
                this.kassa.rekenAf(kassarij.eerstePersoonInRij(), i);
            } catch (TeWeinigGeldException e) {
                e.getMessage();
            }
        }
    }

    /**
     * Publieke Getter om het aanbod van de kantine op te halen.
     *
     * @return het huidige kantineaanbod.
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    /**
     * Publieke Setter voor de artikelen die de kantine aanbied.
     *
     * @param kantineAanbod het huidige kantineaanbod.
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }


}
