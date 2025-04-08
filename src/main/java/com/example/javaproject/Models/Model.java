package com.example.javaproject.Models;

import com.example.javaproject.Views.ViewFactory;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    //private final DatabaseDriver databaseDriver;


    public Model() {
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public static void resetModel() {
        model = null;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

//    public DatabaseDriver getDatabaseDriver() {
//        return databaseDriver
//    }

}
