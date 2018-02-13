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
    
    public enum Obstruction{
        NONE, TAKEN, CONSTRUCTION, RESERVED, SNOW,
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
}
