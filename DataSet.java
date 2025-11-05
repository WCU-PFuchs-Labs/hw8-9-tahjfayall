//package tabular;
/**
 * Author:Tahj Fayall
 * Date: 10/08/2025
 * Purpose: To read a file, create a list, and save list of data rows to process
 * at a later time.
 */

import java.io.File;
import java.util.*;

public class DataSet {

    // add fields here
    private ArrayList<DataRow> data;
    private int numIndepVariables;

    /**
     * @param filename the name of the file to read the data set from
     */
    public DataSet(String filename)
    {
         // initialize fields here
         data = new ArrayList<>();
         try (Scanner scan = new Scanner(new File(filename)))
         {
            if (scan.hasNextLine())
            {
               numIndepVariables = scan.nextLine().split(",").length -1;
            }
            while (scan.hasNextLine())
            {
               String[] vals = scan.nextLine().split(",");
               if (vals.length != numIndepVariables +1) continue;
               double y = Double.parseDouble(vals[0].trim());
               double[] x = Arrays.stream(vals, 1, vals.length)
                                  .mapToDouble(v -> Double.parseDouble(v.trim()))
                                  .toArray();
               data.add(new DataRow(y, x));
            }
         } 
         
         catch (Exception x)
         {
            System.out.println("Cannot read file." + x.getMessage());
         }
    }

    /**
     * @return the list of rows
     */
    public ArrayList<DataRow> getRows() {
        // FIXME: return the right thing here
        return data;
    }

    /**
     * @return the number of independent variables in each row of the data set
     */
    public int getNumIndependentVariables() {
        
        return numIndepVariables;
    }
}
