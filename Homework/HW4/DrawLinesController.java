import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawLinesController {
    double LINE_NUM = 20.;

    @FXML
    private Canvas canvas;

    @FXML
    void drawLinesButtonPressed1(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 300, 300);

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        double diff_x = width / LINE_NUM;
        double diff_y = height / LINE_NUM;

        for(int i = 0; i < LINE_NUM; i++)
            gc.strokeLine(0, 0, diff_x*i, height-diff_y*i);
    }

    @FXML
    void drawLinesButtonPressed2(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 300, 300);

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        double diff_x = width / LINE_NUM;
        double diff_y = height / LINE_NUM;

        for(int i = 0; i < LINE_NUM; i++) {
            gc.strokeLine(0, 0, diff_x*i, height-diff_y*i);
            gc.strokeLine(width, 0, (int)(diff_x*i), diff_y*i);
            gc.strokeLine(0, height, diff_x*i, diff_y*i);
            gc.strokeLine(width, height, diff_x*i, height-diff_y*i);
        }
    }

    @FXML
    void drawLinesButtonPressed3(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 300, 300);

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        double diff_x = width / LINE_NUM;
        double diff_y = height / LINE_NUM;

        for(int i = 0; i < LINE_NUM; i++)
            gc.strokeLine(0, diff_y*i, diff_x*i, height);
    }

    @FXML
    void drawLinesButtonPressed4(ActionEvent event) {        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 300, 300);

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        double diff_x = width / LINE_NUM;
        double diff_y = height / LINE_NUM;

        for(int i = 0; i < LINE_NUM; i++) {
            gc.strokeLine(0, diff_y*i, diff_x*i, height);
            gc.strokeLine(diff_x*i, height, width, height-diff_y*i);
            gc.strokeLine(diff_x*i, 0, width, diff_y*i);
            gc.strokeLine(diff_x*i, 0, 0, height-diff_y*i);
        }
    }
}
