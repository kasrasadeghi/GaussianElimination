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
public class ElementChecks {
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
        //Pattern dwcPattern = Pattern.compile();
        return Pattern.matches("-?((\\d+)|(\\d+\\.\\d+))[a-zA-Z]+\\d*", input);
        //first make it so that 10width counts as 10 times the width variable
        //then make it that each character after 10 before a space counts as a separate variable
        //maybe make a thing in the beginning that asks for the variable names
    }
    
    public static String getCoefficient( String input)
    {
        Pattern doubleWithCoefficient = Pattern.compile("-?((\\d+)|(\\d+\\.\\d+))([a-zA-Z]+\\d*)");
        Matcher m = doubleWithCoefficient.matcher(input);
        for( int i = 0; i < m.groupCount(); ++i) System.out.println(m.group(i));
        return null;
    }
}
