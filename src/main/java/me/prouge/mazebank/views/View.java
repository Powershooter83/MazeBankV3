package me.prouge.mazebank.views;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.prouge.mazebank.utils.MainStage;
import me.prouge.mazebank.utils.cdi.CustomFXMLLoader;
import me.prouge.mazebank.utils.cdi.FXView;

import java.io.IOException;

public abstract class View {

    private final String viewName;
    @Inject
    private Injector injector;
    @Inject
    private MainStage stage;


    public View() {
        FXView config = this.getClass().getAnnotation(FXView.class);
        if (config.value().isEmpty()) {
            this.viewName = mapToFXMLFileName();
        } else {
            this.viewName = config.value();
        }
    }


    public void show() {
        CustomFXMLLoader customLoader = new CustomFXMLLoader(injector);
        try {
            Scene scene = new Scene(customLoader.load("/me/prouge/mazebank/view/" + viewName));
            stage.get().setScene(scene);
            stage.get().setTitle("Maze Bank");
            stage.get().show();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load view: " + viewName, e);
        }
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

    private String mapToFXMLFileName() {
        String className = getClass().getSimpleName();
        className = className.toLowerCase();
        className = className.replace("view", "");
        className += ".fxml";
        return className;
    }


}
