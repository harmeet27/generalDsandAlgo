package com.preparation.algorithm.traversing.iteratively;

/**
 * The only difference between iterative DFS and recursive DFS is that the recursive stack is replaced by a stack of nodes.
 * <p>
 * <p>
 * <p>
 * Algorithm:
 * 1. Created a stack of nodes and visited array.
 * 2. Insert the root in the stack.
 * 3. Run a loop till the stack is not empty.
 * 4. Pop the element from the stack and print the element.
 * 5. For every adjacent and unvsisted node of current node, mark the node and insert it in the stack.
 * <p>
 * <p>
 * Implementation of Iterative DFS: This is similar to BFS, the only difference is queue is replaced by stack.
 */
public class DFS {
}
