import java.io.*;
import java.util.Scanner;

public class Java7B {
    public static void main (String args[]) throws IOException {
        //opens file readers
        FileReader fr = new FileReader("7B_Batch.txt");
        BufferedReader br = new BufferedReader(fr);
        char line = 'A';
        int count = 0;
        Scanner kb = new Scanner(System.in);
        System.out.print("What letter shall I count? > ");
        char letter = kb.nextLine().toUpperCase().charAt(0);
        System.out.println("Counting the "+letter+"s' in the file...");
        //for loop to search through each line of the file
        //if statement to see if a line contains the letter specified
        //if it does then adds 1 to count
        for (int i = 0; i < 250; i++) {
            line = br.readLine().toUpperCase().charAt(0);
            if(line == letter){
                count = count + 1;
            }
        }
        System.out.println("I found "+count+" "+letter+"s' in the file!");
        br.close();
        fr.close();
    }
}