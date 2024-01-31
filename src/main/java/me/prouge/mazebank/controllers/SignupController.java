package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.mazebank.exception.UserAlreadyExistsException;
import me.prouge.mazebank.service.LoginService;
import me.prouge.mazebank.views.AppView;
import me.prouge.mazebank.views.authentication.LoginView;
import me.prouge.mazebank.views.authentication.SignupView;

import java.net.URL;
import java.util.ResourceBundle;

@FXController
public class SignupController implements Initializable {
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;

    @FXML
    private TextField emailField;

    @FXML
    private TextField pwdField;

    @Inject
    private LoginView loginView;

    @Inject
    private LoginService loginService;

    @Inject
    private SignupView signupView;

    @FXML
    private VBox vbox;

    @Inject
    private AppView appView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnMouseClicked(e -> loginView.show((Stage) loginBtn.getScene().getWindow()));
        registerBtn.setOnMouseClicked(e -> {
            if (loginService.isValidEmail(emailField.getText()) && pwdField.isVisible()) {
                try {
                    loginService.register(emailField.getText(), pwdField.getText());
                    appView.show((Stage) loginBtn.getScene().getWindow());
                }catch (UserAlreadyExistsException exception) {
                    vbox.getChildren().add(3, new Text("Not visible"));
                    return;
                }
            }

            if (loginService.isValidEmail(emailField.getText()) && !pwdField.isVisible()) {
                pwdField.setVisible(true);
            }

        });


    }
}
