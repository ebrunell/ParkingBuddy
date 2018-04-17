/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

import java.util.ArrayList;

/**
 *
 * @author emmabrunell
 */
public class ParkingLot {
    
    private String lotName;
    private boolean isFull;
    private int numSpaces;
    
    ArrayList <ParkingSpace> spaces = new ArrayList();
    
    public ParkingLot(String n, int s) {
        lotName = n;
        numSpaces = s;
        
    }
    
    public String getLotName() {
        return lotName;
    }
    
    public boolean getCapacity() {
        return isFull;
    }
    
    public int getNumSpaces() {
        return numSpaces;
    }
    
}
