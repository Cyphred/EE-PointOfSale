package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import main.java.misc.BackgroundProcesses;

import java.net.URL;
import java.util.ResourceBundle;

public class POSCheckout extends POSCashier implements Initializable {

    @FXML
    private ImageView ivPrompt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackgroundProcesses.changeSecondaryFormStageStatus((short) 1);
    }


}
