package application101;

import java.util.Scanner;

public class PointDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("x :");
		int x = sc.nextInt();
		
		System.out.println("y :");
		int y = sc.nextInt();
		
		sc.close();
		
		Point p = new Point(x, y);
		p.transform(">v<>>>v^~><><~><><");		

		System.out.println(p);
	}
}
