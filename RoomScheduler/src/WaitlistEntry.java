
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
public class WaitlistEntry {
    
    private String facultyName;
    private Date waitlistDate;
    private int numberOfSeats;
    private Timestamp reservationTimestamp;
    
    public WaitlistEntry(String facultyName, Date waitlistDate, int numberOfSeats, Timestamp reservationTimestamp) {
        
        this.facultyName = facultyName;
        this.waitlistDate = waitlistDate;
        this.numberOfSeats = numberOfSeats;
        this.reservationTimestamp = reservationTimestamp;
        
    }
    
    public String getFacultyName() {
        return facultyName;
    }
    
    public Date getWaitlistDate() {
        return waitlistDate;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public Timestamp getReservationTimestamp() {
        return reservationTimestamp;
    }
}
