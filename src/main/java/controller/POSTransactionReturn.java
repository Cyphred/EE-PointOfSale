package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class POSTransactionReturn extends POSTransactionLogs implements Initializable {

    @FXML
    private Label lblTransactionNo;

    @FXML
    private TextField tfType;

    @FXML
    private TextField tfUser;

    @FXML
    private TextField tfCustomer;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfTime;

    @FXML
    private TextField tfOrder;

    @FXML
    private TextField tfItemName;

    @FXML
    private TextArea taReason;

    @FXML
    private Label lblQuantity;

    @FXML
    private Label lblTotalAmount;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        sceneManipulator.closeDialog();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Scanner scan = new Scanner(new FileInputStream("etc\\cache-tl-view.file"));
            lblTransactionNo.setText(scan.nextLine());
            tfType.setText(scan.nextLine());
            tfUser.setText(scan.nextLine());
            tfCustomer.setText(scan.nextLine());
            tfDate.setText(scan.nextLine());
            tfTime.setText(scan.nextLine());
            tfOrder.setText(scan.nextLine());
            scan.nextLine();
            tfItemName.setText(scan.nextLine());
            taReason.setText(scan.nextLine());
            lblQuantity.setText(lblQuantity.getText()+" "+scan.nextLine());
            lblTotalAmount.setText(lblTotalAmount.getText()+" "+scan.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
