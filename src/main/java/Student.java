/**
 * class Student - Deze klasse is voor de klant student.
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 03/06/2020.
 */
public class Student extends Persoon {
    private int studentnummer;
    private String studierichting;
    /**
     * Constructor van de klasse student.
     * @param bsn van de student.
     * @param voornaam van de student.
     * @param achternaam van de student.
     * @param geboortedatum van de student.
     * @param geslacht van de student.
     * @param studentnummer van de student
     * @param studierichting van de student.
     */
    public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentnummer, String studierichting) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    /**
     * Lege constructor voor klasse Student.
     */
    public Student() {
    }

    /**
     * Publieke Getter voor het studentnummer van de student.
     *
     * @return studentnummer van de student
     */
    public int getStudentnummer() {
        return studentnummer;
    }

    /**
     * Publieke Getter voor de studierichting van de student.
     * @return studierichting van student.
     */
    public String getStudierichting() {
        return studierichting;
    }

    /**
     * Publieke Setter voor het studentnummer van de student
     * @param studentnummer van de student.
     */
    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    /**
     * Publieke setter voor de studierichting van de student.
     * @param studierichting van de student.
     */
    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
