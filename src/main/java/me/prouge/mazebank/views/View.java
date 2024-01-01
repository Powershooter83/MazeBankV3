package me.prouge.mazebank.views;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.prouge.mazebank.utils.MainStage;

import java.io.IOException;

public abstract class View {

    protected final String view;
    @Inject
    private Injector injector;

    @Inject
    private MainStage stage;


    public View(final String view) {
        this.view = view;
        initialize();
    }

    public void show() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/prouge/mazebank/view/" + view));
        loader.setControllerFactory(type -> injector.getInstance(type));
        createStage(loader);
    }

    public void initialize() {
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.get().setScene(scene);
        stage.get().setTitle("Maze Bank");
        stage.get().show();
    }


}
