package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String [] args) {
	
		System.out.println("Servidor Iniciado");
	ServerSocket servidor  = null;
	Socket sc = null;
	
	DataInputStream in;
	DataOutputStream out;
	
	final int PUERTO= 5000;
	try {
		servidor = new ServerSocket(PUERTO);
		
		
		while(true) {
			sc = servidor.accept();
			
			System.out.println("Cliente conectado");
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			String mensaje = in.readUTF();
			
			System.out.println(mensaje);
			
			out.writeUTF("Hola Mundo desde el servidor");
			
			sc.close();
			System.out.println("Cliente desconectado");
			
			
		}
		
	} catch (IOException e) {
		Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
	}
	
	}
	
	

}
