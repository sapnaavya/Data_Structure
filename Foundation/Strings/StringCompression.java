/**
 This code compresses a string. For example, aaaabbbbbbeee and output will be a4b6e3
*/
import java.util.Scanner;

public class StringCompression{
    public String compressString(String str) {
        if(str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        char prev = charArr[0];
        int counter = 1;
        for(int i=1; i<charArr.length; i++) {
            char current = charArr[i];
            if(prev == current) {
                counter++;
            } else {
                sb.append(prev).append(counter);
                prev = current;
                counter = 1;
            }
        }

        /* 
        Add in the end as we wont be able to add last piece as arr will be null and we wont be able to go
        else part to append. Thus, after coming out ot the loop due to end of chaArray.. appned one last time.
        */
        sb.append(prev).append(counter);
        return sb.toString();
    }

    //main method
    public static void main(String args[]) {
        StringCompression obj = new StringCompression();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String compressedString = obj.compressString(str);
        System.out.println(compressedString);
        sc.close();
    }
}