import javax.swing.*;

/**
 * class TeWeinigGeldException  - Deze klasse is verantwoordelijk voor de te weinig geld exception
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 10/06/2020
 */
public class TeWeinigGeldException extends Throwable {

    /**
     * lege constructor voor de klasse TeWeinigGeldException
     */
    public TeWeinigGeldException() { //Lege TeWeinigGeldException
    }

    /**
     * Constructor voor de klasse TeWeinigGeldException
     *
     * @param e, type exception.
     */
    public TeWeinigGeldException(Exception e) { //Exception e
    }

    /**
     * Constructor voor de klasse TeWeinigGeldException
     *
     * @param message, type String.
     */
    public TeWeinigGeldException(String message) { //String message TeWeinigGeldException. Deze wordt gebruikt.
        //JOptionPane.showMessageDialog(null, message, "Kassa error", JOptionPane.ERROR_MESSAGE); //De errormelding bij een niet geslaagde betaling.
        System.out.println("Betaling niet gelukt");
    }
}
