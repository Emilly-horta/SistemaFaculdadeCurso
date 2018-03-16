package fppa;

import controller.CursoFaculdadeController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tawan Rodrigues
 */
public class CursoFaculdade extends Application {

    public static Stage stage;

    public CursoFaculdade() {
    }

    public CursoFaculdade(int codigo) {
        CursoFaculdadeController.setCodigo(codigo);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CursoFaculdade.fxml"));
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
        CursoFaculdade.stage = stage;
    }

}
