public class interestratetable
{
	public static void main(String [] args)
	{
		// define values to make principal start from 100000 and interest rate from 0.007
		double monPayment, intRate=0.07;
		int principal=100000, numYears=30;

		//print out the header of table
	        for(int i=0;i<92;i++)
			System.out.print("_");

		//print out headers for each column
	        System.out.print("\n\nPrincipal                                  Interest Rate\n\n\t    ");	
		
		// print out headers for the interest rate columns
		for(;intRate<0.105;intRate+=0.005)
			System.out.printf("%11.3f",intRate);
		
		System.out.println();
		for(int i=0;i<92;i++)
			System.out.print("_");
		System.out.println("\n");

		// print out the monthly payment with 2 decimal places
		for(;principal<1100000;principal+=100000)
		{
			System.out.printf("%d\t    ",principal);
			for(intRate=0.07;intRate<0.105;intRate+=0.005)
			{
				monPayment = principal * (intRate/12) * Math.pow((1+(intRate/12)),numYears*12)/(Math.pow((1+(intRate/12)),numYears*12)-1);
				System.out.printf("%11.2f",monPayment);		
			}
			System.out.println("\n");
		}

		for(int i=0;i<92;i++)
			System.out.print("_");
		System.out.println("\n\n");
	}
}
