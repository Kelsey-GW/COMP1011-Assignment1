package comp1011.assignment1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneChanger
{
    /**
     * This method changes the window from one scene to another based on the viewName specified 
     */
  public void changeScenes(ActionEvent event, String viewName, String title) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(viewName));
    Parent parent = (Parent)loader.load();
    
    Scene scene = new Scene(parent);
    
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setTitle(title);
    stage.setScene(scene);
    stage.show();
  }
}

