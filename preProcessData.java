import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class preProcessData 
{

	public static void main(String[] args) throws IOException
	
	{
	
		BufferedReader dataFile = new BufferedReader(new FileReader("IncomeData.txt"));
		BufferedWriter dataFileParse = new BufferedWriter(new FileWriter("IncomeDataParse.txt"));
		
		try {
			String line;
			while ((line = dataFile.readLine()) != null) 
			{
				if(!line.trim().isEmpty()) 
				{
					String[] splitLine = line.split(" ");
							{
					String parsedFile = splitLine[1] + " " + splitLine[2] + " " + splitLine[3] +
							" " + splitLine[4] + " " + splitLine[5] + " " + splitLine[6] +
									" " + splitLine[15];
					dataFileParse.write(parsedFile);
					dataFileParse.write(System.getProperty("line.separator"));
					System.out.println(parsedFile);
					
							}			
				}
			}
		}
		finally 
		{
			try 
			{
				dataFileParse.close();
				}
			catch(IOException ex) 
			{
				try 
				{
					dataFile.close();
					}
				catch(IOException ex1) 
				{
					
				}
			}
		}
	}
}