import java.util.Scanner;
public class BitwiseOperator {
   public static short countBits(int num) {
       short count = 0;
       if(num == 0) {
           return 0;
        }

       while(num != 0){
            count += num & 1;
            num >>>= 1;
        }
        return count;
    }

    public static short computeParityBruteForce(long x){
        short result = 0;
        if(x == 0) {
            return 0;
        }
        while(x != 0) {
            result ^= (x&1);
            x >>>= 1;
        }
        return result;
    }

    public static short computeParityOptimized(long x) {
        short result = 0;
        while(x != 0) {
            result ^= 1;
            x &= (x-1);
        }
        return result;
    }

    public static long swapBits(long num, int i, int j) {
        if (((num >>> i) & 1) != ((num >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j );
            num ^= bitMask;
        }
        return num;
    }

   public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the non negetive integer");
        int num = sc.nextInt();
        int count = countBits(num);
        System.out.println("No of 1 bits:" + count );
        System.out.println("Enter long to compute parity bits");
        long longNum = sc.nextLong();
        long parityCountBrute = computeParityBruteForce(longNum);
        long parityCountOptimized = computeParityBruteForce(longNum);
        System.out.println("Number of 1's using bruteforce methos :" + parityCountBrute);
        System.out.println("Number of 1's using optimized methos :" + parityCountOptimized);
        System.out.println("Enter the long to swap bits");
        long swapBitNum = sc.nextLong();
        long afterSwapNum = swapBits(swapBitNum, 1 , 2);
        System.out.println(afterSwapNum);
    }
}