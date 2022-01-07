import java.util.Scanner;

public class validdate
{
	public static void main(String[] args)
	{
		//declear int variables and input variable for reading data
		int month, day, year;
		Scanner input=new Scanner(System.in);
		
		//ask users to input data
		System.out.print("\nPlease input month, day and year (spearate by space): ");
		month=input.nextInt();
		day=input.nextInt();
		year=input.nextInt();

		//determine if the month is within 12 and day and year are greater than 0 
		if(month>=1 && month<=12 && month!=2 && day>0 && year>0)
		{
			//determine if the month is Apr, Jun, Sep, Nov and day is more than 30 days
			if((month==4||month==6||month==9||month==11) && day>30)
				System.out.println("\nThe month "+month+" cannot have "+day+" days.\n");
			//determine if the month is the rest months but not Feb and the day is more than 31
			else if(month!=2 && day>31)
				System.out.println("\nThe month "+month+" cannot have "+day+" days.\n");
			// if the month and day input is correct,then output the correct infomation.
			else	
				System.out.println("\n"+month+" "+day+" "+year+" is a valid date.\n");			
		}

		//if the month is Feb and day and year are greater than 0
		else if(month==2 && day>0 && year>0)
		{
			//determine if the year is leap year
			if(year%400==0 || (year%4==0 && year%100!=0))
			{
				if(day<=29)
					System.out.println("\n"+month+" "+day+" "+year+" is a valid date.\n");
				else
					System.out.println("\nThe year "+year+" is a leap year and cannot have "+day+" days.\n");
			}
			else
			{
				if(day<=28)
					System.out.println("\n"+month+" "+day+" "+year+" is a valid date.\n");
				else
					System.out.println("\nThe year "+year+" is not a leap year and cannot have "+day+" days.\n");
			}
		}

		//print out the erronous input
		else
			System.out.println("\nInvalid input.\n");
	}
}
