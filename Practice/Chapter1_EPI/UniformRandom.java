import java.util.Scanner;
class ZeroOneRandom {
    int number;
    public int zeroOneRandomNumber() {
       number = (int)Math.round(Math.random());
       return number;
    }
}
public class UniformRandom {
    
    //Uniform random number generator
    public static int uniformRandom(int lowerbound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerbound + 1, result;
        ZeroOneRandom zr = new ZeroOneRandom();
        do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; i++) {
                result = result << 1 | zr.zeroOneRandomNumber();
            }
        } while(result >= numberOfOutcomes);
        return result + lowerbound;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        //generate random number between lowerbound and upperbound
        System.out.println("Enter lowerbound and upperbound to calculate randomnumber");
        int lowerBound = sc.nextInt();
        int upperBound = sc.nextInt();
        int randomNumber = uniformRandom(lowerBound, upperBound);
        System.out.println("Random number is: " + randomNumber);
    }
}