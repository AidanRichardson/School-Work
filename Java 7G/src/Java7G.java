import java.io.*;
import java.util.Scanner;

public class Java7G {
    public static void main(String Args[])throws IOException {
        //Connect Java to the file in Windows
        PrintWriter pw = new PrintWriter("odd.txt");
        PrintWriter pw2 = new PrintWriter("even.txt");

        Scanner kb = new Scanner(System.in);
        System.out.println("Greetings! Please enter five whole numbers > ");
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            int j = i + 1;
            System.out.print("Number #"+j+" > ");
            numbers[i] = Integer.parseInt(kb.nextLine());
        }
        pw.write("ODD numbers"+"\n");
        pw.write("==========="+"\n");
        pw2.write("EVEN numbers"+"\n");
        pw2.write("============"+"\n");
        for (int i = 0; i < 5; i++) {
            int calculate = numbers[i]%2;
            if(calculate > 0){
                pw.write(numbers[i]+"\n");
            }
            else{
                pw2.write(numbers[i]+"\n");
            }
        }
        System.out.println("*** Sorting complete! Have a nice day!");
        pw.close();
        pw2.close();
    }
}