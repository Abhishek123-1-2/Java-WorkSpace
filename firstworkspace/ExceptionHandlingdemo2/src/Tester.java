
public class Tester {
public static double divide(int num,int den) throws Exception {
	if(den==0) {
		throw new Exception("denominator is zero");
	}
	return (double)num/den;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	System.out.println(divide(12,0));

}catch(Exception e){
	System.out.println(e);
e.printStackTrace();	
}
	}

}
