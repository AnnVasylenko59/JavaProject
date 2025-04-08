package com.example.javaproject.Views;

import com.example.javaproject.Controllers.LoginController;
import com.example.javaproject.Controllers.MainController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private final ObjectProperty<MenuOptions> selectedMenuItem;
    private AnchorPane helloView;
    private AnchorPane transportRentView;
    private AnchorPane activeOrdersView;
    private AnchorPane ordersHistoryView;
    private AnchorPane supportContactsView;

    public ViewFactory() {
        this.selectedMenuItem = new SimpleObjectProperty<>();
    }

    public ObjectProperty<MenuOptions> getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public AnchorPane getHelloView() {
        if (helloView == null) {
            try {
                helloView = new FXMLLoader(getClass().getResource("/Fxml/ContentWindows/HelloWindow.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return helloView;
    }

    public AnchorPane getTransportRentView() {
        if (transportRentView == null) {
            try {
                transportRentView = new FXMLLoader(getClass().getResource("/Fxml/ContentWindows/TransportRentWindow.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return transportRentView;
    }

    public AnchorPane getActiveOrdersView() {
        if (activeOrdersView == null) {
            try {
                activeOrdersView = new FXMLLoader(getClass().getResource("/Fxml/ContentWindows/ActiveOrdersWindow.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return activeOrdersView;
    }

    public AnchorPane getOrdersHistoryView() {
        if (ordersHistoryView == null) {
            try {
                ordersHistoryView = new FXMLLoader(getClass().getResource("/Fxml/ContentWindows/OrdersHistoryWindow.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ordersHistoryView;
    }

    public AnchorPane getSupportContactsView() {
        if (supportContactsView == null) {
            try {
                supportContactsView = new FXMLLoader(getClass().getResource("/Fxml/ContentWindows/SupportContactsWindow.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return supportContactsView;
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/LoginWindow.fxml"));
        LoginController loginController = new LoginController();
        loader.setController(loginController);
        createStage(loader);
    }

    public void showMainWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MainWindow.fxml"));
        MainController mainController = new MainController();
        loader.setController(mainController);
        createStage(loader);
    }

    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        //stage.getIcons().add(new Image();
        stage.setTitle("TransportSharingSystem");
        stage.setResizable(false);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
