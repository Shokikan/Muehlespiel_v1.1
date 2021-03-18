import javafx.scene.canvas.GraphicsContext;

public class Spielfeld {

public Spielfeld() {

}
    public void drawFeld(GraphicsContext gc)
    {
        gc.strokeLine(100, 100, 700, 100);
        gc.strokeLine(100, 100, 100, 700);
        gc.strokeLine(700, 100, 700, 700);
        gc.strokeLine(100, 700, 700, 700);

        gc.strokeLine(200, 200, 600, 200);
        gc.strokeLine(200, 200, 200, 600);
        gc.strokeLine(600, 200, 600, 600);
        gc.strokeLine(200, 600, 600, 600);

        gc.strokeLine(300, 300, 500, 300);
        gc.strokeLine(300, 300, 300, 500);
        gc.strokeLine(500, 300, 500, 500);
        gc.strokeLine(300, 500, 500, 500);

        gc.strokeLine(400, 100, 400, 300);
        gc.strokeLine(400, 500, 400, 700);
        gc.strokeLine(100, 400, 300, 400);
        gc.strokeLine(500, 400, 700, 400);

        //gc.strokeLine(arg0, arg1, arg2, arg3);
    }
}
