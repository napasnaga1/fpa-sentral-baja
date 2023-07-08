package Profil;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import TokoSaya.ControllerTokoSaya;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

public class ControllerProfil {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane navigasi;

    @FXML
    private TextField alamat;

    @FXML
    private Label alamat1;

    @FXML
    private ImageView chatBtn;

    @FXML
    private Circle circle;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private TextField email;

    @FXML
    private Label email1;

    @FXML
    private Rectangle greySquare;

    @FXML
    private TextField jenisKelamin;

    @FXML
    private TextField nama;

    @FXML
    private Label nama1;

    @FXML
    private TextField nomorHP;

    @FXML
    private Label nomorHP1;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private AnchorPane paneProfil;

    @FXML
    private TextField password;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private ImageView square;

    @FXML
    private TextField tanggalLahir;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private Label username1;

    @FXML
    private TextField usernameProfil;

    ModelProfil model = new ModelProfil();

    @FXML
    void backFromProfil(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void gantiFoto(ActionEvent event) throws IOException {
        FileChooser Chooser = new FileChooser();

        FileChooser.ExtensionFilter exxFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");

        Chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);

        File file = Chooser.showOpenDialog(null);
        BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        square.setImage(image);
        circle.setFill(new ImagePattern(image));
        greySquare.setVisible(false);
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {
        username1.setText(usernameProfil.getText());
        nomorHP1.setText(nomorHP.getText());
        nama1.setText(nama.getText());
        alamat1.setText(alamat.getText());
        email1.setText(email.getText());

        model.setUsername(usernameProfil.getText());
        model.setNama(nama.getText());
        model.setNomorHP(nomorHP.getText());
        model.setAlamat(alamat.getText());
        model.setEmail(email.getText());
        model.setPassword(password.getText());
        model.setJenisKelamin(jenisKelamin.getText());
        model.setTanggalLahir(tanggalLahir.getText());

    }

    @FXML
    void tampilDaftarPesanan(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DaftarPesanan/DaftarPesanan.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerDaftarPesanan daftarPesananController = loader.getController();
        daftarPesananController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneChat(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Chat/Chat.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerChat chatController = loader.getController();
        chatController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneProfil(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Profil/Profil.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerProfil profilController = loader.getController();
        profilController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilToko(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TokoSaya/tokoSaya.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerTokoSaya tokoSayaController = loader.getController();
        tokoSayaController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }
}
