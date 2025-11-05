//package tabular;

/**
 * Author: Tahj Fayall
 * Date: 10/05/2025
 * Purpose: Stores each row by separating dependent variable (y) from an array of
 * independent variables(array x) and 
 */


public class DataRow {

    // add fields here
    private double y;
    private double[] x;

    /**
     * @param y the dependent variable
     * @param x the array of independent variables
     */
    public DataRow(double y, double[] x)
    {
        // initialize fields here
        this.y = y;
        this.x = x;
    }

    /**
     * @return the dependent variable
     */
    public double getDependentVariable() {
        
        return y;
    }

    /**
     * @return the array of independent variables
     */
    public double[] getIndependentVariables() {
        
        return x;
    }
}
