package ba.unsa.etf.Student;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;




public class Controller implements Initializable {


   private StudentiModel model;
   public DatePicker datePicker;
    public TextField indexField;
    public TextField prezimeField;
    public TextField imeField;
    public ListView<Student> listaStudenata;

    public Controller(StudentiModel model) {
        this.model=model;
    }

    public void dodajAction(ActionEvent actionEvent) {
    }

    public void obrisiAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaStudenata.setItems(model.getStudenti());
        bind(model.getTrenutniStudent());
        listaStudenata.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observableValue, Student oldValue, Student newValue) {
                model.setTrenutniStudent(newValue);
                listaStudenata.refresh();
            }
        });
        model.trenutniStudentProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observableValue, Student oldValue, Student newValue) {
                if(oldValue != null){
                    unbind(oldValue);
                }
                if(newValue == null){
                    imeField.setText("");
                    prezimeField.setText("");
                    indexField.setText("");
                    datePicker.getEditor().setText("");

                }else bind(newValue);
            }
        });
    }

    private void bind(Student newValue) {
        imeField.textProperty().bindBidirectional(newValue.imeProperty());
        prezimeField.textProperty().bindBidirectional(newValue.prezimeProperty());
        indexField.textProperty().bindBidirectional(newValue.indexProperty());
        datePicker.valueProperty().bindBidirectional(newValue.datumRodnjenjaProperty());
    }

    private void unbind(Student oldValue) {

        imeField.textProperty().unbindBidirectional(oldValue.imeProperty());
        prezimeField.textProperty().unbindBidirectional(oldValue.prezimeProperty());
        indexField.textProperty().unbindBidirectional(oldValue.indexProperty());
        datePicker.valueProperty().unbindBidirectional(oldValue.datumRodnjenjaProperty());

    }


}
