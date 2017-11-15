/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios;

import DataBaseLayer.HelperCandidatos;
import DataBaseLayer.HelperLogin;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;
import satseminarios.Logic.Candidato;
import satseminarios.Logic.Validacion;

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
    private ChoiceBox<String> cbCarrera;
    @FXML
    private Button btAnexarCartaCompromiso;
    @FXML
    private Button btAnexarCartaMotivos;
    @FXML
    private ImageView ivFoto;
    @FXML
    private ChoiceBox<String> cbHoraInicial;
    @FXML
    private ChoiceBox<String> chHoraFinal;

    private Candidato mCandidato;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbApellidP;
    @FXML
    private Label lbApellidoM;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbCorreo;
    @FXML
    private Label lbTelefono;
    @FXML
    private Label lbTemaTesis;
    @FXML
    private Label lbDirectorTesis;
    @FXML
    private Label lbCarrera;
    @FXML
    private CheckBox cbTrabaja;
    @FXML
    private Label lbHorarioLaboral;
    @FXML
    private Label lbLugarTrabajo;
    @FXML
    private Label lbCartaCompromiso;
    @FXML
    private Label lbCartaMotivos;
    @FXML
    private Button btSubmit;
    @FXML
    private TextField tfLugarTrabajo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //cbCarrera = new ChoiceBox();
        btSubmit.setDisable(true);

        mCandidato = new Candidato();
        System.out.println("se ejecuta al inicio");
        /* cbCarrera = new ChoiceBox<String>(FXCollections.observableArrayList(
                "Ing. de Software", "Ing. en Sistemas de Transporte Urbano",
                "Ing. en Sistemas Electrónicos Industriales",
                "Ing. de Software",
                "Ing. de Software", "Ing. en Sistemas Energéticos",
                "Modelación Matemática"));*/
        // ChoiceBox cbCarrera = new ChoiceBox<String>();
        cbCarrera.setItems(FXCollections.observableArrayList(
                "Ing. de Software", "Ing. en Sistemas de Transporte Urbano",
                "Ing. en Sistemas Electrónicos Industriales",
                "Ing. de Software",
                "Ing. de Software", "Ing. en Sistemas Energéticos",
                "Modelación Matemática"));
        cbHoraInicial.setItems(FXCollections.observableArrayList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));

        chHoraFinal.setItems(FXCollections.observableArrayList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
        //metodos para onfofusleft de cada campo
        tfNombre.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfNombre.getText())) {
                    lbNombre.setTextFill(Color.web("black"));
                    mCandidato.setNombre(tfNombre.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btSubmit.setDisable(false);
                    }

                } else {
                    lbNombre.setTextFill(Color.web("red"));

                }
            }
        });
        tfApellidoP.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfApellidoP.getText())) {
                    lbApellidP.setTextFill(Color.web("black"));
                    mCandidato.setApellidoP(tfApellidoP.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btSubmit.setDisable(false);
                    }
                } else {
                    lbApellidP.setTextFill(Color.web("red"));

                }
            }
        });
        tfApellidoM.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCadenas(tfApellidoM.getText())) {
                    lbApellidoM.setTextFill(Color.web("black"));
                    mCandidato.setApellidoM(tfApellidoM.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btSubmit.setDisable(false);
                    }
                } else {
                    lbApellidoM.setTextFill(Color.web("red"));

                }
            }
        });

        tfMatricula.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarMatricula(tfMatricula.getText())) {
                    lbMatricula.setTextFill(Color.web("black"));
                    mCandidato.setMatricula(tfMatricula.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btSubmit.setDisable(false);
                    }
                } else {
                    lbMatricula.setTextFill(Color.web("red"));

                }
            }
        });
        Correo.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarCorreo(Correo.getText())) {
                    lbCorreo.setTextFill(Color.web("black"));
                    mCandidato.setCorreo(Correo.getText().toUpperCase());
                    if (ValidarCampos()) {
                        btSubmit.setDisable(false);
                    }
                } else {
                    lbCorreo.setTextFill(Color.web("red"));

                }
            }
        });
        Telefono.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost

                if (Validacion.validarTelefono(Telefono.getText())) {
                    lbTelefono.setTextFill(Color.web("black"));
                    mCandidato.setTelefono(Telefono.getText().toUpperCase());

                } else {
                    lbTelefono.setTextFill(Color.web("red"));
                }
            }
        });

    }

    @FXML
    private void handlerAnexarFoto(ActionEvent event) throws IOException, SQLException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.bitmap", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //Dividiendo la direccion para cortarle la cabeza
            System.out.println(selectedFile.toURI().toString());
            String string = selectedFile.toURI().toString();

            String[] parts = string.split(":");
            mCandidato.setFotografia("C:" + parts[2]);

        } else {

            mCandidato.setFotografia(null);
        }

    }

    @FXML
    private void handlerBtCartaCompromiso(ActionEvent event) throws IOException, SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //Dividiendo la direccion para cortarle la cabeza
            System.out.println(selectedFile.toURI().toString());
            String string = selectedFile.toURI().toString();

            String[] parts = string.split(":");
            System.out.println("parte 0 " + parts[1] + " part 2 = " + parts[2]);
            System.out.println("C:" + parts[2]);

            mCandidato.setCartaComprimisoS("C:" + parts[2]);

        } else {

            mCandidato.setCartaComprimisoS(null);
        }
    }

    @FXML
    private void handlerAnexarCartaMotivos(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //Dividiendo la direccion para cortarle la cabeza
            String string = selectedFile.toURI().toString();

            String[] parts = string.split(":");
            mCandidato.setCartaMotivos("C:" + parts[2]);
            System.out.println("Dir Carta Motivos: " + mCandidato.getCartaMotivos());
        } else {
            mCandidato.setCartaMotivos(null);
        }
    }

    @FXML
    private void handlerCBCarrera(MouseEvent event) {
        System.out.println("CARRERA: " + cbCarrera.getValue());

        mCandidato.setCarrera(cbCarrera.getValue());
    }

    /**
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void handlerSubmit(final ActionEvent event) throws SQLException {
        if (cbCarrera.getValue() == null) {
            lbCarrera.setTextFill(Color.web("red"));
        } else {
            mCandidato.setCarrera(cbCarrera.getValue().toUpperCase());
            mCandidato.setTemaTesis(tfTemaTesis.getText().toUpperCase());
            mCandidato.setDirectorTesis(tfDirectorTesis.getText().toUpperCase());
            if (cbTrabaja.isSelected()) {
                mCandidato.setTrabaja(1);
                mCandidato.setHorario(cbHoraInicial.getValue() + " Hrs a " + chHoraFinal.getValue() + " Hrs");
                mCandidato.setLugarDeTrabajo(tfLugarTrabajo.getText().toUpperCase());
            } else {
                mCandidato.setTrabaja(0);
            }

            System.out.println(
                    "\n nombre:" + mCandidato.getNombre()
                    + "\nApellido paterno: " + mCandidato.getApellidoP()
                    + "\nApellido Materno: " + mCandidato.getApellidoM()
                    + "\nMatricula: " + mCandidato.getMatricula()
                    + "\nCorreo:" + mCandidato.getCorreo()
                    + "\nDirector Tesis: " + mCandidato.getDirectorTesis()
                    + "\nTema tesis: " + mCandidato.getTemaTesis()
                    + "\nCarrera: " + mCandidato.getCarrera()
                    + "\nTrabaja: " + mCandidato.getTrabaja()
                    + "\nHorario de Trabajo: " + mCandidato.getHorario()
                    + "\nLugar de trabajo: " + mCandidato.getLugarDeTrabajo());
            HelperCandidatos mHelperCandidatos = new HelperCandidatos();

            if (mHelperCandidatos.insertCandidato(mCandidato)) {

                System.out.println("Insertado con exito");
                if (mCandidato.getCartaComprimisoS() != null) {
                    if (mHelperCandidatos.setCartaCompromiso(mCandidato)) {
                        System.out.println("Carta insertada con exito");
                    } else {
                        System.out.println("Carta no inseratda");
                    }

                } else {
                    System.out.println("carta compromiso = null");
                }
                if (mCandidato.getFotografia() != null) {
                    if (mHelperCandidatos.setFoto(mCandidato)) {
                        System.out.println("Foto insertada con exito");
                    } else {
                        System.out.println("Foto no inseratda");
                    }

                } else {
                    System.out.println("Foto = null");
                }
                if (mCandidato.getCartaMotivos() != null) {
                    if (mHelperCandidatos.setCartaMotivos(mCandidato)) {
                        System.out.println("Carta motivos insertada con exito");
                    } else {
                        System.out.println("Carta motivos no inseratda");
                    }

                } else {
                    System.out.println("carta motivos = null");
                }
            }
        }
    }

    private boolean ValidarCampos() {
        if (Validacion.validarCadenas(tfNombre.getText())
                && Validacion.validarCadenas(tfApellidoP.getText())
                && Validacion.validarCadenas(tfApellidoM.getText())
                && Validacion.validarMatricula(tfMatricula.getText())
                && Validacion.validarCorreo(Correo.getText())) {

            return true;
        } else {
            return false;
        }
    }

}
