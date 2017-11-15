/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios;

import DataBaseLayer.HelperAsesor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import satseminarios.Logic.Asesor;
import satseminarios.Logic.Validacion;

/**
 * FXML Controller class
 *
 * @author javv
 */
public class RegistrarAsesorController implements Initializable {

    @FXML
    private Label lbNombre;
    @FXML
    private TextField tfNombre;
    @FXML
    private Label lbApellidoP;
    @FXML
    private TextField tfApellidoP;
    @FXML
    private Label lbApellidoM;
    @FXML
    private TextField tfApellidoM;
    @FXML
    private Label lbCorreo;
    @FXML
    private TextField tfCorreo;
    @FXML
    private Label lbContraseña;
    @FXML
    private PasswordField tfContraseña;
    @FXML
    private Label lbCubiculo;
    @FXML
    private TextField tfCubiculo;
    @FXML
    private Label lbHorarioAsesorias;
    @FXML
    private CheckBox cbLunes;
    @FXML
    private CheckBox cbMartes;
    @FXML
    private CheckBox cbMiercoles;
    @FXML
    private CheckBox cbJueves;
    @FXML
    private CheckBox cbViernes;
    @FXML
    private ChoiceBox<String> cbLunesIni;
    @FXML
    private ChoiceBox<String> cbMartesIni;
    @FXML
    private ChoiceBox<String> cbMiercolesIni;
    @FXML
    private ChoiceBox<String> cbJuevesIni;
    @FXML
    private ChoiceBox<String> cbViernesIni;
    @FXML
    private ChoiceBox<String> cbLunesFin;
    @FXML
    private ChoiceBox<String> cbMartesFin;
    @FXML
    private ChoiceBox<String> cbMiercolesFin;
    @FXML
    private ChoiceBox<String> cbViernesFin;
    @FXML
    private Button btRegistrar;
    private String horarioAsesoria;
    Asesor mAsesor;
    @FXML
    private ChoiceBox<String> cbJuevesFin;
    @FXML
    private AnchorPane mainPain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mAsesor = new Asesor();
        horarioAsesoria = "";
        tfNombre.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfNombre.getText())) {
                    lbNombre.setTextFill(Color.web("black"));
                    mAsesor.setNombre(tfNombre.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }

                } else {
                    lbNombre.setTextFill(Color.web("red"));

                }
            }
        });
        tfApellidoP.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfApellidoP.getText())) {
                    lbApellidoP.setTextFill(Color.web("black"));
                    mAsesor.setApellidoP(tfApellidoP.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }
                } else {
                    lbApellidoP.setTextFill(Color.web("red"));

                }
            }
        });
        tfApellidoM.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfApellidoM.getText())) {
                    lbApellidoM.setTextFill(Color.web("black"));
                    mAsesor.setApellidoM(tfApellidoM.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }
                } else {
                    lbApellidoM.setTextFill(Color.web("red"));

                }
            }
        });
        tfCorreo.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCorreo(tfCorreo.getText())) {
                    lbCorreo.setTextFill(Color.web("black"));
                    mAsesor.setCorreo(tfCorreo.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }
                } else {
                    lbCorreo.setTextFill(Color.web("red"));

                }
            }
        });
        tfContraseña.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarContraseña(tfContraseña.getText())) {
                    lbContraseña.setTextFill(Color.web("black"));
                    mAsesor.setPass(tfContraseña.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }
                } else {
                    lbContraseña.setTextFill(Color.web("red"));

                }
            }
        });
        tfCubiculo.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCubiculo(tfCubiculo.getText())) {
                    lbCubiculo.setTextFill(Color.web("black"));
                    mAsesor.setPass(tfCubiculo.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btRegistrar.setDisable(false);
                    }
                } else {
                    lbCubiculo.setTextFill(Color.web("red"));

                }
            }
        });
    }

    private boolean ValidarCampos() {
        System.out.println("Validar Campos");
        if (Validacion.validarCadenas(tfNombre.getText())
                && Validacion.validarCadenas(tfApellidoP.getText())
                && Validacion.validarCadenas(tfApellidoM.getText())
                && Validacion.validarContraseña(tfContraseña.getText())
                && Validacion.validarCorreo(tfCorreo.getText())
                && Validacion.validarCubiculo(tfCubiculo.getText())) {

            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void handlerRegistrar(ActionEvent event) {
        if (cbLunes.isSelected() || cbMartes.isSelected()
                || cbMiercoles.isSelected() || cbJueves.isSelected()
                || cbViernes.isSelected()) {

            lbHorarioAsesorias.setText("Horario de Asesorias");
            lbHorarioAsesorias.setTextFill(Color.web("black"));

            if (cbLunes.isSelected()) {
                horarioAsesoria = horarioAsesoria + " Lunes de " + cbLunesIni.getValue() + " a " + cbLunesFin.getValue();
            }
            if (cbMartes.isSelected()) {
                horarioAsesoria = horarioAsesoria + " Martes de " + cbMartesIni.getValue() + " a " + cbMartesIni.getValue();
            }
            if (cbMiercoles.isSelected()) {
                horarioAsesoria = horarioAsesoria + " Miercoles de " + cbMiercolesIni.getValue() + " a " + cbMiercolesIni.getValue();
            }
            if (cbJueves.isSelected()) {
                horarioAsesoria = horarioAsesoria + " Jueves de " + cbJuevesIni.getValue() + " a " + cbJuevesIni.getValue();
            }
            if (cbViernes.isSelected()) {
                horarioAsesoria = horarioAsesoria + " Viernes de " + cbViernesIni.getValue() + " a " + cbViernesIni.getValue();
            }
            mAsesor.setNombre(tfNombre.getText().toUpperCase());
            mAsesor.setApellidoP(tfApellidoP.getText().toUpperCase());
            mAsesor.setApellidoM(tfApellidoM.getText().toUpperCase());
            mAsesor.setCorreo(tfCorreo.getText().toUpperCase());
            mAsesor.setPass(tfContraseña.getText());
            mAsesor.setHorarioAsesorias(horarioAsesoria);
            mAsesor.setCubiculo(tfCubiculo.getText());
            /*
            mAsesor esta listo para se incrustado en la base de datos
             */
            System.out.println("Nombre: " + mAsesor.getNombre()
                    + "\nApellido paterno: " + mAsesor.getApellidoP()
                    + "\nApellido Materno: " + mAsesor.getApellidoM()
                    + "\nCorreo: " + mAsesor.getCorreo()
                    + "\nHorario Asesorias: " + mAsesor.getHorarioAsesorias()
                    + "\nPass: " + mAsesor.getPass());
            HelperAsesor mHelperAsesor = new HelperAsesor();
            try {
                if (mHelperAsesor.insertAsesor(mAsesor)) {
                    System.out.println("El asesor ha sido insertado con exito");
                    //aviso de que el asesor fue insertado con exito y vuelta atras
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("AVISO");
                    alert.setHeaderText("El aseso fue Registrado con exito.");
                    //  alert.setContentText("Escoja una opción");

                    ButtonType buttonTypeOne = new ButtonType("Registrar Candidato");
                    ButtonType buttonTypeTwo = new ButtonType("Registrar Asesor");

                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    alert.getButtonTypes().setAll(buttonTypeOk);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeOk) {
                        // ... user chose "One"
                        AnchorPane pane;
                        try {
                            pane = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                            mainPain.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(RegistrarAsesorController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                } else {
                    System.out.println("ERROR al insertar asesor");
                }
            } catch (SQLException ex) {
                System.out.println("Exception " + ex.getMessage());
                Logger.getLogger(RegistrarAsesorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lbHorarioAsesorias.setTextFill(Color.web("red"));
            lbHorarioAsesorias.setText("Horario de Asesorias, Este campo es obligatorio");
            btRegistrar.setDisable(true);
        }
    }

    @FXML
    private void handlerLunes(ActionEvent event) {
        if (cbLunes.isSelected()) {
            cbLunesIni.setDisable(false);
            cbLunesFin.setDisable(false);
            llenarCheckBoxHora(cbLunesIni);
            llenarCheckBoxHora(cbLunesFin);
        }
    }

    @FXML
    private void handlerMartes(ActionEvent event) {
        if (cbMartes.isSelected()) {
            cbMartesIni.setDisable(false);
            cbMartesFin.setDisable(false);
            llenarCheckBoxHora(cbMartesIni);
            llenarCheckBoxHora(cbMartesFin);
        }
    }

    @FXML
    private void handlerMiercoles(ActionEvent event) {
        if (cbMiercoles.isSelected()) {
            cbMiercolesIni.setDisable(false);
            cbMiercolesFin.setDisable(false);
            llenarCheckBoxHora(cbMiercolesIni);
            llenarCheckBoxHora(cbMiercolesFin);
        }
    }

    @FXML
    private void handlerJueves(ActionEvent event) {
        if (cbJueves.isSelected()) {
            cbJuevesIni.setDisable(false);
            cbJuevesFin.setDisable(false);
            llenarCheckBoxHora(cbJuevesIni);
            llenarCheckBoxHora(cbJuevesFin);
        }
    }

    @FXML
    private void handlerViernes(ActionEvent event) {
        if (cbViernes.isSelected()) {
            cbViernesIni.setDisable(false);
            cbViernesFin.setDisable(false);
            llenarCheckBoxHora(cbViernesIni);
            llenarCheckBoxHora(cbViernesFin);
        }
    }

    private void llenarCheckBoxHora(ChoiceBox<String> box) {
        box.setItems(FXCollections.observableArrayList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
    }
}
