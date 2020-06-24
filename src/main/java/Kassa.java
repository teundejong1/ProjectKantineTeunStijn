import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Iterator;

public class Kassa {

    private double totalBalance;
    private int passedItems;
    private KassaRij kassaRij;
    private double bedragVanKlant;
    private int artOpDienblad;
    private Artikel volgendeArtikel;
    private int totaalAfgerekendeArtikelen;
    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager entityManager) {
        this.totalBalance = 0;
        this.passedItems = 0;
        this.kassaRij = kassarij;
        this.manager = entityManager;
    }

    /**
     * Publieke methode om af te rekenen met klanten
     * Wordt ook een nette bon geprint.
     * @param klant die moet afrekenen, type Dienblad
     */

    public void rekenAf(Dienblad klant, int i) throws TeWeinigGeldException {

        Factuur factuur = new Factuur(klant, LocalDate.now().plusDays(i));
        try {
            // Het reken gedeelte van de kassa
            klant.getKlant().getBetaalwijze().betaal(factuur.getTotaal());
            this.totalBalance += bedragVanKlant;
            totaalAfgerekendeArtikelen += factuur.getPassedItems();
            totalBalance += factuur.getTotaal();
            create(factuur);

        } catch (TeWeinigGeldException e) {
            System.out.println(klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam() + " kon niet betalen.");

        }
        finally{
            System.out.println(factuur.toString(klant));
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalGepasseerdeArtikelen() {
        return this.passedItems;
    }

    public int aantalAfgerekendeArtikelen() {
        return this.totaalAfgerekendeArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */

    public double hoeveelheidGeldInKassa() {
        return this.totalBalance;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        this.totalBalance = 0;
        this.passedItems = 0;
        this.totaalAfgerekendeArtikelen = 0;
    }

    /**
     * @param getal een double waarde
     * @return afgeronde waarde.
     */
    private double rondAf(double getal) {
        return Math.round(getal * 100.0) / 100.0;
    }

    /**
     * Maak een nieuwe factuur.
     *
     * @param factuur, type Factuur
     */
    public void create(Factuur factuur) {
        EntityTransaction transaction = null;
        try {
            // Get a transaction, sla de student gegevens op en commit de transactie
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(factuur);
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            //ex.printStackTrace();
        }
    }

}
