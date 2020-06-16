/**
 * class Contant Deze klasse die Betaalwijze extend, regelt contante betalingen.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 06/06/2020.
 */
public class Contant extends Betaalwijze {

    /**
     * Deze publieke methode betaal regelt contante betalingen.
     *
     * @param tebetalen van het type double.
     * @throws TeWeinigGeldException regelt wanneer betalingen niet lukken.
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (tebetalen <= saldo) {
            saldo -= tebetalen;
        } else if (tebetalen > saldo) {
            throw new TeWeinigGeldException("Contant betalen niet gelukt, onvoldoende geld!");
        } else {
            throw new TeWeinigGeldException("Contant betalen niet gelukt!");
        }
    }
}