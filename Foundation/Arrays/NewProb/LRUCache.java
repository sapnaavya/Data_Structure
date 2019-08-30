/**
 * This code implements LRU Cache.
 * References: https://www.geeksforgeeks.org/lru-cache-implementation/
*/

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
    static Deque<Integer> dq;
    static HashSet<Integer> set;
    static int csize;
    LRUCache(int n) {
      dq = new LinkedList<>();
      set = new HashSet<>();
      csize = n;  
    }

    /* Refer keys x with in the LRU Cache */
    public void refer(int x) {
        if(!set.contains(x)) {
            if(dq.size() == csize) {
                int last = dq.removeLast();
                set.remove(last);
            } 
        }
        else {
            int index = 0;
            int i = 0;
            Iterator<Integer> itr = dq.iterator();
            while(itr.hasNext()) {
                if(itr.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        set.add(x);
    }

    /* Display the content of cache */
    public void display() {
        Iterator<Integer> itr = dq.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }
    
    // main method
    public static void main(String args[]) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}