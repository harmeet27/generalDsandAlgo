package com.preparation.companywise.arcserve;

import java.util.*;

class MatrixTraverse {

    static HashMap<String, Integer> records = new HashMap();
    static int min = Integer.MAX_VALUE;

    public static String MatrixPath(String[] strArr) {
        // code goes here
        traverse(0, 0, strArr, 0);
        int min = records.get((strArr.length-1)+":"+(strArr[0].length()-1));
        if (min > 0) {
            return String.valueOf(min);
        } else if (min == 0) {
            return "true";
        } else {
            return "not possible";
        }
    }

    public static int traverse(int i, int j, String[] strArr, int sum) {

        if (i < 0 || i >= strArr.length) {
            return 0;
        }

        if (j < 0 || j >= strArr[0].length()) {
            return 0;
        }

//        if (i == strArr[0].length()-1 && j == strArr.length-1) {
//            if (sum < min) {
//                min = sum;
//            }
//        }

        if (records.containsKey("" + i + ":" + j)) {
            if(records.get("" + i + ":" + j)>sum){
                records.put(("" + i + ":" + j),sum);
            }
            return sum;
        }

        List<String> possible = generateneighbours(i, j, strArr);
        char c = strArr[i].charAt(j);
        int value = Character.getNumericValue(c);
        if (value != 1) {
            sum = sum + 1;
        }

        for (String pos : possible) {
            String[] val = pos.split(":");
            records.put(("" + i + ":" + j), sum);
            int first = Integer.parseInt(val[0]);
            int second = Integer.parseInt(val[1]);
            records.put(("" + i + ":" + j),traverse(first, second, strArr, sum));
        }

        return 0;
    }


    public static List<String> generateneighbours(int i, int j, String[] strArr) {
        List<String> possible = new LinkedList();
        possible.add("" + (i - 1) + ":" + j);
        possible.add("" + (i + 1) + ":" + j);
        possible.add("" + i + ":" + (j - 1));
        possible.add("" + i + ":" + (j + 1));

        return possible;
    }


    public static void main(String[] args) {
        // keep this function call here

//        Scanner s = new Scanner(System.in);

//        String[] data = new String[]{"11", "11"}; //true
//        String[] data = new String[] {"100", "000", "001"}; //not possible
//        String[] data = new String[] {"11100", "10011", "10101", "10011"}; //2
//        String[] data = new String[] {"10000", "11011", "10101", "11001"}; //1
        String[] data = new String[] {"1000001", "1001111", "1010101"}; //1
        System.out.print(MatrixPath(data));
//        s.close();


        // MatrixPath();
    }

}
