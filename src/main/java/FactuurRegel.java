import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "FactuurRegel")
@Table (name = "factuurregel")
@Embeddable

public class FactuurRegel implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL, targetEntity = Factuur.class)
    @JoinColumn(name = "FID")
    private Factuur factuur;

    @Embedded
    @Column(name = "ARTIKEL")
    private Artikel artikel;




         public FactuurRegel() {}

         public FactuurRegel(Factuur factuur, Artikel artikel) {
         this.factuur = factuur;
         this.artikel = artikel;
         }

         /**
         * @return een printbare factuurregel
        */
         public String toString() {
             String factuurRegelString = "Naam artikel: " + artikel.getNaam() + "  - Prijs artikel: " + artikel.getPrijs();
             return factuurRegelString;
              }
 }
