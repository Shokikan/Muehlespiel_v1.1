import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    final int W=800, H=800;

    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefSize(700, 700);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                
            }
        }

        return pane;
    }

    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Muehlespiel");
        Canvas canvas = new Canvas(W, H);
        Spielfeld sf = new Spielfeld();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //GraphicsContext ss = canvas.getGraphicsContext2D();
        sf.drawFeld(gc);
        Group root = new Group();
        root.getChildren().add(canvas);
        primarystage.setScene(new Scene(root));
        primarystage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
