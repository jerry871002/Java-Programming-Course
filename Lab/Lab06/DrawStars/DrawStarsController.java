// DrawStarsController.java
// Create a circle of stars using Polygons and Rotate transforms.
import java.security.SecureRandom;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Transform;

public class DrawStarsController {
   @FXML private Pane pane;
   private static final SecureRandom random = new SecureRandom();

   public void initialize() {
      // points that define a five-pointed star shape
      Double[] pointsStar = {205.0,150.0, 217.0,186.0, 259.0,186.0,
         223.0,204.0, 233.0,246.0, 205.0,222.0, 177.0,246.0, 187.0,204.0,
         151.0,186.0, 193.0,186.0};

      Double[] pointsTri = {205.0,150.0, 155.0,220.7, 255.0,220.7};

      // create 18 stars
      for (int count = 0; count < 10; ++count) {
          Polygon newShape = new Polygon();

          if(count % 2 == 0) {
              newShape.getPoints().addAll(pointsStar);
          } else {
              newShape.getPoints().addAll(pointsTri);
          }

         newShape.setStroke(Color.GREY);
         newShape.setFill(Color.rgb(random.nextInt(255),
            random.nextInt(255), random.nextInt(255),
            random.nextDouble()));

         newShape.getTransforms().add(
            Transform.rotate(count * 36, 150, 150));
         pane.getChildren().add(newShape);
      }
   }
}
