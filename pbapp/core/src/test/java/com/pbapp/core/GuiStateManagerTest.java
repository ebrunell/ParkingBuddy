package com.pbapp.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class GuiStateManagerTest {
    
    public GuiStateManagerTest() {
    }
    
    /**
     * Test of push method, of class GuiStateManager.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        GuiStateManager gsm = new GuiStateManager();
        DummyState s = new DummyState(gsm);
        gsm.push(s);
        assertSame(s,gsm.peek());
    }
    
    /**
     * Test of peek method, of class GuiStateManager.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        GuiStateManager gsm = new GuiStateManager();
        assertNull(gsm.peek());
        DummyState s = new DummyState(gsm);
        gsm.push(s);
        assertSame(s,gsm.peek());
    }
    
    /**
     * Test of pop method, of class GuiStateManager.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        GuiStateManager gsm = new GuiStateManager();
        DummyState s = new DummyState(gsm);
        assertNull(gsm.pop());
        gsm.push(s);
        assertSame(s, gsm.pop());
        assertNull(gsm.pop());
    }

    /**
     * Tests of setState method, of class GuiStateManager.
     */
    @Test
    public void testSetStateFromEmpty(){
        GuiStateManager gsm = new GuiStateManager();
        System.out.println("SetState from empty");
        DummyState d = new DummyState(gsm);
        gsm.setState(d);
        assertSame(d,gsm.pop());
    }
    
    @Test
    public void testSetStateFromRunning(){
        System.out.println("SetState from running");
        GuiStateManager gsm = new GuiStateManager();
        DummyState x = new DummyState(gsm);
        DummyState y = new DummyState(gsm);
        assertNotSame(x,y);
        gsm.push(x);
        gsm.setState(y);
        assertSame(y,gsm.pop());
        assertNull(gsm.peek());
    }
    
}
