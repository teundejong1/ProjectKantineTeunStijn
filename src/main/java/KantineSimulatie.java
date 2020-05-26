import java.util.Random;

/**
 * class KantineSimulatie - Deze klasse is verantwoordelijk voor het simuleren van de kantine.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 24/05/2020.
 */
public class KantineSimulatie {

    //Dagen
    public static final int DAGEN = 7;
    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;
    // artikelen
    private static final String[] artikelnamen =
            new String[]{"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};
    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;
    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;
    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    // prijzen
    private static final double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};
    // kantine
    private final Kantine kantine;
    // kantineaanbod
    private final KantineAanbod kantineaanbod;
    // random generator
    private final Random random;

    /**
     * Constructor voor de klasse KantinesSimulatie.
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Main methode om de simulatie aan te roepen.
     * @param args de standaard main methode.
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie kantineSimulatie = new KantineSimulatie();
        kantineSimulatie.simuleer(dagen);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte, min en max te
     * genereren
     * @param lengte van het type int van de array.
     * @param min van het type int.
     * @param max van het type int.
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }
        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     * @param min minimum van het type int.
     * @param max maximum van het type int.
     * @return Een random getal tussen de min en max.
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     * @param indexen van arrays int[].
     * @return De array met artikelnamen.
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }
        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     * @param dagen het aantal dagen dat je de simulatie wilt runnen, type int.
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Datum datumEdwin = new Datum(29, 10, 1970);
                Persoon Edwin = new Persoon(12345, "Edwin", "van der Sar", datumEdwin, 'M');
                Dienblad dienbladEdwin = new Dienblad(Edwin);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienbladEdwin, artikelen);
                // artikelen, sluit aan

            }
            kantine.verwerkRijVoorKassa(); //Hier maken wij een netjes bonnetje, ter verduideliking van de resultaten.
            System.out.println("#########################################");
            System.out.println(" ");
            System.out.println("Dag " + (i + 1));
            System.out.println("Dagtotalen:");
            System.out.println("------------");
            System.out.println();
            System.out.println("Personen : " + aantalpersonen);
            System.out.println("Artikelen: " + kantine.getKassa().aantalArtikelen());
            System.out.println("Geld: €" + Math.round(kantine.getKassa().hoeveelheidGeldInKassa() * 100.0) / 100.0);
            System.out.println(" ");
            System.out.println("#########################################");
            kantine.getKassa().resetKassa();

            // verwerk rij voor de kassa

            // druk de dagtotalen af en hoeveel personen binnen

            // zijn gekomen

            // reset de kassa voor de volgende dag

        }
    }
}
