/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

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
    }

    /**
     * Test of getXpos method, of class MapSprite.
     */
    @Test
    public void testGetXYpos() {
        MapSprite ms = new MapSprite(5,1);
        assertEquals(5, ms.getXpos());
        assertEquals(PBApp.height - 1, ms.getYpos());
    }


    /**
     * Test of getTexture method, of class MapSprite.
     */
    @Test
    public void testGetTexture() {
    }
    
}
