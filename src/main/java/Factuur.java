import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

@Entity
public class Factuur implements Serializable {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DATUM")
    private LocalDate datum;
    @Column(name = "SUBTOTAAL")
    private double subtotaal;
    @Column(name = "KORTING")
    private double korting;
    @Column(name = "TOTAAL")
    private double totaal;
    @Column(name = "AANTAL_ARTIKELEN")
    private int artOpDienblad;
//    @OneToMany(mappedBy = "factuur")
//    ArrayList<FactuurRegel> regels;


    public Factuur() {
    totaal = 0;
    korting = 0;
 }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;
        verwerkBestelling(klant);
         }

         /**
  * Verwerk artikelen en pas kortingen toe.
  *
  * Zet het totaal te betalen bedrag en het
  * totaal aan ontvangen kortingen.
  *
  * @param klant
  */
         private void verwerkBestelling(Dienblad klant) {

             double kaartKorting = 0;
             double bedragVanKlant = 0;
             double kortingsbedrag = 0;

             artOpDienblad = 0;
             Artikel volgendeArtikel;

             Iterator<Artikel> itr = klant.artikelIterator();
             while (itr.hasNext()) {
                 volgendeArtikel = itr.next();
                 if (volgendeArtikel.getKorting() > 0) {
                     kortingsbedrag += volgendeArtikel.getKorting();

                 } else if (volgendeArtikel.getKorting() == 0) {
                     bedragVanKlant += volgendeArtikel.getPrijs();
                 }

                 subtotaal += volgendeArtikel.getPrijs();

                 artOpDienblad++;
             }

                 // bereken de korting voor de klant mits zij KortingskaartHouder zijn
                 if (klant.getKlant() instanceof KortingskaartHouder) {
                     kaartKorting = bedragVanKlant * ((KortingskaartHouder) klant.getKlant()).geefKortingsPercentage();

                     // docenten met max korting
                     if (((KortingskaartHouder) klant.getKlant()).heeftMaximum()) {
                         double maxKorting = ((KortingskaartHouder) klant.getKlant()).geefMaximum();
                         if (kaartKorting <= maxKorting) {
                             bedragVanKlant -= kaartKorting;
                             //korting = bedragVanKlant - korting;
                         } else {
                             bedragVanKlant -= maxKorting;
                             kaartKorting = maxKorting;
                         }
                         // kantinemedewerkers zonder max korting
                     } else {
                         bedragVanKlant -= kaartKorting;
                     }


                     totaal = subtotaal - (kaartKorting + kortingsbedrag);

                 } else {
                     totaal = subtotaal - kortingsbedrag;
                 }
                 this.korting = kaartKorting + kortingsbedrag;

         }

public int getPassedItems()
    {
        return artOpDienblad;
    }


         /**
 * @return het totaalbedrag
 */
        public double getTotaal() {
         return totaal;
         }

         /**
  * @return de toegepaste korting
  */
         public double getKorting() {
         return korting;
         }

         /**
  * @return een printbaar bonnetje
  */
         public String toString(Dienblad klant) {
             String factuur = "####################### \n";
             factuur += datum + "\t Nieuwe transactie: \n";
             factuur += klant.getKlant().toString() + " \n";
             factuur += klant.getKlant().getAchternaam() + ", " + klant.getKlant().getVoornaam() + "\n";
             factuur += "Manier van betalen : " + klant.getKlant().getBetaalwijze().toString()+ "\n";
             factuur += "Totale aantal artikelen " + artOpDienblad + "\n";
             factuur += "Totaal bedrag: " + rondAf(subtotaal) + "\n";
             factuur += "Totale korting: " + rondAf(getKorting()) + "\n";
             factuur += "Bedrag - korting: €" + rondAf(getTotaal()) + "\n";
             factuur += "Einde transactie";
             factuur += "---------------------------------";
             factuur += " ";
            return factuur;
         }

    private double rondAf(double getal) {
        return Math.round(getal * 100.0) / 100.0;
    }
 }
