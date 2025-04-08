package com.example.javaproject.Controllers;

import com.example.javaproject.Models.Model;
import com.example.javaproject.Views.MenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public Button rentBtn;
    public Button activeOrdersBtn;
    public Button historyBtn;
    public Button supportBtn;
    public Button logoutBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        rentBtn.setOnAction(event -> onRent());
        activeOrdersBtn.setOnAction(event -> onOrders());
        historyBtn.setOnAction(event -> onHistory());
        supportBtn.setOnAction(event -> onSupport());
        logoutBtn.setOnAction(event -> onLogout());
    }

    private void onRent() {
        updateButtonStyle(rentBtn);
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(MenuOptions.TransportRent);
    }

    private void onOrders() {
        updateButtonStyle(activeOrdersBtn);
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(MenuOptions.ActiveOrders);
    }

    private void onHistory() {
        updateButtonStyle(historyBtn);
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(MenuOptions.OrdersHistory);
    }

    private void onSupport() {
        updateButtonStyle(supportBtn);
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(MenuOptions.SupportContacts);
    }

    private void onLogout() {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.resetModel();
    }

    public void updateButtonStyle(Button selectedButton) {
        Button[] buttons = {rentBtn, activeOrdersBtn, historyBtn, supportBtn};
        for (Button button : buttons) {
            if (button != selectedButton) {
                button.getStyleClass().remove("selected-button");
                System.out.println("removed selected button from " + button);
            }
        }
        if (!selectedButton.getStyleClass().contains("selected-button")) {
            selectedButton.getStyleClass().add("selected-button");
            System.out.println("added selected button to " + selectedButton.getText() + "\n");
        }
    }

}
