import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();

        int numOfWords = in.nextInt();
        for(int i = 0; i < numOfWords; i++){
            String word = in.next();
            int freq = freqMap.get(word) == null ? 0 : freqMap.get(word);
            freqMap.put(word, freq + 1);
        }

        int queries = in.nextInt();
        for(int i = 0; i < queries; i++){
            String word = in.next();
            int freq = freqMap.get(word) == null ? 0 : freqMap.get(word);
            System.out.println(freq);
        }
    }
}
