
package fppa;

import controller.CadastroCursoController;
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
public class CadastroCurso extends Application {
    
    public static Stage stage;

    public CadastroCurso(int Codigo) {
        CadastroCursoController.setCodigo(Codigo);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroCurso.fxml"));
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
        CadastroCurso.stage = stage;
    }

    
}

