
package fppa;

import controller.AtualizarController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Faculdade;

/**
 *
 * @author Tawan Rodrigues
 */
public class Atualizar extends Application {
    
    public Atualizar(Faculdade faculdade){
        AtualizarController.setFaculdade(faculdade);
    }
    
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Atualizar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Atualizar.stage = stage;
    }
}
