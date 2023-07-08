package ListRefund;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load file FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListRefund.fxml"));
            AnchorPane root = loader.load();
            
            // Mendapatkan instance dari kontroler
            ListRefundController controller = loader.getController();

            // Membuat scene
            Scene scene = new Scene(root);

            // Mengatur scene dan menampilkan stage
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
