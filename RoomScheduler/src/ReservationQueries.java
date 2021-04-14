
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
public class ReservationQueries {

    private static Connection connection;
    private static ArrayList<String> reservedRoomsByDateList;
    private static ArrayList<ReservationEntry> reservationByFacultyList;
    private static ArrayList<ReservationEntry> reservationByDateList;
    private static ArrayList<ReservationEntry> allReservationsList;
    private static ArrayList<ReservationEntry> reservationByRoomList;
    private static PreparedStatement addReservation;
    private static PreparedStatement getRoomsReservedByDate;
    private static PreparedStatement getReservationByFaculty;
    private static PreparedStatement getReservationByDate;
    private static PreparedStatement getReservationByRoom;
    private static PreparedStatement deleteReservation;
    private static PreparedStatement getAllReservations;
    private static ResultSet resultSet;

    public static void addReservationEntry(String facultyName, String roomNumber, Date reservationDate, int numberOfSeats, Timestamp reservationTimestamp) {
        connection = DBConnection.getConnection();
        try {

            addReservation = connection.prepareStatement("INSERT INTO Reservations (faculty, room, date, seats, timestamp) VALUES (?,?,?,?,?)");
            addReservation.setString(1, facultyName);
            addReservation.setString(2, roomNumber);
            addReservation.setDate(3, reservationDate);
            addReservation.setInt(4, numberOfSeats);
            addReservation.setTimestamp(5, reservationTimestamp);

            addReservation.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void addReservationEntry(WaitlistEntry waitlist, String room) {
        connection = DBConnection.getConnection();
        try {

            addReservation = connection.prepareStatement("INSERT INTO Reservations (faculty, room, date, seats, timestamp) VALUES (?,?,?,?,?)");
            addReservation.setString(1, waitlist.getFacultyName());
            addReservation.setString(2, room);
            addReservation.setDate(3, waitlist.getWaitlistDate());
            addReservation.setInt(4, waitlist.getNumberOfSeats());
            addReservation.setTimestamp(5, waitlist.getReservationTimestamp());

            addReservation.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public static void deleteReservation(String desiredFaculty, String desiredRoomNumber, Date desiredDate) {
        connection = DBConnection.getConnection();

        try {
            deleteReservation = connection.prepareStatement("DELETE "
                    + "FROM Reservations "
                    + "WHERE faculty = ? AND room = ? AND date = ?");
            deleteReservation.setString(1, desiredFaculty);
            deleteReservation.setString(2, desiredRoomNumber);
            deleteReservation.setDate(3, desiredDate);

            deleteReservation.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void deleteReservation(ReservationEntry reservation) {
        connection = DBConnection.getConnection();

        try {
            deleteReservation = connection.prepareStatement("DELETE "
                    + "FROM Reservations "
                    + "WHERE faculty = ? AND room = ? AND date = ?");
            deleteReservation.setString(1, reservation.getFacultyName());
            deleteReservation.setString(2, reservation.getRoomNumber());
            deleteReservation.setDate(3, reservation.getReservationDate());

            deleteReservation.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void deleteReservationByFaculty(String firedFaculty) {
        connection = DBConnection.getConnection();

        try {
            deleteReservation = connection.prepareStatement("DELETE "
                    + "FROM Reservations "
                    + "WHERE faculty = ?");
            deleteReservation.setString(1, firedFaculty);

            deleteReservation.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void deleteReservationByDate(Date date) {
        connection = DBConnection.getConnection();

        try {
            deleteReservation = connection.prepareStatement("DELETE "
                    + "FROM Reservations "
                    + "WHERE date = ?");
            deleteReservation.setDate(1, date);

            deleteReservation.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void wipeAllRecords() {
        connection = DBConnection.getConnection();

        try {
            deleteReservation = connection.prepareStatement("TRUNCATE TABLE Reservations");

            deleteReservation.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<ReservationEntry> getReservationByDate(Date date) {
        connection = DBConnection.getConnection();
        reservationByDateList = new ArrayList<>();

        try {
            getReservationByDate = connection.prepareStatement("SELECT faculty, room, date, seats, timestamp "
                    + "FROM Reservations "
                    + "WHERE date = ? "
                    + "ORDER BY date");
            getReservationByDate.setDate(1, date);
            resultSet = getReservationByDate.executeQuery();

            while (resultSet.next()) {
                ReservationEntry currentReservation = new ReservationEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getTimestamp(5));
                reservationByDateList.add(currentReservation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return reservationByDateList;
    }

    public static ArrayList<String> getRoomsReservedByDate(Date date) {

        connection = DBConnection.getConnection();
        reservedRoomsByDateList = new ArrayList<>();

        try {

            getRoomsReservedByDate = connection.prepareStatement("SELECT room "
                    + "FROM Reservations "
                    + "WHERE Reservations.\"DATE\" = ? "
                    + "ORDER BY date");
            getRoomsReservedByDate.setDate(1, date);

            resultSet = getRoomsReservedByDate.executeQuery();

            while (resultSet.next()) {
                reservedRoomsByDateList.add(resultSet.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return reservedRoomsByDateList;

    }

    public static ArrayList<ReservationEntry> getReservationByFaculty(String facultyName) {
        connection = DBConnection.getConnection();
        reservationByFacultyList = new ArrayList<>();

        try {
            getReservationByFaculty = connection.prepareStatement("SELECT * "
                    + "FROM Reservations "
                    + "WHERE faculty = ? "
                    + "ORDER BY date, room");
            getReservationByFaculty.setString(1, facultyName);
            resultSet = getReservationByFaculty.executeQuery();

            while (resultSet.next()) {
                ReservationEntry currentReservation = new ReservationEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getTimestamp(5));
                reservationByFacultyList.add(currentReservation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return reservationByFacultyList;
    }
    
    public static ArrayList<ReservationEntry> getReservationByRoom(String room) {
        connection = DBConnection.getConnection();
        reservationByRoomList = new ArrayList<>();

        try {
            getReservationByRoom = connection.prepareStatement("SELECT * "
                    + "FROM Reservations "
                    + "WHERE room = ?");
            getReservationByRoom.setString(1, room);
            resultSet = getReservationByRoom.executeQuery();

            while (resultSet.next()) {
                ReservationEntry currentReservation = new ReservationEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getTimestamp(5));
                reservationByRoomList.add(currentReservation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return reservationByRoomList;
    }

    public static ArrayList<ReservationEntry> getAllReservations() {
        connection = DBConnection.getConnection();
        allReservationsList = new ArrayList<>();

        try {
            getAllReservations = connection.prepareStatement("SELECT * "
                    + "FROM Reservations "
                    + "ORDER BY date, faculty");
            resultSet = getAllReservations.executeQuery();

            while (resultSet.next()) {
                ReservationEntry currentReservation = new ReservationEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getTimestamp(5));
                allReservationsList.add(currentReservation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return allReservationsList;
    }
}
