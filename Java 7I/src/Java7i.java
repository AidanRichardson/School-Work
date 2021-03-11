import java.io.*;

public class Java7i {
    public static void main (String args[]) throws IOException{
        FileReader fr = new FileReader("7I_Trains.csv");
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        String str = "";
        for (int j = 0; j < 4; j++) {
            i = i + 1;
            str = br.readLine();
            String[] split = str.split(",");
            System.out.println("Train #"+i);
            System.out.println("Type: "+split[0]);
            System.out.println("Colour: "+split[1]);
            System.out.println("Value: "+split[2]);
            System.out.println("Maker: "+split[3]);
            System.out.println("Status: "+split[4]);
            System.out.println();
        }
        br.close();
        fr.close();
    }
}