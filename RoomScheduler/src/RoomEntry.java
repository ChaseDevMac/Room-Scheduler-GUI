/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chase
 */
public class RoomEntry {
    
    private String roomNumber;
    private int numberOfSeats;
            
    public RoomEntry(String roomNumber, int numberOfSeats){
        
        this.roomNumber = roomNumber;
        this.numberOfSeats = numberOfSeats;
        
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
}
