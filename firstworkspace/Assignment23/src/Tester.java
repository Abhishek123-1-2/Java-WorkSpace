import java.awt.*;
class MovingCircles extends Frame implements Runnable{
private Thread t1,t2,t3;
private int x1,x2,x3;
public MovingCircles(){
	x1=100;
	x2=100;
	x3=100;
	t1 = new Thread(this,"t1");
	t2 = new Thread(this,"t2");
	t3 = new Thread(this,"t3");
	t1.start();
	t2.start();
	t3.start();
}
public void paint(Graphics g) {
	g.setColor(Color.RED);
	g.fillOval(x1,80,100,100);
	g.setColor(Color.BLUE);
	g.fillOval(x2,200,100,100);
	g.setColor(Color.GREEN);
	g.fillOval(x3,350,100,100);
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(Thread.currentThread()==t1) {
				synchronized(this) {
					x1++;
					if(x1==this.getWidth()-100) {
						try {
							wait();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							
						}
					}	
				}
				
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
			}
			else if(Thread.currentThread()==t2) {
				synchronized(this) {
					x2++;
					if(x2==this.getWidth()-100) {
						try {
							wait();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							
						}
					}
				}
				
				
				try {
					Thread.sleep(80);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
			}else if(Thread.currentThread()==t3) {
				synchronized(this) {
					x3++;
					if(x3==this.getWidth()-100) {
						x1=x2=x3=0;
						notifyAll();
					}
				}
				
				
				try {
					Thread.sleep(120);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
			
				repaint();
			}
		}
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MovingCircles m1 = new MovingCircles();
m1.setSize(500,500);
m1.setVisible(true);
	}

}
