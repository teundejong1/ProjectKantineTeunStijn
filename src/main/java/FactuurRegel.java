//import java.time.LocalDate;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Iterator;
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//public class FactuurRegel implements Serializable {
//    @Id
//    @Column(name = "ID", unique = true, nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "Factuur_ID")
//    private Factuur factuur;
//
//    @Column(name = "ARTIKEL")
//    private Artikel artikel;
//
//
//
//
//         public FactuurRegel() {}
//
//         public FactuurRegel(Factuur factuur, Artikel artikel) {
//         this.factuur = factuur;
//         this.artikel = artikel;
//         }
//
//         /**
// 17 * @return een printbare factuurregel
// 18 */
//         public String toString() {
//              String factuurRegelString = "";
//
//             return factuurRegelString;
//              }
// }
