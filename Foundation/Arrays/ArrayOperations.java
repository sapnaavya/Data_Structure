/**
 * This code performs below operations for array:
    1. Print an array
    2. reverse an array
    3. print sum of all elements in array
    4. find smallest number in an array and  its index
    5. find largest number in an array and its index
    6. Arrange 0's and 1's in an array
    7. Arrange 0's, 1's and 2's in array using in place
    8. Arrange 0's, 1's and 2's using counting
    9. Find the missing element in the consecutive array. For example, array is {1,2,3,4,6}. So, missing element is 5. and if arr is {2,4,5}
 */

class Num {
    int num;
    int index;
    Num (int num, int index) {
        this.num = num;
        this.index = index;
    }
}
public class ArrayOperations {

    //Print all elements in an array
    static void printallElements(int[] arr) {
        if(arr.length == 0) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //Reverse the content of the array
    public static void reverseArray(int[] arr) {
        if(arr.length == 0) {
            return;
        }
        for(int i = 0; i < arr.length/2; i++) {
          swapElements(i, arr.length - i - 1, arr);  
        }
    }

    //Swap elements in the array
    private static void swapElements(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y] = temp;
    }

    //Print sum of all integers in an array
    public static int sumOfArray(int[]arr) {
        if(arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i=0; i <arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //find min in an array assuming array is not sorted
    public static Num minArray(int[] arr) {
        if(arr.length == 0) {
            return new Num(0, 0);
        }
        int minElem = arr[0];

        // s variable keeps track of current index and start keeps track of the index of minimum number so far in the loop
        //Storing index of minimum num in start and whenever we find minimum num than minElem we update index with s which keeps track of current index
        int start = 0;
        int s = start;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < minElem) {
                minElem = arr[i];
                start = s;
            }
            s = i + 1;
        }
        return new Num(minElem, start);
    }

    //find max element in an array assuming array is not sorted
    public static Num maxArray(int[] arr) {
        if(arr.length == 0) {
            return new Num(0, 0);
        }
        int maxElem = arr[0];

        // s variable keeps track of current index and start keeps track of the index of largest number so far in the loop
        //Storing index of largest num in start and whenever we find largest num than maxElem we update index with s which keeps track of current index
        int start = 0;
        int s = start;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] > maxElem) {
                maxElem = arr[i];
                start = s;
            } 
            s = i + 1;
        }
        return new Num (maxElem, s);
    }

    /* Arrange 0's and 1's in an array containing only 0's and 1's 
    Logic: Maintain two indexes left and right to keep track of 0's and 1's.. Assuming left keeps track of 0 and right keeps tack of 1.
    */
    public static int[] arrangeBinaryElem(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            while(arr[left] == 0 && left < right) {
                left++;
            }

            while(arr[right] == 1 && left < right) {
                right--;
            }

            if(left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        return arr;
    }

    //Segregate 0's, 1's and 2's in the array, using three indices... low, high, and mid .. mid keeps track of 1 and low for 0 and high for 2
    //Do it with inplace
    static int[] segregateNum(int [] arr) {
        if(arr.length == 0) {
            return null;
        }
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid < high) {
            if(arr[mid] == 0) {
                swapElements(low, mid, arr);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else if(arr[mid] == 2) {
                swapElements(mid, high, arr);
                high--;
            }
        }
        return arr;
    }

    //Segregate 0's, 1's and 2's in an array using simple counting
    public static int[] segNumUsingCounting(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        /*
          Traverse an array and count
          number of zero and one present
          in an array.
        */
        for (int i = 0; i < arr.length; i++) {
             /*If value is zero,increment the value of zeroCount variable.*/
             if (arr[i] == 0)
                 zeroCount++;

            /*If value is one, increment the value of oneCount variable. */
             if (arr[i] == 1)
                  oneCount++;
        }

        //Put the zero's first in an array
        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }

        //After zero, put 1's in an array
        for (int i = zeroCount; i < (zeroCount + oneCount); i++) {
        arr[i] = 1;
        }

        //Rest put 2's in an array
        for (int i = (zeroCount + oneCount); i < arr.length; i++) {
            arr[i] = 2;
        }
        return arr;
    }

    //Find the missing element in a consecutive array
    public static int getMissingNum(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return 0;
        }
    
        int x1 = arr[0]; // for XOR of all the elements in the array
        int x2 = arr[0]; //for XOR of all the elements from 1 to n+1
        for(int i = 1; i <arr.length; i++) {
            x1 = x1 ^ arr[i];
        }

        for(int j = arr[0] + 1; j <= arr[arr.length -1]; j++) {
            x2 = x2 ^ j;
        }
        return (x1 ^ x2);
    }

    //main method
    public static void main(String args[]) {
        //PrintArray obj = new PrintArray();
        int[] arr = new int[]{2,3,4,5,6,7,8,9};
        //printallElements(arr);

        //Reverse an array and print it
        // int[] arr1 = new int[]{3,3,4,5,9,7,8,9};
        // reverseArray(arr1);
        // printallElements(arr1);

        // //print sum of all elements in an array
        // int sum = sumOfArray(arr);
        // System.out.println("Sum of all elements in array: " + sum);

        // //Print minimum element in an array and its index
        // Num minNum = minArray(arr);
        // System.out.println("Minimum number and its index:" + minNum.num + " " + minNum.index);

        // //print largest number and its index in an array
        // Num num = maxArray(arr);
        // System.out.println("Largest number and its index: " + num.num +" " + num.index);

        // //Arrange 0's and 1's in an array
        // int[] binaryArray = new int[]{0,1,1,1,1,0,0,0,1,0};
        // binaryArray = arrangeBinaryElem(binaryArray);
        // printallElements(binaryArray);

        //Segregate 0's, 1's and 2's in the array in place
        int[] array1 = new int[]{0,2,1,2,2,1,1,1};
        array1 = segregateNum(array1);
        printallElements(array1);

        //Segregate 0's, 1's and 2's in the array simple counting
        //int[] array2 = new int[]{0,1,1,1,1,1,2,2,1,1};
        //array2 = segNumUsingCounting(array2);
        //printallElements(array2);

        //find the missing element in the consecutive array
        // int [] consecutiveArr = new int[]{3,4,5,6,7,8,10 };
        // int missingElem = getMissingNum(consecutiveArr);
        // System.out.println("Missing element: " + missingElem);
    }
}