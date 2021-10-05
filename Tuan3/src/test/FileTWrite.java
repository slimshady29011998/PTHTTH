package test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileTWrite extends Thread{
	public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addRandom(list);
        saveFile(list);
       
	}
	private static void addRandom(List<Integer> list) {
        Random random = new Random();
        int n = random.nextInt(91) + 10;
        list.add(n);
        for(int i =0 ; i<10;i++) {
            int x = random.nextInt(501) + 1;
            list.add(x);
        }
    }
    private static void saveFile(List<Integer> list) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
        	System.out.println("nhap vao duong dan file luu");
        	Scanner sc = new Scanner(System.in);
            fos = new FileOutputStream(sc.nextLine());
            bos = new BufferedOutputStream(fos);

            for(Integer number : list) {
                String line = number + "\n";
                byte[] b = line.getBytes(StandardCharsets.UTF_8);
                bos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Save File!");
    }
}

