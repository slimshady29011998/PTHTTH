package bai2;

public class Thread3 extends Thread{
	FileTReader f;
	Thread3(FileTReader f){
		this.f=f;
	}
	public void run() {
		f.read("D:\\\\word\\\\phat trien he thong tich hop\\\\FIle out\\\\3.txt");
	}

}