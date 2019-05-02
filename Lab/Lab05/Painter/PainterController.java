import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseDragEvent;
import java.util.ArrayList;
import java.util.List;

public class PainterController {

    private enum PenSize {
        SMALL(2.0),
        MEDIUM(4.0),
        LARGE(6.0);

        private final double thinkness;

        PenSize(double thinkness) {this.thinkness = thinkness;}

        public double getThinkness() {return thinkness;}
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

    private PenSize thinkness = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    double oldX = 0, oldY = 0;
    List<Integer> durationList = new ArrayList<>();
    int duration = 0;

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
        if(oldX != 0 && oldY != 0) {
            Line newLine = new Line(oldX, oldY, e.getX(), e.getY());
            newLine.setStrokeWidth(thinkness.getThinkness());
            newLine.setFill(brushColor);
            newLine.setStroke(brushColor);
            drawingAreaPane.getChildren().add(newLine);
            duration++;
        }
        oldX = e.getX();
        oldY = e.getY();
    }

    @FXML
    void drawingAreaMouseMove(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

    @FXML
    void drawingAreaMousePressed(MouseEvent event) {
        duration = 0;
    }

    @FXML
    void drawingAreaMouseClick(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), (int)(thinkness.getThinkness()/2), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
        duration++;
        durationList.add(duration);
    }

    @FXML
    void drawingAreaMouseReleased(MouseEvent event) {
        durationList.add(duration);
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent e) {
        brushColor = (Color)colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent e) {
        thinkness = (PenSize)sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent e) {
        int count = drawingAreaPane.getChildren().size();
        System.out.printf("%d %d\n", count, duration);
        System.out.println(durationList);

        if(count > 0) {
            drawingAreaPane.getChildren().remove(
            count - durationList.get(durationList.size()-1), count);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }
}
