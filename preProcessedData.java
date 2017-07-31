import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class preProcessedData 
{

	public static void main(String[] args) throws IOException
	{
	
		File dataFile = new File("IncomeData.txt");
		Scanner file = new Scanner(dataFile);
		
		while(file.hasNextLine()) 
		{
			String data = file.nextLine();
			System.out.println(data);
		}
		
	}
}	
		
		