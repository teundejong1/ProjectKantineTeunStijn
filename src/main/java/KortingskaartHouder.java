public interface KortingskaartHouder { //Interface

    /**
     * Publieke Methode om kortingspercentage op te vragen
     */
    double geefKortingsPercentage();

    /**
     * Publieke Methode om op te vragen of er maximum per keer aan de korting zit
     */
    boolean heeftMaximum();

    /**
     * Publieke Methode om het maximum kortingsbedrag op te vragen
     */
    double geefMaximum();
}
