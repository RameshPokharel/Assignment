package assignment;

import java.util.Scanner;

public class Assignment1 {
    
    /**
     * retry is used to count the error generation for input validation 
     * if any user data is invalid in proper format, retry will be increased
     * 
     */
       static int retry=0;


	public static void main(String[] args) {

	    //Take scanner input from console
            String printFormat="";
            Scanner sc= new Scanner(System.in);
            
            System.out.println("Enter Total User : ");
            int totalNum= sc.nextInt();
               
            if(totalNum > 10 || totalNum < 5)
                  System.out.println("The number of individuals is between 5-10 ");
            else
            {
                boolean isError=false;
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
                    printFormat=manageInput(sc, pos,isError,printFormat);
                }
                if(!isError)
                {
                   System.out.print(printFormat);
                }
               }
              }
        
        /**
         * check user input data and return boolean value. it validate data 
         * with required format.
         * 
         * @param id is user identifier which is range between 1-100 
         * @param sbp systolic blood pressure
         * @param dbp diastolic blood pressure
         * @return boolean value 
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
         * and return proper format data to print as out in console
         * 
         * @param scanner is used to take input from user console
         * @param currentPos current position of user  in loop
         * @param isError check whether error occurs or not
         * @param format format of string used to print in console
         * @return string with appended value in format
         */
        public static String manageInput(Scanner scanner,String currentPos,boolean isError,String format)
        {
            
            MAPCalculator mapObj= new MAPCalculator();
           

            System.out.println("Enter " +currentPos +" User Identifier: ");
            int id=scanner.nextInt();
            //identifier is of range 1-100
            System.out.println("Enter "+currentPos +" User SBP in mmHg: ");
	    double sbp=scanner.nextDouble();

	    System.out.println("Enter "+currentPos +" User DBP in mmHg: ");
            double dbp=scanner.nextDouble();
                
                               
            if(!checkValidation(id,sbp,dbp))
            {
                if(retry<2)
                {
                    retry++;
                    isError=true;
                    System.out.println("Enter data again for " +currentPos +" User ");
                    manageInput(scanner,currentPos,isError,format);
                }
                else
                {
                 System.out.println("You have entered incorrect data multiple times");
                 isError=true;
                 System.exit(22);
                }
            }
            else
            {
                retry=0;
                double map= mapObj.value(sbp,dbp);
                String category=mapObj.category(map);
                format+=id+". The "+category+ " MAP "+ String.format("%.2f", map)+"\n";
            }
            return format;
        }

}
