package com.preparation.algorithm.recursion;

import java.util.HashMap;

public class WaterJugRecursion {
    int initX = 0;
    int initY = 0;
    boolean found = false;
    private HashMap<String, Boolean> history = new HashMap();

    public boolean canMeasureWater(int x, int y, int z) {
        initX = x;
        initY = y;
        canMeasure(0, 0, z);
        return found;
    }

    private void canMeasure(int x, int y, int z) {
        if (!history.containsKey("" + x + y)) {
            history.put("" + x + y, true);
            // check for volume greater than the buckets or less than 0
            if (x < 0 || y < 0 || x > initX || y > initY) {
                return;
            }

            if (x == z || y == z || x + y == z) {
                found = true;
                return;
            }

            //6 states , empty 1, empty 2,  fill 1, fill2, transfer a->b, transfer b>a
            //empty
            canMeasure(0, y, z);
            canMeasure(x, 0, z);

            //fill
            canMeasure(initX, y, z);
            canMeasure(x, initY, z);

            //transfer from one bucket to other
            int volx = initX - x;
            int voly = initY - y;
            if (volx > 0 && volx < y) {
                if (volx < y) {
                    canMeasure(x + volx, y - volx, z); //pour some since y has more
                } else {
                    canMeasure(x + y, 0, z); //pour all since y has less
                }
            }
            if (voly > 0) {
                if (voly < x) {
                    canMeasure(x - voly, y + voly, z); //pour some since x has more
                } else {
                    canMeasure(0, y + x, z); //pour all since x has less
                }
            }
            return;
        }
        return;
    }

}
