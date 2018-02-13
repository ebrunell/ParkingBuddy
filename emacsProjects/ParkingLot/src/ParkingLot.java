
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmabrunell
 */
public class ParkingLot {
    
    ArrayList <Spot> spots = new ArrayList();
    private int numParkingSpots; 
    private int maxSize;
    private String lotName;
    
    public ParkingLot(int s, String n) {
        maxSize = s;
        lotName = n;
        numParkingSpots = 0;
    }
    
    public int getSpots() {
        return numParkingSpots;
    }
    
    public String getName() {
        return lotName;
    }
    
    public boolean lotFull () {
        for (int i = 0; i < spots.size(); i++) {
                if (numParkingSpots != maxSize) {
                    return false;
            }
        }
        return true;
    }
    
}
