/** 
 * This code implements manacher's algo to find longest pallindromic substring
*/

public class ManachersAlgo {
    static int manachersAlgorithm(String s, int N) {
        String str = getModifiedString(s, N);
        int len = (2 * N) + 1;
        int[] P = new int[len];
        int c = 0; //stores the center of the longest palindromic substring until now
        int r = 0; //stores the right boundary of the longest palindromic substring until now
        int maxLen = 0;
        for(int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;
            //see if the mirror of i is expanding beyond the left boundary of current longest palindrome at center c
            //if it is, then take r - i as P[i]
            //else take P[mirror] as P[i]
            if(i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }
    
            //expand at i
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while(a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }
            //check if the expanded palindrome at i is expanding beyond the right boundary of current longest palindrome at center c
            //if it is, the new center is i
            if(i + P[i] > r) {
                c = i;
                r = i + P[i];
                if(P[i] > maxLen) { //update maxlen
                    maxLen = P[i];
                }
            }
        }
        return maxLen;
    }
    
    static String getModifiedString(String s, int N){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    //main method
    public static void main(String args[]) {
        String str = "apaplpapaa";
        int maxPalSubstrLen = manachersAlgorithm(str, str.length());
        System.out.println(maxPalSubstrLen);

    }
}