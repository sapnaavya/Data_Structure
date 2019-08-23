/* This code removes duplicates from the array */
public class RemoveDup {

    // function to remove duplicates in a sorted array using third array
    public static int removeDuplicateElements(int arr[], int n){  
        if (n == 0 || n == 1){  
            return n;  
        }  
        int[] temp = new int[n];  
        int j = 0;  
        for (int i = 0; i <n-1; i++){  
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
        }

        temp[j++] = arr[n-1];     
        // Changing original array  
        for (int i = 0; i < j; i++){  
            arr[i] = temp[i];  
        }  
        return j;  
    } 
    
    // remove duplicates in a sorted array using index
    public static int removeDuplicateElementsSorted(int arr[], int n){  
        if (n == 0 || n == 1){  
            return n;  
        }    
        int j = 0;//for next element  
        for (int i = 0; i < n-1; i++){  
            if (arr[i] != arr[i+1]){  
                arr[j++] = arr[i];  
            }  
        }  
        arr[j++] = arr[n-1];  
        return j;  
    }

    // this function removes duplicates from unsorted array - without preserving the order
    public static void removeDup(int[] arr) {
        if(arr.length == 0) {
            return;
        }
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    arr[j] = arr[n - 1];
                    n--;
                    j--;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // this function removes duplicates from the array with preserving the order
    public static int removeDupArr(int[] arr) { 
        if(arr.length == 0) { 
            return 0; 
        } 
        int n = arr.length; 
        // int counter = 0;  
        for(int i = 0; i < n; i++) { 
            for(int j = i + 1; j < n; j++) { 
                if(arr[i] == arr[j]) { 
                    int temp = j; 
                    for(int k = temp; k < n - 1; k++) { 
                        arr[k] = arr[k + 1]; 
                    } 
                    n--; 
                    j--;   //THIS IS VERY IMPORTANT .. do not forget this step
                    // counter++; 
                }
            } 
        } 

        return n; 
    } 
    
    //main method
    public static void main(String args[]) {
        int[] arr = {1,2,2,4,4,5};
        int [] arr1 = {2,4,4,4,6,6,6,6,8,8,8,10};
        int [] arr2 = {6,10,8,2,10,20,30,40,20};
         // removeDup(arr2);
        // remove duplicates in sorted array
        //int length = removeDuplicateElements(arr, arr.length);
        
        // for(int i = 0; i < length; i++) {
        //     System.out.println(arr[i]);
        // }

        int len1 = removeDuplicateElementsSorted(arr, arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // int n = removeDupArr(arr1);
        // for(int i = 0; i < n; i++) {
        //     System.out.println(arr1[i]);
        // }

    }
}