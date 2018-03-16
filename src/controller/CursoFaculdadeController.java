package controller;

import dao.CursoDao;
import fppa.AtualizaCurso;
import fppa.CadastroCurso;
import fppa.CursoFaculdade;
import fppa.TelaPrincipal;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Curso;

/**
 *
 * @author Tawan Rodrigues e Emilly Horta
 */
public class CursoFaculdadeController implements Initializable {

    static Curso curso;

    private Curso cursoEscolhido;

    @FXML
    private TableView<Curso> tvCurso;
    @FXML
    private TableColumn<Curso, String> clCodigo;

    @FXML
    private TableColumn<Curso, String> clCurso;

    @FXML
    private TableColumn<Curso, String> clPeriodo;

    @FXML
    private Button btVolta;
    @FXML
    private Button btExcluir;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btAtualizar;


    @FXML

    public static int codigo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
        tvCurso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                cursoEscolhido = (Curso) newValue;
            }
        });

        btVolta.setOnMouseClicked((MouseEvent MouseEvent) -> {
          voltar();

        });

        btExcluir.setOnMouseClicked((MouseEvent MouseEvent) -> {
            excluir();
            table();

        });
        btCadastrar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            CadastroCurso cadastro = new CadastroCurso(codigo);
            try {
                cadastro.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            CursoFaculdade.getStage().close();

        });

        btAtualizar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            if (cursoEscolhido != null) {
                AtualizaCurso atualiza = new AtualizaCurso(cursoEscolhido);
                try {
                    atualiza.start(new Stage());
                } catch (Exception e) {
                    System.out.println(e);
                }
                CursoFaculdade.getStage().close();

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Nenhum Curso selecionado");
                alerta.show();
            }
        });

    }

    /**método da tabela onde possue várias funcionalidades 

    **/
    public void table() {
        clCodigo.setCellValueFactory(new PropertyValueFactory("codigoCurso"));
        clCurso.setCellValueFactory(new PropertyValueFactory("nome"));
        clPeriodo.setCellValueFactory(new PropertyValueFactory("duracao"));
        tvCurso.setItems(atualizar());
    }

    public ObservableList<Curso> atualizar() {
        CursoDao dao = new CursoDao();
        return FXCollections.observableArrayList(dao.getlist(codigo));

    }
     /**método de excluir 

    **/

    public void excluir() {
        if (cursoEscolhido != null) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setHeaderText("ATENÇÃO! A faculdade será excluida DEFINITIVAMENTE!");
            Optional<ButtonType> result = alerta.showAndWait();
            if (result.get() == ButtonType.OK) {
                CursoDao dao = new CursoDao();
                dao.excluir(cursoEscolhido);
                CursoFaculdade atualiza = new CursoFaculdade();
                try {
                    atualiza.start(new Stage());
                } catch (Exception e) {
                    System.out.println(e);
                }
                CursoFaculdade.getStage().close();

                Alert alerta2 = new Alert(Alert.AlertType.CONFIRMATION);
                alerta2.setHeaderText("Curso Excluido Com sucesso");
                alerta2.show();

            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Selecione Curso!");
            alerta.show();

        }

    }
    /**método voltar 

    **/
    public void voltar(){
      TelaPrincipal principal = new TelaPrincipal();
            try {
                principal.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            CursoFaculdade.getStage().close();
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        CursoFaculdadeController.codigo = codigo;
    }

}
