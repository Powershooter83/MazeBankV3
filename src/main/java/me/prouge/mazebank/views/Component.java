package me.prouge.mazebank.views;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javax.inject.Inject;
import java.io.IOException;

public abstract class Component<T extends Node> {

    protected final T root;
    private final String component;
    @Inject
    private Injector injector;

    public Component(String fxmlPath, T root) {
        this.component = fxmlPath;
        this.root = root;
    }

    public void initializeFXML() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/prouge/mazebank/view/sidebar.fxml"));
        fxmlLoader.setControllerFactory(injector::getInstance);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}