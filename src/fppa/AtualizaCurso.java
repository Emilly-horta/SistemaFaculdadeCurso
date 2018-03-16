package fppa;

import controller.AtualizaCursoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Curso;

/**
 *
 * @author Tawan Rodrigues
 */
public class AtualizaCurso extends Application {
    
   public AtualizaCurso(Curso curso){
        AtualizaCursoController.setCurso(curso);
    }
    
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AtualizaCurso.fxml"));
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
        AtualizaCurso.stage = stage;
    }

   
}
