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
        
    }

    @FXML
    private void onActionTextfield(ActionEvent event) {
        // draw f(x) ...
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
            } catch (ScriptException e) {
                y = 0;
            }
            if(y <= y_max && y >= y_min) {
                polyline.getPoints().addAll((double)x + 250, y * (-1) + 250);
            }
        }
    }
}
