public class MergeTwoSortedUsingThirdArray {
    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return null;
        }
        int mergedArrayLength = arr1.length + arr2.length;
        System.out.println("length" + mergedArrayLength);
        int[] mergedArray = new int[mergedArrayLength];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            }
            else{
                mergedArray[k++] = arr2[j++];
            }
        }

        while(i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            mergedArray[k++] =  arr2[j++];
        }
        return mergedArray;
    }
    public static void main(String args[]) {
        int [] array1 = {1,2,3,4,5,9};
        int [] array2 = {2,5,6,7,8,10,11};
        int merdedArrayLength  =  array1.length + array2.length;
        int[] mergedArray = new int[merdedArrayLength];
        mergedArray =  mergeTwoSortedArray(array1, array2);
        for(int i=0; i < mergedArray.length; i++) {
            System.out.println(mergedArray[i] + " ");
        }
    }
}