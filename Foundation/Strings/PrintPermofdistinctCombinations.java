/**
 * This code generates combinations of a string and also generates permutations of all distinct combinations of a string
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import java.util.TreeMap;
import java.util.Map.Entry;

public class PrintPermofdistinctCombinations {
    static String inputString;
    HashSet<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    TreeMap<String, Vector<String>> map = new TreeMap<String, Vector<String>>();
    static int k = 0;
    public PrintPermofdistinctCombinations(String str) {
        inputString = str;
    }
    

    //Utility function for printing all permutation of distinct combinaions
    public void permDistinctCombinationsUtil() {
        int start = 0;
        permDistinctCombinations(start);

        //Traversing elements  
       Iterator<String> itr = set.iterator();  
       while(itr.hasNext()) {
            Vector<String> vec = new Vector<>(); 
            String permStr = itr.next();
            permutation(permStr, vec);
            map.put(permStr, vec);
        }

        for(Entry<String, Vector<String>> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Utility function for printing all permutation of a string
    public void permutation(String word, Vector<String> vec) {
        //System.out.println("in permutations");
        String perm = "";
        
        permutationRecursive(perm, word, vec);
    }

    //function for printing all permutations of a string
    public void permutationRecursive(String perm, String word, Vector<String> vec) {
        if(word.isEmpty()) {
           //System.out.println(perm + word);
            vec.add(perm);
        }

        for(int i = 0; i < word.length(); i++) {
            permutationRecursive(perm + word.charAt(i), word.substring(0, i) 
                + word.substring(i+1, word.length()), vec);
        }
    }

    public void permDistinctCombinations(int start) {
        for(int i = start;  i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            set.add(sb.toString());
            if(i < inputString.length()) {
                permDistinctCombinations(i + 1);
            }
            sb.setLength(sb.length() - 1);
        }
    }



    //main method
    public static void main(String args[]) {
        PrintPermofdistinctCombinations obj = new PrintPermofdistinctCombinations("abc");
        obj.permDistinctCombinationsUtil();
    }
}