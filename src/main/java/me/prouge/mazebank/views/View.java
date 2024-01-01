package me.prouge.mazebank.views;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.prouge.mazebank.utils.MainStage;

import java.io.IOException;

public abstract class View {

    private final String viewName;
    @Inject
    private Injector injector;
    @Inject
    private MainStage stage;


    public View() {
        ViewConfig config = this.getClass().getAnnotation(ViewConfig.class);
        this.viewName = config.value();
        initialize();
    }


    public void show() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/me/prouge/mazebank/view/" + viewName + ".fxml"));
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
