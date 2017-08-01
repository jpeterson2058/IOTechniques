import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class preProcessData 
{

	public static void main(String[] args) throws IOException
	
	{
	
		BufferedReader dataFile = new BufferedReader(new FileReader("IncomeData.txt"));
		BufferedWriter dataFileParse = new BufferedWriter(new FileWriter("IncomeDataParse.txt"));
		
		try {
			String line;

            // Regex pattern to match the columns needed into groups
            // Start of line: ^
            // Group 1: one or more digits: (\\d+)
            // Comma: ,
            // Group 2: One or more digits: (\\d+)
            // Group 3: One or more any character: (.+?)
            // Group 3 matches up to 2 or more commas: ,{2,}
            // Group 4: One or more digits (\\d+)
            // One or more commas: ,+
            // Group 5: One or more digits: (\\d+)
            // One or more commas: ,+
            // Group 6: One or more digits: (\\d+)
            Pattern p = Pattern.compile("^(\\d+),(\\d+),(.+?),{2,}(\\d+),+(\\d+),+(\\d+)");
			while ((line = dataFile.readLine()) != null) 
			{
				if(!line.trim().isEmpty()) 
				{
                    // Replace spaces or non-ascii values with commas
                    line = line.replaceAll("\\s|[^\\x00-\\x7F]", ",");
                    // One of the lines started with a non-ascii value, replace that comma with nothing
                    line = line.replaceAll("^,", "");

                    Matcher m = p.matcher(line);
                    if (m.find())
                    {
                        String[] cols = new String[6];
                        cols[0] = m.group(1);
                        cols[1] = m.group(2);
                        // Turn the commas that now in the district name back into spaces
                        cols[2] = m.group(3).replaceAll(",", " ");
                        cols[3] = m.group(4);
                        cols[4] = m.group(4);
                        cols[5] = m.group(5);

                        // Join the values with a | for easier splitting
                        String row = String.join("|", cols);

                        dataFileParse.write(row);
                        dataFileParse.write(System.getProperty("line.separator"));
                    }
                    else
                    {
                        System.out.println(line);
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
