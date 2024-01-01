package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import me.prouge.mazebank.views.DashboardView;
import me.prouge.mazebank.views.PaymentView;
import me.prouge.mazebank.views.View;

import java.net.URL;
import java.util.ResourceBundle;

@Singleton
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


    private View activeView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activeView = dashboardView;
        dashboardBtn.setOnAction(e -> changeView(dashboardView));
        paymentBtn.setOnAction(e -> changeView(paymentView));
    }

    private void changeView(View newView) {
        if (activeView.getClass().equals(newView.getClass())) {
            return;
        }

        newView.show();
    }
}
