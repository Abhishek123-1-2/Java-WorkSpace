import java.util.Scanner;

class Mythreads implements Runnable{
private Thread t1,t2;
private int num;
public  Mythreads(int num) {
	this.num=num;
	t1=new Thread(this,"first");
	t2=new Thread(this,"second");
	t1.start();
	t2.start();
}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			if(Thread.currentThread()==t1) {
				System.out.println("Incremented value:"+(num+i));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(Thread.currentThread()==t2) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Table Value:"+(num*i));
			}
			
		}
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		System.out.println("Enter the number:");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		Mythreads m1 = new Mythreads(num);

	}

}
