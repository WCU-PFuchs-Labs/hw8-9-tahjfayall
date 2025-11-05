import java.util.*;

public class TestGeneration
{
   public static void main (String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Enter file name: ");
      String fileName = kb.nextLine();
      
      Generation gen = new Generation (500, 3, fileName);
      
      gen.evalAll();
      gen.printBestTree();
      gen.printBestFitness();
      
      ArrayList<GPTree> topTen = gen.getTopTen();
      System.out.println("Top 10 fitness values: ");
      for (int i = 0; i < topTen.size(); i++)
      {
         System.out.printf("%.2f", topTen.get(i).getFitness());
         if (i < topTen.size() -1)
         {
            System.out.print(", ");
         }
      }
      System.out.println();
   }
}