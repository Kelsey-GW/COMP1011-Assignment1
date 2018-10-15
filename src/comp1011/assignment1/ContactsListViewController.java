import comp1011.assignment1.SceneChanger;
import Models.Contacts;
import Models.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ContactsListViewController implements Initializable
{
  @FXML private TableView<Contacts> contactsTable;
  @FXML private TableColumn<Contacts, Integer> idColumn;
  @FXML private TableColumn<Contacts, String> firstNameColumn;
  @FXML private TableColumn<Contacts, String> lastNameColumn;
  @FXML private TableColumn<Contacts, String> addressColumn;
  @FXML private TableColumn<Contacts, String> phoneNumberColumn;
  @FXML private Label yourContactsLabel;
  @FXML private Button makeNewContact;
  
  public void newContactButtonPushed(ActionEvent event)
    throws IOException
  {
    SceneChanger sc = new SceneChanger();
    sc.changeScenes(event, "saveContactsView.fxml", "New Contact");
  }

  public void initialize(URL url, ResourceBundle rb)
  {
    idColumn.setCellValueFactory(new PropertyValueFactory("contactID"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    addressColumn.setCellValueFactory(new PropertyValueFactory("address"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phone"));
    
    try
    {
      contactsTable.getItems().addAll(DBConnection.getContacts());
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

