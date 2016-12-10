package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    @FXML
    public Button button;

    @FXML
    public Label lable;

    @FXML
    public void on_click(){

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Gramms, 2010");
        XYChart.Series series = new XYChart.Series();
        series.setName("EKG graphics");

        Stage stageTheLabelBelongs = (Stage) lable.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stageTheLabelBelongs);
        String csvFile = selectedFile.getAbsolutePath();

        Complex[][] y = P.readECGFile(csvFile);

        for(int i = 0; i < 2000; i++)
        {
            series.getData().add(new XYChart.Data(i, y[0][i].re));

        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        stageTheLabelBelongs.setScene(scene);
        stageTheLabelBelongs.show();


    }


}
