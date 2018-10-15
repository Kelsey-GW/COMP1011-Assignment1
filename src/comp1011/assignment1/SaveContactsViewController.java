import comp1011.assignment1.SceneChanger;
import Models.Contacts;
import Models.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveContactsViewController implements Initializable
{
  @FXML private Button saveContactButton;
  @FXML private Button cancelContactButton;
  @FXML private Label createContactLabel;
  @FXML private Label firstNameLabel;
  @FXML private Label lastNameLabel;
  @FXML private Label addressLabel;
  @FXML private Label phoneNumberLabel;
  @FXML private Label errorMessageLabel;
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField addressField;
  @FXML private TextField phoneNumberField;
  
  public void saveContactPushed(ActionEvent event)
  {
    errorMessageLabel.setVisible(false);
    try
    {
      Contacts contact = new Contacts(firstNameField.getText(), lastNameField.getText(), addressField.getText(), phoneNumberField.getText());
      
      DBConnection newDb = new DBConnection();
      newDb.insertContact(contact);
      SceneChanger sc = new SceneChanger();
      sc.changeScenes(event, "ContactsListView.fxml", "Your Contacts");
    }
    catch (Exception e)
    {
      errorMessageLabel.setText(e.getMessage());
      errorMessageLabel.setVisible(true);
    }
  }
  
  public void cancelContactPushed(ActionEvent event)
    throws IOException
  {
    SceneChanger sc = new SceneChanger();
    sc.changeScenes(event, "ContactsListView.fxml", "Your Contacts");
  }
  
  public void initialize(URL url, ResourceBundle rb) {
      
  }
}

