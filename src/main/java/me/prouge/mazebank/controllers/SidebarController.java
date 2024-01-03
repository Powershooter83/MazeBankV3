package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import me.prouge.guicefx.View;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.mazebank.views.AppView;
import me.prouge.mazebank.views.navigation.DashboardView;
import me.prouge.mazebank.views.navigation.PaymentView;

import java.net.URL;
import java.util.ResourceBundle;

@Singleton
@FXController
public class SidebarController implements Initializable {

    public Button dashboardBtn;

    public Button paymentBtn;

    public Button inboxBtn;

    public Button favoriteBtn;

    public Button deleteBtn;

    public Button statisticsBtn;

    public Button scheduleBtn;
    public Button logoutBtn;

    @Inject
    private DashboardView dashboardView;
    @Inject
    private PaymentView paymentView;

    @Inject
    private AppView appView;

    private View activeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activeView = dashboardView;

        dashboardBtn.setOnAction(e -> changeView(dashboardView));
        paymentBtn.setOnAction(e -> changeView(paymentView));
    }

    private void changeView(View newView) {
        if (activeView == newView) {
            return;
        }

        BorderPane borderPane = (BorderPane) appView.getNode();
        if (newView == dashboardView) {
            //   dashboardView.show();
            borderPane.setCenter(dashboardView.getNode());
            // dashboardBtn.requestFocus();
        }
        if (newView == paymentView) {
            //  paymentView.show();
            borderPane.setCenter(paymentView.getNode());
            // paymentBtn.requestFocus();
        }

        activeView = newView;
    }
}
