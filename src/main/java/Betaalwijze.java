/**
 * abstract class Betaalwijze - In deze overkoepelende klasse wordt een setsaldo en betaal methode gedefinieerd.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 06/06/2020.
 */
public abstract class Betaalwijze {

    protected double saldo;

    /**
     * Publieke Methode om krediet te initialiseren
     *
     * @param saldo die gezet wordt, type double.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Publieke Methode om betaling af te handelen
     * @throws TeWeinigGeldException wanneer er niet genoeg saldo is.
     * @param tebetalen het te betalen bedrag, type double.
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;

    /**
     * Publieke toString methode.
     * @return contant, wanneer er een instantie van contant is, anders Pinpas.
     */
    public String toString() {
        if (this instanceof Contant) {
            return "Contant";
        } else {
            return "Pinpas";
        }
    }
}
