package com.codified.esword.util;

import com.codified.esword.constants.BibleConstants;

public class PrintUtils {
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);  
    }
   
    public static String padLeft(String s, int n) {
       return String.format("%" + n + "s", s);  
    }

    public static void printErr(String s) {
        System.err.println(BibleConstants.ANSI_COLOR_RED + s + BibleConstants.ANSI_RESET);
    }
}
