package bai_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPEchoServer {
	public final static int serverport = 7;
	public static void main(String[] args) throws IOException{
	    DataOutputStream dos = null;
	    DataInputStream dis=null;
	    try {
	        ServerSocket ss = new ServerSocket(serverport);
	        System.out.print("server da duoc tao \n" );
	        Socket clientSocket = null;
	        clientSocket = ss.accept();
	        dos=new DataOutputStream(clientSocket.getOutputStream());
	        dis=new DataInputStream(clientSocket.getInputStream());
	        String inline="";
	        while(true)
	        {
	            inline = dis.readUTF();
	            char ch[]=inline.toCharArray();
	            if(Character.isDigit(ch[0]))
	                {
	                int i=Integer.parseInt(inline);
	                switch(i)
	                {
	                    case 0:inline="khong";break;
	                    case 1:inline="mot";break;
	                    case 2:inline="hai";break;
	                    case 3:inline="ba";break;
	                    case 4:inline="bon";break;
	                    case 5:inline="nam";break;
	                    case 6:inline="sau";break;
	                    case 7:inline="bay";break;
	                    case 8:inline="tam";break;
	                    case 9:inline="chin";break;
	                }
	                dos.writeUTF(inline);
	            }
	            else
	                dos.writeUTF("khong phai so nguyen");
	        }
	    }
	    catch(Exception e) {
	        dos.close();
	        dis.close();
	        System.out.print(e.getMessage());
	    }
	}
} 