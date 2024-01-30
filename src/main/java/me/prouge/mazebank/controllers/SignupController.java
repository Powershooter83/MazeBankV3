package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.mazebank.service.LoginService;
import me.prouge.mazebank.views.authentication.LoginView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnMouseClicked(e -> loginView.show((Stage) loginBtn.getScene().getWindow()));
        registerBtn.setOnMouseClicked(e -> {
            if (loginService.isValidEmail(emailField.getText()) && pwdField.isVisible()) {
                loginService.register(emailField.getText(), pwdField.getText());
            }

            if (loginService.isValidEmail(emailField.getText()) && !pwdField.isVisible()) {
                pwdField.setVisible(true);
            }

        });


    }
}
