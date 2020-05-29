public class KantineMedewerker extends Persoon {
    private int medewerkersnummer;
    private boolean toestaanKasasa;

    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersnummer, boolean toestaanKasasa) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.toestaanKasasa = toestaanKasasa;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isToestaanKasasa() {
        return toestaanKasasa;
    }

    public void setToestaanKasasa(boolean toestaanKasasa) {
        this.toestaanKasasa = toestaanKasasa;
    }
}
