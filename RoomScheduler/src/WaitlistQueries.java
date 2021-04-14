
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class WaitlistQueries {
    private static Connection connection;
    private static ResultSet resultSet;
    
    private static ArrayList<WaitlistEntry> waitlistByDateList;
    private static ArrayList<WaitlistEntry> waitlistByFacultyList;
    private static ArrayList<WaitlistEntry> allWaitlistEntries;
    private static PreparedStatement addWaitlistEntry;
    private static PreparedStatement deleteWaitlistEntry;   
    private static PreparedStatement getWaitlistByDate;
    private static PreparedStatement getWaitlistByFaculty;
    private static PreparedStatement getAllWaitlistEntries;
    
    public static void addWaitlistEntry(String facultyName, Date reservationDate, int numberOfSeats, Timestamp reservationTimestamp) {
        connection = DBConnection.getConnection();
        
        try {
            addWaitlistEntry = connection.prepareStatement("INSERT INTO Waitlist (faculty, date, seats, timestamp) "
                    + "VALUES (?, ?, ?, ?)");
            addWaitlistEntry.setString(1, facultyName);
            addWaitlistEntry.setDate(2, reservationDate);
            addWaitlistEntry.setInt(3, numberOfSeats);
            addWaitlistEntry.setTimestamp(4, reservationTimestamp);
            
            addWaitlistEntry.executeUpdate();
            
        }
        
        catch (SQLException sqlException) {
            sqlException.getStackTrace();
        }
        
    }
    
    public static void addWaitlistEntry(ReservationEntry reservation) {
        connection = DBConnection.getConnection();
        
        try {
            addWaitlistEntry = connection.prepareStatement("INSERT INTO Waitlist (faculty, date, seats, timestamp) "
                    + "VALUES (?, ?, ?, ?)");
            addWaitlistEntry.setString(1, reservation.getFacultyName());
            addWaitlistEntry.setDate(2, reservation.getReservationDate());
            addWaitlistEntry.setInt(3, reservation.getNumberOfSeats());
            addWaitlistEntry.setTimestamp(4, reservation.getReservationTimestamp());
            
            addWaitlistEntry.executeUpdate();
            
        }
        
        catch (SQLException sqlException) {
            sqlException.getStackTrace();
        }
        
    }
    
    public static void deleteWaitlistEntry(String desiredFaculty, Date desiredDate) {
        connection = DBConnection.getConnection();
        
        try {
            deleteWaitlistEntry = connection.prepareStatement("DELETE "
                + "FROM Waitlist "
                + "WHERE faculty = ? AND date = ?");
            deleteWaitlistEntry.setString(1, desiredFaculty);
            deleteWaitlistEntry.setDate(2, desiredDate);
            
            deleteWaitlistEntry.executeUpdate();
            
        }
        
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public static void deleteWaitlistEntryByFaculty(String firedFaculty) {
        connection = DBConnection.getConnection();
        
        try {
            deleteWaitlistEntry = connection.prepareStatement("DELETE "
                + "FROM Waitlist "
                + "WHERE faculty = ?");
            deleteWaitlistEntry.setString(1, firedFaculty);

            deleteWaitlistEntry.executeUpdate();
            
        }
        
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public static void deleteWaitlistEntryByDate(Date date) {
        connection = DBConnection.getConnection();
        
        try {
            deleteWaitlistEntry = connection.prepareStatement("DELETE "
                + "FROM Waitlist "
                + "WHERE date = ?");
            deleteWaitlistEntry.setDate(1, date);

            deleteWaitlistEntry.executeUpdate();
            
        }
        
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public static void wipeAllRecords() {
        connection = DBConnection.getConnection();

        try {
            deleteWaitlistEntry = connection.prepareStatement("TRUNCATE TABLE Waitlist");

            deleteWaitlistEntry.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<WaitlistEntry> getWaitlistByDate(Date date) {
        connection = DBConnection.getConnection();
        waitlistByDateList = new ArrayList<>();
        
        try {
            getWaitlistByDate = connection.prepareStatement("SELECT * "
                + "FROM Waitlist "
                + "WHERE date = ? "
                + "ORDER BY timestamp");
            getWaitlistByDate.setDate(1, date);
            
            resultSet = getWaitlistByDate.executeQuery();
            
            while (resultSet.next()) {
                WaitlistEntry currentWaitlistEntry = new WaitlistEntry(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getTimestamp(4));
                waitlistByDateList.add(currentWaitlistEntry);
            }
        }
        
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return waitlistByDateList;
    }
            
            
    public static ArrayList<WaitlistEntry> getWaitlistByFaculty(String facultyName) {
        connection = DBConnection.getConnection();
        waitlistByFacultyList = new ArrayList<>();
        
        try {
            getWaitlistByFaculty = connection.prepareStatement("SELECT * "
                    + "FROM Waitlist "
                    + "WHERE faculty = ? "
                    + "ORDER BY timestamp");
            getWaitlistByFaculty.setString(1, facultyName);
            resultSet = getWaitlistByFaculty.executeQuery();
            
            while(resultSet.next()){
                WaitlistEntry currentWaitlistEntry = new WaitlistEntry(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getTimestamp(4));
                waitlistByFacultyList.add(currentWaitlistEntry);
            }
            
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return waitlistByFacultyList;
    }
    
        
    public static ArrayList<WaitlistEntry> getAllWaitlistEntries() {
        connection = DBConnection.getConnection();
        allWaitlistEntries = new ArrayList<>();
        
        try {
            getAllWaitlistEntries = connection.prepareStatement("SELECT * "
                    + "FROM Waitlist "
                    + "ORDER BY timestamp");
            resultSet = getAllWaitlistEntries.executeQuery();
            
            while(resultSet.next()){
                WaitlistEntry currentWaitlistEntry = new WaitlistEntry(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getTimestamp(4));
                allWaitlistEntries.add(currentWaitlistEntry);
            }
            
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return allWaitlistEntries;
    }
    
}
