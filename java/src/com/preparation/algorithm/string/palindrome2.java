package com.preparation.algorithm.string;

public class palindrome2 {
    public static boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        int j = sb.length() - 1;
        int i = 0;
        if (s.length() == 0) {
            return true;
        }
        while (i <= j) {
            if (i == j) {
                return true;
            }
            if (sb.charAt(i) != sb.charAt(j)) {
                StringBuilder sb1 = new StringBuilder(sb);
                StringBuilder sb2 = new StringBuilder(sb);

                sb1.deleteCharAt(i);
                sb2.deleteCharAt(j);

                return isPalindrome(sb1) || isPalindrome(sb2);
            } else {
                i++;
                j--;
            }
        }
        return false;
    }

    public static boolean isPalindrome(StringBuilder str) {
        StringBuilder reverse = new StringBuilder(str);
        reverse = reverse.reverse();
        if (str.compareTo(reverse) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String... s) {
        System.out.println(validPalindrome("bddb"));
    }
}
