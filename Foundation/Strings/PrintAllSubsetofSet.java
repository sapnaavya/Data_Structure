/**
 * This code print all the subset of a set given in arry form.
 * Also, for a given set, we can get atmost 2^n subset from a set
 * So, if a subset has 3 length then we will have 2^3 i.e. 8 subset
 * Reference Link: https://www.quora.com/How-do-I-generate-all-subsets-of-a-set-in-Java-iteratively
 */
public class PrintAllSubsetofSet {
    static void printAllSubset(int set[]) {
        int n = set.length;
        //run a loop from 0 to 2^n
        for(int i = 0; i < (1 << n); i++) {
            // m is used to check set bit in binary representation.
            System.out.print("{ ");
            int m = 1; 
			// Print current subset
            for(int j = 0; j < n; j++) {
                if((i & m) > 0) {
                    System.out.print(set[j] + " ");
                }
                m = m << 1;
            }
            System.out.println("}");
        }
    }
    //main method
    public static void main(String args[]) {
        int subset [] = {1, 2, 3};
        printAllSubset(subset);
    }
}