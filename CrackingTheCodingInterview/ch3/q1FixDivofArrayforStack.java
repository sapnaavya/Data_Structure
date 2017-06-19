import java.lang.Math;
import java.util.Arrays;
public class FixedMultiStack{
  
    private static final int stackCapacity = 50;
    private static final int numberofStacks = 3;
    private static int[] stackPointers = new int[numberofStacks];
    //static { Arrays.fill(stackPointers, -1); }
    private int[] values = new int[numberofStacks * stackCapacity];
 
    
    public void printStack(int stackNum){
      if(stackNum < 0 || stackNum > numberofStacks){
        throw new IllegalArgumentException("Stack " + stackNum + " doen't exist!");
      }
      int top = getBufferedIndex(stackNum);
      int btm = stackNum * stackCapacity;
      for(int i=btm; i<=top; i++){
      System.out.print(values[i] + " ");
      }
      System.out.println(" " + "[TOP]");
    }
    
    public void printStacks(){
      for(int i=0; i<numberofStacks; i++){
      printStack(i);
      }
    }
    
    public void push(int stackNum, int item){
      if(isFull(stackNum)){
      throw new IllegalArgumentException("Stack " + stackNum + " is full");
      }  
         //increment stack pointer and then update top value
         stackPointers[stackNum]++;
         values[getBufferedIndex(stackNum)] = item;
    }
    
    public int pop(int stackNum){
      if(isEmpty(stackNum)){
      throw new IllegalArgumentException("Stack " + stackNum + " is empty");
      }
     // int item =  values[getBufferedIndex(int stackNum)];
      // int topIndex = getBufferedIndex(int stackNum);
        // int value = values[topIndex];
         //stackPointer[stackNum] --;
         //return value;
      
         int val = peek(stackNum);
          stackPointers[stackNum]--;
           return val;

    }
    
    public boolean isFull(int stackNum){
      if (stackNum < 0 || stackNum >= numberofStacks)
            throw new IllegalArgumentException("Stack " + stackNum + " doen't exist!");
      return stackPointers[stackNum] == stackCapacity;
    }
    
    public boolean isEmpty(int stacknum){
      return stackPointers[stacknum] == 0; 
    }
    
    public int peek(int stackNum){
    if (isEmpty(stackNum))
            throw new IllegalArgumentException("Stack " + stackNum + " is empty!");
      return values[getBufferedIndex(stackNum)];
    }
    
    public int getBufferedIndex(int stackNum){
      int offset = stackNum * stackCapacity;
      int size = stackPointers[stackNum];
      return offset + size -1;
    }
    
  public static void main(String args[]){
    FixedMultiStack stack1 = new FixedMultiStack();
    stack1.printStacks();
    stack1.push(0, -1); stack1.push(0,-2); stack1.push(0,-3);
    stack1.push(1,9);   stack1.push(1,8);   stack1.push(1,7);
    stack1.push(2,2);   stack1.push(2,9);   stack1.push(1,4);
    stack1.printStacks();
    System.out.println();
    System.out.println("Pop Stack 0: " + stack1.pop(0));
    System.out.println("Pop Stack 1: " + stack1.pop(1));
    System.out.println("Pop Stack 1: " + stack1.pop(1));
    System.out.println("Pop Stack 2: " + stack1.pop(2));
    System.out.println();
    stack1.printStacks();

  }
}

