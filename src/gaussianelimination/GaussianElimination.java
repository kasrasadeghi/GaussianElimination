package gaussianelimination;

import static gaussianelimination.ElementChecks.*;
import java.util.*;
import java.util.regex.Pattern;

public class GaussianElimination {
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static double inputDouble()
    {
        if ( sc.hasNextDouble())
            return sc.nextDouble();
        else {
            System.out.println( "You must input a double.");
            return inputDouble();
        }
    }
    
    public static void GaussianElimination()
    {
        System.out.println( "Please input an equation.");
        Equation equation = new Equation(sc.nextLine());
        
    }
    
    public static void main(String[] args) 
    {
        //GaussianElimination();
        String test = sc.next();
        System.out.println(isDoubleWithCoefficient(test));
        System.out.println(getCoefficient(test));
    }
}