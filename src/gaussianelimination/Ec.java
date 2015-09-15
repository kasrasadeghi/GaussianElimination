/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussianelimination;

import java.util.regex.*;

/**
 *
 * @author KSADEGHI
 */
public class Ec {
    
    public static boolean isDouble( String input) 
    {
        try {
            Double.valueOf(input);
            return true;
        } catch(NumberFormatException | NullPointerException ex)
        {
            return false;
        }
    }
    
    static final String patString = "(-?((\\d+)|(\\d+\\.\\d+)))?([a-zA-Z]+\\d*)";
    static Pattern doubleCoeffWithVar = Pattern.compile(patString);
    
    public static boolean isCoeffVar( String input)
    {
        Matcher m = doubleCoeffWithVar.matcher(input);
        return m.find();
        
        //first make it so that 10width counts as 10 times the "width" variable
        //then make it that each character after 10 before a space counts as a separate variable
        //maybe make a thing in the beginning that asks for the variable names
    }
    
    public static Double getCoefficient( String input)
    {
        Matcher m = doubleCoeffWithVar.matcher(input);
        m.find();
        if (isDouble(m.group(1)))
            return Double.valueOf(m.group(1));
        else if (m.group(0).equals(input))
            return 1.0;
        else if (input.startsWith("-"))
            return -1.0;
        else {
            System.out.println("Coefficient Parsing Error");
            System.exit(0);
            return null;
        }
    }
    
    public static String getVariable(String input)
    {
        Matcher m = doubleCoeffWithVar.matcher(input);
        if (m.find())
            return m.group(m.groupCount());
        else return null;
    }
}
