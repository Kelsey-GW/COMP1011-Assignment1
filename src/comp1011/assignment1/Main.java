package comp1011.assignment1;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    Parent root = (Parent)FXMLLoader.load(getClass().getResource("ContactsListView.fxml"));
    
    Scene scene = new Scene(root);
    
    primaryStage.setTitle("Your Contacts");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

