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
        
        // while(x != 0) {
        //     result ^= (x&1);
        //     x >>>= 1;
        // }

        while(x != 0) {
            if((x & 1) != 0 ) {
                result ^= 1;
            }
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

    public static long multiply(long num1, long num2) {
        long sum = 0;
        while(num1 != 0) {
            if((num1 & 1) != 0) {
                sum = add(sum, num2);
            }
            num1 >>>= 1;
            num2 <<= 1;
        }
        return sum;
    }

    public static int divide(int x, int y) {
        int result = 0;
        int power = 32;
        long yPower = (long)y << power;
        while(x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result = (result + 1) << power;
            x -= yPower;
        }
        return result;
    }

    private static long add(long a, long b) {
        while(b != 0) {
           long carry = (a&b);
           a = a^b;
           b = carry << 1; 
        }
        return a;
    }

    public static long reverse(int x) {
        long result = 0;
        while(x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    public static boolean isPallindrome(int x) {
        if(x <= 0) {
            return x == 0;
        }
        int numDigit = (int)(Math.floor(Math.log10(x))) + 1;
        int msdMask = (int)Math.pow(10, numDigit - 1);
        for(int i = 0; i < (numDigit / 2); ++i) {
            if(x / msdMask != x % 10) {
                return false;
            }
            x /= msdMask; //Remove least significant digit
            x %= 10;      //Remove most significant digit
            msdMask /= 100;
        }
        return true;
    }

    //Computer power 
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if(y < 0) {
            power = -power;
            x = 1.0 / x;
        }
        while(power != 0) {
            if((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

   public static void main(String args[]) {
       
        Scanner sc = new Scanner (System.in);
        //Calculate number of 1's bits in a non negative integer
        System.out.println("Enter the non negetive integer");
        int num = sc.nextInt();
        int count = countBits(num);
        System.out.println("No of 1 bits:" + count );
        
        //Compute parity bit using bruteforce and optimized
        System.out.println("Enter long to compute parity bits");
        long longNum = sc.nextLong();
        long parityCountBrute = computeParityBruteForce(longNum);
        long parityCountOptimized = computeParityBruteForce(longNum);
        System.out.println("Number of 1's using bruteforce methos :" + parityCountBrute);
        System.out.println("Number of 1's using optimized methos :" + parityCountOptimized);

        //Swap bits in long
        System.out.println("Enter the long to swap bits");
        long swapBitNum = sc.nextLong();
        long afterSwapNum = swapBits(swapBitNum, 1 , 2);
        System.out.println(afterSwapNum);
       
        //Multiplication of two number
        System.out.println("Enter two number to multiple");
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();
        long num3 = multiply(num1, num2);
        System.out.println("Multiplication is:" + num3);   
        
        //Divide two integer numbers
        System.out.println("Enter two number to divide");
        int divNum1 = sc.nextInt();
        int divNum2 = sc.nextInt();
        int resultDiv = divide(divNum1, divNum2);
        System.out.println("Quotient is:" + resultDiv);

        //Reverse an integer
        System.out.println("Enter the integer number to reverse");
        int reverseInt = sc.nextInt();
        System.out.println("the reversed digit is " + reverse(reverseInt));

        //Check if a number is pallindrome or not
        System.out.println("Enter the integer number to check if it is a pallindrome or not");
        int palInt = sc.nextInt();
        System.out.println(isPallindrome(palInt));

        //Compute power of x and y
        System.out.println("Enter double value and integer to calculate power");
        double x = sc.nextDouble();
        int y = sc.nextInt();
        double result = power(x,y);
        System.out.println("Power is: " + result); 
    }
}