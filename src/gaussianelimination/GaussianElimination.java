package gaussianelimination;

import static gaussianelimination.Ec.*;
import java.util.*;

public class GaussianElimination {
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void GaussianElimination()
    {
        System.out.println( "Please input an equation.");
        Equation equation = new Equation(sc.nextLine());
        
    }
    
    public static void TermChecker()
    {
        System.out.println("Please input a term you want "
                + "to check the value of.");
        String next = sc.next();
        System.out.println(isCoeffVar(next));
    }
    
    
    
    public static void main(String[] args) 
    {
        GaussianElimination();
//        TermChecker();
        //TODO read 5 - 4 as 5 + -4
    }
}