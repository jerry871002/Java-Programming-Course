// BallAnimationTimerController.java
// Bounce a circle around a window using an AnimationTimer subclass.
import java.security.SecureRandom;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

public class BallAnimationTimerController {
   @FXML private Circle c;
   @FXML private Pane pane;
   @FXML private Label timeLabel;
   @FXML private ImageView imageView;
   @FXML private Button button;

   long startTime = 0;
   boolean start = false;
   Thread t1;

   public void initialize() {
      SecureRandom random = new SecureRandom();

      t1 = new Thread(() -> {
          // time pass since start button pressed in milisecond
          double now = System.nanoTime();
          double timePass = (now - startTime) / 1000000.0;
          int milisecond = (int)(timePass % 1000);
          int second = (int)(timePass / 1000 % 60);
          int minute = (int)(timePass / 1000 / 60);
          String timeString = String.valueOf(minute) + ":" + String.valueOf(second) + "." + String.valueOf(milisecond);
          if(startTime != 0)
            timeLabel.setText(timeString);
      });

      // define a timeline animation
      Timeline timelineAnimation = new Timeline(
         new KeyFrame(Duration.millis(10),
            new EventHandler<ActionEvent>() {
               int dx = 1 + random.nextInt(5);
               int dy = 1 + random.nextInt(5);

               // move the circle by the dx and dy amounts
               @Override
               public void handle(final ActionEvent e) {
                  c.setLayoutX(c.getLayoutX() + dx);
                  c.setLayoutY(c.getLayoutY() + dy);
                  Bounds bounds = pane.getBoundsInLocal();

                  if (hitRightOrLeftEdge(bounds)) {
                     dx *= -1;
                  }

                  if (hitTopOrBottom(bounds)) {
                     dy *= -1;
                  }

                  if(c.getBoundsInParent().intersects(imageView.getBoundsInParent())) {
                      dx *= -1;
                  }

                  t1.run();
               }
            }
         )
      );

      // indicate that the timeline animation should run indefinitely
      timelineAnimation.setCycleCount(Timeline.INDEFINITE);
      timelineAnimation.play();
   }

   // determines whether the circle hit left/right of the window
   private boolean hitRightOrLeftEdge(Bounds bounds) {
      return (c.getLayoutX() <= (bounds.getMinX() + c.getRadius())) ||
         (c.getLayoutX() >= (bounds.getMaxX() - c.getRadius()));
   }

   // determines whether the circle hit top/bottom of the window
   private boolean hitTopOrBottom(Bounds bounds) {
      return (c.getLayoutY() <= (bounds.getMinY() + c.getRadius())) ||
         (c.getLayoutY() >= (bounds.getMaxY() - c.getRadius()));
   }

   boolean inside() {
       Bounds imageBound = imageView.getBoundsInLocal();
       Bounds circleBound = c.getBoundsInLocal();
       return circleBound.intersects(imageBound);
   }

   @FXML
   void keyPressed(KeyEvent event) {
       System.out.println("Key Pressed");
       Bounds bounds = pane.getBoundsInLocal();
       Double x = imageView.getLayoutX();
       Double y = imageView.getLayoutY();

       start = true;
       if(start) {
           if(event.getCode() == KeyCode.W) {
               if(bounds.getMinY() < y) {
                   imageView.setLayoutY(y - 10);
               }
           } else if(event.getCode() == KeyCode.S) {
               if(bounds.getMaxY() > y + imageView.getFitHeight()) {
                   imageView.setLayoutY(y + 10);
               }
           }
       }
   }

   @FXML
   void startClicked(ActionEvent event) {
        startTime = System.nanoTime();
        start = true;
        button.setVisible(false);
        c.setVisible(true);
        pane.requestFocus();
   }
}
