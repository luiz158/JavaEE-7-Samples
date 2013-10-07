package org.javaee7.javamail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner sc=new Scanner(new File("data.txt"));
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
