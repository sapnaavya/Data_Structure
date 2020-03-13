namespace Foundation {
    public class RemoveDuplicates {

        // remove duplicates from sorted array using third array
        public void RemoveDupSortedUsingThirdArr(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return;
            }
            int[] temp = new int[arr.Length];
            int j = 0;
            int n = arr.Length;
            for(int i=0; i < n-1; i++) {
                if(arr[i] != arr[i+1]) {
                    temp[j++] = arr[i];
                }
            }

            temp[j++] = arr[n-1];
            for(int i = 0; i < j; i++) {
                arr[i] = temp[i];
            }
            
            for(int i = 0; i < j; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }

        //remove duplicates from the sorted array without using third array
        public void removeDupSortedArrayWithoutThirdArr(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return;
            }

            int j = 0;
            int n = arr.Length;
            for(int i = 0; i < n-1; i++) {
                if(arr[i] != arr[i+1]) {
                    arr[j++] = arr[i];
                }
            }

            arr[j++] = arr[n-1];
            for(int i = 0; i < j; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }

        //remove duplicates from the unsorted array with preserving the order
        public void removeDupUnsortedArray(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return;
            }
            int n = arr.Length;
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    if(arr[i] == arr[j]) {
                        int temp = j; //very important
                        for(int k = temp; k < n-1; k++) {
                            arr[k] = arr[k+1];
                        }
                        n--;
                        j--; // very important-- Do not forget this
                    }
                }
            }

            for(int i=0; i < n; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }

        //remove duplicate from unsorted array without preserving the order
        public void removeDupUnsortedWithoutPreservingOrder(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return;
            }
            int n = arr.Length;
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    if(arr[i] == arr[j]) {
                        arr[j] = arr[n-1];
                        j--;
                        n--;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }
    }
}