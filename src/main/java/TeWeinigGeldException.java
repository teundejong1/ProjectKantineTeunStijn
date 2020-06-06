import javax.swing.*;

public class TeWeinigGeldException extends Throwable {

    public TeWeinigGeldException() { //Lege TeWeinigGeldException
    }

    public TeWeinigGeldException(Exception e) { //Exception e
    }

    public TeWeinigGeldException(String message) { //String message TeWeinigGeldException. Deze wordt gebruikt.
        JOptionPane.showMessageDialog(null, message, "Kassa error", JOptionPane.ERROR_MESSAGE); //De errormelding bij een niet geslaagde betaling.
        System.out.println("Betaling niet gelukt");
    }
}
