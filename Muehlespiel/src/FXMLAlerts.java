import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/* 
    Diese Alerts sind Hinweise oder Fehlermeldungen für den Spiele. Mit diesen Alerts kann
    der Spieler sehen ob er einen gültigen Zug gemacht hat oder er wird darauf hingewiesen
    was er als nächstes machen kann.
 */
public class FXMLAlerts {

    Alert alertI = new Alert(AlertType.INFORMATION);
    Alert alertE = new Alert(AlertType.ERROR);

    /*  p1millalert und p2millalert weisen den Spieler darauf hin, dass er eine Mühle hat und vom
        Gegner einen Stein weg nehmen kann.
    */
    public void p1millalert() {
        alertI.setTitle("Spieler 1 hat eine Mühle!");
        alertI.setHeaderText(null);
        alertI.setContentText("Sie können nun einen Stein ihres Gegners entfernen!");
        alertI.showAndWait();
    }

    public void p2millalert() {
        alertI.setTitle("Spieler 2 hat eine Mühle!");
        alertI.setHeaderText(null);
        alertI.setContentText("Sie können nun einen Stein ihres Gegners entfernen!");

        alertI.showAndWait();
    }

    // cantremove weist den Spieler hin, dass er kein Stein von einer Mühle entfernen kann.

    public void cantremove() {
        alertE.setTitle("Ungültiger Zug!");
        alertE.setHeaderText(null);
        alertE.setContentText("Stein in einer Mühle können nicht entfernt weren!");

        alertE.showAndWait();
    }

    /*  notoken weist den Spieler hin, dass er in 5 Versuchen keinen Stein entfernen konnte 
        und dass anschliessend den Spieler gewechselt wird.
    */
    public void notoken() {
        alertI.setTitle("Nicht möglich!");
        alertI.setHeaderText(null);
        alertI.setContentText("Es können keine Steine entfernt werden, Spieler wird gewechselt!");

        alertI.showAndWait();
    }

    //  cantjump weist den Spieler hin, dass er bei der Schiebphase nicht zu weit setzten kann.

    public void cantjump() {
        alertE.setTitle("Ungültiger Zug!");
        alertE.setHeaderText(null);
        alertE.setContentText("Springen ist momentan nicht möglich!");

        alertE.showAndWait();
    }

    //  alreadytoken weist den Spieler hin, dass er seinen Stein nicht auf einen anderen Stein setzten kann.

    public void alreadytoken() {
        alertE.setTitle("Ungültiger Zug!");
        alertE.setHeaderText(null);
        alertE.setContentText("Da befindet sich schon ein Stein in diesem Feld!");

        alertE.showAndWait();
    }

    //  samespot weist den Spieler hin, dass er nicht auf die gleiche Stelle setzen kann.
    public void samespot() {
        alertE.setTitle("Ungültiger Zug!");
        alertE.setHeaderText(null);
        alertE.setContentText("Kann Stein nicht an gleicher stelle setzen!");

        alertE.showAndWait();
    }

    // p1won und p2won zeigen dem Spieler an, dass sie das Spiel gewonnen haben.
    public void p1won() {
        alertI.setTitle("WIN!");
        alertI.setHeaderText(null);
        alertI.setContentText("Gratulation! Spieler 2 hat gewonnen!");

        alertI.showAndWait();
    }

    public void p2won() {
        alertI.setTitle("WIN!");
        alertI.setHeaderText(null);
        alertI.setContentText("Gratulation! Spieler 1 hat gewonnen!");

        alertI.showAndWait();
    }
}    
