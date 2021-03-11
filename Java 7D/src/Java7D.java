import java.io.*;
import java.util.*;

public class Java7D {
    public static void main(String Args[])throws IOException {
        //Connect Java to the file in Windows
        PrintWriter pw = new PrintWriter("text.txt");

        Scanner kb = new Scanner(System.in);
        LinkedList <String> emails = new LinkedList<String>();
        boolean done = false;
        while(done == false) {
            System.out.print("Enter the year (e.g 2016) > ");
            String year = kb.nextLine().substring(2,4);
            System.out.print("Enter your first name > ");
            char fName = kb.nextLine().charAt(0);
            System.out.print("Enter your last name > ");
            String lName = kb.nextLine();
            String combined = year+lName+fName+"@mymail.co.uk";
            emails.add(combined);
            System.out.print("*** Email created - shall we make another? (Y/N) > ");
            char answer = kb.nextLine().toUpperCase().charAt(0);
            if (answer == 'N') {
                System.out.println("*** Program terminated - have a nice day!");
                done = true;
            }
        }
        for (int i = 0; i < emails.size(); i++) {
            pw.write(emails.get(i)+"\n");
        }
        pw.close();
    }
}