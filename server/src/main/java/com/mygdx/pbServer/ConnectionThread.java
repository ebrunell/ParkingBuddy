package com.mygdx.pbServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//CONNECTIONTHREAD: A thread to handle interactions between a single client and the
//server
public class ConnectionThread implements Runnable{
    protected Socket s;
    protected ObjectInputStream i;
    protected ObjectOutputStream o;
    private ParkingLot shineman;
    private ParkingLot sheldon;

    //Constructer takes a socket from a client that has been accepted by the server
    //socket and splits it into an object input and object output stream
    public ConnectionThread(Socket client, ParkingLot shinem, ParkingLot sheld){
        shineman = shinem;
        sheldon = sheld;
	s = client;
        try {
            //always initialize streams in this order
            o = new ObjectOutputStream(s.getOutputStream());
            o.flush();
            i = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
	System.out.printf("Connection thread for %s made successfully!\n", s.getInetAddress().getHostName());
    }
        @Override
	public void run(){
            send("Welcome!");
	    String message = "";
	    do{
		try {
		    //waits for messages from the client
		    message = (String) i.readObject();
                    //TODO: handle commands from client
                    String [] command = message.split(" ");
                    //command[0] = id
                    //command[1] = lot name
                    //command[2] = command
                    //command[3+] = data
                    if(command[2].equals("fil")){
                    
                    }else if(command[2].equals("obs")){
                    
                    }else if(command[2].equals("opn")){
                    
                    }else if(command[2].equals("chk")){
                    
                    }
                    
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
