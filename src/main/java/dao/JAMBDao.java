package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import hello.User;
import util.DatabaseConnection;
import util.Dbquery;

// actual implementation of all the functionalities
@Component
public class JAMBDao {
    
    private Connection connection = null; // connection object created
    private PreparedStatement statement = null; // prepared statement object is created for inject sql queries
    private ResultSet resultSet = null; // result object to collect the sql data
    private Dbquery query; //query object created


 //utility functionalities
    
    
    public String canProfile(String username) {
        JSONObject candidate = new JSONObject();
        try {
            DatabaseConnection.getInstance();        //Get the database instance
            connection = DatabaseConnection.getConnection();        //Get the database connection
            statement = connection.prepareStatement(query.getCandidateProfile());
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                candidate.put("firstname", resultSet.getString(2));
                candidate.put("middlename", resultSet.getString(3));
                candidate.put("lastname", resultSet.getString(4));
                candidate.put("primarynumber", resultSet.getLong(5));
                candidate.put("email", resultSet.getString(6));
                candidate.put("address", resultSet.getString(7));
                candidate.put("city", resultSet.getString(8));
                candidate.put("state", resultSet.getString(9));
                candidate.put("country", resultSet.getString(10));
                candidate.put("linkedin", resultSet.getString(11));
                candidate.put("education", resultSet.getString(12));
                candidate.put("experience", resultSet.getLong(13));
                candidate.put("skills", resultSet.getString(14));
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return candidate.toString();
    }


    public int insertUser( User user) {
        int status = 0;
        try {
            DatabaseConnection.getInstance();        //Get the database instance
            connection = DatabaseConnection.getConnection();        //Get the database connection
            statement = connection.prepareStatement(query.getInsertuser());
            
            statement.setString(1, user.firstName);
            statement.setString(2, user.lastName);
            statement.setString(2, user.emailAddress);
            statement.setString(4, user.password);
            statement.setString(5, user.role);
            
            status = statement.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }



}
