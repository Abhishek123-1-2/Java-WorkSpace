	interface printable{
		public void printDetails();
	}
	class CktPlayer implements printable{
		private String name;
		private int runs;
		public CktPlayer() {
			name="Abhishek";
			runs=1000;
		}
		public CktPlayer(String name,int runs) {
			super();
			this.name = name;
			this.runs = runs;
		}
		public void printDetails() {
			System.out.println("Player name:"+name);
			System.out.println("Runs scored:"+runs);
		}
	}
	class FtPlayer implements printable{
	private String name;
	private int goals;
	public FtPlayer() {
		name="Lionel messi";
		goals=870;
	}
	public void FtPLayer(String name,int goals) {
		this.name=name;
		this.goals=goals;
	}
		@Override
		public void printDetails() {
			// TODO Auto-generated method stub
			System.out.println("Player name:"+name);
			System.out.println("Runs scored:"+goals);
		}
		
	}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
CktPlayer c1 = new CktPlayer("Abhishek",10000);
c1.printDetails();


FtPlayer f1 = new FtPlayer();
f1.printDetails();
	}

	

}
