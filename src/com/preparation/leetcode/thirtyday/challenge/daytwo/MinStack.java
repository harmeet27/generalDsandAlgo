package com.preparation.leetcode.thirtyday.challenge.daytwo;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class MinStack {
    Stack<Node> stack = new Stack();

    public MinStack() {

    }

    public void push(int x) {
        Node node = new Node();
        node.element = x;
        if (stack.isEmpty()) {
            node.lastMin = x;
        } else {
            Node peek = stack.peek();
            if (peek.lastMin > x) {
                node.lastMin = x;
            } else {
                node.lastMin = peek.lastMin;
            }
        }
        stack.add(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().element;
    }

    public int getMin() {
        return stack.peek().lastMin;
    }

    private class Node {
        int element;
        int lastMin;
    }
}
