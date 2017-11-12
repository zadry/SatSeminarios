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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Label lbInfo;
    @FXML
    private Button submit;
    @FXML
    private Button registrarse;
    @FXML
    private TextField tfPass;
    private static String userType;
    private String id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //focus lost para el usuario se verificara que el usuario existe en la base de datos
        submit.setDisable(true);
        lbUser.setTextFill(Color.web("Black"));
        tfUsuario.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
                // Your code
                //buscando en la tabla cadidato y en Asesor
                HelperLogin mHelperLogin = new HelperLogin();
                if (mHelperLogin.getCorreo(tfUsuario.getText().toUpperCase())) {
                    lbUser.setTextFill(Color.web("black"));
                    userType = "CANDIDATO";
                } else {

                    if (mHelperLogin.getCorreoAsesor(tfUsuario.getText().toUpperCase())) {
                        System.out.println("busco correo en asesor");
                        lbUser.setTextFill(Color.web("black"));
                        userType = "ASESOR";
                    } else {
                        lbUser.setTextFill(Color.web("Red"));
                    }

                }

            }
        });
        //focus lost para la contraseña

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlerSubmit(ActionEvent event) throws IOException {
        HelperLogin mHelperLogin = new HelperLogin();

        if (mHelperLogin.getMatricula(tfPass.getText(), tfUsuario.getText().toUpperCase())) {
            System.out.println("existe el candidato");
            lbPass.setTextFill(Color.web("black"));
            Stage myStage = showCandidatosDialog(id);
            submit.setDisable(true);
            myStage.show();

        } else {

            id = mHelperLogin.getMatriculaAsesor(tfPass.getText(), tfUsuario.getText().toUpperCase());
            System.out.println("entro a buscar el pass en Asesor y id = " + id);
            if (id != null) {

                lbPass.setTextFill(Color.web("black"));
                submit.setDisable(false);
                System.out.println("fui yo =" + id);
                //Creando un panel nuevo
                //showCustomerDialog(String id)
                Stage myStage = showAsesorDialog(id);
                myStage.show();
                submit.setDisable(true);
                // AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLActionPanelAsesor.fxml"));
                //mainPane.getChildren().setAll(pane);
            } else {
                submit.setDisable(true);
                lbPass.setTextFill(Color.web("Red"));
            }

        }
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

    @FXML
    private void handlerTFPass(KeyEvent event) {

        if (tfPass.getText().length() > 0) {
            submit.setDisable(false);

        }
    }

    public Stage showAsesorDialog(String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("FXMLActionPanelAsesor.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLActionPanelAsesorController controller = loader.<FXMLActionPanelAsesorController>getController();
        controller.initData(id);

        stage.show();

        return stage;
    }

    public Stage showCandidatosDialog(String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("FXMLActionPanelCandidatos.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        FXMLActionPanelCandidatosController controller = loader.<FXMLActionPanelCandidatosController>getController();
        controller.initData(id);

        stage.show();

        return stage;
    }
}
