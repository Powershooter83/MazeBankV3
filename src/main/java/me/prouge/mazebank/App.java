package me.prouge.mazebank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;
import me.prouge.mazebank.utils.cdi.BasicModule;
import me.prouge.mazebank.views.AppView;


public class App extends Application {


    @Override
    public void start(Stage stage) {
        Injector injector = Guice.createInjector(new BasicModule());

        AppView appView = injector.getInstance(AppView.class);
        appView.show();
        appView.test();
    }


}