/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussianelimination;

import static gaussianelimination.GaussianElimination.*;
import static gaussianelimination.Ec.*;
import static gaussianelimination.Equation.elementCollector;
import java.util.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author KSADEGHI
 */
public class Equation {
    public Map<String, Double> terms = new HashMap<>();
    
    public static Collector<String, HashMap<String, Double>, HashMap<String, Double>> elementCollector() { 
        return Collector.of(
                    () -> new HashMap<>(),//supplier
                    (base, element) -> base.merge(
                            getVariable( element), 
                            getCoefficient( element), 
                            (c1,c2) ->  c1 + c2
                        ),     
                    (base1, base2) -> {base1.putAll(base2); return base1;} 
        );
    }
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
        
        
//        variables with coefficients logic
//        Map<String, String> base = new HashMap<>();
        HashMap<String, Double> leftMap = Arrays.stream(leftSide)
                .filter(el -> isCoeffVar(el))
                .collect( elementCollector());
        HashMap<String, Double> rightMap = Arrays.stream(rightSide)
                .filter(el -> isCoeffVar(el))
                .collect( elementCollector());
        System.out.println("Printing the entrySet()s of each sides' term map.\n"
                + leftMap.entrySet() + " = " + rightMap.entrySet());
        
        terms.putAll(leftMap);
        rightMap.entrySet().stream().forEach((entry) -> {
            terms.merge(entry.getKey(), -entry.getValue(),(v1,v2) -> v1 + v2 );
        });
        
        String positives = terms.entrySet().stream()
                .filter(entry -> entry.getValue() >= 0)
                .map(entry -> Double.toString(entry.getValue()) + entry.getKey())
                .collect(Collectors.joining(" + "));
        String negatives = terms.entrySet().stream()
                .filter(entry -> entry.getValue() < 0)
                .map(entry -> Double.toString(Math.abs(entry.getValue())) + entry.getKey())
                .collect(Collectors.joining(" - "));
        String negativeString = "";
        if(!"".equals(negatives) && !"".equals(positives)) negativeString = " - ";
        System.out.println(positives + negativeString + negatives + " = " + rightMinusLeft);
                
    }
    
    
    //methods
    
}
