/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author javv
 */
public class RegistrarCandidatosController implements Initializable {

    @FXML
    private Button btAnexarFoto;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoP;
    @FXML
    private TextField tfApellidoM;
    @FXML
    private TextField tfMatricula;
    @FXML
    private TextField Correo;
    @FXML
    private TextField Telefono;
    @FXML
    private TextField tfTemaTesis;
    @FXML
    private TextField tfDirectorTesis;
    @FXML
    private ChoiceBox<?> cbCarrera;
    @FXML
    private Button btAnexarCartaCompromiso;
    @FXML
    private Button btAnexarCartaMotivos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlerAnexarFoto(ActionEvent event) {
    }

    @FXML
    private void handlerBtCartaCompromiso(ActionEvent event) {
    }

    @FXML
    private void handlerAnexarCartaMotivos(ActionEvent event) {
    }

}
