import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FXMLController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    // Sämtliche Variablen werden im voraus initialisiert
    @FXML
    private Spieler currentPlayer;
    private Spieler Player1;
    private Spieler Player2;
    private Boolean[] hmill = new Boolean[9];
    private Boolean[] vmill = new Boolean[9];
    private String pid;
    private String lastpid;
    private String remove = "removetoken";
    private String move = "move";
    private String jump = "jump";
    private Boolean muehle = false;
    private Boolean exit = false;
    private String fillcolor;
    private String colorgrey = "#808080";
    private String colorbeige = "#F5F5DC";
    private String colortransparent = "#00000000";
    private int notokens = 0;
    private int counter = 0;

    FXMLAlerts al = new FXMLAlerts();
    HashMaps Hm = new HashMaps();
    

    // Hier werden einige Hashmaps initialisiert
    HashMap<String, Circle> testhash = new HashMap<String, Circle>();
    HashMap<String, Boolean> hmillhash = new HashMap<String, Boolean>();
    HashMap<String, Boolean> vmillhash = new HashMap<String, Boolean>();

    // Alle Kreise haben eine eigene ID, die ID ist wichtig für überprüfungne der Mühlen
    @FXML private Circle circ1;
    @FXML private Circle circ2;
    @FXML private Circle circ3;
    @FXML private Circle circ4;
    @FXML private Circle circ5;
    @FXML private Circle circ6;
    @FXML private Circle circ7;
    @FXML private Circle circ8;
    @FXML private Circle circ9;
    @FXML private Circle circ10;
    @FXML private Circle circ11;
    @FXML private Circle circ12;
    @FXML private Circle circ13;
    @FXML private Circle circ14;
    @FXML private Circle circ15;
    @FXML private Circle circ16;
    @FXML private Circle circ17;
    @FXML private Circle circ18;
    @FXML private Circle circ19;
    @FXML private Circle circ20;
    @FXML private Circle circ21;
    @FXML private Circle circ22;
    @FXML private Circle circ23;
    @FXML private Circle circ24;
    @FXML private Circle circ25;

    @FXML
    private Pane pae; // Dieser Pane dient als Hilfe für die Id des geklickten Feldes

    // Hier werden die Labels initialisiert 
    @FXML private Label labelcp;
    @FXML private Label lblp1;
    @FXML private Label lblp2;
    @FXML private Label lblp1t;
    @FXML private Label lblp1z;
    @FXML private Label lblp2t;
    @FXML private Label lblp2z;
    @FXML private Label lblzuege;

    
    // Mit einem Mausklick werden sämtliche Methoden überprüft.

    @FXML
    void manageMouseClicked(MouseEvent event) {

        // Hier werden alle hashmaps initialisiert und noch default Werte angegeben.
        if(counter == 0) {
            setmillfalse();
            TestHashMap();
            Hm.VHashMap();
            Hm.HHashMap();
            HMillStatusHashMap();
            VMillStatusHashMap();
            circ25.setFill(Color.valueOf(colorbeige));
        }

        counter += 1; // Counter wird benutzt um die Hashmaps einmal zu initialisieren.

        /*  Dieser Teil wurde benutzt um die Verarbeitung einiger Daten zu überprüfen.
        System.out.println("Counter: " + counter);
        System.out.println("Who is current player: " + currentPlayer.getSpielerNummer());
        System.out.println("Player1 amount of tokens: " + Player1.getanzSteine());
        System.out.println("Player2 amount of tokens: " + Player2.getanzSteine());
        System.out.println("The fillcolor is: " + fillcolor);
        
        for(int m = 0; m < 9; m++){
            System.out.print(vmill[m] + " ");
        }
        System.out.println();
        for(int n = 0; n < 9; n++){
            System.out.print(hmill[n] + " ");
        }
        System.out.println();
        
        Dieser Teil wurde benutzt zur Überprüfung wo eine Mühle ist und wo nicht.
        */

        // Die Variable pid erhält die ID des feldes, dies ist sehr wichtig für die Überprüfungen des Feldes.
        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);
        

        if(currentPlayer.getplayerInstance().equals(remove)) { // Es wird überprüft ob der Status des Spielers remove ist, dass heisst ob er ein Stein entfernen kann. In diesem Abschnitt wird der Spieler dem Gegener einen Stein wegnehmen können.
            if(!testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) { // Überprüfung ob das Feld kein Stein enthält
                if((hmillhash.get(pid).equals(false))&&(vmillhash.get(pid).equals(false))) { // Überprüfung ob der Stein in diesem Feld sich in keine Mühle(vertikal oder horizontal) befinden 
                    deleteToken();
                    zugzaehler();
                    muehle=false;
                    removeplayerinstance();
                    changePlayer();
                    setcirc25();
                    setlabelcp();
                    reducetoken();
                    System.out.println("Removed opponents token!");
                }else if(notokens==5) { // Falls kein Stein entfernt werden konnte nach fünf Versuchen wird der Spieler gewechselt
                    System.out.println("No available tokens to take, changing Player!");
                    al.notoken();
                    zugzaehler();
                    removeplayerinstance();
                    changePlayer();
                    setcirc25();
                    setlabelcp();
                }else{ // Dies tritt ein Wenn der Spieler versucht einen Stein in einer Mühle zu entfernen. Es wird noch ein Alert ausgegeben und die Variable notokens wird um 1 erhöht.
                    System.out.println("You can't remove tokens in a mill!");
                    al.cantremove();
                    System.out.println(hmillhash.get(pid));
                    System.out.println(vmillhash.get(pid));
                    notokens += 1;
                    return;
                }
            }else{
                return;
            }
            
        }else if(currentPlayer.getplayerInstance().equals(move)) { // Hier wir überprüft ob der Spieler die Instanz move hat. Dies ist die Zugphase.
            System.out.println("Last pid: " + lastpid);
            if(!pid.equals(lastpid)) { // Es wird überprüft ob es bei diesem Zug um den gleichen Spielfeld handelt.
                if(testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) { // Es wird überprüft ob ein Stein im Spielfeld ist.
                    undomillswitch();
                    if(exit.equals(false)){ // Überprüfung ob dieser Zug gültig ist.
                        settoken();
                        checkpane();
                        if(muehle!=true) { // Ein Check ob eine Mühle entstanden ist bei diesem Zug.
                            zugzaehler();
                            removeplayerinstance();
                            changePlayer();
                            setcirc25();
                            setlabelcp();
                        }else{
                            System.out.println("Setting player instance to remove!"); // Wenn eine Mühle entstanden ist wird dem Spieler die Insanz remove gegeben
                            millalert();
                            setplayerinstanceremove();
                            return;
                        }
                    }else{
                        System.out.println("Token is too far away, you can't jump yet!");
                        al.cantjump();
                        exit = false;
                        return;
                    }
                }else{
                    System.out.println("There is already a token in this field!");
                    al.alreadytoken();
                    return;
                }
            }else{
                System.out.println("Can't set token on same spot!");
                al.samespot();
                return;
            }
        }else if(currentPlayer.getplayerInstance().equals(jump)) { // Überprüfung ob der Spieler die Instanz jump hat. Dies ist die Sprungphase.
            if(!pid.equals(lastpid)) { // Hier auch wieder ob das Feld die gleiche ist wie das letzte Feld
                if(testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) { // Überprüfung ob das Feld kein Stein enthält
                    undomilljump();
                    settoken();        
                    checkpane();
                    if(muehle!=true) { // Überprüfung ob eine Mühle entstanden ist.
                        zugzaehler();
                        removeplayerinstance();
                        changePlayer();
                        setcirc25();
                        setlabelcp();
                    }else{ // Dies tritt ein wenn eine Mühle entstanden ist.
                        System.out.println("Setting player instance to remove!");
                        millalert();
                        setplayerinstanceremove();
                        return;
                    }
                }else{
                    System.out.println("There is already a token in this field!");
                    al.alreadytoken();
                    return;
                }
            }else{
                System.out.println("Can't place token on the same spot!");
                al.samespot();
                return;
            }
        }else{
            if(currentPlayer.getanzZuege()<9) { // Überprüfung ob der Spieler weniger als 9 Züge gemacht hat. Dies ist die Setztphase
                if(testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) { // Hier auch wieder Überprüfung ob das Feld kein Stein enthält
                    settoken();
                    checkpane();
                    setplayerinstanceremove();
                    increasetoken();
                    if(muehle!=true) { // Überprüfung ob keine Mühle entstanden ist.
                        zugzaehler();
                        changePlayer();
                        setcirc25();
                        setlabelcp();
                    }else{ // Wenn keine Mühle entstanden ist wird dies durch geführt.
                        millalert();
                        return;
                    }
                }else{
                    System.out.println("There is already a token in this field!");
                    al.alreadytoken();
                    return;
                }
            }else if(currentPlayer.getanzSteine()==3) { // Wenn der Spieler nur noch 3 Steine hat, wird dieser in die Sprungphase versetzt.
                if(!testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) {
                    lastpid = pid;
                    deleteToken3();
                    System.out.println("Current player incance is: " + currentPlayer.getplayerInstance());
                }else{
                    return;
                }
            }else if(currentPlayer.getanzSteine()<3) { // Wenn der Spieler weniger wie 3 Steine hat, hat der andere Spieler gewonnen. Es taucht ein Alert auf, dass der andere Spieler gewonnen hat.
                won();
                if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
                    System.out.println("Player 1 has lost the game!");
                }else{
                    System.out.println("Player 2 has lost the game!");
                }
                
            }else{
                if(!testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) { // Wenn keines der Verzweigungen übereinstimmt kommen wir hier in die Zugphase. Hier wird der Stein den man bewegen will entfernt um es beim nächsten Click wieder setzten.
                    lastpid = pid;
                    deleteToken2();
                    System.out.println("Current player instance is: " + currentPlayer.getplayerInstance());
                }else{
                    return;
                }
                
            }
        }
        HMillStatusHashMap();
        VMillStatusHashMap();
        lblzuege.setText("Gesamt Anzahl Züge: " + (Player1.getanzZuege()+Player2.getanzZuege())); // Hier werden die GesamtanzahlZüge berechnet und wiedergegen als ein Label in der Gui
    }

    // In der Gui Zeigt dieses Label an welcher Spieler am Zug ist.
    private void setlabelcp() {
        labelcp.setText("Atueller Spieler ist: " + currentPlayer.getSpielerNummer());
    }

    // Diese Methode überprüft welcher Spieler am Zug ist und wird dem entsprechend den Alert Ausgeben
    private void millalert() {
        if(currentPlayer.getSpielerNummer()==1){
            al.p1millalert();
        }else{
            al.p2millalert();
        }
    }

    // Diese Methode macht das gleiche wie die letzte Methode, es überprüft welcher Spieler dran ist und wird dem entsprechen den Alert Ausgeben.
    private void won() {
        if(Player1.getanzSteine()<3) {
            al.p1won();
        }else{
            al.p2won();
        }
    }

    // Bei dieser Methode handelt es sich um den Circle ganz oben in der GUI, neben dem Label mit dem aktuellen Spieler zeigt es die Farbe des aktuellen Spielers an.
    private void setcirc25() {
        if(currentPlayer.getSpielerNummer()==1){
            circ25.setFill(Color.valueOf(colorbeige));
        }else{
            circ25.setFill(Color.valueOf(colorgrey));
        }
    }

    // Diese Methode setzt die Instanz des Spielers auf remove, damit die Removephase durchgeführt werden kann.
    private void setplayerinstanceremove() {
        if(muehle==true) {
            currentPlayer.setplayerInstance("removetoken");
        }else{
        }
    }

    // Diese Methode setzt den Spielerinstanz auf move
    private void setplayerinstancemove() {
        currentPlayer.setplayerInstance(move);
    }

    // Diese Methode setzt den Spielerinstanz auf jump
    private void setplayerinstancejump() {
        currentPlayer.setplayerInstance(jump);
    }

    /*  Dies ist die erste deleteToken Methode. Sie wird benutzt für das Entfernen der Steine des Gegners anch einer Mühle.
        Als erstes wird Überprüft ob der Stein den man wegnehmen will nicht die selbe Farbe hat
        wie den Stein den man setzen möchte. Ist dies nicht der Fall wird der Kreis transparent gemacht.
        Was man nicht kann, ist den eigenen Stein Entfernen, ein Stein von einer Mühle entfenen oder kein Stein entfernen 
        ausser es gibt nichts zu entfernen
    */
    public void deleteToken() {
        if(!testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {    
            testhash.get(pid).setFill(Color.valueOf(colortransparent));
        }else if(testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {
            System.out.println("You can't remove your own token!");
            return;
        }else{
            System.out.println("Here is no token to be removed!");
            return;
        }
    }

    /*  Dieses deleteToken wird für die Setzphase benötig um den eigenen Stein zu entfernen um es an einem anderen Ort zu setzten.
        Es ist ähnlich aufgebaut wie deleteToken nur wird hier noch den Spielerinstanz entfernt wenn der if nicht wahr ist.
    */
    private void deleteToken2() {
        if(!testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {    
            testhash.get(pid).setFill(Color.valueOf(colortransparent));
            setplayerinstancemove();
        }else if(testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {
            System.out.println("You can't remove your opponents token!");
            removeplayerinstance();
            return;
        }else{
            System.out.println("Here is no token to be removed!");
            removeplayerinstance();
            return;
        }
    }

    /*  Es ist das gleiche wie deleteToken2 nur wird hier der Spielerinstanz auf jump gesetzt.
    */
    private void deleteToken3() {
        if(!testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {    
            testhash.get(pid).setFill(Color.valueOf(colortransparent));
            setplayerinstancejump();
        }else if(testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {
            System.out.println("You can't remove your opponents token!");
            removeplayerinstance();
            return;
        }else{
            System.out.println("Here is no token to be removed!");
            removeplayerinstance();
            return;
        }
        return;
    }

    /* Diese Methode wird benutzt für die Öffnung einer Mühle. Hier wird die Mühle welches mit diesem Feld verbunden ist auf false gestellt. 
    Dies wird für die horizontale Mühlen durchgeführt.
    */
    private void hundomill() {
        int x = 1;
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 4; j++) {
                if(Hm.Hhash.get(x).equals(lastpid)) {
                    hmill[i] = false;
                    System.out.println("Undo mill at: " + i + " horizontal.");
                }else{
                    System.out.println("Undo mill failed!");
                }
                x++;
            }
        }
    }

    // Hier wird ebenfalls die Mühle welches mit dem Feld verbunden ist auf false gestellt. Dies wird für die vertikale Mühlen durchgeführt um die Mühle zu öffnen.
    private void vundomill() {        
        int x = 1;
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 4; j++) {
                if(Hm.Vhash.get(x).equals(lastpid)) {
                    vmill[i] = false;
                    System.out.println("Undo mill at: " + i + " vertical.");
                }else{
                    System.out.println("Undo mill failed!");
                }
                x++;
            }
        }
    }

    // Diese Methode überprüft ob der Wert in dem hmillhash Hashmap übereinstimmt mit true. Falls dies wahr ist wird hundo durchgeführt.
    private void hundo(){
        if(hmillhash.get(lastpid).equals(true)) {
            hundomill();
        }else{
            System.out.println("Failed!");
        }
    }

    // Diese Methode ist das gleiche wie hundo einfach für die vertikalen Mühlen.
    private void vundo(){
        if(vmillhash.get(lastpid).equals(true)) {
            vundomill();
        }else{
            System.out.println("Failed!");
        }
    }

    // Die Methode ist für die Sprungphase gemacht. Für wenn eine Mühle geöffnet wird. 
    private void undomilljump() {
        if(vmillhash.get(lastpid).equals(true)) {
            vundomill();
        }else if(hmillhash.get(lastpid).equals(true)) {
            hundomill();
        }else{
            return;
        }
        return;
    }

    // Diese Methode setzt alle Werte in diesem Array auf false.
    public void setmillfalse() {
        for(int i = 1; i <= 8; i++){
            hmill[i] = false;
            vmill[i] = false;
        }
    }

    /*  Dies ist die Methode die benötigt wird um Steine zu setzten. Dies gilt für die Setztphase, Zugphase und Sprungphase.
        Als erstes wird überprüft um welchen Spieler es sich handelt und danach wird die Farbe des Spielers gesetzt
    */
    private void settoken() {
        if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
            testhash.get(pid).setFill(Color.valueOf(colorbeige));
            fillcolor = colorbeige;
            System.out.println("Player1 sets token on field " + testhash.get(pid));
        }else{
            testhash.get(pid).setFill(Color.valueOf(colorgrey));
            fillcolor = colorgrey;
            System.out.println("Player2 sets token on field " + testhash.get(pid));
        }
    }

    // Diese Methode wird benötigt um die Steinzähler des Spielers zu reduzieren, wenn dieser ein Stein verliert.
    private void reducetoken() {
        if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
            Player1.setanzSteine(Player1.getanzSteine()-1);
            lblp1t.setText("Anzahl Steine: " + Player1.getanzSteine());
        }else{
            Player2.setanzSteine(Player2.getanzSteine()-1);
            lblp2t.setText("Anzahl Steine: " + Player2.getanzSteine());
        }
    }

    // Diese Methode ist das Gegenteil von reducetoken. Sie wird benötigt um den Steinzähler zu erhöhen wenn der Spieler ein stein gesetzt hat in der Setztphase.
    private void increasetoken() {
        if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
            Player1.setanzSteine(Player1.getanzSteine()+1);
            lblp1t.setText("Anzahl Steine: " + Player1.getanzSteine());
        }else{
            Player2.setanzSteine(Player2.getanzSteine()+1);
            lblp2t.setText("Anzahl Steine: " + Player2.getanzSteine());
        }
    }
    
    // Initialisierung vom Objekt Spieler und Labels
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPlayer = new Spieler(1, 0, 0, " ");
        Player1 = new Spieler(1, 0, 0, " ");
        Player2 = new Spieler(2, 0, 0, " ");
        labelcp.setText("Aktueller spieler ist: ");
        lblp1.setText("Spieler 1");
        lblp1t.setText("Anzahl Steine: ");
        lblp1z.setText("Anzahl Züge: ");
        lblp2.setText("Spieler 2");
        lblp2t.setText("Anzahl Steine: ");
        lblp2z.setText("anzahl Züge: ");
        lblzuege.setText("Gesamt anzahl Züge: ");
    }

    // Dies ist der Zugzähler. Dieser zählt die Züge eines Spielers und muss bei jeder Phase vorkommen. Dies ist auch noch mit den Labels verküpft in der Gui.
    private int zugzaehler() {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            Player1.setanzZuege(Player1.getanzZuege() + 1);
            System.out.println("Player1 anzahl Züge: " + Player1.getanzZuege());
            lblp1z.setText("Anzahl Züge: " + Player1.getanzZuege());
            return Player1.getanzZuege();
        } else {
            Player2.setanzZuege(Player2.getanzZuege() + 1);
            System.out.println("Player2 anzahl Züge: " + Player2.getanzZuege());
            lblp2z.setText("Anzahl Züge: " + Player2.getanzZuege());
            return Player2.getanzZuege();
        }
    }

    //  Diese Methode wechselt den Spieler.
    private int changePlayer() {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            currentPlayer = Player2;
            return currentPlayer.getSpielerNummer();
        } else {
            currentPlayer = Player1;
            return currentPlayer.getSpielerNummer();
        }
    }

    //  Diese Methode wird am Anfang initialisiert und setzt einen leeren String.
    private void removeplayerinstance() {
        currentPlayer.setplayerInstance(" ");
        Player1.setplayerInstance(" ");
        Player2.setplayerInstance(" ");
    }

    /*  Dies ist der Switchcase, jede Methode ist für jedes Feld im Gridpane. Diese Methoden dienen dazu um herauszufinden ob sich
        horizontal oder vertikal die gleichen Steine befinden. Falls dies der Fall ist wird die Mühle auf war gesetzt. Folgende Variablen
        werden auf wahr gesetzt: hmill/vmill und muehle.
    */
    private void checkpane() {
        switch (pid) {
            case "1":
                checkmill1();
                break;
        
            case "2":
                checkmill2();
                break;
            
            case "3":
                checkmill3();
                break;

            case "4":
                checkmill4();
                break;

            case "5":
                checkmill5();
                break;

            case "6":
                checkmill6();
                break;

            case "7":
                checkmill7();
                break;

            case "8":
                checkmill8();
                break;

            case "9":
                checkmill9();
                break;

            case "10":
                checkmill10();
                break;

            case "11":
                checkmill11();
                break;

            case "12":
                checkmill12();
                break;

            case "13":
                checkmill13();
                break;

            case "14":
                checkmill14();
                break;

            case "15":
                checkmill15();
                break;

            case "16":
                checkmill16();
                break;

            case "17":
                checkmill17();
                break;

            case "18":
                checkmill18();
                break;

            case "19":
                checkmill19();
                break;

            case "20":
                checkmill20();
                break;

            case "21":
                checkmill21();
                break;

            case "22":
                checkmill22();
                break;

            case "23":
                checkmill23();
                break;

            case "24":
                checkmill24();
                break;
        }
    }

    /*  Dies ist eine zweite Case, diese überprüft ober der Spieler seinen Stein bei der Zugphase zu weit setzen will.
        Wenn dies der Fall ist gibt es eine Meldung aus und der Spieler muss sich eine neu Position aussuchen, dass
        nicht so weit weg ist vom Ausgangspunkt. Jedes Case steht für einen Feld (Eckpunkt/Schnittpunkt) auf dem Mühlespielfeld. */
    private void undomillswitch() {
        switch (lastpid) {
            case "1":
                if(pid.equals("2")){
                    vundo();
                }else if(pid.equals("10")){
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;
        
            case "2":
                if(pid.equals("1")){
                    vundo();
                }else if(pid.equals("5")){
                    hundo();
                }else if(pid.equals("3")){
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "3":
                if(pid.equals("2")){
                    vundo();
                }else if(pid.equals("15")){
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;
            
            case "4":
                if(pid.equals("5")){
                    vundo();
                }else if(pid.equals("11")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "5":
                if(pid.equals("2")){
                    hundo();
                }else if(pid.equals("4")) {
                    vundo();
                }else if(pid.equals("6")) {
                    vundo();
                }else if(pid.equals("8")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;
                    
            case "6":
                if(pid.equals("5")) {
                    vundo();
                }else if(pid.equals("14")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;
            
            case "7":
                if(pid.equals("8")) {
                    vundo();
                }else if(pid.equals("12")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "8":
                if(pid.equals("5")) {
                    hundo();
                }else if(pid.equals("7")) {
                    vundo();
                }else if(pid.equals("9")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "9":
                if(pid.equals("8")) {
                    vundo();
                }else if(pid.equals("13")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "10":
                if(pid.equals("1")) {
                    hundo();
                }else if(pid.equals("11")) {
                    vundo();
                }else if(pid.equals("22")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "11":
                if(pid.equals("4")) {
                    hundo();
                }else if(pid.equals("10")) {
                    vundo();
                }else if(pid.equals("12")) {
                    vundo();
                }else if(pid.equals("19")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "12":
                if(pid.equals("7")) {
                    hundo();
                }else if(pid.equals("11")) {
                    vundo();
                }else if(pid.equals("16")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "13":
                if(pid.equals("9")) {
                    hundo();
                }else if(pid.equals("14")) {
                    vundo();
                }else if(pid.equals("18")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "14":
                if(pid.equals("6")) {
                    hundo();
                }else if(pid.equals("13")) {
                    vundo();
                }else if(pid.equals("15")) {
                    vundo();
                }else if(pid.equals("21")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "15":
                if(pid.equals("3")) {
                    hundo();
                }else if(pid.equals("14")) {
                    vundo();
                }else if(pid.equals("24")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "16":
                if(pid.equals("12")) {
                    hundo();
                }else if(pid.equals("17")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "17":
                if(pid.equals("16")) {
                    vundo();
                }else if(pid.equals("18")) {
                    vundo();
                }else if(pid.equals("20")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "18":
                if(pid.equals("13")) {
                    hundo();
                }else if(pid.equals("17")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "19":
                if(pid.equals("11")) {
                    hundo();
                }else if(pid.equals("20")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "20":
                if(pid.equals("17")) {
                    hundo();
                }else if(pid.equals("19")) {
                    vundo();
                }else if(pid.equals("21")) {
                    vundo();
                }else if(pid.equals("23")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "21":
                if(pid.equals("14")) {
                    hundo();
                }else if(pid.equals("20")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "22":
                if(pid.equals("10")) {
                    hundo();
                }else if(pid.equals("23")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "23":
                if(pid.equals("20")) {
                    hundo();
                }else if(pid.equals("22")) {
                    vundo();
                }else if(pid.equals("24")) {
                    vundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;

            case "24":
                if(pid.equals("23")) {
                    vundo();
                }else if(pid.equals("15")) {
                    hundo();
                }else{
                    System.out.println("Token is too far away, you can't jump yet!");
                    exit=true;
                    return;
                }
                break;


        }
    }

    public void TestHashMap() {
        testhash.put("1", circ1);
        testhash.put("2", circ2);
        testhash.put("3", circ3);
        testhash.put("4", circ4);
        testhash.put("5", circ5);
        testhash.put("6", circ6);
        testhash.put("7", circ7);
        testhash.put("8", circ8);
        testhash.put("9", circ9);
        testhash.put("10", circ10);
        testhash.put("11", circ11);
        testhash.put("12", circ12);
        testhash.put("13", circ13);
        testhash.put("14", circ14);
        testhash.put("15", circ15);
        testhash.put("16", circ16);
        testhash.put("17", circ17);
        testhash.put("18", circ18);
        testhash.put("19", circ19);
        testhash.put("20", circ20);
        testhash.put("21", circ21);
        testhash.put("22", circ22);
        testhash.put("23", circ23);
        testhash.put("24", circ24);
    }

    

    public void HMillStatusHashMap() {
        hmillhash.put("1", hmill[1]);
        hmillhash.put("2", hmill[1]);
        hmillhash.put("3", hmill[1]);
        hmillhash.put("4", hmill[2]);
        hmillhash.put("5", hmill[2]);
        hmillhash.put("6", hmill[2]);
        hmillhash.put("7", hmill[3]);
        hmillhash.put("8", hmill[3]);
        hmillhash.put("9", hmill[3]);
        hmillhash.put("10", hmill[4]);
        hmillhash.put("11", hmill[4]);
        hmillhash.put("12", hmill[4]);
        hmillhash.put("13", hmill[5]);
        hmillhash.put("14", hmill[5]);
        hmillhash.put("15", hmill[5]);
        hmillhash.put("16", hmill[6]);
        hmillhash.put("17", hmill[6]);
        hmillhash.put("18", hmill[6]);
        hmillhash.put("19", hmill[7]);
        hmillhash.put("20", hmill[7]);
        hmillhash.put("21", hmill[7]);
        hmillhash.put("22", hmill[8]);
        hmillhash.put("23", hmill[8]);
        hmillhash.put("24", hmill[8]);
    }

    public void VMillStatusHashMap() {
        vmillhash.put("1", vmill[1]);
        vmillhash.put("2", vmill[4]);
        vmillhash.put("3", vmill[8]);
        vmillhash.put("4", vmill[2]);
        vmillhash.put("5", vmill[4]);
        vmillhash.put("6", vmill[7]);
        vmillhash.put("7", vmill[3]);
        vmillhash.put("8", vmill[4]);
        vmillhash.put("9", vmill[6]);
        vmillhash.put("10", vmill[1]);
        vmillhash.put("11", vmill[2]);
        vmillhash.put("12", vmill[3]);
        vmillhash.put("13", vmill[6]);
        vmillhash.put("14", vmill[7]);
        vmillhash.put("15", vmill[8]);
        vmillhash.put("16", vmill[3]);
        vmillhash.put("17", vmill[5]);
        vmillhash.put("18", vmill[6]);
        vmillhash.put("19", vmill[2]);
        vmillhash.put("20", vmill[5]);
        vmillhash.put("21", vmill[7]);
        vmillhash.put("22", vmill[1]);
        vmillhash.put("23", vmill[5]);
        vmillhash.put("24", vmill[8]);
    }


    private Boolean checkmill1() {
        if((circ1.getFill().equals(circ2.getFill()))&&(circ1.getFill().equals(circ3.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmillhash.put("1", true);
        }else if((circ1.getFill().equals(circ10.getFill()))&&(circ1.getFill().equals(circ22.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[1] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill2() {
        if((circ2.getFill().equals(circ1.getFill()))&&(circ2.getFill().equals(circ3.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[1] = true;
        }else if((circ2.getFill().equals(circ5.getFill()))&&(circ2.getFill().equals(circ8.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[4] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill3() {
        if((circ3.getFill().equals(circ1.getFill()))&&(circ3.getFill().equals(circ2.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[1] = true;
        }else if((circ3.getFill().equals(circ15.getFill()))&&(circ3.getFill().equals(circ24.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[8] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill4() {
        if((circ4.getFill().equals(circ5.getFill()))&&(circ4.getFill().equals(circ6.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[2] = true;
        }else if((circ4.getFill().equals(circ11.getFill()))&&(circ4.getFill().equals(circ19.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[2] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill5() {
        if((circ5.getFill().equals(circ4.getFill()))&&(circ5.getFill().equals(circ6.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[2] = true;
        }else if((circ5.getFill().equals(circ2.getFill()))&&(circ5.getFill().equals(circ8.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[4] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill6() {
        if((circ6.getFill().equals(circ4.getFill()))&&(circ6.getFill().equals(circ5.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[2] = true;
        }else if((circ6.getFill().equals(circ14.getFill()))&&(circ6.getFill().equals(circ21.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[7] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill7() {
        if((circ7.getFill().equals(circ8.getFill()))&&(circ7.getFill().equals(circ9.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[3] = true;
        }else if((circ7.getFill().equals(circ12.getFill()))&&(circ7.getFill().equals(circ16.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[3] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill8() {
        if((circ8.getFill().equals(circ7.getFill()))&&(circ8.getFill().equals(circ9.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[3] = true;
        }else if((circ8.getFill().equals(circ2.getFill()))&&(circ8.getFill().equals(circ5.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[4] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill9() {
        if((circ9.getFill().equals(circ7.getFill()))&&(circ9.getFill().equals(circ8.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[3] = true;
        }else if((circ9.getFill().equals(circ13.getFill()))&&(circ9.getFill().equals(circ18.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[6] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill10() {
        if((circ10.getFill().equals(circ11.getFill()))&&(circ10.getFill().equals(circ12.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[4] = true;
        }else if((circ10.getFill().equals(circ1.getFill()))&&(circ10.getFill().equals(circ22.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[1] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill11() {
        if((circ11.getFill().equals(circ10.getFill()))&&(circ11.getFill().equals(circ12.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[4] = true;
        }else if((circ11.getFill().equals(circ4.getFill()))&&(circ11.getFill().equals(circ19.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[2] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill12() {
        if((circ12.getFill().equals(circ10.getFill()))&&(circ12.getFill().equals(circ11.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[4] = true;
        }else if((circ12.getFill().equals(circ7.getFill()))&&(circ12.getFill().equals(circ16.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[3] = true; 
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill13() {
        if((circ13.getFill().equals(circ14.getFill()))&&(circ13.getFill().equals(circ15.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[5] = true;
        }else if((circ13.getFill().equals(circ9.getFill()))&&(circ13.getFill().equals(circ18.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[6] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill14() {
        if((circ14.getFill().equals(circ13.getFill()))&&(circ14.getFill().equals(circ15.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[5] = true;
        }else if((circ14.getFill().equals(circ6.getFill()))&&(circ14.getFill().equals(circ21.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[7] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill15() {
        if((circ15.getFill().equals(circ13.getFill()))&&(circ15.getFill().equals(circ14.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[5] = true;
        }else if((circ15.getFill().equals(circ3.getFill()))&&(circ15.getFill().equals(circ24.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[8] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill16() {
        if((circ16.getFill().equals(circ17.getFill()))&&(circ16.getFill().equals(circ18.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[6] = true;
        }else if((circ16.getFill().equals(circ7.getFill()))&&(circ16.getFill().equals(circ12.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[3] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill17() {
        if((circ17.getFill().equals(circ16.getFill()))&&(circ17.getFill().equals(circ18.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[6] = true;
        }else if((circ17.getFill().equals(circ20.getFill()))&&(circ17.getFill().equals(circ23.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[5] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill18() {
        if((circ18.getFill().equals(circ16.getFill()))&&(circ18.getFill().equals(circ17.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[6] = true;
        }else if((circ18.getFill().equals(circ9.getFill()))&&(circ18.getFill().equals(circ13.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[6] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill19() {
        if((circ19.getFill().equals(circ20.getFill()))&&(circ19.getFill().equals(circ21.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[7] = true;
        }else if((circ19.getFill().equals(circ4.getFill()))&&(circ19.getFill().equals(circ11.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[2] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill20() {
        if((circ20.getFill().equals(circ19.getFill()))&&(circ20.getFill().equals(circ21.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[7] = true;
        }else if((circ20.getFill().equals(circ17.getFill()))&&(circ20.getFill().equals(circ23.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[5] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill21() {
        if((circ21.getFill().equals(circ19.getFill()))&&(circ21.getFill().equals(circ20.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[7] = true;
        }else if((circ21.getFill().equals(circ6.getFill()))&&(circ21.getFill().equals(circ14.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[7] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill22() {
        if((circ22.getFill().equals(circ23.getFill()))&&(circ22.getFill().equals(circ24.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[8] = true;
        }else if((circ22.getFill().equals(circ1.getFill()))&&(circ22.getFill().equals(circ10.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[1] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill23() {
        if((circ23.getFill().equals(circ22.getFill()))&&(circ23.getFill().equals(circ24.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[8] = true;
        }else if((circ23.getFill().equals(circ17.getFill()))&&(circ23.getFill().equals(circ20.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[5] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill24() {
        if((circ24.getFill().equals(circ22.getFill()))&&(circ24.getFill().equals(circ23.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
            hmill[8] = true;
        }else if((circ24.getFill().equals(circ3.getFill()))&&(circ24.getFill().equals(circ15.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
            vmill[8] = true;
        }else{
            muehle = false;
        }
        return muehle;
    }



    
    @FXML
    void initialize() {
        assert circ1 != null : "fx:id=\"circ1\" was not injected: check your FXML file 'view.fxml'.";
        assert circ2 != null : "fx:id=\"circ2\" was not injected: check your FXML file 'view.fxml'.";
        assert circ3 != null : "fx:id=\"circ3\" was not injected: check your FXML file 'view.fxml'.";
        assert circ4 != null : "fx:id=\"circ4\" was not injected: check your FXML file 'view.fxml'.";
        assert circ5 != null : "fx:id=\"circ5\" was not injected: check your FXML file 'view.fxml'.";
        assert circ6 != null : "fx:id=\"circ6\" was not injected: check your FXML file 'view.fxml'.";
        assert circ7 != null : "fx:id=\"circ7\" was not injected: check your FXML file 'view.fxml'.";
        assert circ8 != null : "fx:id=\"circ8\" was not injected: check your FXML file 'view.fxml'.";
        assert circ9 != null : "fx:id=\"circ9\" was not injected: check your FXML file 'view.fxml'.";
        assert circ10 != null : "fx:id=\"circ10\" was not injected: check your FXML file 'view.fxml'.";
        assert circ11 != null : "fx:id=\"circ11\" was not injected: check your FXML file 'view.fxml'.";
        assert circ12 != null : "fx:id=\"circ12\" was not injected: check your FXML file 'view.fxml'.";
        assert circ13 != null : "fx:id=\"circ13\" was not injected: check your FXML file 'view.fxml'.";
        assert circ14 != null : "fx:id=\"circ14\" was not injected: check your FXML file 'view.fxml'.";
        assert circ15 != null : "fx:id=\"circ15\" was not injected: check your FXML file 'view.fxml'.";
        assert circ16 != null : "fx:id=\"circ16\" was not injected: check your FXML file 'view.fxml'.";
        assert circ17 != null : "fx:id=\"circ17\" was not injected: check your FXML file 'view.fxml'.";
        assert circ18 != null : "fx:id=\"circ18\" was not injected: check your FXML file 'view.fxml'.";
        assert circ19 != null : "fx:id=\"circ19\" was not injected: check your FXML file 'view.fxml'.";
        assert circ20 != null : "fx:id=\"circ20\" was not injected: check your FXML file 'view.fxml'.";
        assert circ21 != null : "fx:id=\"circ21\" was not injected: check your FXML file 'view.fxml'.";
        assert circ22 != null : "fx:id=\"circ22\" was not injected: check your FXML file 'view.fxml'.";
        assert circ23 != null : "fx:id=\"circ23\" was not injected: check your FXML file 'view.fxml'.";
        assert circ24 != null : "fx:id=\"circ24\" was not injected: check your FXML file 'view.fxml'.";
    }
}
