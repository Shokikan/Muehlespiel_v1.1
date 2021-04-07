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
    private Spielregeln regel;

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

    /* Hier wurde jedes einzelne wichtige Gridbox definiert, ich habe ein test versuch gemacht mit dem Mousevent*/

    @FXML
    void manageMouseClickBox1(MouseEvent event) {
        if (tokencounter() <= 9) {
            if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
                circ1.setFill(Color.BEIGE);
            } else {
                circ1.setFill(Color.GREY);
            }
            tokencounter();
            changePlayer();
        } else if (currentPlayer.getanzSteine() > 3) {
            if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
                if (circ1.getFill().equals(Color.BEIGE)) {
                    circ1.setFill(Color.TRANSPARENT);
                } else if (circ1.getFill().equals(Color.GREY)) {
                    circ1.setFill(Color.TRANSPARENT);
                } else {
                    if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
                        circ1.setFill(Color.BEIGE);
                    } else {
                        circ1.setFill(Color.GREY);
                    }
                }
            }
        }
    } 

    @FXML
    void manageMouseClickBox2(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ2.setFill(Color.BEIGE);
        } else {
            circ2.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox3(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ3.setFill(Color.BEIGE);
        } else {
            circ3.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox4(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ4.setFill(Color.BEIGE);
        } else {
            circ4.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox5(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ5.setFill(Color.BEIGE);
        } else {
            circ5.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox6(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ6.setFill(Color.BEIGE);
        } else {
            circ6.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox7(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ7.setFill(Color.BEIGE);
        } else {
            circ7.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox8(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ8.setFill(Color.BEIGE);
        } else {
            circ8.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox9(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ9.setFill(Color.BEIGE);
        } else {
            circ9.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox10(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ10.setFill(Color.BEIGE);
        } else {
            circ10.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox11(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ11.setFill(Color.BEIGE);
        } else {
            circ11.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox12(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ12.setFill(Color.BEIGE);
        } else {
            circ12.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox13(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ13.setFill(Color.BEIGE);
        } else {
            circ13.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox14(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ14.setFill(Color.BEIGE);
        } else {
            circ14.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox15(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ15.setFill(Color.BEIGE);
        } else {
            circ15.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox16(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ16.setFill(Color.BEIGE);
        } else {
            circ16.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox17(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ17.setFill(Color.BEIGE);
        } else {
            circ17.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox18(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ18.setFill(Color.BEIGE);
        } else {
            circ18.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox19(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ19.setFill(Color.BEIGE);
        } else {
            circ19.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox20(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ20.setFill(Color.BEIGE);
        } else {
            circ20.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox21(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ21.setFill(Color.BEIGE);
        } else {
            circ21.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox22(MouseEvent event) {
        
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ22.setFill(Color.BEIGE);
        } else {
            circ22.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox23(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ23.setFill(Color.BEIGE);
        } else {
            circ23.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    @FXML
    void manageMouseClickBox24(MouseEvent event) {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            circ24.setFill(Color.BEIGE);
        } else {
            circ24.setFill(Color.GREY);
        }
        tokencounter();
        changePlayer();
    }

    private boolean check() {
        if (
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPlayer = new Spieler(1, 0);
        Player1 = new Spieler(1, 0);
        Player2 = new Spieler(2, 0);
        regel = new Spielregeln();
    }

    private int tokencounter() {
        if (currentPlayer.getSpielerNummer() == Player1.getSpielerNummer()) {
            Player1.setanzSteine(Player1.getanzSteine() + 1);
            System.out.println("Player1 tokens: " + Player1.getanzSteine());
            return Player1.getanzSteine();
        } else {
            Player2.setanzSteine(Player2.getanzSteine() + 1);
            System.out.println("Player2 tokens: " + Player2.getanzSteine());
            return Player2.getanzSteine() + 1;
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
