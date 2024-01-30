package me.prouge.mazebank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;
import me.prouge.mazebank.utils.BasicModule;
import me.prouge.mazebank.views.authentication.LoginView;


public class App extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Injector injector = Guice.createInjector(new BasicModule());

        LoginView loginView = injector.getInstance(LoginView.class);
        stage.setWidth(450);
        stage.setTitle("Simplenote");
        stage.setHeight(450);
        loginView.show(stage);
    }

}