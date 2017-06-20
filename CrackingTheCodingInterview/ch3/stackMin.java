import java.lang.Math; // headers MUST be above the first class
import java.util.LinkedList;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
  Stack<Integer> s2;
    public StackWithMin2(){
   s2 = new Stack <Integer>(); 
   }
  
  public void push(int value){
    if(value <= min()){
    s2.push(value);
    }
    
    super.push(values);
  
  }
  
  public Integer pop() {
  int value = super.pop();
    if(value == min()) {
    s2.pop();
    }
    
    return value;
  }
  
  public int min(){
    if(s2.isEmpty()){
      return Integer.MAX_VALUE;
    }
    else{
    s2.peek();
    }
  }
  
  public static void main(String args[]){
    
  }
}

