import java.util.*;

public class TestGP
{
   public static void main (String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Enter file name: ");
      String fileName = kb.nextLine();
      
      Generation gen = new Generation (500, 3, fileName);
      
      for (int i = 1; i <= 50; i++)
      {
         System.out.println("Generation " + i + ":");
         gen.evalAll();
         gen.printBestTree();
         gen.printBestFitness();
         gen = evolveNewGeneration(gen);
      }
      
      ArrayList<GPTree> topTen = gen.getTopTen();
      System.out.print("Top Ten fitness values: ");
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
   
   private static Generation evolveNewGeneration(Generation currGen)
   {
      currGen.evolve();
      return currGen;
   }
}