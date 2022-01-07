import java.util.Scanner;

public class depositrate
{
	public static void main(String [] args)
	{
		//declear variables
                double monthlyDeposit, yearlyIntRate, monthlyIntRate, monthlyValue=0;
                
		Scanner input = new Scanner(System.in);
		
		//ask users to input values
                System.out.print("\nPlease input the monthly deposit: ");
                monthlyDeposit = input.nextDouble();
                
		System.out.print("\nPlease input the yearly rate (decimal value): ");
                yearlyIntRate = input.nextDouble();

		//calculate the monthly rate
                monthlyIntRate = yearlyIntRate/12;

		 //using for-loop to calculate the monthly value and print out the result
                 for(int i=0;i<6;i++)
		 {
			 monthlyValue = (monthlyDeposit + monthlyValue) * (1+monthlyIntRate);
			 System.out.printf("\nThe month "+(i+1)+": %.2f\n",monthlyValue);
		 }
		 System.out.print("\n");
	}
}
