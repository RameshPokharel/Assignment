package assignment;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		//Take scanner input from console
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User Identifier: ");
		int id=sc.nextInt();
		//identifier is of range 1-100
		System.out.println("Enter User SBP in mmHg: ");
		double sbp=sc.nextDouble();

		System.out.println("Enter User DBP in mmHg: ");
		double dbp=sc.nextDouble();
		
		
		if(checkValidation(id,sbp,dbp))
		{
			MAPCalculator mapObj= new MAPCalculator();
			
			double map= mapObj.value(sbp,dbp);
			
			String category=mapObj.category(map);
			
			System.out.println();
			System.out.println(id+". The "+category+ " MAP "+ String.format("%.2f", map));
		
		}
		
		
		
	}
	public static boolean checkValidation(int id, double sbp, double dbp)
	{
		if(id<1 && id>100)
		{
			System.out.println("The identifier is an range of 1-100");
			return false ;
		}
		
		if(sbp < dbp)
		{
			System.out.println("The SBP is always greater than DBP");
			return false ;
		}
		return true;
	}

}
