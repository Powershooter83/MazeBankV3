package me.prouge.mazebank.controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.mazebank.service.LoginService;
import me.prouge.mazebank.views.authentication.SignupView;

import java.net.URL;
import java.util.ResourceBundle;

@FXController
public class LoginController implements Initializable {


    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private Button pwdResetBtn;

    @FXML
    private TextField emailField;

    @FXML
    private TextField pwdField;

    @Inject
    private LoginService loginService;

    @Inject
    private SignupView signupView;


    private void login() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnMouseClicked(e -> loginService.login(emailField.getText(), pwdField.getText()));
        registerBtn.setOnMouseClicked(e -> signupView.show((Stage) loginBtn.getScene().getWindow()));
    }

}
