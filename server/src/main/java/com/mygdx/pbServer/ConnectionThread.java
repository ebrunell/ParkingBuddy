package com.mygdx.pbServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Mike
 */
//CONNECTIONTHREAD: A thread to handle interactions between a single client and the
//server
public class ConnectionThread implements Runnable{
    protected Socket s;
    protected ObjectInputStream i;
    protected ObjectOutputStream o;

    //Constructer takes a socket from a client that has been accepted by the server
    //socket and splits it into an object input and object output stream
    public ConnectionThread(Socket client) throws IOException {
	s = client;
	//always initialize streams in this order
	o = new ObjectOutputStream(s.getOutputStream());
	o.flush();
	i = new ObjectInputStream(s.getInputStream());
	System.out.printf("Connection thread for %s made successfully!\n", s.getInetAddress().getHostName());
    }
        @Override
	public void run(){
            send("Welcome!");
	    String message = "";
	    do{
		try {
		    //waits for messages from the client and displays them to the server
		    message = (String) i.readObject();
		    this.send("Message recieved.");
		    System.out.println(message);
		} catch (IOException ex) {
		    ex.printStackTrace();
		} catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }

	    }while(!message.equals("exit"));

            System.out.println(s.getInetAddress().getHostName() + " disconnected.");
	    try {
		//closes all streams on exit
		i.close();
		o.close();
		s.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }

	}
    //SEND: sends a message to the client
    public void send(String message){
	try {
	    o.writeObject(message);
	    o.flush();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }
}
