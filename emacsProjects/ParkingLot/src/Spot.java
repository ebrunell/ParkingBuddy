
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Smith
 */
public class Spot {
    
    private ParkingLot lot;
    private boolean available;
    private Obstruction current;
    private LocalDateTime timeOccupied;
    
    
    public enum Obstruction{
        NONE, CONSTRUCTION, RESERVED, SNOW,
        EMERGENCY, OTHER
    }
    
    public Spot(ParkingLot lot){
        this.lot = lot;
    }
    
    public void setAvailability(boolean available){
        this.available = available;
    }
    
    public boolean getAvailability(){
        return available;
    }
    
    public void setObstruction(Obstruction current){
        this.current = current;
    }
    
    public Obstruction getObstruction(){
        return current;
    }
    
    public void setTimeOccupied(LocalDateTime timeOccupied){
        this.timeOccupied = timeOccupied;
    }
    
    public LocalDateTime getTimeOccupied(){
        return timeOccupied;
    }
}
