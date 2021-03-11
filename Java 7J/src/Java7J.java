import java.io.*;
import java.util.*;

public class Java7J {
    public static void main (String args[]) throws IOException{
        FileReader fr = new FileReader("7J_Mushrooms.csv");
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        int lines = 0;
        LinkedList<String> file = new LinkedList<String>();
        while(str != null){
            str = br.readLine();
            lines = lines + 1;
            file.add(str);
        }
        lines = lines - 1;
        file.removeLast();
        int[] nums = new int[lines];
        for (int j = 0; j < file.size(); j++) {
            String[] split = file.get(j).split(",");
            nums[j] = Integer.parseInt(split[1]);
        }
        Arrays.sort(nums);
        System.out.printf("%-30s %-15s %s %n","Mushroom","Weight","Cooking");
        System.out.println("==============================================================");
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                String[] split = file.get(j).split(",");
                if(Integer.parseInt(split[1]) == nums[i]){
                    System.out.printf("%-30s %-15s %s",split[0],split[1],split[2]);
                    System.out.println();
                    break;
                }
            }
        }
        br.close();
        fr.close();
    }
}