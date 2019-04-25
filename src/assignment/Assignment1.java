package assignment;

import java.util.Scanner;

public class Assignment1 {
    
    /**
     * lowestMap is used lowest MAP value from all individuals
     * highestMap is used highest MAP value from all individuals
     * 
     */
        static double lowestMap=0;
        static double highestMap=0;
        static double averageMap=0;
        static int num=0;


	public static void main(String[] args) {

            lowestMap=0;
            highestMap=0;
            averageMap=0;
            num=0;
            
            //made object of Assignment1 class
            Assignment1  assignment= new Assignment1();
            
            //initialize scanner for input from console
            Scanner sc= new Scanner(System.in);
            
            System.out.println("Enter Total User : ");
            int totalNum= sc.nextInt();
               
            // sample number of individuals must be within specified interval
            if(totalNum > 10 || totalNum < 5)
                  System.out.println("The number of individuals is between 5-10 ");
            else
            {
                for(int i=0;i<totalNum;i++)
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
                   assignment.manageInput(sc, pos);
                }
               System.out.println("Summary report as: ");
                System.out.println("1. The lowest MAP value: "+String.format("%.1f", lowestMap)+" mmHg");
                System.out.println("2. The highest MAP value: "+String.format("%.1f", highestMap)+" mmHg");
                System.out.println("3. The average MAP value: "+String.format("%.1f", (averageMap)/num)+" mmHg");
               
               }
              }
        
    
        
        
        /**
         * check user input data, it validate data 
         * with required format. 
         * @param id is user identifier which is range between 1-100 
         * @param sbp systolic blood pressure
         * @param dbp diastolic blood pressure
         * @return 
         */
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
        
        
        
     
        /**
         * this method manage the input data 
         * Scanner will be used to take data from console 
         * 
         * @param scanner is used to take input from user console
         * @param currentPos current position of user  in loop
         */
        public void manageInput(Scanner scanner,String currentPos)
        {
            
            //Create onject of class MAPCalculator
            MAPCalculator mapObj= new MAPCalculator();
           

            System.out.println("Enter " +currentPos +" User Identifier: ");
            int id=scanner.nextInt();
            if(id<1 || id >100)
            {
                System.out.println("You have entered incorrect User Identifier, Please enter again ");
                manageInput(scanner,currentPos);
                return;
            }
            
            System.out.println("Enter "+currentPos +" User SBP in mmHg: ");
	        double sbp=scanner.nextDouble();

	        System.out.println("Enter "+currentPos +" User DBP in mmHg: ");
            double dbp=scanner.nextDouble();
                
                         
            //check validation of id, sbp and dbp
            if(!checkValidation(id,sbp,dbp))
            {
                 System.out.println("You have entered incorrect data for id "+id);
                 return;
            }
            else
            {
                double map= mapObj.value(sbp,dbp);
                String category=mapObj.category(map);
               
                System.out.println("User ID: "+ id);
                System.out.println("User MAP value: "+ String.format("%.1f", map)+" mmHg");
                System.out.println("MAP is "+ category);
                
                averageMap+=map;
                num++;
                //calculate max and min MAP value
                maxMinMap(map);
            }
        }
        
        
        /**
         * calculate Max and Min value of MAP
         * @param map is MAP of current user in loop
         */
        public void maxMinMap(double map)
        {
            if(highestMap==0 )
            {
                highestMap=map;
  
            }
            if(lowestMap==0 )
            {
                lowestMap=map;
  
            }
            if(map>=highestMap)
            {
                highestMap=map;
            } 
            if(map<=lowestMap)
            {
                lowestMap=map;
            }
            
        }

}
