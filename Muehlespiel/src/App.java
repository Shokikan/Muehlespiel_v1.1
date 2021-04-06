import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {

        FXMLController controller = new FXMLController();

        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);

        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));

        Scene scene = new Scene(root);

        primarystage.setScene(scene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
