package ba.unsa.etf.Student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StudentiModel model = new StudentiModel();
        Controller controller = new Controller(model);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(controller);
        Parent root =loader.load();
        primaryStage.setTitle("Studenti");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.toFront();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
