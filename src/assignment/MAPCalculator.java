package assignment;

public class MAPCalculator {
	
        //CONSTRUCTOR
	public MAPCalculator()
	{
	}
        
        /**
         * calculate Mean Arterial Pressure 
         * @param sbp systolic blood pressure
         * @param dbp diastolic blood pressure
         * @return MAP (Mean Arterial Pressure )
         */
        public double value(double sbp, double dbp) {
            double MAP = 1.0/3.0 * sbp + 2.0/3.0 * dbp;
            return MAP;
	}
        
        
        /**
         * calculate category of blood pressure 
         * 
         * @param map Mean Arterial Pressure 
         * @return category "low", "high","normal"
         */
        public String category(double map) {
            if(map<70)
                return "low";
            else if(map>100)
                return "high";
            else
                return "normal";
        }
}
