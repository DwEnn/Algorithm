package basic;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }

        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }

        while(!stack1.isEmpty())
            System.out.print("" + stack1.pop());
        System.out.println();

        while (!queue.isEmpty()) {
            System.out.print("" + queue.poll());
        }



    }

}
