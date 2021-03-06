import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.*;


/**
 * class KantineSimulatie - Deze klasse is verantwoordelijk voor het simuleren van de kantine.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 24/05/2020.
 */
public class KantineSimulatie {

    //Dagen
    public static final int DAGEN = 7;
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;
    // artikelen
    private static final String[] artikelnamen =
            new String[]{"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"}; // Maak de artikelen aan.
    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 100;
    private static final int MAX_ARTIKELEN_PER_SOORT = 200;
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    private static final double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65}; // Prijzen per artikel.
    private static final String[] voornamenM = new String[]{"George", "Paul", "John", "Ringo"};
    private static final String[] voornamenV = new String[]{"Lady", "Alicia", "Katy", "Stevie"};
    private static final String[] achternamen = new String[]{"Harrison", "Mc Cartney", "Lennon", "Knicks", "GaGa", "Keys", "Perry", "Starr"};
    // kantine
    private final Kantine kantine;
    // kantineaanbod
    private final KantineAanbod kantineaanbod;
    // random generator
    private final Random random;
    // Personen
    int MIN_PERSONEN_PER_DAG = 50;
    int MAX_PERSONEN_PER_DAG = 100;
    int aantalStudenten = 0;
    int aantalDocenten = 0;
    int aantalKantineMedewerkers = 0;
    int aantalRandomPersonen;
    char geslacht;
    private EntityManager manager;
    private String voornaam;

    // ArrayList klanten
    private ArrayList<Persoon> klanten = new ArrayList<>();

    /**
     * Constructor voor de klasse KantinesSimulatie.
     */
    public KantineSimulatie() {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        kantine = new Kantine(manager);
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);

        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Publieke Main methode om de simulatie aan te roepen.
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
     * Private Methode om een array van random getallen liggend tussen min en max van de gegeven lengte, min en max te
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
     * Private Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min minimum van het type int.
     * @param max maximum van het type int.
     * @return Een random getal tussen de min en max.
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Private Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
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
     * Deze private methode rond de getallen af, zodat de doubles goed worden weergegeven
     *
     * @return de nieuwe, afgeronde waarde.
     */
    private double rondAf(double afTeRonden) {
        return Math.round(afTeRonden * 100.0) / 100.0;
    }

    /**
     * Deze Private methode genereert het aantal bezoekers en hoe veel, van welk type bezoekers komen.
     */
    private void genereerKantineBezoekers() {
        aantalRandomPersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG); // Maak hier de randomaantalpersonen aan van min personen per dag en max personen per dag.
        for (int i = 0; i < aantalRandomPersonen; i++) {
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
     * Deze private methode reset de kantinebezoekers weer naar 0.
     */
    private void resetKantineBezoekers() {
        aantalStudenten = 0;
        aantalDocenten = 0;
        aantalKantineMedewerkers = 0;
        klanten.clear(); //cleart de klanten ArrayList

    }


    /**
     * Deze publieke methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen het aantal dagen dat je de simulatie wilt runnen, type int.
     */
    public void simuleer(int dagen) {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();


        int[] verkochteAantalProducten = new int[dagen];
        double[] omzet = new double[dagen];
        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {
            //Kortings
            genereerKortings();
            // bedenk hoeveel personen vandaag binnen lopen
            genereerKantineBezoekers();
            int aantalpersonen = aantalStudenten + aantalDocenten + aantalKantineMedewerkers;
            // laat de personen maar komen...

            for (int j = 1; j <= aantalpersonen; j++) {
                int randomGeslacht = getRandomValue(0, 1);
                if (randomGeslacht == 0) {
                    geslacht = 'M';
                    voornaam = voornamenM[getRandomValue(0, voornamenM.length - 1)];
                } else {
                    geslacht = 'V';
                    voornaam = voornamenV[getRandomValue(0, voornamenM.length - 1)];
                }

                if (j <= aantalKantineMedewerkers) {

                    klanten.add(new KantineMedewerker(12345, voornaam, achternamen[getRandomValue(0, achternamen.length - 1)], LocalDate.of(1999, 9, 9), geslacht, 1, false)); // nieuwe random kantinemedewerker
                } else if (j <= aantalKantineMedewerkers + aantalDocenten) {
                    klanten.add(new Docent(12345, voornaam, achternamen[getRandomValue(0, achternamen.length - 1)], LocalDate.of(1989, 8, 8), geslacht, "Docent", "ICT")); //nieuwe random docent
                } else if (j <= aantalDocenten + aantalStudenten + aantalKantineMedewerkers) {
                    klanten.add(new Student(12345, voornaam, achternamen[getRandomValue(0, achternamen.length - 1)], LocalDate.of(1979, 7, 7), geslacht, 12345, "ICT")); //nieuwe random student
                }
            }

            for (Persoon klant : klanten) {
                Dienblad dienblad = new Dienblad(klant);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienblad, artikelen);
                int randomBetaalWijze = getRandomValue(0, 1); //random betaalwijze
                if (randomBetaalWijze == 0) {
                    klant.setBetaalwijze(new Contant());
                    klant.getBetaalwijze().setSaldo(getRandomValue(0, 50)); //random contant geld
                } else if (randomBetaalWijze == 1) {
                    klant.setBetaalwijze(new Pinpas(getRandomValue(0, 500))); //random kredietlimiet
                    klant.getBetaalwijze().setSaldo(getRandomValue(0, 250)); //random saldo
                }


            }
            kantine.verwerkRijVoorKassa(i); //Hier maken wij een bonnetje, ter verduideliking van de resultaten.
            System.out.println("#######################");
            System.out.println(" ");
            System.out.println("Dag " + (i + 1));
            System.out.println("Dagtotalen : ");
            System.out.println("------------");
            System.out.println();
            System.out.println("Personen : " + aantalpersonen);
            System.out.println(aantalStudenten + " studenten");
            System.out.println(aantalDocenten + " docenten");
            System.out.println(aantalKantineMedewerkers + " kantine medewerkers");
            //System.out.println("Totale artikelen : " + kantine.getKassa().aantalGepasseerdeArtikelen()); //Totale Artikelen
            System.out.println("Afgerekende artikelen : " + kantine.getKassa().aantalAfgerekendeArtikelen()); // Afgerekende Artikelen
            System.out.println("Omzet: €" + rondAf(kantine.getKassa().hoeveelheidGeldInKassa())); //Omzet
            System.out.println(" ");
            System.out.println("#######################");
            verkochteAantalProducten[i] = kantine.getKassa().aantalAfgerekendeArtikelen();
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            kantine.getKassa().resetKassa(); //Reset Kassa.

            resetKantineBezoekers(); //Reset kantinebezoekers.

        }
        // verwerk rij voor de kassa
        // druk de dagtotalen af en hoeveel personen binnen
        // zijn gekomen
        // reset de kassa voor de volgende dag

        System.out.println(); // Aan het einde, wordt de administratie geprint.
        System.out.println("Administratie: ");
        System.out.println();
        System.out.println("Gemiddelde verkochte aantal producten: ");
        System.out.println(rondAf(Administratie.berekenGemiddeldAantal(verkochteAantalProducten)));
        System.out.println("Gemiddelde omzet: ");
        System.out.println(rondAf(Administratie.berekenGemiddeldeOmzet(omzet)));
        System.out.println(printDagOmzet(omzet));
        System.out.println("Totale omzet, gevolgd door totale korting query: ");
        totaleOmzetenKorting();
        System.out.println("Gemiddelde omzet, gevolgd door gemiddelde korting query: ");
        gemiddeldeOmzet();
        System.out.println("Hoogste drie facturen: ");
        System.out.println("ID, gevolgd door totale bedrag");
        hoogsteDrieFacturen();
        System.out.println(" \n");
        getSumOmzetEnSumKortingPerArtikel("Koffie");
        getSumOmzetEnSumKortingPerArtikel("Broodje pindakaas");
        getSumOmzetEnSumKortingPerArtikel("Broodje kaas");
        getSumOmzetEnSumKortingPerArtikel("Appelsap");
        System.out.println(" ");
        ArrayList<Integer> hoogsteArtikelen = new ArrayList<Integer>();
        hoogsteArtikelen.add(hoogsteDrieArtikelen("Koffie"));
        hoogsteArtikelen.add(hoogsteDrieArtikelen("Broodje pindakaas"));
        hoogsteArtikelen.add(hoogsteDrieArtikelen("Broodje kaas"));
        hoogsteArtikelen.add(hoogsteDrieArtikelen("Appelsap"));
        Collections.sort(hoogsteArtikelen);
//        for(int teller: hoogsteArtikelen){
//            System.out.println(teller);
//        }
        System.out.println("Het meest verkochte artikel " + vindNaam(hoogsteArtikelen, 3) + " is " + hoogsteArtikelen.get(3) + " keer verkocht.");
        System.out.println("Vervolgens is " + vindNaam(hoogsteArtikelen, 2) + " "+ hoogsteArtikelen.get(2) + " keer verkocht");
        System.out.println("Als derde is " + vindNaam(hoogsteArtikelen, 1) + " " + hoogsteArtikelen.get(1) + " keer verkocht");
        System.out.println(" ");
        System.out.println("Hoogste drie artikelen: ");
        for (Object[] artikels : drieArtikelenHoogsteOmzet()){
            System.out.println(Arrays.toString(artikels));
        }
        System.out.println(" ");
        totaleEnToegepasteKortingPerDag(DAGEN);
        manager.close();
        ENTITY_MANAGER_FACTORY.close();

    }


    /**
     * Deze methode telt de omzet per dag bij de dag op.
     *
     * @param DagenInWeekOmzet van het type double[].
     * @return een String met per dag, de omzet.
     */
    private String printDagOmzet(double[] DagenInWeekOmzet) {
        int i = 0;
        StringBuilder dagOmzet = new StringBuilder("Omzet per dag: \n");
        for (double value1 : Administratie.berekenDagOmzet(DagenInWeekOmzet)) {
            String[] weekdagen = {"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
            dagOmzet.append(weekdagen[i]).append(": €").append(rondAf(value1)).append("\n");
            i++;
        }
        return dagOmzet.toString();

    }

    /**
     * Deze Private methode genereert de artikelen met korting.
     * Vervolgens wordt een nieuw kantineaanbod met de nieuwe arraylist gegenereerd.
     */
    private void genereerKortings() {
        int random = getRandomValue(1, 2); //1,2 niet alles in de aanbieding.
        //System.out.println("Zoveel artikelen kortings :"); //check
        Artikel artikel;
        for (int i = 0; i < random; i++) {
            int getal = getRandomValue(0, artikelnamen.length - 1);
            artikel = kantineaanbod.getArtikel(artikelnamen[getal]);
            artikel.setKorting(artikel.getPrijs() * 0.2);
            System.out.println(artikel.getNaam() + "  -  " + artikel.getKorting());
            ArrayList<Artikel> artikelenKortings = new ArrayList<>();
            for (int j = 0; j <= kantineaanbod.getArrayList(artikelnamen[getal]).size(); j++) {
                artikelenKortings.add(artikel);

            }
            kantineaanbod.aanbod.put(artikelnamen[getal], artikelenKortings);
            //System.out.println(count);
        }
    }

    /**
     * Toon totale omzet uit database
     */
    public void totaleOmzetenKorting() {
        Query query = manager.createQuery("SELECT sum(totaal), sum(korting) FROM Factuur factuur");
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(r -> System.out.println(Arrays.toString(r)));
    }

    /**
     * Toon gemiddelde omzet uit database
     */
    public void gemiddeldeOmzet() {
        Query query = manager.createQuery("SELECT avg(totaal), avg(korting) FROM Factuur factuur");
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(r -> System.out.println(Arrays.toString(r)));
    }

    /**
     * Toon totale omzet uit database
     */
    public void hoogsteDrieFacturen() {
        Query query = manager.createQuery("SELECT id, totaal FROM Factuur factuur ORDER BY factuur.totaal DESC").setMaxResults(3);
        List<Object[]> resultList = query.getResultList();

        resultList.forEach(r -> System.out.println(Arrays.toString(r)));
    }
    /**
     * Toon omzet en korting per atikel uit de database
     */
    public void getSumOmzetEnSumKortingPerArtikel(String artikel) {
        Query query = manager.createQuery("SELECT id FROM FactuurRegel where naam = '"+ artikel + "' and korting > 0");
        List<FactuurRegel> resultList = query.getResultList();
        double korting = resultList.size() * (kantineaanbod.getArtikel(artikel).getPrijs()  * 0.2);
        System.out.println("Korting op " + artikel + ": €" + korting);

        query = manager.createQuery("SELECT id FROM FactuurRegel where naam = '"+ artikel + "'");
        resultList = query.getResultList();
        System.out.println("Totaal verdiend met " + artikel + ": €" + resultList.size() * kantineaanbod.getArtikel(artikel).getPrijs());

    }
    /**
     * Toon omzet en korting per artikel, per dag
     */
    public void totaleEnToegepasteKortingPerDag(int dagen){
        for (int i = 0; i < dagen; i++) {
            System.out.println("Dag: " + LocalDate.now().plusDays(i));
            System.out.println("Artikelnaam, Totale omzet, Totale korting");
            Query query = manager
                    .createQuery("SELECT fr.artikel.naam, sum(fr.artikel.prijs), sum(fr.artikel.korting) FROM FactuurRegel fr JOIN fr.factuur f WHERE f.datum = '"+ LocalDate.now().plusDays(i)+ "'GROUP BY fr.artikel.naam ");
            query.setMaxResults(4);
            List<Object[]> resultList = query.getResultList();
            resultList.forEach(r -> System.out.println(Arrays.toString(r)));

        }
    }

    /**
     * Toon de count van een artikel
     * @param artikel, type String
     */
    public int hoogsteDrieArtikelen(String artikel) {
        Query query = manager.createQuery("SELECT new list (count(naam)) FROM FactuurRegel where naam = '"+ artikel +"'");
        Object resultList = query.getSingleResult();
        String count = resultList.toString();
        count = count.replace("[", "");
        count = count.replace("]", "");
        int countArtikel = Integer.parseInt(count);
        return countArtikel;
    }

    /**
     * Vind de naam die bij het artikel hoort
     * @param hoogsteArtikelen, i, Arraylist <Integer>
     *
     */
    public String vindNaam(ArrayList<Integer> hoogsteArtikelen, int i){
        String naam = "";
        if (hoogsteDrieArtikelen("Koffie") == hoogsteArtikelen.get(i)){
            naam = "Koffie";
        }
        else if (hoogsteDrieArtikelen("Broodje pindakaas") == hoogsteArtikelen.get(i)){
            naam = "Broodje pindakaas";
        }
        else if (hoogsteDrieArtikelen("Broodje kaas") == hoogsteArtikelen.get(i)){
            naam = "Broodje kaas";
        }
        else if (hoogsteDrieArtikelen("Appelsap") == hoogsteArtikelen.get(i)){
            naam = "Appelsap";
        }
        return naam;

    }

    /**
     * Vind de artikelen met de hoogste omzet
     * @return de artikelen met de hoogste omzet
     */
    public List<Object[]> drieArtikelenHoogsteOmzet() {
        Query query = manager
                .createQuery("SELECT artikel.naam, SUM(artikel.prijs - artikel.korting) FROM FactuurRegel GROUP BY artikel.naam ORDER BY SUM(artikel.prijs - artikel.korting) DESC");
        query.setMaxResults(3);
                return query.getResultList();
    }
}

