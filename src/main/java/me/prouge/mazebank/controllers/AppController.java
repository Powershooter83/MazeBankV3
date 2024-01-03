package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.mazebank.views.navigation.DashboardView;
import me.prouge.mazebank.views.navigation.SidebarView;

import java.net.URL;
import java.util.ResourceBundle;


@Singleton
@FXController
public class AppController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Inject
    private SidebarView sidebarView;

    @Inject
    private DashboardView dashboardView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borderPane.setLeft(sidebarView.getNode());
        borderPane.setCenter(dashboardView.getNode());
    }
}
