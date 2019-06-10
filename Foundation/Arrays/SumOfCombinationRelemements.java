/**
 * This code prints all combination of r elements in an array whose sum is equal to x

 * for example, in an array {1, 4, 3, 0} if r is 2 and value is 4 that mean print all possible combination of 2 elements
 * that sum to a value 4. so, the output would be 04 and 13 because r is 2 .. we cant take 130. 
 * If r would be 3 and value is 4 then output would 130 because it contains 3 elements that sum to 4 
 */
import java.util.ArrayList;

public class SumOfCombinationRelemements {
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> myIntegers = new ArrayList<Integer>(); 

    //utility function to print combinational sum of r elements. Here, value is the sum of total sum 
    public void printCombinationUtil(int[] arr, int value, int r) {
        int start = 0;
        printCombinationArr(start, arr, r);

        for(int i = 0; i < myIntegers.size(); i++) {
            int sum = sumofInteger(myIntegers.get(i));
            if(sum == value) {
                System.out.println(myIntegers.get(i));
            }
        }
    }

    //Combines all number in an interger
    private static int sumofInteger(int num) {
        int sum = 0;
        while(num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    //print all combinations of r elements in an array and store them in an arraylist
    public void printCombinationArr(int start, int[] arr, int r) {
        for(int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            //if sb length is equal to r then only save value to arraylist
            if(sb.length() == r){
                //save values of sb in arraylist so that we check if those values sum to a value x
                myIntegers.add(Integer.parseInt(sb.toString()));
            }
            if(i < arr.length) {
                printCombinationArr(i + 1, arr, r);
            }

            sb.setLength(sb.length() - 1);
        }
    }
    
    //main method 
    public static void main(String args[]) {

        SumOfCombinationRelemements obj = new SumOfCombinationRelemements();
        int [] arr = {1, 0, 2, 1};

        //here, value is the combinational sum
        int value = 2;
        // r is the total elements in the combination. if r is 2 that mean show all combination with only 2 elements
        int r = 2;

        obj.printCombinationUtil(arr, value, r);
    }
}