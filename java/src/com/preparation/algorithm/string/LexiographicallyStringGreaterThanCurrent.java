package com.preparation.algorithm.string;

import java.util.Arrays;

/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 *
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 * Example
 *
 * The next largest word is .
 *
 * Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.
 *
 * Function Description
 *
 * Complete the biggerIsGreater function in the editor below.
 *
 * biggerIsGreater has the following parameter(s):
 *
 * string w: a word
 * Returns
 * - string: the smallest lexicographically higher string possible or no answer
 *
 * Input Format
 *
 * The first line of input contains , the number of test cases.
 * Each of the next  lines contains .
 *
 * Constraints
 *
 *  will contain only letters in the range ascii[a..z].
 * Sample Input 0
 *
 * 5
 * ab
 * bb
 * hefg
 * dhck
 * dkhc
 *
 * Sample Output 0
 * ba
 * no answer
 * hegf
 * dhkc
 * hcdk
 */
public class LexiographicallyStringGreaterThanCurrent {
    public static String biggerIsGreater(String s)
    {
        char charArr[] = s.toCharArray();
        int n = charArr.length;
        int i = 0;
        for (i = n - 1; i > 0; i--)
        {
            if (charArr[i] > charArr[i - 1])
            {
                break;
            }
        }
        if (i == 0) //No value found with prev less than current (dcba can be one example)
        {
            return "no answer";
        }
        else
        {
            //pivot is found at small, this needs to be swapped with smaller number greater than pivot
            //all remaining then can be sorted directly in ascending order to give just greater number.
            int small = charArr[i - 1], next = i;

            for (int j = i + 1; j < n; j++)
            {
                if (charArr[j] > small && charArr[j] < charArr[next])
                {
                    next = j;
                }
            }
            swap(charArr, i - 1, next);
            Arrays.sort(charArr, i , n);
        }
        return new String(charArr);
    }

    private static void swap(char[] ch, int first, int second){
        char temp=ch[first];
        ch[first]=ch[second];
        ch[second]=temp;
    }

}
