/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satseminarios;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;
import satseminarios.Logic.Candidato;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //cbCarrera = new ChoiceBox();
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
    }

    @FXML
    private void handlerAnexarFoto(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.bitmap", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            Image image = new Image(selectedFile.toURI().toString());
            ivFoto.setImage(image);
            BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", s);
            //ress es la variable a guardar en la base de datos como binario
            byte[] res = s.toByteArray();
            s.close();
            System.out.println(res.length);

            // String photo = selectedFile.toURI().toString();
            //System.out.println(selectedFile.toURI());
            //actionStatus.setText("File selected: " + selectedFile.getName());
        } else {
            //actionStatus.setText("File selection cancelled.");

        }

    }

    @FXML
    private void handlerBtCartaCompromiso(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //Dividiendo la direccion para cortarle la cabeza
            System.out.println(selectedFile.toURI().toString());
            String string = selectedFile.toURI().toString();

            String[] parts = string.split(":");
            System.out.println("parte 0 " + parts[1] + " part 2 = " + parts[2]);
            File file = new File("C:" + parts[2]);
            FileInputStream fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];
            fin.read(fileContent);
            //File contente tiene el archivo a guardar en la base de datos

        } else {
            //actionStatus.setText("File selection cancelled.");

        }
    }

    @FXML
    private void handlerAnexarCartaMotivos(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //Dividiendo la direccion para cortarle la cabeza
            System.out.println(selectedFile.toURI().toString());
            String string = selectedFile.toURI().toString();

            String[] parts = string.split(":");
            System.out.println("parte 0 " + parts[1] + " part 2 = " + parts[2]);
            File file = new File("C:" + parts[2]);
            FileInputStream fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];
            fin.read(fileContent);
        }
    }

    @FXML
    private void handlerCBCarrera(MouseEvent event) {

    }

}
