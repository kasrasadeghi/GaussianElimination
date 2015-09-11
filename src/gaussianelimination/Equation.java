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

/**
 *
 * @author KSADEGHI
 */
public class Equation {
    public List<Double> constants = new ArrayList<Double>();
    public double coefficients [] = {};
    public String variables [];
    public List<String> sidesOfEquation = new ArrayList<String>(); 
    //constructor
    public Equation(String input) {
        constants.add(0.0);
        sidesOfEquation.addAll(Arrays.asList(input.split("=")));
        System.out.println(sidesOfEquation);
        
        //constant logic
        for (String el : sidesOfEquation.get(0).split(" ")) {
            if (isDouble(el))
                constants.add(Double.valueOf(el));
            if (isDoubleWithCoefficient(el))
                return;
        }
        for (String el : sidesOfEquation.get(1).split(" ")) {
            if (isDouble(el))
                constants.add(-Double.valueOf(el));
        }
        for (Double constant : constants) constants.set(0, constants.get(0)+constant);
        constants.set(0, -constants.get(0));
        System.out.println(constants.get(0));
        
        
    }       
    
    
    //methods
    
}
