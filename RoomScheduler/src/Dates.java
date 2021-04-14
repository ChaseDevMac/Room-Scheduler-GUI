import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chase
 */

public class Dates {
    
    private static Connection connection;
    private static ArrayList<Date> datesList;
    private static PreparedStatement addDate;
    private static PreparedStatement deleteDate;
    private static PreparedStatement getDatesList;
    private static ResultSet resultSet;
    
    public static void addDate(Date date)
    {
        connection = DBConnection.getConnection();
        try
        {
            addDate = connection.prepareStatement("INSERT INTO Dates (date) VALUES (?)");
            addDate.setDate(1, date);
            addDate.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static void deleteDate(Date date)
    {
        connection = DBConnection.getConnection();
        try
        {
            addDate = connection.prepareStatement("DELETE FROM Dates WHERE date = ?");
            addDate.setDate(1, date);
            addDate.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<Date> getDatesList() {
        connection = DBConnection.getConnection();
        datesList = new ArrayList<Date>();
        
        try
        {
            getDatesList = connection.prepareStatement("SELECT date FROM Dates ORDER BY date");
            resultSet = getDatesList.executeQuery();
            
            while(resultSet.next())
            {
                datesList.add(resultSet.getDate(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return datesList;
        
    }
    
}
