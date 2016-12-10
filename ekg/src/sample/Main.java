package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
        public void start(Stage stage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.setTitle("Grams");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
