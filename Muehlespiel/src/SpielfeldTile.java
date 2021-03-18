import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpielfeldTile extends StackPane {
    public SpielfeldTile() {
        Rectangle feld = new Rectangle(100, 100);
        feld.setFill(null);
        feld.setStroke(Color.TRANSPARENT);

        setAlignment(Pos.CENTER);
        getChildren().add(feld);

        setOnMouseClicked(event -> {    
            if (event.getButton() == MouseButton.PRIMARY) {
                
            }
        });
    }
}
