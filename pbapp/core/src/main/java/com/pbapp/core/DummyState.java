/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbapp.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Andrew Smith
 */
public class DummyState extends State{
  
     public DummyState(GuiStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {
    }
    
    @Override
    public void update(double dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
    }
    
}
