/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FaculdadeDao;
import fppa.Cadastro;
import fppa.TelaPrincipal;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faculdade;

/**
 *
 * @author Tawan Rodrigues e Emilly Horta
  */
public class CadastroController implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfLocalidade;

    @FXML
    private TextField tfNome11;

    public String nome, localidade, uf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /** Evento do botão cancelar 

        **/
        btCancelar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            TelaPrincipal principal = new TelaPrincipal();
            try {
                principal.start(new Stage());
            } catch (Exception e) {
                System.out.println(e);
            }
            Cadastro.getStage().close();

        });
        btCadastrar.setOnMouseClicked((MouseEvent MouseEvent) -> {
            //System.out.println("aeee");
            cadastrar();
        });

    }
    /**
        método de cadastrar o curso, no qual se ele não preencher todos os campos aparecerá um alerta

    **/

    public void cadastrar() {

        nome = tfNome.getText();
        localidade = tfLocalidade.getText();
        uf = tfNome11.getText();
        if ("".equals(tfNome.getText()) || "".equals(tfLocalidade.getText()) || "".equals(tfNome11.getText())) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Por favor, Preencha todos os espaços");
            alerta.show();

            /**Se todos os campos forem preenchidos , a função cadastrar será realizada com sucesso 


            **/
        } else {
            Faculdade faculdade = new Faculdade(nome, localidade, uf);
            FaculdadeDao dao = new FaculdadeDao();
            if (dao.inserir(faculdade)) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText("Curso cadastrado com sucesso!");
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    TelaPrincipal principal = new TelaPrincipal();
                    try {
                        principal.start(new Stage());
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Cadastro.getStage().close();
                } else {

                }
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Curso não foi cadastrado!");
                alerta.show();

            }
        }

    }
}
