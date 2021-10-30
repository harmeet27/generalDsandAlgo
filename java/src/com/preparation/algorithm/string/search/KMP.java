package com.preparation.algorithm.string.search;

import java.util.Arrays;

/**
 * Algorithm :
 * 1. Create an lps/aux
 *      lps : longest proper prefix which is also a suffix
 *      array which contains the max length of prefix(excluding the whole pattern)
 *    which is also a suffix of the pattern to search.
 * For ex : ABC as pattern has prefixes: A, AB but has suffixes : C,BC,ABC , the max common prefix/suffix is
 *
 * The Naive pattern searching algorithm doesn’t work well in cases where we see many matching characters
 * by a mismatching character. Following are some examples.
 *
 *
 *
 *    txt[] = "AAAAAAAAAAAAAAAAAB"
 *    pat[] = "AAAAB"
 *
 *    txt[] = "ABABABCABABABCABABABC"
 *    pat[] =  "ABABAC" (not a worst case, but a bad case for Naive)
 *    The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more than once
 *    in the pattern) of the pattern and improves the worst case complexity to O(n).
 *
 *    The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches),
 *    we already know some of the characters in the text of the next window. We take advantage of this information
 *    to avoid matching the characters that we know will anyway match.
 *
 * Need of Preprocessing?
 * How to know how many characters to be skipped int the original string. To know this,
 * we pre-process pattern and prepare an integer array
 * lps[] that tells us the count of characters to be skipped.
 *
 *  2. Use lps[] to check for string in original String and use it for skipping elements in case there is a mismatch.
 *
 *
 *  DIY:
 *  1. String having a lot of common prefixes with pattern results in poor time complexity of naive.
 *  2. TO improve this we create lps aux array which helps us in skipping certain elements in such cases.
 *
 *   Text :    abcxabcdabxabcdabcdabcy
 *Pattern :    abcdabcy
 *
 *             abcxabcdabxabcdabcdabcy
 *             abcd   (d is not matched with x so we check if we can skip elements for checking using lps)
 *
 *             abcxabcdabxabcdabcdabcy
 *                 abcdabc  (c is not matched with x in the above pattern , we check if we can skip)
 *
 *             abcxabcdabxabcdabcdabcy
 *                     abcdabc  (we skipped matching ab since it is the longest prefix till this point)
 *
 */
public class KMP {

    private static int[] computeLps(char[] arr) {
        int[] lps = new int[arr.length];
        int j = 0;
        int i = 1;

        while (i < arr.length) {
            if (arr[i] == arr[j]) {
                lps[i] = j+1;
                i++;
                j++;
            } else if (j == 0) {
                lps[i] = 0;
                i++;
            } else {
                j = lps[j - 1];
            }
        }

        return lps;

    }

    public static void main(String... s) {
        String pattern1 = "AABAACAABAA";
        String pattern2 = "AAACAAAAAC";
        String pattern3 = "AAABAAA";
        String pattern4 = "ABCDE";
        String pattern5 = "AAAA";
        Arrays.stream(computeLps(pattern2.toCharArray())).forEach(element -> System.out.print(element + " , "));
    }

}
