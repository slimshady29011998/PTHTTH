package bai2;

public class test {
	public static void main(String[] args) {
		FileTReader obj = new FileTReader();
		Thread1 t1 = new Thread1(obj);
		Thread2 t2 = new Thread2(obj);
		Thread3 t3 = new Thread3(obj);
		t1.start();
		t2.start();
		t3.start();
	}

}
