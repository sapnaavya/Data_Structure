using System.Collections.Generic;

namespace Foundation.Arrays {
    public class FindNextGreaterElem {

        // find next greater element for each array element using bruteforce approach
        public void FindNextGreaterElemBruteForce(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            for(int i = 0; i < arr.Length; i++) {
                int next = -1;
                for(int j = i+1; j < arr.Length; j++) {
                    if(arr[i] < arr[j]) {
                        next = arr[j];
                        break;
                    }
                }
                System.Console.WriteLine(arr[i] + " --> " +next) ;
            }
        }

        // find next greater element using Stack
        public void FindNextgreaterElemUsingStack(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            
            Stack<int> stack = new Stack<int>();
            stack.Push(arr[0]);
            for(int i = 1; i < arr.Length; i++) {
                int next = arr[i];
                if(stack.Count != 0) {
                    int element = stack.Pop();
                    while(element < next) {
                        System.Console.WriteLine(element +" --> "+ next);
                        if(stack.Count == 0) {
                            break;
                        }
                        element = stack.Pop();
                    }
                    if(element > next) {
                        stack.Push(element);
                    }
                }
                stack.Push(next);
            } 
             
            while(stack.Count != 0) {
                System.Console.WriteLine(stack.Pop() + "-->" + "-1");
            } 
        }
    }
}