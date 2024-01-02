package me.prouge.mazebank.controllers;

import com.google.inject.Singleton;
import javafx.fxml.Initializable;
import me.prouge.mazebank.utils.cdi.FXController;

import java.net.URL;
import java.util.ResourceBundle;


@Singleton
@FXController
public class AppController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("YEAH");
    }
}
