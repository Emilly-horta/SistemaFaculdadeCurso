package controller;

import dao.FaculdadeDao;
import fppa.Atualizar;
import fppa.CursoFaculdade;
import fppa.TelaPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faculdade;

/**
 * @author Tawan Rodrigues e Emilly Horta
 */
public class AtualizarController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField tfLocalidade;

    @FXML
    private TextField tfUf;

    static Faculdade faculdade;
    public String nome, localidade, uf;
    public int codigo;
    /** iniciando com o método initialize pra dar inicio a tela inicial 

    **/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciar();
        btCancelar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            TelaPrincipal principal = new TelaPrincipal();
            try {
                principal.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            Atualizar.getStage().close();

        });
        /**Se ele clicar em atualizar , e não preencher todos os campos , aparecerá uma mensagem 

        **/

        btAtualizar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            if ("".equals(tfNome.getText()) || "".equals(tfLocalidade.getText()) || "".equals(tfUf.getText())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Por favor, Preencha todos os espaços");
                alerta.show();

            } else {
                Atualizar();
            }



        });

    }
    /**método iniciar com todos os atributos da tabela faculdade (nome , localidade e UF)

    **/

    public void iniciar() {
        tfNome.setText(faculdade.getNome());
        tfLocalidade.setText(faculdade.getLocalidade());
        tfUf.setText(faculdade.getUf());
    }

    public static Faculdade getFaculdade() {
        return faculdade;
    }

    public static void setFaculdade(Faculdade faculdade) {
        AtualizarController.faculdade = faculdade;
    }
    /**Método Atualizar faculdade 

    **/

    public void Atualizar() {
        System.out.println("AEEE");
        nome = tfNome.getText();
        localidade = tfLocalidade.getText();
        uf = tfUf.getText();
        codigo = faculdade.getCodigo();
        System.out.println(localidade);
        System.out.println(codigo);
        Faculdade f = new Faculdade(codigo, nome, localidade, uf);
        FaculdadeDao dao = new FaculdadeDao();
        if (dao.atualizar(f)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Faculdade atualizada com sucesso!");
            alerta.show();

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro ao atualizar Faculdade");
            alerta.show();

        }

    }

}
