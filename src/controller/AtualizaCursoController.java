
package controller;

import static controller.CursoFaculdadeController.codigo;
import dao.CursoDao;
import fppa.AtualizaCurso;
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
import model.Faculdade;

/**
 * FXML Controller class
 *
 * @author Tawan Rodrigues e Emilly Horta
 */
public class AtualizaCursoController implements Initializable {
    
    @FXML
    private TextField tfNome;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;
       @FXML
    private TextField tfDuracao;

    String nome,duracao;
    int coidgo;
    static Curso curso;


        @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciar();
        btCancelar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            CursoFaculdade cursoFaculdade = new CursoFaculdade(curso.getCodigoCurso());
            try {
                cursoFaculdade.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            AtualizaCurso.getStage().close();

        });

        /**Eventos do Botão , abrir e fechar a janela do cadastro dos cursos

        **/
        
        btAtualizar.setOnMouseClicked((MouseEvent MouseEvent) -> {
              if ("".equals(tfNome.getText()) || "".equals(tfDuracao.getText())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Por favor, Preencha todos os espaços");
                alerta.show();

            } else {
            Atualizar(curso);
            }

        });

        /**Se o usuário não preencher todos os campos , exibirá um alerta na tela 

        **/
    }    public void iniciar() {
        tfNome.setText(curso.getNome());
        tfDuracao.setText(curso.getDuracao());
    }
    
     public static Curso getCurso() {
        return curso;
    }

    public static void setCurso(Curso curso) {
        AtualizaCursoController.curso = curso;
    }
     public void Atualizar(Curso curso) {
        System.out.println("AEEE");
        nome = tfNome.getText();
        duracao = tfDuracao.getText();
        codigo = curso.getCodigoCurso();
        System.out.println(nome);
        System.out.println(codigo);
        System.out.println(duracao);
        
        Curso c = new Curso(codigo, nome,duracao);
        CursoDao dao = new CursoDao();
         if (true) {
            /** Codigo , nome e duração(se o usuario pedir pra atualiazr)
            será realizado com sucesso .

            **/     
         }
        if (dao.atualizar(c)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Curso atualizado com sucesso!");
            alerta.show();
              
            }
        else{
             Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Erro ao atualizar Curso");
                alerta.show();
        
        }

        }

    
}
