/*Java assignment question-1
  Date : 13/03/2021
  Author: Dhanashree Wani
  Problem statement : Write a code to print the patterns*/

import java.io.*;
import java.util.*;
public class Pattern {
    public void printStarPattern() {
        //number of rows
        int rows = 5;
        //loop for print rows
        for(int i=0;i<rows;i++){
             //loop for print space
             for (int j=rows-i; j>1; j--) {
                System.out.print(" ");
             }
             //loop for print stars
             for(int k=0;k<=i;k++) {
                 System.out.print(" *");
             }
             //print stars on next line
             System.out.println("");
        }
    }
    public void printLetterPattern() {
        int row = 5;
        int k=1;
        //loop for print rows
        for(int i=0;i<row;i++) {
            //loop for left align
            for(int j = 2 * (row - i); j >= 0; j--) {
                System.out.print(" ");
            }
            //loop for print space and alphabet
            for(int j = 0; j <= i; j++,k++) {  
                System.out.print(" "+(char)(k+64));
            }
             //print alphabet on next line
             System.out.println("");
        }
    }
    public static void main(String args[]) {
        Pattern p= new Pattern();
        p.printStarPattern();
        p.printLetterPattern();
    }
}