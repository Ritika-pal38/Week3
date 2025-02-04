package stackandqueue.sortstack;
import java.util.*;

public class SortstackRecursively {
    public static void sortedInsert(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
        }
        else{
            int temp = stack.pop();
            sortedInsert(stack, element);
            stack.push(temp);
        }
    }


    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

}
