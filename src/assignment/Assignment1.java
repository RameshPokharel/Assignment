package assignment;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {

		//Take scanner input from console
            String form="";
		Scanner sc= new Scanner(System.in);
               System.out.println("Enter Total User : ");
               int num= sc.nextInt();
               
               if(num > 10 || num < 5)
                  System.out.println("The number of individuals is between 5-10 ");
                else
               {
                   boolean isError=false;
               for(int i=0;i<num;i++)
               {
                   String pos="";
                   
                   if(i==0)
                       pos=1+"st ";
                   else if(i==1)
                       pos=2+"nd ";
                   else if(i==2)
                       pos=3+"rd ";
                   else
                       pos= pos=(i+1)+"th ";
                   
                   form=manageInput(sc, pos,isError,form);
                }
                if(!isError)
               {
                   System.out.print(form);
               }
               }
              }
        
	public static boolean checkValidation(int id, double sbp, double dbp)
	{
		if(id<1 && id>100)
		{
			System.out.println("The identifier is an range of 1-100");
			return false ;
		}
		
		if(sbp <= dbp)
		{
			System.out.println("The SBP is always greater than DBP");
			return false ;
		}
		return true;
	}
        
        static int j=0;
        public static String manageInput(Scanner sc,String pos,boolean isError,String format)
        {
            MAPCalculator mapObj= new MAPCalculator();
           

             System.out.println("Enter " +pos +" User Identifier: ");
		int id=sc.nextInt();
		//identifier is of range 1-100
		System.out.println("Enter "+pos +" User SBP in mmHg: ");
		double sbp=sc.nextDouble();

		System.out.println("Enter "+pos +" User DBP in mmHg: ");
		double dbp=sc.nextDouble();
                
                               
                if(!checkValidation(id,sbp,dbp))
                {           
                    if(j<2)
                    {
                        j++;
                        isError=true;
                        System.out.println("Enter data again for " +pos +" User ");
                        manageInput(sc,pos,isError,format);
                    }
                    else
                    {
                        //you have enter incorrect more times 
                        //exit 
                        System.out.println("You have entered incorrect data multiple times");
                        isError=true;
                        System.exit(22);
                    }
                }
                else
                {
                    j=0;
                    double map= mapObj.value(sbp,dbp);
                    String category=mapObj.category(map);
                    format+=id+". The "+category+ " MAP "+ String.format("%.2f", map)+"\n";
		   
                }
                return format;
        }

}
