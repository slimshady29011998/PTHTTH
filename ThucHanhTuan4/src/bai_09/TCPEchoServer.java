package bai_09;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class TCPEchoServer {
	public final static int serverport = 8;
	public static void main(String[] args) throws IOException{
		try {
			ServerSocket ss= new ServerSocket(serverport);
			System.out.println("server da duoc tao");
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			String menu = "\n1: 1.txt\n2: 2.txt\n3: 3.txt\n4: exit\nnhap lua chon";
			dos.writeUTF(menu);
			while(true) {
				String inline="";
				inline=dis.readUTF();
				char ch[]=inline.toCharArray();
				if(Character.isDigit(ch[0])) {
					int i = Integer.parseInt(inline);
					switch(i) {
					case 1:
						BufferedReader br1 = new BufferedReader(new FileReader("D://word//phat trien he thong tich hop//FIle out//1.txt"));
						String content = br1.readLine();
						dos.writeUTF(content+"\nMoi Nhap lua chon\n");
						dos.flush();
						break;
					case 2:
						BufferedReader br2 = new BufferedReader(new FileReader("D://word//phat trien he thong tich hop//FIle out//2.txt"));
						String content2 = br2.readLine();
						dos.writeUTF(content2+"\nMoi Nhap lua chon\n");
						dos.flush();
						break;
					case 3:
						BufferedReader br3 = new BufferedReader(new FileReader("D://word//phat trien he thong tich hop//FIle out//3.txt"));
						String content3 = br3.readLine();
						dos.writeUTF(content3+"\nMoi Nhap lua chon\n");
						dos.flush();
						break;
					case 4:
						System.out.println("\ndong ket noi\n");
						dos.close();
						ss.close();
						dis.close();
						break;
					}
				}else
					dos.writeUTF("nhap sai!!!");
			}		
		}catch(IOException ie) {
			System.out.println("Server Createion Error: "+ie);
		}
	}

}
