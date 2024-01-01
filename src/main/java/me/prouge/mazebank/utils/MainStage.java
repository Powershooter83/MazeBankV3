package me.prouge.mazebank.utils;

import com.google.inject.Singleton;
import javafx.stage.Stage;


@Singleton
public class MainStage {

    private final Stage stage;

    public MainStage() {
        stage = new Stage();
    }


    public Stage get() {
        return this.stage;
    }

}
