import java.util.*;
public class ReverseBits {
    public static long precomputeReverse(int n) {
        int result = Integer.reverse(n);
        return result;
    } 

    public static long reverseBits(long num) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return precomputeReverse((int)(num & BIT_MASK)) << (2 * MASK_SIZE)|
                precomputeReverse((int)(num >>> MASK_SIZE) & BIT_MASK) << (1 * MASK_SIZE) |
                precomputeReverse((int)(num >>> (2 * MASK_SIZE)) & BIT_MASK) |
                precomputeReverse((int)(num >>> (3 * MASK_SIZE)) & BIT_MASK) >> MASK_SIZE; 
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter long to reverse bits");
        long longNum = sc.nextLong();
        System.out.println("Reversed bits in long are:" + reverseBits(longNum));
    }
}