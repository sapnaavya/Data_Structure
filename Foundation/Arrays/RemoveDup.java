/* This code removes duplicates from the array */
class Temp {
    int[] arr;
    int size;
    Temp(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }
}

public class RemoveDup {
    // this function removes duplicates from the array
    public static Temp removeDup(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        int n = arr.length;
        int counter = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    int temp = j;
                    for(int k = temp; k < n - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;
                    counter++;
                }
            }
        }
        return new Temp(arr, counter);
    }
    
    //main method
    public static void main(String args[]) {
        int[] arr = {1, 1, 2, 2, 3, 4, 3, 5, 5};
        Temp temp = removeDup(arr);
        for(int i = 0; i <= temp.size; i++) {
            System.out.print(temp.arr[i] + " ");
        }
    }
}