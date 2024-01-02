package me.prouge.mazebank.utils.cdi;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CustomFXMLLoader {
    private final Injector injector;
    private final Map<String, Class<?>> controllerMap = new HashMap<>();

    public CustomFXMLLoader(Injector injector) {
        this.injector = injector;

        Reflections reflections = new Reflections("me.prouge.mazebank.controllers");
        Set<Class<?>> controllerClasses = reflections.getTypesAnnotatedWith(FXController.class);

        for (Class<?> controllerClass : controllerClasses) {
            controllerMap.put(controllerClass.getSimpleName(), controllerClass);
        }
    }


    public Parent load(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        String controllerName = deriveControllerName(fxmlPath);

        try {
            Object controller = injector.getInstance(controllerMap.get(controllerName));
            loader.setController(controller);
        } catch (Exception e) {
            throw new RuntimeException("Controller not found for " + fxmlPath, e);
        }
        return loader.load();
    }

    private String deriveControllerName(String fxmlPath) {
        String baseName = fxmlPath.substring(fxmlPath.lastIndexOf("/") + 1);
        String controller = baseName.replace(".fxml", "");
        controller = controller.substring(0, 1).toUpperCase() + controller.substring(1);
        controller += "Controller";
        return controller;
    }

}
