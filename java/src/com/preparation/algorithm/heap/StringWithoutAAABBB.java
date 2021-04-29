package com.preparation.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 1. using heap but high memory, can be avoided since only 2values are there
 * 2. using if else
 */
public class StringWithoutAAABBB {
    public String strWithout3a3b2(int a, int b) {

        StringBuilder sol = new StringBuilder();
        String last = "";
        while (a != 0 && b != 0) {
            if (sol.length() >= 2) {
                last = sol.substring(sol.length() - 2, sol.length());
            }

            if (last.equals("aa")) {
                sol.append("b");
                b--;
            } else if (last.equals("bb")) {
                sol.append("a");
                a--;
            } else if (a > b) {
                sol.append("a");
                a--;
            } else if (b > a) {
                sol.append("b");
                b--;
            } else {
                sol.append('a');
                a--;
            }
        }

        int remaining = a == 0 ? b : a;

        for (int i = 0; i < remaining; i++) {
            if (a > 0) {
                sol.append("a");
            } else {
                sol.append("b");
            }
        }
        return sol.toString();
    }


    public String strWithout3a3b(int a, int b) {

        PriorityQueue<Node> queue = new PriorityQueue((first, second) -> {
            Node f = (Node) first;
            Node s = (Node) second;

            if (f.value > s.value) {
                return -1;
            } else if (f.value == s.value) {
                return 0;
            }
            return 1;
        });
        queue.add(new Node(a, 'a'));
        queue.add(new Node(b, 'b'));
        String solution = "";
        char lastChar = ' ';
        int total = 0;
        while (!queue.isEmpty()) {
            Node topElement = queue.peek();

            if (lastChar == ' ') {
                lastChar = topElement.character;
                solution += topElement.character;
                topElement.value = topElement.value - 1;
                total += 1;
                if (topElement.value == 0) {
                    queue.poll();
                }
            } else {
                if (lastChar == topElement.character) {
                    if (total >= 2) {
                        //already aa or bb occured
                        Node removed = queue.poll();
                        lastChar = queue.peek().character;
                        solution += queue.peek().character;
                        total = 1;
                        queue.peek().value = queue.peek().value - 1;
                        if (queue.peek().value == 0) {
                            queue.poll();
                        }
                        queue.add(removed);

                    } else {
                        //not aa or bb occured yet
                        solution += lastChar;
                        topElement.value = topElement.value - 1;
                        total += 1;
                        if (topElement.value == 0) {
                            queue.poll();
                        }
                    }
                } else {
                    //not last and curr character same.

                    lastChar = topElement.character;
                    solution += topElement.character;
                    topElement.value = topElement.value - 1;
                    total = 1;
                    if (topElement.value == 0) {
                        queue.poll();
                    }
                }

            }


        }

        return solution;

    }

    class Node {
        int value;
        char character;

        Node(int value, char character) {
            this.value = value;
            this.character = character;
        }
    }
}
