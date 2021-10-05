package twoThreads;

public class B extends Thread{
	public void run() {
		for(int i=0;i<10; i++)
		System.out.println((char)(i+66)+" ");
		try 
		{
			Thread.sleep(2500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub

	}

}
