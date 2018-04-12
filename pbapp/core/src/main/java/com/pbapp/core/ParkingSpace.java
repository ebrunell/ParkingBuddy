/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

/**
 *
 * @author emmabrunell
 */
public class ParkingSpace {
    
    private boolean isFull;
    private int amtTime;
    
    enum Obstructed {
        CONSTRUCTION, WEATHER, EMERGENCYVEHICLE, ILLEGALITY, OTHER
    }
    
    public ParkingSpace() {
        isFull = false;
    }
    
    public boolean getIsFull() {
        return isFull;
    }
    
    public int getTime() {
        return amtTime;
    }
    
    public void enterSpace() {
        isFull = true;
    }
    
    public void exitSpace() {
        isFull = false;
    }
    
}
