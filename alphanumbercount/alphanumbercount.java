import java.util.Scanner;
import java.io.*;

public class alphanumbercount 
{
	public static void main(String[] args)throws IOException
	{
		//declear variables
		String text="", t="";
		int nletters=0, ndigits=0, nchar=0;

		//read the file hw6test
		File tfile = new File("hw6test.txt");
		Scanner input = new Scanner(tfile);

		//declear variables for print out a file
		PrintWriter ofile = new PrintWriter("hw6Ofile.txt");

		//print out the header in the file (requirement 4)
		header(ofile,"*********", "******", "HW", 6, "*******");

		//read sentences from the test file (requirement 1)
		while(input.hasNext())
		{
			t=input.nextLine();
			text += t;
		}

		//count total number letters, digits and all other characters (requirement 2)
		for(int i=0;i<text.length();i++)
		{
			if(Character.isLetter(text.charAt(i)))
				nletters++;
			else if(Character.isDigit(text.charAt(i)))
				ndigits++;
			else
				nchar++;
		}

		//output the results to a file
		ofile.println("The number of letters: "+nletters);
		ofile.println("The number of digits: "+ndigits);
		ofile.println("The number of other characters: "+nchar+"\n\n");

		//call countChars method and output the results to hw6ofile.txt (requirement 3)
		countChars(ofile, text, 'a', 'z');
		countChars(ofile, text, 'A', 'Z');
		countChars(ofile, text, '0', '9');

		System.out.println("\n\nA file has been created. File name: hw6ofile.txt\n\n");
	
		ofile.close();

	}

	//countChars method(requirement 3)
	public static void countChars(PrintWriter pw, String text, char start, char end)
	{
		int n=0;

		pw.println("The numbers from "+start+" and "+end+": ");
		for(char i=start;i<=end;i++)
		{
			for(int j=0;j<text.length();j++)
			{
				if(i==text.charAt(j))
					n++;
			}
			if(n>0)
				pw.println("The number of "+i+": "+n);
			n=0;
		}
		pw.println("\n\n");
	}

	//print out the header (requirement 4)
	public static void header(PrintWriter pw, String name, String classection, String type, int num, String dueDate)
	{
		pw.println("\n\n              "+name+"        "+classection+"        "+type+num+"             "+dueDate+"            "+"\n________________________________________________________________________________________________________\n\n");
	}
}
