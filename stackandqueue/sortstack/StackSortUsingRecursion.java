package stackandqueue.sortstack;
import java.util.Stack;
public class StackSortUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);


        System.out.println("Original Stack: " + stack);
        SortstackRecursively.sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}


