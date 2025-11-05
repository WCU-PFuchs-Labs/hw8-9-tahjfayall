import java.util.Random;

public class NodeFactory
{
   private int numIndepVars;
   private Node[] currentOps;
   
   /*
   @param b - array of binop objects
   @param numVars - # of independent variables
   **/
   public NodeFactory(Binop[] b, int numVars)
   {
      this.numIndepVars = numVars;
      this.currentOps = new Node[b.length];
      
      for(int i = 0; i < b.length; i++)
      {
         this.currentOps[i] = new Node(b[i]);//Wrap each binop in a node and store in currentOps
      }
   }
   
   /*
   Returns random operator node from currentOps
   * @param generate random types
   **/
   
   public Node getOperator(Random rand)
   {
      int index = rand.nextInt(currentOps.length);
      return (Node) currentOps[index].clone();
   }
   
   //Returns # of operator types 
   public int getNumOps()
   {
      return currentOps.length;
   }
   
   /*
   * Returns terminal node, a var or a const
   * @param random number between 0 and numIndepVars
   **/
   public Node getTerminal(Random rand)
   {
      int choice = rand.nextInt(numIndepVars + 1);
      
      if(choice < numIndepVars)//less than creates a var node with choice
      {
         return new Node(new Variable(choice));
      }
      
      else
      {
         return new Node(new Const(rand.nextDouble()));//equal creates a const node between 0 and 1
      }
   }
   
   //Returns # of indepedent variables
   public int getNumIndepVars()
   {
      return numIndepVars;
   }
}