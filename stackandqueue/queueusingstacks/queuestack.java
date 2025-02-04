package stackandqueue.queueusingstacks;
import java.util.*;

public class queuestack {
    public Stack<Integer>stack1;
    public Stack<Integer>stack2;

    public queuestack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //Enque
    public void enqueue(int data){
        stack1.push(data);
    }
    //Dequeue
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Stack is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
