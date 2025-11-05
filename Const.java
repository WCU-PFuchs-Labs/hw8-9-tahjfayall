/**
* Code Template Author: David G. Cooper
* Purpose: An operation class representing a constant number
*/
import java.util.Random;

public class Const extends Unop {
    /** the constant value */
    private double value;
    /**
     * @param d the value to set the constant to.
     */
    public Const(double value) {
        this.value = value;
    }
    
    @Override
    /**
     * @return the value of the constant.
     */
    public double eval(double[] values) {
        return value;
    }
    
    /**
   * Overrides default toString method
   * @returns value
   */
    public String toString()
    {
      return Double.toString(value);
    }
}
