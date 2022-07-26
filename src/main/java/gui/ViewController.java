package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private Label labelResult;
    @FXML
    private Button btSum;
    @FXML
    private Button btReset;

    @FXML
    public void onBtSumAction() {
        try {
            Locale.setDefault(Locale.US);
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;
            labelResult.setText(Double.toString(sum));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Incorrect input",null, "Invalid input", Alert.AlertType.ERROR);
            onBtResetAction();
        }

    }
    public void onBtResetAction() {
        txtNumber1.setText(null);
        txtNumber2.setText(null);
        labelResult.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);

        Constraints.setTextFieldMaxLength(txtNumber1, 8);
        Constraints.setTextFieldMaxLength(txtNumber2, 8);
    }
}