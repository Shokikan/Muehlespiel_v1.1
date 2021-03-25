public class Spieler {

    private int SpielerNummer;
    private int anzSteine;
    private int maxAnzSteine = 9;

    public Spieler(int SpielerNummer, int anzSteine) {
        this.SpielerNummer = SpielerNummer;
        this.anzSteine = anzSteine;
    }

    public int getSpielerNummer() {
        return SpielerNummer;
    }

    public void setanzSteine(int anzSteine) {
        this.anzSteine = anzSteine;
    }

    public int getanzSteine() {
        return anzSteine;
    }

    public int getmaxAnzSteine() {
        return maxAnzSteine;
    }

    public void setzPhase() {
        if (anzSteine > 9){
            zugPhase();
        }
    }

    public void schiebePhase () {
         
    }


    public void sprungPhase() {
        if (anzSteine < 3) {
            System.out.println("Sie haben verloren.");
        }
    }

    public void zugPhase() {
        if (anzSteine > 3) {
            schiebePhase();
        } else if (anzSteine == 3) {
            sprungPhase();
        } else {
            System.out.println("Verloren");
        }

    }
}
