import java.io.*;
import java.util.Scanner;

public class Java7F {
    public static void main(String Args[]) throws IOException {
        //Connect Java to the file in Windows
        PrintWriter pw = new PrintWriter("7F_translator.txt");

        Scanner kb = new Scanner(System.in);
        System.out.print("Greetings! Please select either French or Spanish (F/S) > ");
        char input = kb.nextLine().toUpperCase().charAt(0);
        if(input == 'F') {
            pw.write("Thank you for selecting: French"+"\n");
            pw.write("==============================="+"\n");
            pw.write("1 - ONE - un"+"\n");
            pw.write("2 - TWO - deux"+"\n");
            pw.write("3 - THREE - trois"+"\n");
            pw.write("4 - FOUR - quatre"+"\n");
            pw.write("5 - FIVE - cinq"+"\n");
            pw.write("6 - SIX - six"+"\n");
            pw.write("7 - SEVEN - sept"+"\n");
            pw.write("8 - EIGHT - huit"+"\n");
            pw.write("9 - NINE - neuf"+"\n");
            pw.write("10 - TEN - dix"+"\n");
            pw.write("================================");
            System.out.println("*** File created! Enjoy!");
        }
        else if (input == 'S'){
            pw.write("Thank you for selecting: Spanish"+"\n");
            pw.write("==============================="+"\n");
            pw.write("1 - ONE - uno"+"\n");
            pw.write("2 - TWO - dos"+"\n");
            pw.write("3 - THREE - tres"+"\n");
            pw.write("4 - FOUR - cautro"+"\n");
            pw.write("5 - FIVE - cinco"+"\n");
            pw.write("6 - SIX - seis"+"\n");
            pw.write("7 - SEVEN - siete"+"\n");
            pw.write("8 - EIGHT - ocho"+"\n");
            pw.write("9 - NINE - nueve"+"\n");
            pw.write("10 - TEN - diez"+"\n");
            pw.write("================================");
            System.out.println("*** File created! Enjoy!");
        }
        else{
            pw.write("*** ERROR! Language choice not known");
            System.out.println("*** ERROR! Language choice not known");
        }
        pw.close();
    }
}
