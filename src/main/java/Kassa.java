import java.util.Iterator;

public class Kassa {

    private double totalBalance;
    private int passedItems;
    private KassaRij kassaRij;
    private double bedragVanKlant;
    private int artOpDienblad;
    private Artikel volgendeArtikel;
    private int totaalAfgerekendeArtikelen;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.totalBalance = 0;
        this.passedItems = 0;
        this.kassaRij = kassarij;
    }

    /**
     * Publieke methode om af te rekenen met klanten
     * Wordt ook een nette bon geprint.
     * @param klant die moet afrekenen, type Dienblad
     */

    public void rekenAf(Dienblad klant) throws TeWeinigGeldException {

        bedragVanKlant = 0;
        double kortingsbedrag = 0;
        double subtotaal = 0;
        artOpDienblad = 0;
        double naKorting;


        System.out.println("#######################");
        System.out.println("Nieuwe transactie ");
        System.out.println((klant.getKlant().toString()));
        System.out.println((" "));
        System.out.println((klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam()));
        System.out.println("Manier van betalen: " + (klant.getKlant().getBetaalwijze().toString()));
        System.out.println((" "));

        Iterator<Artikel> itr = klant.artikelIterator();
        while (itr.hasNext()) {
            volgendeArtikel = itr.next();
            if (volgendeArtikel.getKorting() > 0) {
                kortingsbedrag += volgendeArtikel.getKorting();

            } else if (volgendeArtikel.getKorting() == 0) {
                bedragVanKlant += volgendeArtikel.getPrijs();
            }
            System.out.println((volgendeArtikel.getNaam() + " : " + volgendeArtikel.getPrijs()));

            subtotaal += volgendeArtikel.getPrijs();

            this.passedItems++;
            artOpDienblad++;
        }
        double saldoVoor = klant.getKlant().getBetaalwijze().getSaldo();

        try {

            System.out.println(("+"));
            System.out.println((("Te betalen voor korting: €" + rondAf(subtotaal))));

            // bereken de korting voor de klant mits zij KortingskaartHouder zijn
            if (klant.getKlant() instanceof KortingskaartHouder) {
                double korting = bedragVanKlant * ((KortingskaartHouder) klant.getKlant()).geefKortingsPercentage();

                // docenten met max korting
                if (((KortingskaartHouder) klant.getKlant()).heeftMaximum()) {
                    double maxKorting = ((KortingskaartHouder) klant.getKlant()).geefMaximum();
                    if (korting <= maxKorting) {
                        bedragVanKlant -= korting;
                        //korting = bedragVanKlant - korting;
                    } else {
                        bedragVanKlant -= maxKorting;
                        korting = maxKorting;
                    }
                    // kantinemedewerkers zonder max korting
                } else {
                    bedragVanKlant -= korting;
                }

                System.out.println("Kortingskaartkorting: €" + rondAf(korting));
                System.out.println("Dagaanbiedingkorting: €" + rondAf(kortingsbedrag));
                System.out.println("Totale korting      : €" + rondAf(korting + kortingsbedrag));
                System.out.println("-");
                naKorting = subtotaal - (korting + kortingsbedrag);
                System.out.println("Na korting: €" + rondAf(naKorting));
            } else {
                naKorting = subtotaal - kortingsbedrag;
                System.out.println("Dagaanbiedingkorting: €" + rondAf(kortingsbedrag));
                System.out.println(" ");
                System.out.println("Na korting: €" + rondAf(naKorting));
            }

            // Het reken gedeelte van de kassa

            klant.getKlant().getBetaalwijze().betaal(rondAf(naKorting));
            this.totalBalance += bedragVanKlant;
            totaalAfgerekendeArtikelen += artOpDienblad;

            System.out.println("Aantal artikelen: " + artOpDienblad);
            System.out.println(" ");
            System.out.println("Saldo voor betaling: €" + rondAf(saldoVoor));
            System.out.println("Saldo na betaling €" + rondAf(klant.getKlant().getBetaalwijze().getSaldo()));
            System.out.println("Administratie: ");
            System.out.println(" ");
            System.out.println("Subtotaal Afgerekende Artikelen: " + totaalAfgerekendeArtikelen);
            System.out.println("Subtotaal gepasseerde artikelen: " + passedItems);
            System.out.println("Dagtotaal: €" + rondAf(totalBalance));

        } catch (TeWeinigGeldException e) {
            System.out.println(klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam() + " kon niet betalen.");

        } finally {

            System.out.println(" ");
            System.out.println("Einde transactie");
            System.out.println("#######################");
            System.out.println(" ");
            System.out.println("---------------------------------");
            System.out.println(" ");

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


}
