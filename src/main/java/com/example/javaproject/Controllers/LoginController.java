package com.example.javaproject.Controllers;

import com.example.javaproject.Models.Model;
import com.sun.jdi.connect.spi.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.swing.interop.SwingInterOpUtils;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public TextField su_surname;
    public TextField su_name;
    public TextField su_password;
    public TextField su_phone;
    public Button su_signupBtn;

    public TextField si_password;
    public TextField si_phone;
    public Hyperlink si_forgotPass;
    public Button si_signinBtn;

    public AnchorPane side_form;
    public Label side_message;
    public Button side_button;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        si_signinBtn.setOnAction((ActionEvent event) -> onLogin());
        side_button.setOnAction((ActionEvent event) -> switchForm());

    }

    public void onLogin() {
        Stage stage = (Stage) si_signinBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showMainWindow();
    }

    public void switchForm() {
        System.out.println("SwitchForm called!");

        TranslateTransition slider = new TranslateTransition();
        slider.setNode(side_form);
        slider.setDuration(Duration.seconds(.5));

        if (side_button.getText().equals("Create New Account")) {
            System.out.println("Create button clicked!");
            side_message.setText("Already have an account?");
            side_button.setText("Log In");

            slider.setToX(300);

        } else if (side_button.getText().equals("Log In")) {
            System.out.println("Already have button clicked!");
            side_message.setText("Don't have an account yet?");
            side_button.setText("Create New Account");

            slider.setToX(0);
        }

        slider.play();
    }
}
