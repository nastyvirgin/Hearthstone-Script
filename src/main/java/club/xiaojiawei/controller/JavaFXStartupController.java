package club.xiaojiawei.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 肖嘉威
 * @date 2023/10/14 12:43
 */
public class JavaFXStartupController implements Initializable {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label tip;
    private static int count;
    private static Label staticTip;
    private static ProgressBar staticProgressBar;
    private static Timer timer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticTip = tip;
        staticProgressBar = progressBar;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (++count == 100){
                    timer.cancel();
                }else {
                    Platform.runLater(() -> {
                        tip.setText(String.format("HS-Assistant启动中......%d%%", count));
                        progressBar.setProgress((double) count / 100);
                    });
                }
            }
        }, 400, 10);
    }

    public static void complete(){
        Platform.runLater(() -> {
            timer.cancel();
            staticTip.setText("HS-Assistant启动中......100%");
            staticProgressBar.setProgress(1D);
        });
    }
}
