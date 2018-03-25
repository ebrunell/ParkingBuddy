package com.pbapp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pbapp.core.PBApp;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmabrunell
 */
public class ShinemanDataState extends State {
    
     private Texture background;
     private Button backButton;
     private Button serverButton;
     private Texture connectionEstablished;
     private Boolean messageRecieved;
     private String port;
     private Socket s;
     private ObjectOutputStream o;
     private ObjectInputStream i;
     private InetAddress address;
     String host;
     
     
    public ShinemanDataState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("ShinemanData.png");
        connectionEstablished = new Texture("SuccessfulConnection.png");
        backButton = new Button("BackButton.png", new Vector2(37,60), new Vector2(230,50));
        serverButton = new Button("ServerButton.png", new Vector2(425, 60), new Vector2(230,50));
        port = "2525";
        messageRecieved = false;
        s = null;
        o = null;
        i = null;
    }

    @Override
    public void handleInput() {
        //TODO: find x and y for back button and data button
        if (Gdx.input.justTouched()) {
            
            if (backButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())) {
                if (s != null){
                    try {
                        o.writeObject("exit");
                        o.flush();
                        String response = "";
                        while(response.equals("")){
                            response = (String)i.readObject();
                        }
                        System.out.println(response);
                        i.close();
                        o.close();
                        s.close();
                    } catch (IOException ex) {
                        System.out.println("Failed to intialize socket/streams");
                        ex.printStackTrace();
                        System.exit(1);
                    }catch(ClassNotFoundException ex){
                        System.out.println("Object recieved was not string");
                        ex.printStackTrace();
                        System.exit(1);
                    }
                }
                
                this.dispose();
                gsm.pop();
                ShinemanMapState sm = new ShinemanMapState(gsm);
                gsm.push(sm);
                
            }
            if(serverButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())){
                try{
                    address = InetAddress.getLocalHost();
                    host = address.getHostAddress();
                    s = new Socket(host, Integer.parseInt(port));
                    o = new ObjectOutputStream (s.getOutputStream());
                    o.flush();
                    i = new ObjectInputStream(s.getInputStream());
                    
                    String response = "";
                    while(response.equals("")){
                        response = (String)i.readObject();
                    }
                    messageRecieved = true;
                    
                }catch(EOFException eof){
                    System.out.println("Connection terminated.");
                }catch(UnknownHostException ex){
                    System.out.println("Unable to identify local host");
                    ex.printStackTrace();
                }catch(IOException ex){
                    System.out.println("Failed to initialize socket/streams");
                    ex.printStackTrace();
                    System.exit(1);
                }catch(ClassNotFoundException ex){
                    System.out.println("Object recieved was not string");
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
            
        }
    }

    @Override
    public void update(double dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, PBApp.width, PBApp.height);
        sb.draw(backButton.getTexture(), backButton.getXpos(), backButton.getYpos());
        sb.draw(serverButton.getTexture(), serverButton.getXpos(), serverButton.getYpos());
        if(messageRecieved) sb.draw(connectionEstablished, 135, 520,230,50);
        sb.end();
    }
    
     public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
    }
    
    
}
