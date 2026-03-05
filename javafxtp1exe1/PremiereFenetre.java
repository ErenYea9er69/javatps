import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class PremiereFenetre extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
       
        Line ligne = new Line(20, 20, 280, 20); 
        Rectangle rectangle = new Rectangle(50, 100, 50, 80); 
        Circle cercle = new Circle(180, 120, 40); 
        
        cercle.setFill(Color.RED);
        ligne.setStroke(Color.BLACK);
        rectangle.setStroke(Color.ORANGE);
        rectangle.setStrokeWidth(5);
        ligne.setStrokeWidth(3);

        root.getChildren().add(ligne);
        root.getChildren().add(rectangle);
        root.getChildren().add(cercle);

        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        primaryStage.setTitle("tp1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
