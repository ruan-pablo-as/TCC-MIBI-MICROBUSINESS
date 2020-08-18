/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JDBCC.EmpDAO;
import Model.Empresa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author r_pab
 */
public class ControllerTabelaEmpresas implements Initializable {

    //TABELA
    @FXML
    TableView<Empresa> TabelaID;
    @FXML
    TableColumn<Empresa, Long> IDEmpresa;
    @FXML
    TableColumn<Empresa, String> NomeFantasia;
    @FXML
    TableColumn<Empresa, String> CNPJ;
    @FXML
    TableColumn<Empresa, String> Email;
    @FXML
    TableColumn<Empresa, Integer> DDDf;
    @FXML
    TableColumn<Empresa, Long> TelefoneFixo;
    @FXML
    TableColumn<Empresa, Integer> DDDw;
    @FXML
    TableColumn<Empresa, Long> WhatsApp;
    @FXML
    TableColumn<Empresa, String> Endereco;
    @FXML
    TableColumn<Empresa, String> Num;
    @FXML
    TableColumn<Empresa, String> Complemento;
    @FXML
    TableColumn<Empresa, Long> IDMunicipio;
    @FXML
    TableColumn<Empresa, Long> IDEstado;
    @FXML
    TableColumn<Empresa, Long> IDUsuario;
    @FXML
    private Button deleteEmp;
    @FXML
    private Button deleteUsEmp;
    @FXML
    private TextField empresa;
    @FXML
    private TextField nome;
    @FXML
    private TextField cnpj;
    @FXML
    private TextField email;
    @FXML
    private TextField fixo;
    @FXML
    private TextField whats;
    @FXML
    private TextField endereco;
    @FXML
    private TextField num;
    @FXML
    private TextField complemento;
    @FXML
    private TextField municipio;
    @FXML
    private TextField estado;
    @FXML
    private TextField usuario;

    private ObservableList<Empresa> empresas;
    private static Empresa selecionado;

    public void preencheTabela() {
        //ASSOCIA OS CAMPOS DA TABLE VIEW COM OS CAMPOS DO BANCO DE DADOS
        IDEmpresa.setCellValueFactory(new PropertyValueFactory("pkidempresa"));
        NomeFantasia.setCellValueFactory(new PropertyValueFactory("nomeemp"));
        CNPJ.setCellValueFactory(new PropertyValueFactory("cnpj"));
        Email.setCellValueFactory(new PropertyValueFactory("emailemp"));
        DDDf.setCellValueFactory(new PropertyValueFactory("dddf"));
        TelefoneFixo.setCellValueFactory(new PropertyValueFactory("numerofixoemp"));
        DDDw.setCellValueFactory(new PropertyValueFactory("dddw"));
        WhatsApp.setCellValueFactory(new PropertyValueFactory("numerowhats"));
        Endereco.setCellValueFactory(new PropertyValueFactory("enderecoemp"));
        Num.setCellValueFactory(new PropertyValueFactory("numendereco"));
        Complemento.setCellValueFactory(new PropertyValueFactory("complemento"));
        IDMunicipio.setCellValueFactory(new PropertyValueFactory("fkidmunicipio"));
        IDEstado.setCellValueFactory(new PropertyValueFactory("fkidestado"));
        IDUsuario.setCellValueFactory(new PropertyValueFactory("fkidusuario"));
        EmpDAO dao = new EmpDAO();
        empresas = dao.getEmps();
        TabelaID.setItems(empresas);
    }

