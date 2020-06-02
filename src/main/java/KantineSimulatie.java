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
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;
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
    // aantal personen worden hier op 0 gezet.
    int MIN_PERSONEN_PER_DAG = 50;
    int MAX_PERSONEN_PER_DAG = 100;
    int aantalStudenten = 0;
    int aantalDocenten = 0;
    int aantalKantineMedewerkers = 0;

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
     *
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
     *
     * @param lengte van het type int van de array.
     * @param min    van het type int.
     * @param max    van het type int.
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
     *
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
     *
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
     * Deze methode rond de getallen af, zodat de doubles goed worden weergegeven
     */
    private double rondAf(double afTeRonden) {
        return Math.round(afTeRonden * 100.0) / 100.0;
    }

    /**
     * Deze methode genereert het aantal bezoekers en hoe veel, van welk type bezoekers komen.
     */
    private void genereerKantineBezoekers() {
        int r = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG); // Maak hier de r aan van min personen per dag en max personen per dag.
        for (int i = 0; i < r; i++) {
            int nextInt = getRandomValue(0, 100);
            if (nextInt > 10) { // student met een kans van 1 op 89
                aantalStudenten++;
            } else if (nextInt > 0) { // docent met een kans van 1 op 10
                aantalDocenten++;
            } else { //kantinemedewerker met een kans van 1 op 100
                aantalKantineMedewerkers++;
            }
        }
    }


    /**
     * Deze methode reset de kantinebezoekers weer naar 0.
     */
    private void resetKantineBezoekers() {
        aantalStudenten = 0;
        aantalDocenten = 0;
        aantalKantineMedewerkers = 0;

    }


    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen het aantal dagen dat je de simulatie wilt runnen, type int.
     */
    public void simuleer(int dagen) {

        int[] verkochteAantalProducten = new int[dagen];
        double[] omzet = new double[dagen];
        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            //int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            genereerKantineBezoekers();
            int aantalpersonen = aantalStudenten + aantalDocenten + aantalKantineMedewerkers;
            // laat de personen maar komen...
            for (int j = 0; j < aantalStudenten; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Datum datumGeorge = new Datum(29, 10, 1970);
                Persoon george = new Student(12345, "George", "Harrison", datumGeorge, 'M', 12345, "SE");
                Dienblad dienbladGeorge = new Dienblad(george);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                // vind de artikelnamen op basis van
                // de indexen hierboven
                // artikelen, sluit aan
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienbladGeorge, artikelen);
                System.out.println(george.toString());

            }
            for (int j = 0; j < aantalDocenten; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Datum datumRingo = new Datum(29, 10, 1970);
                Persoon Ringo = new Docent(12345, "Ringo", "Starr", datumRingo, 'M', "STAR", "NSE");
                Dienblad dienbladRingo = new Dienblad(Ringo);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                // vind de artikelnamen op basis van
                // de indexen hierboven
                // artikelen, sluit aan
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienbladRingo, artikelen);
                System.out.println(Ringo.toString());

            }
            for (int j = 0; j < aantalKantineMedewerkers; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Datum datumPaul = new Datum(29, 10, 1970);
                Persoon Paul = new KantineMedewerker(12345, "Paul", "McCartney", datumPaul, 'M', 12345, false);
                Dienblad dienbladPaul = new Dienblad(Paul);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                // vind de artikelnamen op basis van
                // de indexen hierboven
                // artikelen, sluit aan
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienbladPaul, artikelen);
                System.out.println(Paul.toString());

            }
            kantine.verwerkRijVoorKassa(); //Hier maken wij een netjes bonnetje, ter verduideliking van de resultaten.
            System.out.println("#########################################");

            System.out.println(" ");
            System.out.println("Dag " + (i + 1));
            System.out.println("Dagtotalen : ");
            System.out.println("------------");
            System.out.println();
            System.out.println("Personen : " + aantalpersonen);
            System.out.println(aantalStudenten + " studenten");
            System.out.println(aantalDocenten + " docenten");
            System.out.println(aantalKantineMedewerkers + " kantine medewerkers");
            System.out.println("Artikelen : " + kantine.getKassa().aantalArtikelen());
            System.out.println("Geld: €" + rondAf(kantine.getKassa().hoeveelheidGeldInKassa()));
            System.out.println(" ");
            System.out.println("#########################################");
            verkochteAantalProducten[i] = kantine.getKassa().aantalArtikelen();
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            kantine.getKassa().resetKassa();
            resetKantineBezoekers();

            // verwerk rij voor de kassa
            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            // reset de kassa voor de volgende dag

        }
        System.out.println(); // Aan het einde, wordt de administratie geprint.
        System.out.println("Administratie: ");
        System.out.println();
        System.out.println("Gemiddelde verkochte aantal producten: ");
        System.out.println(rondAf(Administratie.berekenGemiddeldAantal(verkochteAantalProducten)));
        System.out.println("Gemiddelde omzet: ");
        System.out.println(rondAf(Administratie.berekenGemiddeldeOmzet(omzet)));
        System.out.println(printDagOmzet(omzet));
    }

    /**
     * Deze methode telt de omzet per dag bij de dag op.
     * @param DagenInWeekOmzet van het type double[].
     * @return een String met per dag, de omzet.
     */
    private String printDagOmzet(double[] DagenInWeekOmzet) {
        int i = 0;
        String dagOmzet = "Omzet per dag: \n";
        for (double value1 : Administratie.berekenDagOmzet(DagenInWeekOmzet)) {
            String[] weekdagen = {"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
            dagOmzet += weekdagen[i] + ": €" + rondAf(value1) + "\n";
            i++;
        }
        return dagOmzet;
    }
}
