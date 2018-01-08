package stack;

import entity.ListNode;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private int[] stack;
    private int size;

    private Stack<Integer> minStack;

    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new int[16];
    }

    public void push(int x) {
        ensureSpace();
        stack[size] = x;
        size++;
        if (x < min){
            min = x;
        }
    }

    public void pop() {
        if (size > 0) {
            stack[size - 1] = 0;
            size--;
        }
    }

    public int top() {
        if (size > 0) {
            return stack[size - 1];
        } else {
            return 0;
        }
    }

    public int getMin() {

        return 0;
    }

    private void ensureSpace() {
        if (size > stack.length / 2) {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
    }

    public static void main(String[] args) {

        int[] stack = new int[16];
        System.out.println(stack.length);

//        MinStack obj = new MinStack();
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();
//        minStack.pop();
//        minStack.top();
//        minStack.getMin();
    }
}
