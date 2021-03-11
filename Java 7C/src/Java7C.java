import java.io.*;
import java.util.Scanner;

public class Java7C {
    public static void main (String args[]) throws IOException {
        //opens file readers
        FileReader fr = new FileReader("7C_Wordsearch.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        int count = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the word to search for:");
        String word = kb.nextLine().toLowerCase();
        System.out.println("Looking for the word... "+word);
        //for loop to search through each line of the file
        //if statement to see if a line contains the word specified
        //if it does then adds 1 to count
        for (int i = 0; i < 300; i++) {
            line = br.readLine().toLowerCase();
            if(line.equals(word)){
                count = count + 1;
            }
        }
        System.out.println("The word "+word+" appears "+count+" times!");
        br.close();
        fr.close();
    }
}