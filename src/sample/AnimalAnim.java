package sample;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import noGraphic.Animal;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;
import javax.swing.*;
import java.awt.*;
public class AnimalAnim extends Transition {
    Animal animal;

    public AnimalAnim(Animal animal) {
        this.animal = animal;
        this.setCycleDuration(Duration.millis(3000));
        this.setCycleCount(1);
    }

    @Override
    protected void interpolate(double v) {
      this.animal.setImageView();
    }
}
