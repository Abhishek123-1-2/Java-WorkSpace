import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

class MyCircle extends Frame implements Runnable{
	private Thread t1;
	private int x,y;
	public MyCircle(){
		x=100;
		y=100;
		t1=new Thread(this,"t1");
		t1.start();
		
	}
	public void paint(Graphics g) {
	    //g.drawOval(x, y, 100,100);
	    g.setColor(Color.RED);
	    g.fillOval(x,y,100,100);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int flag=0;
		while(true) {
			if(Thread.currentThread()==t1) {
				
				if(flag==0) {
					x++;
				}
					else if(flag==1) {
						x--;
					}
				if(x==this.getWidth()-100) {
				flag=1;
				if(x==0) {
					flag=0;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
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
MyCircle mc = new MyCircle();
mc.setSize(500,500);
mc.setVisible(true);
	}

}
}
