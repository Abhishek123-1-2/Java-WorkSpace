import java.awt.*;
class MovingStrings extends Frame implements Runnable{
	private Thread t1,t2;
	private int x1,x2;
	public MovingStrings() {
		x1 = 100;
		x2 = 100;
		t1 = new Thread(this,"t1");
		t2 = new Thread(this,"t2");
		t1.start();
		t2.start();
		
	}
public void paint(Graphics g) {
	g.setFont(new Font("Tahoma",30,30));
	g.setColor(Color.blue);
	g.drawString("Mindcraft", x1, 100);
	
	g.setColor(Color.red);
	g.drawString("Software", x2, 300);
}
@Override
public void run() {
	// TODO Auto-generated method stub
	while(true) {
		if(Thread.currentThread()==t1) {
			x1++;
			if(x1==this.getWidth()+15) 
				x1=0;
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
				
			} 
		else if(Thread.currentThread()==t2) {
				x2--;
				if(x2==0-15) 
					x2=this.getWidth();
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		repaint();
		
		}
	}
}

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MovingStrings ms =new MovingStrings();
ms.setSize(500,500);
ms.setVisible(true);
	}

}
