// TransitionAnimationsController.java
// Applying Transition animations to a Rectangle.
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TransitionAnimationsController {
   @FXML private Rectangle rectangle;
   SequentialTransition sequentialTransition;

   int STATUS = 0;

   @FXML
   private void backButtonPressed(ActionEvent event) {
       if (STATUS > 0) {
           STATUS--;
       } else {
           STATUS = 4;
       }
       playAnimation();
   }

   @FXML
   private void nextButtonPressed(ActionEvent event) {
       if (STATUS < 4) {
           STATUS++;
       } else {
           STATUS = 0;
       }
       playAnimation();
   }

   void playAnimation() {
       switch (STATUS) {
           case 0:
           ScaleTransition scaleTransition =
              new ScaleTransition(Duration.seconds(1));
           scaleTransition.setByX(0.75);
           scaleTransition.setByY(0.75);
           scaleTransition.setCycleCount(2);
           scaleTransition.setInterpolator(Interpolator.EASE_OUT);
           scaleTransition.setAutoReverse(true);

           sequentialTransition = new SequentialTransition (rectangle, scaleTransition);
           sequentialTransition.play();
           break;

           case 1:
           FillTransition fillTransition =
              new FillTransition(Duration.seconds(1));
           fillTransition.setToValue(Color.CYAN);
           fillTransition.setCycleCount(2);

           // each even cycle plays transition in reverse to restore original
           fillTransition.setAutoReverse(true);

           StrokeTransition strokeTransition =
              new StrokeTransition(Duration.seconds(1));
           strokeTransition.setToValue(Color.BLUE);
           strokeTransition.setCycleCount(2);
           strokeTransition.setAutoReverse(true);

           ParallelTransition parallelTransition =
              new ParallelTransition(fillTransition, strokeTransition);

           sequentialTransition = new SequentialTransition (rectangle, parallelTransition);
           sequentialTransition.play();
           break;

           case 2:
           FadeTransition fadeTransition =
              new FadeTransition(Duration.seconds(1));
           fadeTransition.setFromValue(1.0); // opaque
           fadeTransition.setToValue(0.0); // transparent
           fadeTransition.setCycleCount(2);
           fadeTransition.setAutoReverse(true);

           sequentialTransition = new SequentialTransition (rectangle, fadeTransition);
           sequentialTransition.play();
           break;

           case 3:
           RotateTransition rotateTransition =
              new RotateTransition(Duration.seconds(1));
           rotateTransition.setByAngle(360.0);
           rotateTransition.setCycleCount(2);
           rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
           rotateTransition.setAutoReverse(true);

           sequentialTransition = new SequentialTransition (rectangle, rotateTransition);
           sequentialTransition.play();
           break;

           case 4:
           Path path = new Path(new MoveTo(45, 45), new LineTo(45, 0),
              new LineTo(90, 0), new LineTo(90, 90), new LineTo(0, 90));
           PathTransition translateTransition =
              new PathTransition(Duration.seconds(2), path);
           translateTransition.setCycleCount(2);
           translateTransition.setInterpolator(Interpolator.EASE_IN);
           translateTransition.setAutoReverse(true);

           sequentialTransition = new SequentialTransition (rectangle, translateTransition);
           sequentialTransition.play();
           break;
       }
   }
}
