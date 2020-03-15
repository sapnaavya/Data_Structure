namespace Foundation.Arrays {
    public class MergeTwoSortedArr {
        public int[] Sorted_Merge_UsingThirdArray(int[] arr1, int [] arr2) {
            int n1 = arr1.Length;
            int n2 = arr2.Length;
            int [] arr3 = new int[n1 + n2];
            int i = 0;
            int j = 0;
            int k = 0;
            while(i < n1 && j < n2) {
                if(arr1[i] < arr2[j]) {
                    arr3[k++] = arr1[i++];
                } else {
                    arr3[k++] = arr2[j++];
                }
            }
            while(i < n1) {
                arr3[k++] = arr1[i++];
            }
            
            while(j < n2) {
                arr3[k++] = arr2[j++];
            }
            foreach(int item in arr3) {
                System.Console.Write(item + " ");
            }
            return arr3;
        }

        // merge two sorted array without using third array
        public void Merge_Two_SortedArray_WithoutThirdArray(int[] arr1, int[] arr2) {
            if(arr1.Length == 0 || arr2.Length == 0) {
                return;
            }

            for(int i = 0; i < arr1.Length; i++) {
                if(arr1[i] > arr2[0]) {
                    //swap
                    int temp = arr1[i];
                    arr1[i] = arr2[0];
                    arr2[0] = temp;
                    ArrangeArr2(arr2);
                }
            }

            foreach(int i in arr1) {
                System.Console.Write(i + " ");
            }

            foreach(int j in arr2) {
                System.Console.Write(j + " ");
            }
        }

        private void ArrangeArr2(int[] arr2) {
            int temp = arr2[0];
            int i;
            for(i = 1; i < arr2.Length && arr2[i] < temp; i++) {
                arr2[i-1] = arr2[i];
            }
            arr2[i-1] = temp;
        }
    }
}