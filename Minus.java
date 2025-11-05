/**
* Author: Tahj Fayall
* Program: Minus
* Date: 09/24/2025
* Edit Date: 10/11/2025
* Editor: Tahj Fayall
**/
import java.util.Random;

public class Minus extends Binop //Inherits abstract methods in Binop class

{
   /**
   * Overrides eval() method in Binop
   * Performs subtraction of left by right
   * @return the result of left - right
   */
   public double eval(double left, double right) 
   {
      return left - right; 
   }
   
   /**
   * Overrides default toString method
   * @returns subtraction symbol
   */
   public String toString() 
   {
      return "-"; 
   }
}
