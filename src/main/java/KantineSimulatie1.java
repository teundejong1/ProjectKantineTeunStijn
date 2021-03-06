//public class KantineSimulatie {
//
//    private Kantine kantine;
//
//    public static final int DAGEN = 7;
//
//    /**
//     * Constructor
//     */
//    public KantineSimulatie() {
//        kantine = new Kantine();
//    }
//
//    /**
//     * Deze methode simuleert een aantal dagen in het
//     * verloop van de kantine
//     *
//     * @param dagen
//     */
//    public void simuleer(int dagen) {
//
//        // herhaal voor elke dag
//        for (int i = 0; i<=dagen; i++) {
//
//            // per dag nu even vast 10 + i personen naar binnen
//            // laten gaan, wordt volgende week veranderd...
//
//            // for lus voor personen
//            for (int j = 0; j < 10 + i; j++) {
//                 kantine.loopPakSluitAan();
//            }
//
//            // verwerk rij voor de kassa
//                kantine.verwerkRijVoorKassa();
//             // toon dagtotalen (artikelen en geld in kassa)
//
//                        System.out.println("#########################################");
//                        System.out.println(" ");
//                        System.out.println("Dag " + i);
//                        System.out.println("Dagtotalen:");
//                        System.out.println("------------");
//                        System.out.println();
//                        System.out.println("Artikelen: " + kantine.getKassa().aantalArtikelen());
//                        System.out.println("Geld: €" + Math.round(kantine.getKassa().hoeveelheidGeldInKassa() * 100.0) / 100.0);
//                        System.out.println(" ");
//                        System.out.println("#########################################");
//                        kantine.getKassa().resetKassa();
//        }
//    }
//
//    /**
//     * Start een simulatie
//     */
//    public static void main(String[] args) {
//        int dagen;
//
//        if (args.length == 0) {
//            dagen = DAGEN;
//        } else {
//            dagen = Integer.parseInt(args[0]);
//        }
//        KantineSimulatie kantineSimulatie = new KantineSimulatie();
//        kantineSimulatie.simuleer(dagen);
//    }
//}
