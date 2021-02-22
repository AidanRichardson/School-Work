import java.io.*;
import java.util.Scanner;

public class Java7A {
    public static void main(String args[]) throws IOException {
        //Connect Java to the file in Windows
        FileReader fr = new FileReader("name.txt");

        //Connect a reader to the file
        BufferedReader br = new BufferedReader(fr);
        Scanner kb = new Scanner(System.in);
        System.out.print("Shall we cascade forwards or backwards? (F/B) > ");
        char input = kb.nextLine().toUpperCase().charAt(0);
        System.out.println("Let's cascade your name!");
        String [] lines = new String[5];
        String line = "";
        for (int i = 0; i < 5; i++) {
            line = br.readLine();
            lines[i] = line;
        }
        if (input == 'F') {
            for (int i = 0; i < 5; i++) {
                System.out.println(lines[i]);
            }
        } else {
            for (int i = 4; i >= 0; i--) {
                System.out.println(lines[i]);
            }
            br.close();
            fr.close();
        }
    }
}