import java.util.Scanner;
import java.io.*;

public class bowlingscore
{
	public static void main(String[] args) throws IOException
	{
		String[] names = new String[50];
		double[] avgScore = new double[50];
		int nblowers = 0, b = 0;

		//declear a variable for printing out data
		PrintWriter ofile = new PrintWriter("bowlingoutput.txt");
		
		ofile.println("\n  CISC1115 MY11        HW7           Due Date: 11/30/2020\n__________________________________________________________________________________________________\n\n");
		
		//calling the method readDate(requirement 1) and print out data
		nblowers = readData(names, avgScore);
	
		ofile.println("The average score of each blower:\n");
		for(int i=0;i<nblowers;i++)
		{
			ofile.println("\t"+names[i]+"\t      "+String.format("%.2f",avgScore[i]));
		}

		//calling the method: parallesort for ascending order (requirement 2.1) and print out data
		parallesort(names, avgScore, nblowers);
	
		ofile.println("\n\nThe ascending order by name:\n");
		for(int i=0;i<nblowers;i++)
		{
			ofile.println("\t"+names[i]+"\t      "+String.format("%.2f",avgScore[i]));
		}

		//calling the method: parallesort for descending order (requirement 2.2) and print out data
		parallesort(avgScore, names, nblowers);
	
		ofile.println("\n\nThe descending order by average score:\n");
		for(int i=0;i<nblowers;i++)
		{
			ofile.println("\t"+names[i]+"\t      "+String.format("%.2f",avgScore[i]));
		}

		//Calling the method: binarysearch (requirement 3) 
		parallesort(names, avgScore, nblowers);

		b = binarySearch(names, "Sam", nblowers);
		if(b>0)
		{
			ofile.println("\n\nThe searching result of Sam:  \n");
			ofile.println("\tFound!  "+names[b]+"\t      "+String.format("%.2f",avgScore[b]));
		}
		else 
			ofile.println("\n\nThe searching result of sam:  no found\n");

		b = binarySearch(names, "Roberta", nblowers);
		if(b>0)
		{
			ofile.println("\n\nThe searching result of Roberta:  \n");
			ofile.println("\tFound!  "+names[b]+"\t      "+String.format("%.2f",avgScore[b]));
		}
		else 
			ofile.println("\n\nThe searching result of Roberta:\n\n\t   Not found\n");

		ofile.close();

	}

	// read in the file to calcualte the average and count the total numbers of blower(requirement 1)
	public static int readData(String[] names, double[] avgScore) throws IOException 
	{
		String name = "", num = "", snum = "", tstr = "";
		int nblowers = 0, nscore = 0, score = 0, tscore=0;
		double bAscore = 0;
		boolean fvalue = true;   //check if the value is the first value

		File rfile = new File("bowlingInput.txt");
		Scanner input = new Scanner(rfile);
                
	        while(input.hasNext())
		{
			nblowers++;
			tstr = input.nextLine();
			for(int i=0;i<tstr.length();i++)
			{
				if(Character.isSpaceChar(tstr.charAt(i)))
					continue;
				if(Character.isLetter(tstr.charAt(i)))
					name += tstr.charAt(i);
				if(fvalue == true && Character.isDigit(tstr.charAt(i)))
				{

					snum += tstr.charAt(i);
					nscore = Integer.parseInt(snum);
					fvalue = false;
					snum = "";
				}
			        else if(fvalue == false && Character.isDigit(tstr.charAt(i)))
				{
					num += tstr.charAt(i);
					if(Character.isSpaceChar(tstr.charAt(i+1)))
					{
						tscore = Integer.parseInt(num);
						score += tscore;
						num = "";
					}					
				}
			}

			bAscore = (double)score/nscore;

			names[nblowers-1] = name;
			avgScore[nblowers-1] = bAscore;
		        name = "";
			score = nscore = 0;
			fvalue = true;
		}	
		return nblowers;
	}

	//sorting the string array (names) (requirement 2.1)
	public static void parallesort(String[] arrStr, double[] arrDbl, int ndx)
	{
		String mstr = "";
		double mascore = 0;
		int cindex = 0;

		for(int i=0;i<ndx-1;i++)
		{
			mstr = arrStr[i];
			mascore = arrDbl[i];
			cindex = i;

			for(int j=i+1;j<ndx;j++)
			{
				if(mstr.compareTo(arrStr[j])>0)
				{
					mstr = arrStr[j];
					mascore = arrDbl[j];
					cindex = j;
				}
			}

			if(cindex != i)
			{
				arrStr[cindex] = arrStr[i];
				arrStr[i] = mstr;

				arrDbl[cindex] = arrDbl[i];
				arrDbl[i] = mascore;
			}
		}
	}

	//sorting the double array (avgScore) (requirement 2.2)
	public static void parallesort(double[] arrDbl, String[] arrStr, int ndx)
	{
		String lstr = "";
		double lascore = 0;
		int cindex = 0;

		for(int i=0;i<ndx-1;i++)
		{
			lstr = arrStr[i];
			lascore = arrDbl[i];
			cindex = i;

			for(int j=i+1;j<ndx;j++)
			{
				if(lascore<arrDbl[j])
				{
					lstr = arrStr[j];
					lascore = arrDbl[j];
					cindex = j;
				}
			}

			if(cindex != i)
			{
				arrStr[cindex] = arrStr[i];
				arrStr[i] = lstr;

				arrDbl[cindex] = arrDbl[i];
				arrDbl[i] = lascore;
			}
		}
	}

	//binary search method for searching the name Sam and Roberta (requirement 3)
	public static int binarySearch(String[] list, String key, int ndx)
	{
		int l = 0, h = ndx-1, mid = 0;

		while(h>=l)
		{
			mid = (l+h)/2;
			if(key.compareTo(list[mid])<0)
				h = mid-1;
			else if(key.equals(list[mid]))
				return mid;
			else
				l = mid+1;
		}

		return -l-1;
	}
}
