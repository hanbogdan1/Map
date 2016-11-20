import Gui.SarcinaView;
import UserInterface.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import Domain.*;

public class main extends Application{
    public static void main(String argv[]){
        launch(argv);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
          
        SarcinaView sarcinaView = new SarcinaView(model.getModel(), controller);
        Parent parent = sarcinaView.getView();
        Scene scene = new Scene(parent,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Repository");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                repository.saveData();
            }
        });
    }
}