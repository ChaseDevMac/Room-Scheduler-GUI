import java.sql.Connection;
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

public class Faculty
{
    private static Connection connection;
    private static ArrayList<String> faculty;
    private static PreparedStatement addFaculty;
    private static PreparedStatement fireFaculty;
    private static PreparedStatement getFacultyList;
    private static ResultSet resultSet;
    
    public static void addFaculty(String name)
    {
        connection = DBConnection.getConnection();
        try
        {
            addFaculty = connection.prepareStatement("INSERT INTO faculty (name) VALUES (?)");
            addFaculty.setString(1, name);
            addFaculty.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static void fireFaculty(String name) {
        connection = DBConnection.getConnection();
        
        try {
            fireFaculty = connection.prepareStatement("DELETE FROM Faculty WHERE name = ?");
            fireFaculty.setString(1, name);
            fireFaculty.executeUpdate();
        }
        
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getFacultyList()
    {
        connection = DBConnection.getConnection();
        faculty = new ArrayList<>();
        try
        {
            getFacultyList = connection.prepareStatement("SELECT name FROM Faculty ORDER BY name");
            resultSet = getFacultyList.executeQuery();
            
            while(resultSet.next())
            {
                faculty.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return faculty;
        
    }
    
    
}
