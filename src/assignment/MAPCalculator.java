package assignment;

public class MAPCalculator {
	
	public MAPCalculator()
	{
	}
		public double value(double sbp, double dbp) {
			double MAP = 1.0/3.0 * sbp + 2.0/3.0 * dbp;
			return MAP;
		}
		
		
		public String category(double map) {
		
			if(map<70)
			{
				return "low";

			}
			else if(map>100)
			{
				return "high";

			}
			else
			return "normal";
			
		}
	

	
}
