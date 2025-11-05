/**
* Author: Tahj Fayall
* Program: Variable
* Date: 10/10/2025
**/
import java.util.Random;

public class Variable extends Unop //Inherits abstract eval() method in Unop class
{
   private int index; //Stores postion of the variable in a vlaues array
   
   /**
   * Constructor
   * @param index - variable represented
   */
   public Variable(int index)
   {
      this.index = index;
   }
   
   /**
   * Overrides eval() method in Unop class
   * @param values - retrieves correct value
   * @returns - value at index
   */
   @Override
   public double eval(double[] values)
   {
      return values[index];
   }
   
   /**
   * Overrides default toString method
   * @returns variable string
   */
   public String toString()
   {
      return "X" + index;
   }
}