    @FXML
    public void deletarEmpresa() {
        if (ControllerTabelaEmpresas.selecionado != null) {
            EmpDAO dao = new EmpDAO();
            dao.deletaEmpresa(ControllerTabelaEmpresas.selecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Empresa deletada com sucesso!");
            a.showAndWait();
            preencheTabela();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Por favor, selecione uma Empresa na tabela!");
            a.showAndWait();
        }
    }

    @FXML
    public void deletarUsEmp() {
        if (ControllerTabelaEmpresas.selecionado != null) {
            EmpDAO dao = new EmpDAO();
            dao.deletaUsEmp(ControllerTabelaEmpresas.selecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Empresa deletada com sucesso!");
            a.showAndWait();
            preencheTabela();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Por favor, selecione uma Empresa na tabela!");
            a.showAndWait();
        }
    }

    public void pesquisaNome() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getNomeemp().toUpperCase().contains(nome.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaCnpj() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getCnpj().toUpperCase().contains(cnpj.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaIdemp() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            String pkidempresa = Long.toString(empresas.get(x).getPkidempresa());

            if (pkidempresa.toUpperCase().contains(empresa.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaEmail() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getEmailemp().toUpperCase().contains(email.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaFixo() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (Long.toString(empresas.get(x).getDddf()).toUpperCase().contains(fixo.getText().toUpperCase())
                    || Long.toString(empresas.get(x).getNumerofixoemp()).toUpperCase().contains(fixo.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            } else if (Long.toString(empresas.get(x).getDddf()).toUpperCase().contains(fixo.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            } else if (Long.toString(empresas.get(x).getNumerofixoemp()).toUpperCase().contains(fixo.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);
    }

    public void pesquisaWhats() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (Long.toString(empresas.get(x).getDddw()).toUpperCase().contains(whats.getText().toUpperCase())
                    || Long.toString(empresas.get(x).getNumerowhats()).toUpperCase().contains(whats.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            } else if (Long.toString(empresas.get(x).getDddw()).toUpperCase().contains(whats.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            } else if (Long.toString(empresas.get(x).getNumerowhats()).toUpperCase().contains(whats.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaEndereco() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getEnderecoemp().toUpperCase().contains(endereco.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaNum() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getNumendereco().toUpperCase().contains(num.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaComplemento() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (empresas.get(x).getComplemento().toUpperCase().contains(complemento.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaIdmunicipio() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (Long.toString(empresas.get(x).getFkidmunicipio()).toUpperCase().contains(municipio.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaIdestado() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (Long.toString(empresas.get(x).getFkidestado()).toUpperCase().contains(estado.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    public void pesquisaIdusuario() {
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        for (int x = 0; x < empresas.size(); x++) {
            if (Long.toString(empresas.get(x).getFkidusuario()).toUpperCase().contains(usuario.getText().toUpperCase())) {
                emp.add(empresas.get(x));
            }
        }
        TabelaID.setItems(emp);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        preencheTabela();

        TabelaID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    ControllerTabelaEmpresas.selecionado = (Empresa) newValue;
                } else {
                    ControllerTabelaEmpresas.selecionado = null;
                }
            }
        });
        nome.setOnKeyReleased((KeyEvent e) -> {
            pesquisaNome();
        });
        cnpj.setOnKeyReleased((KeyEvent e) -> {
            pesquisaCnpj();
        });
        empresa.setOnKeyReleased((KeyEvent e) -> {
            pesquisaIdemp();
        });
        email.setOnKeyReleased((KeyEvent e) -> {
            pesquisaEmail();
        });
        fixo.setOnKeyReleased((KeyEvent e) -> {
            pesquisaFixo();
        });
        whats.setOnKeyReleased((KeyEvent e) -> {
            pesquisaWhats();
        });
        endereco.setOnKeyReleased((KeyEvent e) -> {
            pesquisaEndereco();
        });
        num.setOnKeyReleased((KeyEvent e) -> {
            pesquisaNum();
        });
        complemento.setOnKeyReleased((KeyEvent e) -> {
            pesquisaComplemento();
        });
        municipio.setOnKeyReleased((KeyEvent e) -> {
            pesquisaIdmunicipio();
        });
        estado.setOnKeyReleased((KeyEvent e) -> {
            pesquisaIdestado();
        });
        usuario.setOnKeyReleased((KeyEvent e) -> {
            pesquisaIdusuario();
        });
    }
}
