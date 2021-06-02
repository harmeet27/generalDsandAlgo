package sample;

import java.util.Arrays;
import java.util.Comparator;


public class Driver {


//    static int[] absSort(int[] arr) {
//        Arrays.sort(arr, new CustomComparator());
//        return arr;
//        // your code goes here
//    }

    static class CustomComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int element1 = (int) o1;
            int element2 = (int) o2;

            int first = Math.abs(element1);
            int second = Math.abs(element2);


            if (first < second) {
                return -1;
            } else if (first > second) {
                return 1;
            } else {
                if (element1 < element2) return -1;
                else if (element2 < element1) return 1;
                else return 0;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = {2, -7, -2, -2, 0};
//        absSort(arr);

    }

}
