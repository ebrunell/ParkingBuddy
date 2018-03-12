package com.mygdx.pbServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Mike
 */
//SERVER: A multi-threaded server to accept client connections
public class MultiThreadServer {
    public static void main(String args[]) throws IOException {
	//Displays local server information
        int port;
        if(args.length == 0){
            try {
                InetAddress address = InetAddress.getLocalHost();
                System.out.println("IP address: " + address.getHostAddress());
                System.out.println("Host name : " + address.getHostName());
            } catch (UnknownHostException uhEx) {
                System.out.println("Local adress unknown");
            }
            //specifies which port to run on
            Scanner kb = new Scanner(System.in);
            System.out.println("Port to run on?");
            port = kb.nextInt();
        }else{
            port = Integer.parseInt(args[0]);
        }
	ServerSocket s = new ServerSocket(port);
	for(;;) {
	    //waits for a connection and then passes the socket to a new connection
	    //thread
	    Socket client = s.accept();
	    System.out.println(client.getInetAddress().getHostName() + " just connected.");
	    new Thread(new ConnectionThread(client)).start();
	    //TODO: add connection threads to a collection of some sort?
	}
    }
}
