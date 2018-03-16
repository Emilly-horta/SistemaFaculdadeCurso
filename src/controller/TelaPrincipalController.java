package controller;

import dao.FaculdadeDao;
import fppa.Atualizar;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faculdade;

/**
 * FXML Controller class
 *
 * @author Tawan Rodrigues
 */
public class TelaPrincipalController implements Initializable {

    private Faculdade faculdadeEscolhida;

    @FXML
    private TableView<Faculdade> tvFaculdades;

    @FXML
    private TableColumn<Faculdade, String> clCodigo;

    @FXML
    private TableColumn<Faculdade, String> clCampus;

    @FXML
    private TableColumn<Faculdade, String> clLocalidade;

    @FXML
    private TableColumn<Faculdade, String> clUf;
    @FXML
    private Button btCadastrar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btVisualizar;

    int codigo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();

        tvFaculdades.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                faculdadeEscolhida = (Faculdade) newValue;
            }
        });

        btCadastrar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            cadastrar();
        });

        btExcluir.setOnMouseClicked((MouseEvent MouseEvent) -> {
            excluir();
        });

        btVisualizar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            if (faculdadeEscolhida != null) {
                visualizar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Faculdade não selecionada");
                alerta.show();
            }

        });

        btAtualizar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            if (faculdadeEscolhida != null) {
                Atualizar atualiza = new Atualizar(faculdadeEscolhida);
                try {
                    atualiza.start(new Stage());
                } catch (Exception e) {
                    System.out.println(e);
                }
                TelaPrincipal.getStage().close();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Faculdade não selecionada");
                alerta.show();

            }
        });

    }

    public void table() {
        clCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clCampus.setCellValueFactory(new PropertyValueFactory("nome"));
        clLocalidade.setCellValueFactory(new PropertyValueFactory("localidade"));
        clUf.setCellValueFactory(new PropertyValueFactory("uf"));

        tvFaculdades.setItems(atualizar());
    }

    public ObservableList<Faculdade> atualizar() {
        FaculdadeDao dao = new FaculdadeDao();
        return FXCollections.observableArrayList(dao.getlist());

    }

    public void excluir() {
        if (faculdadeEscolhida != null) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setHeaderText("ATENÇÃO! A faculdade será excluida DEFINITIVAMENTE!");
            Optional<ButtonType> result = alerta.showAndWait();
            if (result.get() == ButtonType.OK) {
                FaculdadeDao dao = new FaculdadeDao();
                dao.excluir(faculdadeEscolhida);
                table();

            } else {

            }

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Faculdade não selecionada");
            alerta.show();

        }
    }

    public void visualizar() {
        codigo = faculdadeEscolhida.getCodigo();
        CursoFaculdade visu = new CursoFaculdade(codigo);

        try {
            visu.start(new Stage());
        } catch (Exception e) {
            System.out.println(e);
        }
        TelaPrincipal.getStage().close();

    }

    public void cadastrar() {
        codigo = faculdadeEscolhida.getCodigo();
        CursoFaculdade visu = new CursoFaculdade(codigo);

        try {
            visu.start(new Stage());
        } catch (Exception e) {
            System.out.println(e);
        }
        TelaPrincipal.getStage().close();

    }

}
