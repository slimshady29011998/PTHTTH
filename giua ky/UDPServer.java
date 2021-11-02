package De1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UDPServer {
	private static final int PORT = 7777;
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(PORT);
			System.out.println("Server da chay");

			while (true) {
				//nhan yeu cau tu client
				byte[] inputByteFile = new byte[60000];
				DatagramPacket inputPackFile = new DatagramPacket(inputByteFile, inputByteFile.length);
				socket.receive(inputPackFile);
				System.out.println("da ket noi voi Client: " + inputPackFile.getPort());

				String inputStrFile = new String(inputPackFile.getData(), 0, inputPackFile.getLength());
				String fileName = inputStrFile;

				//doc file
				File file = new File(fileName);
				int fileLength = (int)file.length();
				byte[] outputByteFile = new byte[fileLength];
				FileInputStream fis = new FileInputStream(file);
				fis.read(outputByteFile);

				// hien thi file o server
				DatagramPacket inputPackF = new DatagramPacket(outputByteFile, outputByteFile.length);
				String inputStrF = new String(inputPackF.getData(), 0, inputPackF.getLength());
				String files = inputStrF;
				System.out.println("\nnoi dung file nhan duoc: \n" + files);

				// nhan lua chon cong viec tu client
				byte[] inputByteRq = new byte[60000];
				DatagramPacket inputPackRq = new DatagramPacket(inputByteRq, inputByteRq.length);
				socket.receive(inputPackRq);
				//09_LuongHoangLong_16015921
				String inputStrRq = new String(inputPackRq.getData(), 0, inputPackRq.getLength());

				// tien hanh xu ly chuoi
				String[] strArray = new String[2];
				String[] splits = inputStrRq.split(" ", 2);
				int i = 0;
				for (String item : splits) {
					strArray[i] = item;
					i++;
				}
				String strChoice = strArray[0];
				String letter = strArray[1];

				int choice = Integer.parseInt(strChoice);
				switch (choice) {
				case 1:
					Scanner scn = new Scanner(files);
					String fileStr = "";
					String line;
					char[] charArrLet = letter.toCharArray();
					int letterLength = charArrLet.length;
					while (scn.hasNextLine()) {
						line = new StringBuffer(scn.nextLine()).toString();

						String[] arrStr = line.split("[ ]+");

						for (int k = 0; k < arrStr.length; k++) {
							if (arrStr[k].contains(letter)) {
								int indexLetter = arrStr[k].indexOf(letter); 

								String first = arrStr[k].substring(0, indexLetter);
								String middle = arrStr[k].substring(indexLetter, indexLetter + letterLength);
								String last = arrStr[k].substring(indexLetter + letterLength);


								char[] charArray = middle.toCharArray();
								int charArrLenght = charArray.length;
								for (int j = 0; j < charArrLenght; j++) {
									if (charArray[j] >= 97 && charArray[j] <= 122) {
										charArray[j] -= 32; 
									}
								}
								String middleUper = String.valueOf(charArray);
								arrStr[k] = first + middleUper + last;
							}
						}
						StringBuilder builder = new StringBuilder();
						for(String s : arrStr) {
							builder.append(s + " ");
						}
						String lineUper = builder.toString();

						fileStr = fileStr.concat(lineUper + "\n");
					}
					System.out.println("\nnoi dung file da xu ly: \n" + fileStr);
					byte[] outputByteFUper = fileStr.getBytes();
					DatagramPacket outputPackFUper = new DatagramPacket(outputByteFUper, outputByteFUper.length, inputPackRq.getAddress(), inputPackRq.getPort());
					socket.send(outputPackFUper);
					System.out.println("-----------------------------------------------------------------------");
					break;
				case 2:
					String exit = "chuong trinh da ket thuc";
					byte[] outputByteExit = exit.getBytes();
					DatagramPacket outputPackExit = new DatagramPacket(outputByteExit, outputByteExit.length, inputPackRq.getAddress(), inputPackRq.getPort());
					socket.send(outputPackExit);
					// socket.close();
					System.out.println("-----------------------------------------------------------------------");
					break;
				default:
					break;
				}
			}
		} catch (IOException ex) {
			System.out.println("Khong tao duoc server" + ex.toString());
		} catch (NoSuchElementException ex) {
			System.out.println("Client out");
		}
	}
}
