import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private final int radius;

        PenSize(int radius) {this.radius = radius;}

        public int getRadius() {return radius;}
    }

    @FXML private RadioButton blackRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton greenRadioButton;
    @FXML private RadioButton blueRadioButton;
    @FXML private RadioButton smallRadioButton;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;
    @FXML private Button undoButton;
    @FXML private Button clearButton;
    @FXML private Pane drawingAreaPane;
    @FXML private ToggleGroup sizeToggleGroup;
    @FXML private ToggleGroup colorToggleGroup;

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    public void initialize() {
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent e) {
        brushColor = (Color)colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent e) {
        radius = (PenSize)sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent e) {
        int count = drawingAreaPane.getChildren().size();

        if(count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }
}
