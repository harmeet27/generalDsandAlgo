package com.preparation.common.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class WaterJugGraphBFS {

    int initX = 0;
    int initY = 0;
    boolean found = false;
    private HashMap<String, Boolean> history = new HashMap();
    private Queue<QueueNode> queue = new LinkedList();

    public boolean canMeasureWater(int x, int y, int z) {
        initX = x;
        initY = y;
        queue.add(new QueueNode(0, 0));
        canMeasure(z);
        return found;
    }

    private void canMeasure(int z) {
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();

            if (!history.containsKey("" + node.x + node.y)) {
                history.put("" + node.x + node.y, true);
                int x = node.x;
                int y = node.y;

                if (x < 0 || y < 0 || x > initX || y > initY) {
                    continue;
                }

                if (x == z || y == z || x + y == z) {
                    found = true;
                    break;
                }

                queue.add(new QueueNode(0, y));
                queue.add(new QueueNode(x, 0));
                queue.add(new QueueNode(initX, y));
                queue.add(new QueueNode(x, initY));
                //transfer from one bucket to other
                int volx = initX - x;
                int voly = initY - y;
                if (volx > 0 && volx < y) {
                    if (volx < y) {
                        queue.add(new QueueNode(x + volx, y - volx)); //pour some since y has more
                    } else {
                        queue.add(new QueueNode(x + y, 0)); //pour all since y has less
                    }
                }
                if (voly > 0) {
                    if (voly < x) {
                        queue.add(new QueueNode(x - voly, y + voly)); //pour some since x has more
                    } else {
                        queue.add(new QueueNode(0, y + x)); //pour all since x has less
                    }
                }
            }
        }

    }

    class QueueNode {
        public Integer x;
        public Integer y;

        public QueueNode(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }


}
