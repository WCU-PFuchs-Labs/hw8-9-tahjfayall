/**
* Author: Tahj Fayall
* Program: GPTree
* Date: 10/28/2025
* Edit: 11/04/2025
**/
import java.util.ArrayList;
import java.util.Random;

public class GPTree implements Comparable<GPTree>, Cloneable, Collector
{
   private Node root;   //Top node
   private ArrayList<Node> crossNodes; //List to hold non leaf nodes
   private double fitness;
   
   public GPTree()   //Empty tree with no node
   {
      root = null;
   }
   
   public GPTree(NodeFactory n, int maxDepth, Random rand)
   {
      root = n.getOperator(rand);   //Get random operator node
      root.addRandomKids(n, maxDepth, rand); //Build to maxDepth
   }
   
   public double eval(double[] data)   //Evaluates using data array
   {
      return root.eval(data);
   }
   
   public void evalFitness(DataSet dataSet)
   {
      fitness = 0.0;
      for (DataRow row : dataSet.getRows())
      {
         double pred = eval(row.getIndependentVariables());
         double act = row.getDependentVariable();
         fitness += Math.pow(pred - act, 2);
      }
   }
   
   public double getFitness()
   {
      return fitness;
   }
   
   @Override
   public int compareTo(GPTree other)
   {
      return Double.compare(this.fitness, other.fitness);
   }
   
   @Override
   public boolean equals(Object o)
   {
      if (o == null || !(o instanceof GPTree))
      {
         return false;
      }
      return this.compareTo((GPTree) o) == 0;
   }
   
   @Override
   public Object clone()
   {
      GPTree copy = null;
      try
      {
         copy = (GPTree) super.clone();
         copy.root = (Node) this.root.clone();
      }
      catch (CloneNotSupportedException e)
      {
         System.out.println("GPTree cannot clone");
      }
      return copy;
   }
   
   public String toString()   //Returns string of tree
   {
      return root.toString();
   }
   
   public void traverse()  //Collects each internal node
   {
      crossNodes = new ArrayList<Node>();
      root.traverse(this);
   }
   
   public void collect(Node node)   //Implementation of collector interface
   {
      if (!node.isLeaf())  //Adds to crossNodes if not a leaf
      {
         crossNodes.add(node);
      }
   }
   
   /**
   * This returns a String with all of the binop Strings
   * separated by semicolons
   */
   public String getCrossNodes() 
   {
      StringBuilder string = new StringBuilder();
      int lastIndex = crossNodes.size() - 1;
      for(int i = 0; i < lastIndex; ++i) 
      {
         Node node = crossNodes.get(i);
         string.append(node.toString());
         string.append(";");
      }
      
      string.append(crossNodes.get(lastIndex));
      return string.toString();
   }
   
   /**
   * this implements left child to left child
   * and right child to right child crossover.
   * Challenge: additionally implement left to 
   * right child and right to left child crossover.
   */
   public void crossover(GPTree tree, Random rand) 
   {
      // find the points for crossover
      this.traverse();
      tree.traverse();
      int thisPoint = rand.nextInt(this.crossNodes.size());
      int treePoint = rand.nextInt(tree.crossNodes.size());
      boolean left = rand.nextBoolean();
      // get the connection points
      Node thisTrunk = crossNodes.get(thisPoint);
      Node treeTrunk = tree.crossNodes.get(treePoint);
      
      if(left) 
      {
         thisTrunk.swapLeft(treeTrunk);
      } 
      else 
      {
         thisTrunk.swapRight(treeTrunk);
      }
   }
}