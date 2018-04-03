/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Andrew Smith
 */
public class ParkingSpaceButton extends Button{
    private String identifier;
    
    public ParkingSpaceButton(String id, Vector2 p, Vector2 d) {
        super(p, d);
        identifier = id;
    }
    
    public String getIdentifier(){
        return identifier;
    }

}
