import java.util.Scanner;

public class rectangledimension
{
	public static void main(String[] args)
	{
		double length, width, perimeter, area; // declear variables for storing data
		Scanner input = new Scanner (System.in); // declear variable for reading users`input

		System.out.print("\nPlease input a length for the rectangle: "); // ask users to input a value for length

		length = input.nextDouble(); // read data from what users input

		System.out.print("\nPlease input a width for the rectangle: ");

		width = input.nextDouble();
		
		// calcualte the perimeter and area
                perimeter = (length + width)*2;
		area = length * width;

		//print out the length, width, perimeter and area
		System.out.println("\nA rectangle with width "+width+" and length "+length+" has area of "+area+" and perimeter "+ perimeter+".\n");
	}
}
