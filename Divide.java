/**
* Author: Tahj Fayall
* Program: Divide
* Date: 09/24/2025
* Edit Date: 10/28/2025
* Editor: Tahj Fayall
**/
import java.util.Random;

public class Divide extends Binop //Inherits abstract methods in Binop class

{
   
   /**
   * Overrides eval() method in Binop
   * Performs division of left by right
   * @return the result of left / right
   */
   public double eval(double left, double right) 
   {
      if (Math.abs(right) < 0.0001)    //No zero division
      {
         return 1.0;
      }
      
      return left / right; 
   }
   
   /**
   * Overrides default toString method
   * @returns division symbol
   */
   public String toString() 
   {
      return "/"; 
   }
}
