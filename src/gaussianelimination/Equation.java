/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussianelimination;

import static gaussianelimination.GaussianElimination.*;
import static gaussianelimination.ElementChecks.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Stream;

/**
 *
 * @author KSADEGHI
 */
public class Equation {
    public double coefficients [] = {};
    public String variables [];
    
    //constructor
    public Equation(String input) {
        
        String[] leftSide = input.split("=")[0].split(" ");
        String[] rightSide = input.split("=")[1].split(" ");
        
        
        //constant logic
        // make these stream()-y
        Double leftSum = Arrays.stream(leftSide)
                .filter(el -> isDouble(el))
                .mapToDouble(str -> Double.valueOf(str))
                .sum();
        Double rightSum = Arrays.stream(rightSide)
                .filter(el -> isDouble(el))
                .mapToDouble(str -> Double.valueOf(str))
                .sum();
        Double rightMinusLeft = rightSum - leftSum;
        
        System.out.println("0 = " + rightMinusLeft );
        
    }       
    
    
    //methods
    
}
