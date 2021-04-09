import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FXMLController implements Initializable {

    HashMap<Pane, Integer> pmap = new HashMap<Pane, Integer>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Spieler currentPlayer;
    private Spieler Player1;
    private Spieler Player2;
    private Boolean[] paneStatus = new Boolean[25];
    private String pid;
    private String remove = "removetoken";
    private Boolean muehle = false;
    private String fillcolor;
    private String colorgrey = "#808080";
    private String colorbeige = "#F5F5DC";
    private String colortransparent = "#00000000";

    Spielfeld sf = new Spielfeld();

    HashMap<String, Circle> testhash = new HashMap<String, Circle>();
    HashMap<String, Integer> pidhash = new HashMap<String, Integer>();

    @FXML
    private Pane box1;

    @FXML
    private Circle circ1;

    @FXML
    private Pane box2;

    @FXML
    private Circle circ2;

    @FXML
    private Pane box3;

    @FXML
    private Circle circ3;

    @FXML
    private Pane box4;

    @FXML
    private Circle circ4;

    @FXML
    private Pane box5;

    @FXML
    private Circle circ5;

    @FXML
    private Pane box6;

    @FXML
    private Circle circ6;

    @FXML
    private Pane box7;

    @FXML
    private Circle circ7;

    @FXML
    private Pane box8;

    @FXML
    private Circle circ8;

    @FXML
    private Pane box9;

    @FXML
    private Circle circ9;

    @FXML
    private Pane box10;

    @FXML
    private Circle circ10;

    @FXML
    private Pane box11;

    @FXML
    private Circle circ11;

    @FXML
    private Pane box12;

    @FXML
    private Circle circ12;

    @FXML
    private Pane box13;

    @FXML
    private Circle circ13;

    @FXML
    private Pane box14;

    @FXML
    private Circle circ14;

    @FXML
    private Pane box15;

    @FXML
    private Circle circ15;

    @FXML
    private Pane box16;

    @FXML
    private Circle circ16;

    @FXML
    private Pane box17;

    @FXML
    private Circle circ17;

    @FXML
    private Pane box18;

    @FXML
    private Circle circ18;

    @FXML
    private Pane box19;

    @FXML
    private Circle circ19;

    @FXML
    private Pane box20;

    @FXML
    private Circle circ20;

    @FXML
    private Pane box21;

    @FXML
    private Circle circ21;

    @FXML
    private Pane box22;

    @FXML
    private Circle circ22;

    @FXML
    private Pane box23;

    @FXML
    private Circle circ23;

    @FXML
    private Pane box24;

    @FXML
    private Circle circ24;

    @FXML
    private Pane pae;

    /* Hier wurde jedes einzelne wichtige Gridbox definiert, ich habe ein test versuch gemacht mit dem Mousevent*/

    @FXML
    void manageMouseClicked(MouseEvent event) {
        TestHashMap();
        pidHashMap();
        //setfalse();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);
        //checkpid();
        
        if(currentPlayer.getplayerInstance().equals(remove)){
            deleteToken();
            zugzaehler();
            changePlayer();
            muehle=false;
            removeplayerincance();
            System.out.println("incance of current player" + currentPlayer.getplayerInstance());
            System.out.println("incance of current player" + Player1.getplayerInstance());
            System.out.println("incance of current player" + Player2.getplayerInstance());
        }else{
            if(currentPlayer.getanzZuege()<9) {
                ueberpruefe();
                checkpane();
                removeToken();
                if(muehle!=true) {
                    zugzaehler();
                    changePlayer();
                    System.out.println("incance of current player" + currentPlayer.getplayerInstance());
                    System.out.println("incance of current player" + Player1.getplayerInstance());
                    System.out.println("incance of current player" + Player2.getplayerInstance());
                }else{
                    System.out.println("incance of current player" + currentPlayer.getplayerInstance());
                    System.out.println("incance of current player" + Player1.getplayerInstance());
                    System.out.println("incance of current player" + Player2.getplayerInstance());
                    return;
                }
            }else if(currentPlayer.getanzSteine()==3) {
                return;
            }else{
                return;
            }
        }        
    }

    private void removeToken() {
        if(muehle==true) {
            currentPlayer.setplayerInstance("removetoken");
        }else{
            return;
        }
    }

    private void deleteToken() {
        if(!testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {    
            testhash.get(pid).setFill(Color.valueOf(colortransparent));
        }else if(testhash.get(pid).getFill().equals(Color.valueOf(fillcolor))) {
            System.out.println("You can't remove your own token!");
            deleteToken();
        }else{
            System.out.println("Here is no token to be removed!");
            deleteToken();
        }
    }

    private void setfalse() {
        for(int i = 1; i <= 24; i++){
            paneStatus[i] = false;
        }
    }

    private void checkpid() {
        for(int i = 1; i <= 24; i++) {
            if(pidhash.get(pid)==i) {
                paneStatus[i] = true;
            }else{
            }
        }
    }

    private void ueberpruefe() {
        if(testhash.get(pid).getFill().equals(Color.valueOf(colortransparent))) {
            if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
                testhash.get(pid).setFill(Color.valueOf(colorbeige));
                fillcolor = colorbeige;
                System.out.println("Player1 sets token on field " + testhash.get(pid));
            }else{
                testhash.get(pid).setFill(Color.valueOf(colorgrey));
                fillcolor = colorgrey;
                System.out.println("Player2 sets token on field " + testhash.get(pid));
            }
        }else{
            return;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPlayer = new Spieler(1, 0, 0, " ");
        Player1 = new Spieler(1, 0, 0, " ");
        Player2 = new Spieler(2, 0, 0, " ");
    }

    private int zugzaehler() {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            Player1.setanzZuege(Player1.getanzZuege() + 1);
            System.out.println("Player1 anzahl Züge: " + Player1.getanzZuege());
            return Player1.getanzZuege();
        } else {
            Player2.setanzZuege(Player2.getanzZuege() + 1);
            System.out.println("Player2 anzahl Züge: " + Player2.getanzZuege());
            return Player2.getanzZuege();
        }
    }

    private int changePlayer() {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            currentPlayer = Player2;
            return currentPlayer.getSpielerNummer();
        } else {
            currentPlayer = Player1;
            return currentPlayer.getSpielerNummer();
        }
    }

    private void removeplayerincance() {
        currentPlayer.setplayerInstance(" ");
        Player1.setplayerInstance(" ");
        Player2.setplayerInstance(" ");
    }

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

    private void pidHashMap() {
        pidhash.put("1", 1);
        pidhash.put("2", 2);
        pidhash.put("3", 3);
        pidhash.put("4", 4);
        pidhash.put("5", 5);
        pidhash.put("6", 6);
        pidhash.put("7", 7);
        pidhash.put("8", 8);
        pidhash.put("9", 9);
        pidhash.put("10", 10);
        pidhash.put("11", 11);
        pidhash.put("12", 12);
        pidhash.put("13", 13);
        pidhash.put("14", 14);
        pidhash.put("15", 15);
        pidhash.put("16", 16);
        pidhash.put("17", 17);
        pidhash.put("18", 18);
        pidhash.put("19", 19);
        pidhash.put("20", 20);
        pidhash.put("21", 21);
        pidhash.put("22", 22);
        pidhash.put("23", 23);
        pidhash.put("24", 24);
    }

    private void TestHashMap() {
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

    private Boolean checkmill1() {
        if((circ1.getFill().equals(circ2.getFill()))&&(circ1.getFill().equals(circ3.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ1.getFill().equals(circ10.getFill()))&&(circ1.getFill().equals(circ22.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill2() {
        if((circ2.getFill().equals(circ1.getFill()))&&(circ2.getFill().equals(circ3.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ2.getFill().equals(circ5.getFill()))&&(circ2.getFill().equals(circ8.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill3() {
        if((circ3.getFill().equals(circ1.getFill()))&&(circ3.getFill().equals(circ2.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ3.getFill().equals(circ15.getFill()))&&(circ3.getFill().equals(circ24.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill4() {
        if((circ4.getFill().equals(circ5.getFill()))&&(circ4.getFill().equals(circ6.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ4.getFill().equals(circ11.getFill()))&&(circ4.getFill().equals(circ19.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill5() {
        if((circ5.getFill().equals(circ4.getFill()))&&(circ5.getFill().equals(circ6.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ5.getFill().equals(circ2.getFill()))&&(circ5.getFill().equals(circ8.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill6() {
        if((circ6.getFill().equals(circ4.getFill()))&&(circ6.getFill().equals(circ5.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ6.getFill().equals(circ14.getFill()))&&(circ6.getFill().equals(circ21.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill7() {
        if((circ7.getFill().equals(circ8.getFill()))&&(circ7.getFill().equals(circ9.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ7.getFill().equals(circ12.getFill()))&&(circ7.getFill().equals(circ16.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill8() {
        if((circ8.getFill().equals(circ7.getFill()))&&(circ8.getFill().equals(circ9.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ8.getFill().equals(circ2.getFill()))&&(circ8.getFill().equals(circ5.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill9() {
        if((circ9.getFill().equals(circ7.getFill()))&&(circ9.getFill().equals(circ8.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ9.getFill().equals(circ13.getFill()))&&(circ9.getFill().equals(circ18.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill10() {
        if((circ10.getFill().equals(circ11.getFill()))&&(circ10.getFill().equals(circ12.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ10.getFill().equals(circ1.getFill()))&&(circ10.getFill().equals(circ22.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill11() {
        if((circ11.getFill().equals(circ10.getFill()))&&(circ11.getFill().equals(circ12.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ11.getFill().equals(circ4.getFill()))&&(circ11.getFill().equals(circ19.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill12() {
        if((circ12.getFill().equals(circ10.getFill()))&&(circ12.getFill().equals(circ11.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ12.getFill().equals(circ7.getFill()))&&(circ12.getFill().equals(circ16.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill13() {
        if((circ13.getFill().equals(circ14.getFill()))&&(circ13.getFill().equals(circ15.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ13.getFill().equals(circ9.getFill()))&&(circ13.getFill().equals(circ18.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill14() {
        if((circ14.getFill().equals(circ13.getFill()))&&(circ14.getFill().equals(circ15.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ14.getFill().equals(circ6.getFill()))&&(circ14.getFill().equals(circ21.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill15() {
        if((circ15.getFill().equals(circ13.getFill()))&&(circ15.getFill().equals(circ14.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ15.getFill().equals(circ3.getFill()))&&(circ15.getFill().equals(circ24.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill16() {
        if((circ16.getFill().equals(circ17.getFill()))&&(circ16.getFill().equals(circ18.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ16.getFill().equals(circ7.getFill()))&&(circ16.getFill().equals(circ12.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill17() {
        if((circ17.getFill().equals(circ16.getFill()))&&(circ17.getFill().equals(circ18.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ17.getFill().equals(circ20.getFill()))&&(circ17.getFill().equals(circ23.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill18() {
        if((circ18.getFill().equals(circ16.getFill()))&&(circ18.getFill().equals(circ17.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ18.getFill().equals(circ9.getFill()))&&(circ18.getFill().equals(circ13.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill19() {
        if((circ19.getFill().equals(circ20.getFill()))&&(circ19.getFill().equals(circ21.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ19.getFill().equals(circ4.getFill()))&&(circ19.getFill().equals(circ11.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill20() {
        if((circ20.getFill().equals(circ19.getFill()))&&(circ20.getFill().equals(circ21.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ20.getFill().equals(circ17.getFill()))&&(circ20.getFill().equals(circ23.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill21() {
        if((circ21.getFill().equals(circ19.getFill()))&&(circ21.getFill().equals(circ20.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ21.getFill().equals(circ6.getFill()))&&(circ21.getFill().equals(circ14.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill22() {
        if((circ22.getFill().equals(circ23.getFill()))&&(circ22.getFill().equals(circ24.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ22.getFill().equals(circ1.getFill()))&&(circ22.getFill().equals(circ10.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill23() {
        if((circ23.getFill().equals(circ22.getFill()))&&(circ23.getFill().equals(circ24.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ23.getFill().equals(circ17.getFill()))&&(circ23.getFill().equals(circ20.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }

    private Boolean checkmill24() {
        if((circ24.getFill().equals(circ22.getFill()))&&(circ24.getFill().equals(circ23.getFill()))) {
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else if((circ24.getFill().equals(circ3.getFill()))&&(circ24.getFill().equals(circ15.getFill()))){
            System.out.println("Currentplayer has a mill");
            muehle = true;
        }else{
            muehle = false;
        }
        return muehle;
    }


    
    @FXML
    void initialize() {
        assert box1 != null : "fx:id=\"box1\" was not injected: check your FXML file 'view.fxml'.";
        assert circ1 != null : "fx:id=\"circ1\" was not injected: check your FXML file 'view.fxml'.";
        assert box2 != null : "fx:id=\"box2\" was not injected: check your FXML file 'view.fxml'.";
        assert circ2 != null : "fx:id=\"circ2\" was not injected: check your FXML file 'view.fxml'.";
        assert box3 != null : "fx:id=\"box3\" was not injected: check your FXML file 'view.fxml'.";
        assert circ3 != null : "fx:id=\"circ3\" was not injected: check your FXML file 'view.fxml'.";
        assert box4 != null : "fx:id=\"box4\" was not injected: check your FXML file 'view.fxml'.";
        assert circ4 != null : "fx:id=\"circ4\" was not injected: check your FXML file 'view.fxml'.";
        assert box5 != null : "fx:id=\"box5\" was not injected: check your FXML file 'view.fxml'.";
        assert circ5 != null : "fx:id=\"circ5\" was not injected: check your FXML file 'view.fxml'.";
        assert box6 != null : "fx:id=\"box6\" was not injected: check your FXML file 'view.fxml'.";
        assert circ6 != null : "fx:id=\"circ6\" was not injected: check your FXML file 'view.fxml'.";
        assert box7 != null : "fx:id=\"box7\" was not injected: check your FXML file 'view.fxml'.";
        assert circ7 != null : "fx:id=\"circ7\" was not injected: check your FXML file 'view.fxml'.";
        assert box8 != null : "fx:id=\"box8\" was not injected: check your FXML file 'view.fxml'.";
        assert circ8 != null : "fx:id=\"circ8\" was not injected: check your FXML file 'view.fxml'.";
        assert box9 != null : "fx:id=\"box9\" was not injected: check your FXML file 'view.fxml'.";
        assert circ9 != null : "fx:id=\"circ9\" was not injected: check your FXML file 'view.fxml'.";
        assert box10 != null : "fx:id=\"box10\" was not injected: check your FXML file 'view.fxml'.";
        assert circ10 != null : "fx:id=\"circ10\" was not injected: check your FXML file 'view.fxml'.";
        assert box11 != null : "fx:id=\"box11\" was not injected: check your FXML file 'view.fxml'.";
        assert circ11 != null : "fx:id=\"circ11\" was not injected: check your FXML file 'view.fxml'.";
        assert box12 != null : "fx:id=\"box12\" was not injected: check your FXML file 'view.fxml'.";
        assert circ12 != null : "fx:id=\"circ12\" was not injected: check your FXML file 'view.fxml'.";
        assert box13 != null : "fx:id=\"box13\" was not injected: check your FXML file 'view.fxml'.";
        assert circ13 != null : "fx:id=\"circ13\" was not injected: check your FXML file 'view.fxml'.";
        assert box14 != null : "fx:id=\"box14\" was not injected: check your FXML file 'view.fxml'.";
        assert circ14 != null : "fx:id=\"circ14\" was not injected: check your FXML file 'view.fxml'.";
        assert box15 != null : "fx:id=\"box15\" was not injected: check your FXML file 'view.fxml'.";
        assert circ15 != null : "fx:id=\"circ15\" was not injected: check your FXML file 'view.fxml'.";
        assert box16 != null : "fx:id=\"box16\" was not injected: check your FXML file 'view.fxml'.";
        assert circ16 != null : "fx:id=\"circ16\" was not injected: check your FXML file 'view.fxml'.";
        assert box17 != null : "fx:id=\"box17\" was not injected: check your FXML file 'view.fxml'.";
        assert circ17 != null : "fx:id=\"circ17\" was not injected: check your FXML file 'view.fxml'.";
        assert box18 != null : "fx:id=\"box18\" was not injected: check your FXML file 'view.fxml'.";
        assert circ18 != null : "fx:id=\"circ18\" was not injected: check your FXML file 'view.fxml'.";
        assert box19 != null : "fx:id=\"box19\" was not injected: check your FXML file 'view.fxml'.";
        assert circ19 != null : "fx:id=\"circ19\" was not injected: check your FXML file 'view.fxml'.";
        assert box20 != null : "fx:id=\"box20\" was not injected: check your FXML file 'view.fxml'.";
        assert circ20 != null : "fx:id=\"circ20\" was not injected: check your FXML file 'view.fxml'.";
        assert box21 != null : "fx:id=\"box21\" was not injected: check your FXML file 'view.fxml'.";
        assert circ21 != null : "fx:id=\"circ21\" was not injected: check your FXML file 'view.fxml'.";
        assert box22 != null : "fx:id=\"box22\" was not injected: check your FXML file 'view.fxml'.";
        assert circ22 != null : "fx:id=\"circ22\" was not injected: check your FXML file 'view.fxml'.";
        assert box23 != null : "fx:id=\"box23\" was not injected: check your FXML file 'view.fxml'.";
        assert circ23 != null : "fx:id=\"circ23\" was not injected: check your FXML file 'view.fxml'.";
        assert box24 != null : "fx:id=\"box24\" was not injected: check your FXML file 'view.fxml'.";
        assert circ24 != null : "fx:id=\"circ24\" was not injected: check your FXML file 'view.fxml'.";

    }
}
