package ba.unsa.etf.Student;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Student {

    private SimpleStringProperty ime = new SimpleStringProperty(),
                                prezime= new SimpleStringProperty(),
                                index= new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> datumRodnjenja = new SimpleObjectProperty<>();

    public Student() {
    }

    public Student(String ime, String prezime,String index,LocalDate datumRodnjenja) {
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.index.set(index);
        this.datumRodnjenja.set(datumRodnjenja);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public LocalDate getDatumRodnjenja() {
        return datumRodnjenja.get();
    }

    public SimpleObjectProperty<LocalDate> datumRodnjenjaProperty() {
        return datumRodnjenja;
    }

    public void setDatumRodnjenja(LocalDate datumRodnjenja) {
        this.datumRodnjenja.set(datumRodnjenja);
    }

    @Override
    public String toString() {
        return getIme() + "  "+ getPrezime();
    }




}
