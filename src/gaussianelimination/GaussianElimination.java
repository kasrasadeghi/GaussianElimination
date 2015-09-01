package gaussianelimination;

import java.util.Scanner;

public class GaussianElimination {
    
    public static double inputDouble()
    {
        Scanner sc = new Scanner( System.in);
        if ( sc.hasNextDouble())
            return sc.nextDouble();
        else {
            System.out.println( "You must input a double.");
            return inputDouble();
        }
    }
    
    public static String inputString()
    {
        Scanner sc = new Scanner( System.in);
        if ( sc.hasNext())
            return sc.next();
        else {
            System.out.println( "You must input a string.");
            return inputString();
        }
    }
    
    public static String inputLine()
    {
        Scanner sc = new Scanner( System.in);
        if ( sc.hasNextLine())
            return sc.nextLine();
        else {
            System.out.println( "You must input a string.");
            return inputLine();
        }
    }
    
    public static void main(String[] args) 
    {
        GaussianElimination();
    }
    
    
    public static boolean isDouble( String input) 
    {
        try {
            Double.valueOf(input);
            return true;
        } catch(NumberFormatException ex)
        {
            return false;
        }
    }
    
    public static boolean isDoubleWithCoefficient( String input)
    {
        //TODO: check to see if all of the leading digits are numbers {0-9, .}
        return true;
        
    }
    
    public static void GaussianElimination()
    {
        System.out.println( "Please input an equation.");
        String equation = inputLine();
        String[] equationParts = equation.split(" ");
        double[] vals = new double[equationParts.length];
        for ( int i = 0; i < vals.length; ++i ) {
            vals[i] = Double.valueOf(equationParts[i]);
        }
    }
}