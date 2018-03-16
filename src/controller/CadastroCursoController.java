package controller;

import dao.CursoDao;
import fppa.CadastroCurso;
import fppa.CursoFaculdade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Curso;

/**
 *
 *
 * @author Tawan Rodrigues
 */
public class CadastroCursoController implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField tfPeriodo;

    @FXML
    private TextField tfNome;

    public String nome, periodo;
    int test;

    public static int codigoFaculdade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btCancelar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            Cancelar();
        });
        btCadastrar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            if ("".equals(tfNome.getText()) || "".equals(tfPeriodo.getText())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Por favor! Preencha todos os espaços");
                alerta.show();

            } else {
                cadastrar(codigoFaculdade);
            }

        });

    }

    public static int getCodigo() {
        return codigoFaculdade;
    }

    public static void setCodigo(int codigo) {
        CadastroCursoController.codigoFaculdade = codigo;
    }

    public void cadastrar(int codigoFaculdade) {
        nome = tfNome.getText();
        periodo = tfPeriodo.getText();
        boolean numero= true;
        try {
              Integer.parseInt(tfPeriodo.getText());

        } catch (Exception e) {
            numero = false;
        }
        if (numero) {
        Curso curso = new Curso(periodo, nome, codigoFaculdade);
        CursoDao dao = new CursoDao();
        if (dao.inserir(curso)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Curso atualizado com sucesso!");
            alerta.show();

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro ao cadastrar curso");
            alerta.show();

        }
            
        }
        else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Por favor! Colocque um numero inteiro em periodos");
            alerta.show();
        
        
        }

    }
    public void Cancelar(){
         CursoFaculdade volta = new CursoFaculdade();
            try {
                volta.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            CadastroCurso.getStage().close();
        }
}
