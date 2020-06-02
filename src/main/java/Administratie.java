public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    private Administratie() {
    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */


    public static double berekenGemiddeldAantal(int[] aantal) {

        double totaal = 0;
        if (aantal.length == 0) {
            return 0;
        } else {
            for (int value : aantal) {
                totaal += value;
            }
            return totaal / aantal.length;
        }
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        if (omzet.length == 0) {
            return 0;
        } else {
            for (double v : omzet) {
                totaal += v;
            }
            return totaal / omzet.length;
        }
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {

        double[] temp = new double[DAYS_IN_WEEK];

        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while (j < omzet.length) {
                if (i == j % DAYS_IN_WEEK) {
                    temp[i] += omzet[j];
                }
                j++;
            }
        }
        return temp;
    }


}
