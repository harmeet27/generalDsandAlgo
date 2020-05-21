package com.preparation.dp.memoization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


//https://www.techiedelight.com/longest-common-subsequence/
public class Lcs {

    // Complete the commonChild function below.
    static HashMap<String, Integer> visited = new HashMap();

    static int commonChild(String s1, String s2) {
        return findLcs(s1, s2, s1.length() - 1, s2.length() - 1);
    }


    static int findLcs(String s1, String s2, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (visited.containsKey(s1.charAt(i) + "-" + s2.charAt(j))) {
            return visited.get(s1.charAt(i) + "-" + s2.charAt(j));
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            visited.put(s1.charAt(i) + "-" + s2.charAt(j), 1 + findLcs(s1, s2, i - 1, j - 1));
            return visited.get(s1.charAt(i) + "-" + s2.charAt(j));
        } else {
            visited.put(s1.charAt(i) + "-" + s2.charAt(j), Math.max(findLcs(s1, s2, i, j - 1), findLcs(s1, s2, i - 1, j)));
            return visited.get(s1.charAt(i) + "-" + s2.charAt(j));
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(String.valueOf(result));
        System.out.println();

        scanner.close();
    }
}

