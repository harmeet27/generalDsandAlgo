package com.preparation.algorithm.dp.grokkingDPPattern.longestcommonsubstring;

public class LongestINcreasingSubsequence {

    public static int lisBacktracking(int[] m1, int[] m2){
        return lisBacktracking(m1,m2,m1.length-1,m2.length-1,Integer.MAX_VALUE);
    }

    private static int lisBacktracking(int[] m1, int[] m2, int i, int j, int prev){
        if(i<0 || j<0 || m1==null || m2==null){
            return 0;
        }

        int include = 0;
        if(m1[i]==m2[j] && m1[i]<prev){
            include = 1+ lisBacktracking(m1,m2,i-1,j-1,m1[i]);
        }

        int exclude = Math.max(lisBacktracking(m1,m2,i,j-1,prev),lisBacktracking(m1,m2,i-1,j,prev));

        return Math.max(include,exclude);


    }

    public static void main(String... s){
//        lisBacktracking(new int[]{})
    }

}
