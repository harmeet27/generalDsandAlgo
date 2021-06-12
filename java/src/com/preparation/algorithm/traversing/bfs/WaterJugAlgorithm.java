package com.preparation.algorithm;

public class WaterJugAlgorithm {

    private int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }


    public boolean canMeasureWater(int x, int y, int z) {
        int gcd = gcd(x, y);

        if (gcd <= 1) {
            System.out.println();
            return false;
        }

        if (z % gcd == 0) {
            return true;
        }
        return false;
    }
}
