import java.io.*;

public class Java7H {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("7H_Sentencelist.txt");
        BufferedReader br = new BufferedReader(fr);
        int counter = 0;
        String str = "";
        for (int i = 0; i < 100; i++) {
            counter = counter + 1;
            str = str + br.readLine();
        }
        str = str.replace(".", " ");
        String[] words = str.split(" ");
        System.out.println("Ok, I count the following...");
        System.out.println("There are " + counter + " sentences!");
        System.out.println("There are " + words.length + " words!");
        str = str.replace(" ", "");
        System.out.println("There are " + str.length() + " letters!");
        br.close();
        fr.close();
    }
}