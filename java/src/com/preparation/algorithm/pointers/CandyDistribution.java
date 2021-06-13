package com.preparation.algorithm.pointers;

public class CandyDistribution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int candies = 0;
        int lSmaller[] = new int[ratings.length];
        int rSmaller[] = new int[ratings.length];

        lSmaller[0] = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) lSmaller[i] = lSmaller[i - 1] + 1;
            else lSmaller[i] = 0;
        }

        rSmaller[ratings.length - 1] = 0;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) rSmaller[i] = rSmaller[i + 1] + 1;
            else rSmaller[i] = 0;
        }

        for (int i = 0; i < ratings.length; i++) {
            candies += Math.max(lSmaller[i], rSmaller[i]) + 1;
        }

        return candies;
    }
}
