package com.codified.esword.util;

import com.codified.esword.constants.AnsiConstants;

public class PrintUtils {
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);  
    }
   
    public static String padLeft(String s, int n) {
       return String.format("%" + n + "s", s);  
    }

    public static void printErr(String s) {
        System.err.println(AnsiConstants.ANSI_COLOR_RED + s + AnsiConstants.ANSI_RESET);
    }
}
