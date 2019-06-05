import java.util.Scanner;

public class StringPermutations {

    //This helper function generates the permutation of a string
    public static void permutations(String str) {
        permutations( "", str);
    } 

    private static void permutations(String perm, String word) {
        if(word.isEmpty()) {
            System.out.println(perm + word);
        }

        for(int i = 0; i < word.length(); i++) {
            permutations(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
        }
    }
    
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        permutations(str);
        sc.close();
    }
}