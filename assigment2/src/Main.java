import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while(true) {
            try {
                System.out.print("Enter the number of persons: ");
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("please entre a postive number!");
                    continue;
                } else {
                    break;
                }
            }
            catch(InputMismatchException e1){

                System.out.println(e1.toString());
                return;
            }
        }
        int n_sure=n;
        ArrayList <Data> list1=new ArrayList<Data>(n);
        Data array1 = new Data();
        try {
            array1.main_function(list1, n_sure);
        }
        catch(InputMismatchException e2){
            System.out.println(e2.toString());

        }

    }
}