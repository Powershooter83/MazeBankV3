package me.prouge.mazebank.views;


import com.google.inject.Singleton;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import me.prouge.mazebank.utils.cdi.FXView;

@Singleton
@FXView
public class AppView extends View {


    @FXML
    private BorderPane borderPane;


    public void test() {
        System.out.println(borderPane);

    }

}
