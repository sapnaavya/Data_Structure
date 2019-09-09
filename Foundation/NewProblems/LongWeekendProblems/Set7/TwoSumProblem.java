import java.util.HashMap;

class Range {
    int index1;
    int index2;
    Range(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }
}

public class TwoSumProblem {

    // function returns when target is equal to two values in the array
    public static Range twoSum(int[] arr, int target) {
        if(arr.length < 2 || arr == null) {
            return new Range(0,0);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                return new Range(map.get(arr[i]), i);
            } else {
                map.put(target - arr[i], i);
            }
        }
        return new Range(0,0);
    }

    // main method
    public static void main(String args[]) {
        int[] arr = {2, 7, 4, 5, 3};
        int target = 8;
        Range index = twoSum(arr, target);
        System.out.print(index.index1 + " " + index.index2);        
    }
}