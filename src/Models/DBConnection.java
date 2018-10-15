package Models;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class DBConnection
{
  private static String user = "root";
  private static String password = "TimHortons";
  private static String localHost = "jdbc:mysql://localhost:3306/contactsApp?useSSL=false";
  

  public DBConnection() {}
  
  /**
   * This method gets the contacts from the DB and puts them in a table
   */
  public static ObservableList<Contacts> getContacts() throws SQLException
  {
    ObservableList<Contacts> contactsList = FXCollections.observableArrayList();
    
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    try
    {
      conn = DriverManager.getConnection(localHost, user, password);
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM contacts");
      
      while (resultSet.next())
      {
        Contacts newContact = new Contacts(resultSet.getString("firstName"), resultSet.getString("lastName"), 
                                            resultSet.getString("address"), resultSet.getString("phoneNumber"));
        newContact.setContactID(resultSet.getInt("contactId"));
        contactsList.add(newContact);
      }
        return contactsList;
    }
    catch (Exception e)
    {
      System.err.println(e.getMessage());
     
      return contactsList;
    }
    finally
    {
      if (conn != null) {
        conn.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (resultSet != null)
        resultSet.close();
    }
    //return contactsList;
  }
  
/**
 * This method inserts the contacts into the db 
 */
  public void insertContact(Contacts newContact) throws SQLException
  {
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    try
    {
      conn = DriverManager.getConnection(localHost, user, password);
      
      String sql = "INSERT INTO contacts(firstName, lastName, address, phoneNumber)VALUES(?,?,?,?)";
      
      preparedStatement = conn.prepareStatement(sql);
      
      preparedStatement.setString(1, newContact.getFirstName());
      preparedStatement.setString(2, newContact.getLastName());
      preparedStatement.setString(3, newContact.getAddress());
      preparedStatement.setString(4, newContact.getPhone());
      
      preparedStatement.executeUpdate();
    }
    catch (SQLException e) {
      System.err.println(e);
    }
    finally {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
  }
}

