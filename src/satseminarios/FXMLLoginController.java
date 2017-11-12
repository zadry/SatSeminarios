/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios;

import DataBaseLayer.HelperLogin;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author javv
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Label lbUser;
    @FXML
    private TextField tfUsuario;
    @FXML
    private Label lbPass;
    @FXML
    private TextField pass;
    @FXML
    private Label lbInfo;
    @FXML
    private Button submit;
    @FXML
    private Button registrarse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //focus lost para el usuario se verificara que el usuario existe en la base de datos
        tfUsuario.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                // Your code
                ArrayList<String> resultado = new ArrayList();
                HelperLogin mHelperLogin = new HelperLogin();
                resultado = mHelperLogin.getCorreo(tfUsuario.getText());
                System.out.println(resultado.toString());
            }
        });
        //focus lost para la contraseña
        tfUsuario.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                // Your code
                // System.out.println("foucuslost");
            }
        });
    }

    @FXML
    private void handlerSubmit(ActionEvent event) {
    }

    @FXML
    private void handlerRegistrarse(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("AVISO");
        alert.setHeaderText("Escoja la acción que desea realizar");
        alert.setContentText("Escoja una opción");

        ButtonType buttonTypeOne = new ButtonType("Registrar Candidato");
        ButtonType buttonTypeTwo = new ButtonType("Registrar Asesor");

        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarCandidatos.fxml"));
            mainPane.getChildren().setAll(pane);

        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarAsesor.fxml"));
            mainPane.getChildren().setAll(pane);
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

}
