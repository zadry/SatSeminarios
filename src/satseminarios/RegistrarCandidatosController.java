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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;

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
    @FXML
    private ImageView ivFoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

            InputStream inputStream = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                System.out.println(selectedFile.toURI().toString());
                File file = new File(selectedFile.toURI().toString());
                inputStream = new FileInputStream(file);

                byte[] buffer = new byte[1024];
                baos = new ByteArrayOutputStream();

                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                System.out.println(bytesRead);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // String photo = selectedFile.toURI().toString();
            //System.out.println(selectedFile.toURI());
            //actionStatus.setText("File selected: " + selectedFile.getName());
        } else {
            //actionStatus.setText("File selection cancelled.");

        }
    }

    @FXML
    private void handlerAnexarCartaMotivos(ActionEvent event) {
    }

}
