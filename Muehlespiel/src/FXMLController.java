import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.graalvm.compiler.nodes.extended.GetClassNode;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Boolean[] paneStatus = new Boolean[24];
    private int[] id = new int[24];
    private String[] arraypid = new String[24];
    private String color;
    private String pid;
    Spielfeld sf = new Spielfeld();
    HashMap<String, Circle> testhash = new HashMap<String, Circle>();

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
    void manageMouseClickBox1(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }
    }
        

    @FXML
    void manageMouseClickBox2(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }
    }

    @FXML
    void manageMouseClickBox3(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }
    }

    @FXML
    void manageMouseClickBox4(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox5(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox6(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox7(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox8(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox9(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox10(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox11(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox12(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox13(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox14(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox15(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox16(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox17(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox18(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox19(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox20(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox21(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox22(MouseEvent event) {
        
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox23(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox24(MouseEvent event) {
        TestHashMap();

        pae = (Pane) event.getSource();
        pid = pae.getId();
        System.out.println(pid);

        if(currentPlayer.getanzZuege()<9) {
            ueberpruefe();
        }else{
            return;
        }

        zugzaehler();
        changePlayer();
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


    private void ueberpruefe() {
        if(testhash.get(pid).getFill().equals(Color.valueOf("#1f93ff00"))) {
            if(currentPlayer.getSpielerNummer()==Player1.getSpielerNummer()) {
                testhash.get(pid).setFill(Color.BEIGE);
                zugzaehler();
                changePlayer();
            }else{
                testhash.get(pid).setFill(Color.GREY);
                zugzaehler();
                changePlayer();
            }
        }else{
            return;
        }
    }

    private String setzen() {
        String Stein;
        
        

        return Stein;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPlayer = new Spieler(1, 0, 0);
        Player1 = new Spieler(1, 0, 0);
        Player2 = new Spieler(2, 0, 0);
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

    private 

    


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
