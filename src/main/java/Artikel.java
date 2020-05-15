public class Artikel {
    private String naam;
    private float prijs;

    public Artikel(String naam, float prijs) {
        this.naam = naam;
        this.prijs = prijs;
}
    public Artikel() {
        this.naam = naam;
        this.prijs = prijs;

    }

    public String getNaam() {
        return naam;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }
}
