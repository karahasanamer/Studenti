package ba.unsa.etf.Student;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class StudentiModel {


    private ObservableList<Student> studenti = FXCollections.observableArrayList();
    private SimpleObjectProperty<Student> trenutniStudent = new SimpleObjectProperty();


    public StudentiModel() {
        napuni();
    }

    private void napuni() {
        studenti.add(new Student("Meho", "Mehic", "131", LocalDate.of(2011,5,1)));
        studenti.add(new Student("Suljo", "Suljic", "1231", LocalDate.of(1999, 3, 22)));
        trenutniStudent.set(studenti.get(0));

    }

    public ObservableList<Student> getStudenti() {
        return studenti;
    }



    void dodajStudenta(Student student) {
        studenti.add(student);
        trenutniStudent.set(studenti.get(studenti.size() - 1));

    }

    void izbrisiStudenta(int i) {
        studenti.remove(trenutniStudent.get());
        if (studenti.size() != 0) {
            trenutniStudent.set(studenti.get(0));
        } else trenutniStudent.set(null);
    }


    void postaviTrenutnog(int i) {

        trenutniStudent.set(studenti.get(i));


    }

    public void setStudenti(ObservableList<Student> studenti) {
        this.studenti = studenti;
    }

    public Student getTrenutniStudent() {
        return trenutniStudent.get();
    }

    public SimpleObjectProperty<Student> trenutniStudentProperty() {
        return trenutniStudent;
    }

    public void setTrenutniStudent(Student trenutniStudent) {
        this.trenutniStudent.set(trenutniStudent);
    }

}