import java.util.Scanner;
import java.io.*;

public class filechecking
{
	public static void main(String[] args) throws IOException
	{
		// declare variables for reading the file
		String firstName, lastName, strSalary, cityState;
		char status;

		String temStr, city, state, salaryBonus;    // storing tempory string, sepearte city and state, salary bonus
		double s, b;                   // salary and bonous
		int e=0, d=0, f=0, c, decimalPoint;          // counting error, status D, status F, space/comma and decimal point 
		boolean typos = false;   //indicate if data has typos
		
		System.out.println("\n\n____________________________________________________________________________________________________________________________\n\n");

		//read the file
		File inFile = new File("strInput.txt");
		Scanner input = new Scanner(inFile);

		//output the d and f file
		PrintWriter filed = new PrintWriter("strOutputD.txt");
	        PrintWriter filef = new PrintWriter("strOutputF.txt");

		while(input.hasNext())
		{
			//initialize variables
		       	firstName = lastName = strSalary = cityState = "";
			status = ' ';
			
			temStr = city = state = "";
			s = b = c = decimalPoint =0;
			typos = false;

			temStr = input.nextLine();
	
			//reading data from file	
			for(int i=0;i<temStr.length();i++)
			{
				if(Character.isSpaceChar(temStr.charAt(i)))
				{
					c++;
					continue;
				}
				if(c==0)
					firstName += temStr.charAt(i);
				else if(c==1)
					lastName += temStr.charAt(i);
				else if(c==2)
				{
					if(temStr.charAt(i)=='.')
						decimalPoint++;

					//validate salary (requirement 2.a)
					if(Character.isDigit(temStr.charAt(i)) || temStr.charAt(i) == '.')
					{
						if(decimalPoint<=1)
						{
							if(temStr.charAt(i) == '.' &&  temStr.charAt(i+3)!=' ')
							{
								typos = true;
								e++;
								System.out.println("\""+temStr+"\""+"\tSalary has more than 3 position from the decimal point.\n");
							}
							strSalary += temStr.charAt(i);
						}
						else if(decimalPoint>1 && temStr.charAt(i)=='.')
						{
							typos = true;
							e++;
							System.out.println("\""+temStr+"\""+"\tSalary has more than one decimal point. Position: "+i+". \n");
						}
					}
					else
					{
						typos = true;
						e++;
						System.out.println("\""+temStr+"\" "+"\tChar at position "+i+" is not a digit for the salary.\n");
					}
				}
				else if (c==3)
				{
					//if status neither D or F, it will stop reading data (requirement 1)
					status=temStr.charAt(i);
					if(status=='D' || status=='F')
						continue;
					else
					{
						typos = true;
						e++;
						System.out.println("\""+temStr+"\" "+"\thas a wrong status "+ status+".\n");	
					}
				}
				else if(c==4)
					cityState += temStr.charAt(i);
			}

			if(typos == true)
				continue;
			else
			{
				//convert salary from string to double and calculate bonus (requirement 2.b and 2.c)
				s = Double.parseDouble(strSalary);
				if(status == 'D')
				{
					d++;
					b = s*0.125;
				}
				else if(status == 'F')
				{
					f++;
					b = s*0.18;	
				}
				salaryBonus = String.format("Bonus: %.2f", b);
				
				//sperate city and state (requirement 3)
				c=cityState.indexOf(',');

				city = cityState.substring(0,c);
				state = cityState.substring(c+1,cityState.length());

				//record the files (requirement 4)
				if(status == 'D')
					filed.println(firstName+" "+lastName+" "+strSalary+" "+salaryBonus+" "+status+" "+city+" "+state);
				else if(status == 'F')
					filef.println(firstName+" "+lastName+" "+strSalary+" "+salaryBonus+" "+status+" "+city+" "+state);
			}
		}

		//printout the result(requirement 5)
		System.out.println("----------------------------------------------------------------------------------------------------------------------------\n\nData is recorded into the files.\n\nThe results as follows:\n\n"+"Numbers of status D: "+d+"\n\nNumbers of status F: "+f+"\n\nThe incorrect records processed: "+e+"\n\n____________________________________________________________________________________________________________________________\n\n");

		//close files
		input.close();
		filed.close();
		filef.close();
	}
}
