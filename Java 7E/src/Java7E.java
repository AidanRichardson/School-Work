import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Java7E {
    public static void main(String Args[])throws IOException {
        //Connect Java to the file in Windows
        PrintWriter pw = new PrintWriter("7E_Wage.txt");

        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter your name > ");
        String name = kb.nextLine();
        System.out.print("Enter hours worked > ");
        int hours = Integer.parseInt(kb.nextLine());
        double total = hours * 9.5;
        pw.write("========= Salary Slip ========="+"\n");
        pw.write("Employee: "+name+"\n");
        pw.write("Company: CompSci Industrial"+"\n");
        pw.write("==============================="+"\n");
        pw.write("Hours worked: "+hours+"\n");
        pw.write("Hourly rate: £9.50"+"\n");
        pw.write("Total Salary: £"+total+"\n");
        pw.write("===============================");
        pw.close();
        System.out.println("*** Wage slip generated - now get back to work!");
    }
}