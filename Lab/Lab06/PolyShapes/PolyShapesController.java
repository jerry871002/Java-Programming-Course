// Fig. 22.6: PolyShapesController.java
// Drawing Polylines, Polygons and Paths.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.input.MouseButton;

public class PolyShapesController {
   // enum representing shape types
   private enum ShapeType {POLYLINE, POLYGON, PATH};

   // instance variables that refer to GUI components
   @FXML private RadioButton polylineRadioButton;
   @FXML private RadioButton polygonRadioButton;
   @FXML private RadioButton pathRadioButton;
   @FXML private ToggleGroup toggleGroup;
   @FXML private Polyline polyline;
   @FXML private Polygon polygon;
   @FXML private Path path;

   // instance variables for managing state
   private ShapeType shapeType = ShapeType.POLYLINE;
   private boolean sweepFlag = true; // used with arcs in a Path

   // set user data for the RadioButtons and display polyline object
   public void initialize() {
      // user data on a control can be any Object
      polylineRadioButton.setUserData(ShapeType.POLYLINE);
      polygonRadioButton.setUserData(ShapeType.POLYGON);
      pathRadioButton.setUserData(ShapeType.PATH);

      displayShape(); // sets polyline's visibility to true when app loads
   }

   // handles drawingArea's onMouseClicked event
   @FXML
   private void drawingAreaMouseClicked(MouseEvent e) {
      System.out.println("Before");
      System.out.println(polyline.getPoints().size());
      System.out.println(polygon.getPoints().size());
      System.out.println(path.getElements().size());
      if(e.getButton() == MouseButton.PRIMARY) {
          polyline.getPoints().addAll(e.getX(), e.getY());
          polygon.getPoints().addAll(e.getX(), e.getY());

          // if path is empty, move to first click position and close path
          if (path.getElements().isEmpty()) {
             path.getElements().add(new MoveTo(e.getX(), e.getY()));
             path.getElements().add(new ClosePath());
          }
          else { // insert a new path segment before the ClosePath element
             // create an arc segment and insert it in the path
             ArcTo arcTo = new ArcTo();
             arcTo.setX(e.getX());
             arcTo.setY(e.getY());
             arcTo.setRadiusX(100.0);
             arcTo.setRadiusY(100.0);
             arcTo.setSweepFlag(sweepFlag);
             sweepFlag = !sweepFlag;
             path.getElements().add(path.getElements().size() - 1, arcTo);
          }
      } else if(e.getButton() == MouseButton.SECONDARY) {
          if(polyline.getPoints().size() <= 4) {
              polyline.getPoints().clear();
              polygon.getPoints().clear();
              path.getElements().clear();
              return;
          }

          if(polyline.getPoints().isEmpty() == false)
            polyline.getPoints().remove(polyline.getPoints().size()-2, polyline.getPoints().size());
          if(polygon.getPoints().isEmpty() == false)
            polygon.getPoints().remove(polygon.getPoints().size()-2, polygon.getPoints().size());
          if(path.getElements().isEmpty() == false)
            path.getElements().remove(path.getElements().size()-1);
      }
      System.out.println("After");
      System.out.println(polyline.getPoints().size());
      System.out.println(polygon.getPoints().size());
      System.out.println(path.getElements().size());
      System.out.println();
   }

   // handles color RadioButton's ActionEvents
   @FXML
   private void shapeRadioButtonSelected(ActionEvent e) {
      // user data for each color RadioButton is a ShapeType constant
      shapeType =
         (ShapeType) toggleGroup.getSelectedToggle().getUserData();
      displayShape(); // display the currently selected shape
   }

   // displays currently selected shape
   private void displayShape() {
      polyline.setVisible(shapeType == ShapeType.POLYLINE);
      polygon.setVisible(shapeType == ShapeType.POLYGON);
      path.setVisible(shapeType == ShapeType.PATH);
   }

   // resets each shape
   @FXML
   private void clearButtonPressed(ActionEvent event) {
      polyline.getPoints().clear();
      polygon.getPoints().clear();
      path.getElements().clear();
   }
}
