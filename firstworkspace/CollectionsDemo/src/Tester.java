//Vector-It is called a dynamically growing array.
import java.util.*;
public class Tester {

	public static void main(String[] args) {
		List<Integer> v = new ArrayList<>();
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);
        System.out.println(v);//Using toString Method
        for(Integer val:v) {
        	System.out.println(val+" ");//Using For-Each Loop
        }
        	System.out.println();
        	Iterator<Integer> itr = v.iterator();//Using Iterator class
        	while(itr.hasNext()) {
        		System.out.print(itr.next()+" ");
        	}
	
        	System.out.println(v.get(3)*5);
        	System.out.println(v.get(4));
	}
        }
        
	


