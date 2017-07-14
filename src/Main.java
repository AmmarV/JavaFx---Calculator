package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public Stage primaryStage;
    public AnchorPane anchorPane;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        mainView();
    }


    public void mainView() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
            anchorPane = (AnchorPane) loader.load();

            Controller controller = loader.getController();
            controller.setMain(this);

            primaryStage.setTitle("Calculator");
            primaryStage.setScene(new Scene(anchorPane,225,290));
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
