
import java.sql.Date;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chase
 */
public class ReservationEntry {
    
    private String facultyName;
    private String roomNumber;
    private Date reservationDate;
    private int numberOfSeats;
    private Timestamp reservationTimestamp;
    
    public ReservationEntry(String facultyName, String roomNumber, Date reservationDate, int numberOfSeats, Timestamp reservationTimestamp) {
        
        this.facultyName = facultyName;
        this.roomNumber = roomNumber;
        this.reservationDate = reservationDate;
        this.numberOfSeats = numberOfSeats;
        this.reservationTimestamp = reservationTimestamp;
        
    }
    
    public String getFacultyName() {
        return facultyName;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public Date getReservationDate() {
        return reservationDate;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public Timestamp getReservationTimestamp() {
        return reservationTimestamp;
    }
    
}
