package com.example.javaproject.Controllers;

import com.example.javaproject.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public BorderPane root;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getSelectedMenuItem().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case TransportRent:
                    root.setCenter(Model.getInstance().getViewFactory().getTransportRentView());
                    break;
                case ActiveOrders:
                    root.setCenter(Model.getInstance().getViewFactory().getActiveOrdersView());
                    break;
                case OrdersHistory:
                    root.setCenter(Model.getInstance().getViewFactory().getOrdersHistoryView());
                    break;
                case SupportContacts:
                    root.setCenter(Model.getInstance().getViewFactory().getSupportContactsView());
                    break;
                default :
                    root.setCenter(Model.getInstance().getViewFactory().getHelloView());
                    break;
            }
        });
    }

}
