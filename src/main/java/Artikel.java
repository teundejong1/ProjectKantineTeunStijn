public class Artikel {
    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs) {
        setNaam(naam);
        setPrijs(prijs);
}
    public Artikel() {
        naam = "Nader te bepalen naam";
        prijs = 0;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString(){//overriding the toString() method
        return naam+" "+prijs;
    }

}
