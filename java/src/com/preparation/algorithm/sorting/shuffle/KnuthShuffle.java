package com.preparation.algorithm.sorting.shuffle;

import java.util.Arrays;

/**
 * Shuffle a deck of cards randomly.
 * <p>
 * Algo1:
 * 1. Assign each element of array a math.random number between 0 to length and sort it : complexity : o(nlogn) cz of sorting
 * <p>
 * Algo2: we can avoid sorting:
 * Traverse linearly, and whenever we encounter an element, find random number (between 0 and i/current)
 * and swap it with that digit in the left array.
 * Now for every i, we do only 1 swap.
 * <p>
 * 1. In iteration i, pick integer random : between 0 and i uniformly at random.
 * 2. swap arr[i] and arr[random].
 * <p>
 * <p>
 * Math.random : gives probability value in the range 0 to 1 like 0.25 etc.
 * Now lets say start is 5, and end is 10.
 * <p>
 * then 0.25*(10-5) --> 1.25 --> to fetch value in the range of diff of max and min
 * now this should be on top of start right? so we add +min to it, hence : 1.25+5 --> 6.25 --> int --> 6
 * <p>
 * (Math.random() * ( Max - Min )) + min
 */
public class KnuthShuffle {

    public void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //To generate a random number between start and end range
            // obtain a random number using Math.random() which gives possible values from 0..1 in decimal
            int random = (int) (Math.random() * (i));
            swap(arr, i, random);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String... s) {
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        int arr[] = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        knuthShuffle.shuffle(arr);
        Arrays.stream(arr).forEach(element -> System.out.print(element + " "));
    }

}
