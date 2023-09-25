package dayOfweek;

import java.util.Scanner;

public class Dayofweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String day_of_week;
		System.out.println("Enter the week");
		Scanner sc = new Scanner(System.in);
		day_of_week = sc.next();
		switch(day_of_week) {
		case "Sunday":
			System.out.println(1);
			break;
		case "Monday":
			System.out.println(2);
			break;
		case "Tuesday":
			System.out.println(3);
			break;
		case "Wednesday":
			System.out.println(4);
			break;
		case "Thursday":
			System.out.println(5);
			break;
		case "Friday":
			System.out.println(6);
			break;
		case "Saturday":
			System.out.println(7);
			break;

	}

	}
}
