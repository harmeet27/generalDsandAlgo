package com.preparation.ds.stack;
//https://leetcode.com/problems/online-stock-span/submissions/

import java.util.Stack;

public class StockSpan {

    class PriceNode {
        int price;
        int total;

        PriceNode(int price, int total) {
            this.price = price;
            this.total = total;
        }
    }

    Stack<PriceNode> s = null;

    public StockSpan() {
        s = new Stack();
    }

    public int next(int price) {
        if (s.isEmpty() || price < s.peek().price) {
            s.push(new PriceNode(price, 1));
            return 1;
        }

        int total = 1;
        while (!s.isEmpty() && price >= s.peek().price) {
            total += s.pop().total;
        }

        s.push(new PriceNode(price, total));

        return total;
    }
}
