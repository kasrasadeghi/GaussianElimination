/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussianelimination;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Kasra
 */
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
    
    public static void GaussianElimination()
    {
        System.out.println( "Please input an equation.");
        String equation = inputLine();
        String[] equationParts = equation.split(" ");
        double[] vals = new double[equationParts.length];
        
        for ( int i = 0; i < vals.length; ++i ) {
            System.out.print(equationParts[i] + ": ");
            vals[i] = Double.valueOf(equationParts[i]);
            
            System.out.println(vals[i]);
        }
        
    }
}
