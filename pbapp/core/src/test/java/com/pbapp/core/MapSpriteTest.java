/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

import com.badlogic.gdx.math.Vector2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Smith
 */
public class MapSpriteTest {
    
    public MapSpriteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of update method, of class MapSprite.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        MapSprite ms = new MapSprite(5,7,-200,-950,-190,-336);
        Vector2 input = new Vector2(3,3);
        ms.update(input);
        assertEquals(-200,ms.getXpos());
        assertEquals(-190, ms.getYpos());
        input.x = -800;
        input.y = 1200;
        ms.update(input);
        assertEquals(-950,ms.getXpos());
        assertEquals(-336,ms.getYpos());
        input.x = 50;
        input.y = -36;
        ms.update(input);
        assertEquals(-900,ms.getXpos());
        System.out.println(ms.getYpos());
        assertEquals(-300,ms.getYpos());
        
    }

    /**
     * Test of getXpos method, of class MapSprite.
     */
    @Test
    public void testGetXYpos() {
        System.out.println("GetXYpos");
        MapSprite ms = new MapSprite(5,7,10,2,15,3);
        assertEquals(5, ms.getXpos());
        assertEquals(PBApp.height - 7, ms.getYpos());
    }


    /**
     * Test of getTexture method, of class MapSprite.
     */
    @Test
    public void testGetTexture() {
    }
    
}
