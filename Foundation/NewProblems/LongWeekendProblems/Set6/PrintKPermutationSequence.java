import java.util.ArrayList;

public class PrintKPermutationSequence {

    public static String getKPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }

        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            num.add(i);
        }

        // calculate the factorial
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }

        k--;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = k / factorial;
            sb.append(num.get(index));
            num.remove(index);

            //remove current k
            k %= factorial;
        }

        return sb.toString();
    }
    
    // main method
    public static void main(String args[]) {
        int n = 3;
        int k = 4;
        String str = getKPermutation(n,k);
        System.out.println(str);
    }
}