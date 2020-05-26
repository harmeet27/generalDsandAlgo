package com.preparation.algorithm.maths;

import java.util.Stack;

/**
 * expected logn
 */
public class HCF {


    static int findHcfRecursively(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a == b) {
            return a;
        }

        if (a > b) {
            return findHcfRecursively(b, a - b);
        } else {
            return findHcfRecursively(a, b - a);
        }
    }


    static int findHcfIteratively(int a, int b) {
        Stack<String> stack = new Stack();
        stack.add(a + "-" + b);
        int hcf = 0;
        while (!stack.isEmpty()) {
            String[] element = stack.pop().split("-");
            int first = Integer.parseInt(element[0]);
            int second = Integer.parseInt(element[1]);

            if (first == 0) {
                hcf = second;
                break;
            }
            if (second == 0) {
                hcf = first;
                break;
            }

            if (first == second) {
                hcf = first;
                break;
            }

            if (first > second) {
                stack.add(second + "-" + (first - second));
            } else {
                stack.add(first + "-" + (second - first));
            }

        }

        return hcf;
    }


    public static void main(String... s) {
        System.out.println(findHcfRecursively(50, 100));
        System.out.println(findHcfIteratively(50, 100));
    }
}
