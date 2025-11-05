/**
* Author: Tahj Fayall
* Program: Generation
* Date: 11/04/2025
*/
import java.util.*;

public class Generation
{
   private GPTree[] trees;
   private DataSet dataSet;
   private NodeFactory factory;
   private Random rand;
   
   /**
   * Creates a new generation of trees
   * @param size - # of trees
   * @param maxDepth - maximum depth of each tree
   * @param fileName - path to file for fitness eval
   */
   public Generation(int size, int maxDepth, String fileName)
   {
      dataSet = new DataSet(fileName);
      Binop[] ops = { new Plus(), new Minus(), new Mult(), new Divide() }; //defining set of binops
      factory = new NodeFactory(ops, dataSet.getNumIndependentVariables());
      rand = new Random();
      trees = new GPTree[size];
      for (int i = 0; i < size; i++)
      {
         trees[i] = new GPTree(factory, maxDepth, rand);
      }
   }
   
   //evaluate fitness of each tree from file and sort in ascending order of fitness
   public void evalAll()
   {
      for (GPTree tree : trees)
      {
         tree.evalFitness(dataSet);
      }
      Arrays.sort(trees);
   }
   
   //returns top ten trees with lowest fitness scores and stores in an ArrayList
   public ArrayList<GPTree> getTopTen()
   {
      ArrayList<GPTree> topTen = new ArrayList<>();
      for (int i = 0; i < 10 && i < trees.length; i++)
      {
         topTen.add(trees[i]);
      }
      return topTen;
   }
   
   //prints tree with best fitness
   public void printBestFitness()
   {
      System.out.printf("Best fitness: %.2f%n", trees[0].getFitness());
   }
   
   //prints string for best tree
   public void printBestTree()
   {
      System.out.println("Best tree: " + trees[0]);
   }
   
   //new generation using crossover between trees
   public void evolve()
   {
      GPTree[] nextGen = new GPTree[trees.length];
      for (int i = 0; i < trees.length; i += 2)
      {
         GPTree parent1 = (GPTree) trees[rand.nextInt(trees.length /2)].clone();
         GPTree parent2 = (GPTree) trees[rand.nextInt(trees.length /2)].clone();
         parent1.crossover(parent2, rand);
         nextGen[i] = parent1;
         if (i + 1 < trees.length) nextGen[i + 1] = parent2; //add new children to next generation
      }
      trees = nextGen;//replace old gen with new
   }
}