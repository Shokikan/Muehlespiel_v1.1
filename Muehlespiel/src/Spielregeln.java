public class Spielregeln {

    Spieler player = new Spieler(0, 0);
    Spieler spieler1 = new Spieler(1, 0);
    Spieler spieler2 = new Spieler(2, 0);

    public Spieler wechslespieler() {
        if (player.equals(spieler1)) {
            player = spieler1;
            return player;
        } else {
            player = spieler2;
            return player;
        }
    }
    
    public int setzPhase() {
        do {
            if (player.getSpielerNummer() == 1) {
                return 1;
            } else {
                return 2;
            }
        } while (player.getanzSteine() < player.getmaxAnzSteine());
    }
}
