import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.effect.*;
import javax.script.*;

public class GraphController { //varible you need
    int x_min = -250;
    int x_max = 250;
    int y_min = -250;
    int y_max = 250;

    @FXML private TextField textfield;
    @FXML private TextField xmin;
    @FXML private TextField xmax;
    @FXML private TextField ymin;
    @FXML private TextField ymax;
    @FXML private Polyline polyline;
    @FXML private Line axisx;
    @FXML private Line axisy;
    @FXML private Label labelx;
    @FXML private Label labely;

    ScriptEngineManager manager;
    ScriptEngine engine;

    public void initialize() {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("JavaScript");
    }

    @FXML
    private void onChangeSize(ActionEvent e) {
        // change layouts of axis and labels.
        x_min = Integer.parseInt(xmin.getText());
        x_max = Integer.parseInt(xmax.getText());
        y_min = Integer.parseInt(ymin.getText());
        y_max = Integer.parseInt(ymax.getText());
        draw();
    }

    @FXML
    private void onActionTextfield(ActionEvent event) {
        // draw f(x) ...
        draw();
    }

    void draw() {
        int xorigin = -500 * x_min / (x_max - x_min);
        int yorigin = 500 * y_max / (y_max - y_min);
        axisx.setEndX​(0);
        axisx.setEndY​((double)yorigin);
        axisx.setStartX​(500);
        axisx.setStartY​((double)yorigin);

        axisy.setEndX​((double)xorigin);
        axisy.setEndY​(0);
        axisy.setStartX​((double)xorigin);
        axisy.setStartY​(500);

        polyline.getPoints().clear();
        String fx = textfield.getText();
        fx = fx.replace("sin", "Math.sin")
            .replace("cos", "Math.cos")
            .replace("tan", "Math.tan")
            .replace("sqrt", "Math.sqrt")
            .replace("pow", "Math.pow")
            .replace("log", "Math.log")
            .replace("abs", "Math.abs")
            .replace("PI", "Math.PI")
            .replace("E", "Math.E");
        System.out.println(fx);
        double y;
        for(int x = x_min; x <= x_max; x++) {
            try {
                engine.eval("x = (" + x + ")*1.0");
                engine.eval("y = (" + fx + ")*1.0");
                y = (double)engine.get("y");
                System.out.println(x + " " + y);
            } catch (ScriptException e) {
                y = 0;
            }
            if(y <= y_max && y >= y_min) {
                polyline.getPoints().addAll((double)x * (500/(x_max-x_min)) + xorigin,
                y * (-500/(y_max-y_min)) + yorigin);
            }
        }
    }
}
