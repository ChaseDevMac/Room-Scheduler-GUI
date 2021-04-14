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

public class RoomQueries {
    
    private static ArrayList<String> availableRoomsList;
    private static ArrayList<RoomEntry> allRoomsList;
    private static ArrayList<String> allRoomsListString;
    private static RoomEntry selectedRoomEntry;
    private static Connection connection;
    private static PreparedStatement addRoom;
    private static PreparedStatement dropRoom;
    private static PreparedStatement getAllPossibleRooms;
    private static PreparedStatement getAllRooms;
    private static PreparedStatement getSelectedRoom;
    private static ResultSet resultSet;
    
    public static void addRoom(String roomNumber, int roomCapacity){
        connection = DBConnection.getConnection();
        
        try {
            addRoom = connection.prepareStatement("INSERT INTO Rooms (name, seats) VALUES (?, ?)");
            addRoom.setString(1, roomNumber);
            addRoom.setInt(2, roomCapacity);
            
            addRoom.executeUpdate();
        }   
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static void dropRoom(String droppedRoom) {
        connection = DBConnection.getConnection();
        
        try {
            dropRoom = connection.prepareStatement("DELETE FROM Rooms WHERE name = ?");
            dropRoom.setString(1, droppedRoom);
            
            dropRoom.executeUpdate();
        }   
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAllPossibleRooms(int numberOfSeats){
        connection = DBConnection.getConnection();
        availableRoomsList = new ArrayList<>();
        try {
            getAllPossibleRooms = connection.prepareStatement("SELECT name FROM Rooms WHERE seats >= ? ORDER BY seats");
            getAllPossibleRooms.setInt(1, numberOfSeats);
            resultSet = getAllPossibleRooms.executeQuery();
            
            while(resultSet.next()){
                availableRoomsList.add(resultSet.getString(1));
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return availableRoomsList;
    }
    
    public static ArrayList<RoomEntry> getAllRooms() {
        connection = DBConnection.getConnection();
        allRoomsList = new ArrayList<>();
        
        try {
            getAllRooms = connection.prepareStatement("SELECT * FROM Rooms ORDER BY name");
            resultSet = getAllRooms.executeQuery();
            
            while(resultSet.next()){
                RoomEntry currentRoom = new RoomEntry(resultSet.getString(1), resultSet.getInt(2));
                allRoomsList.add(currentRoom);
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return allRoomsList;
    }
    
    public static RoomEntry getSelectedRoom(String selectedRoom) {
        connection = DBConnection.getConnection();
        
        try {
            getSelectedRoom = connection.prepareStatement("SELECT * FROM Rooms WHERE name = ?");
            getSelectedRoom.setString(1, selectedRoom);
            resultSet = getSelectedRoom.executeQuery();
            
            while(resultSet.next()){
                selectedRoomEntry = new RoomEntry(resultSet.getString(1), resultSet.getInt(2));
            }
            
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return selectedRoomEntry;
    }
    
    
    public static ArrayList<String> getAllRoomsString() {
        connection = DBConnection.getConnection();
        allRoomsListString = new ArrayList<>();
        
        try {
            getAllRooms = connection.prepareStatement("SELECT name FROM Rooms ORDER BY name");
            resultSet = getAllRooms.executeQuery();
            
            while(resultSet.next()){
                String currentRoom = resultSet.getString(1);
                allRoomsListString.add(currentRoom);
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return allRoomsListString;
    }
}
