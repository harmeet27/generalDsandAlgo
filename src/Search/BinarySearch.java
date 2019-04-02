package Search;

import java.util.Arrays;

public class BinarySearch {
    public Integer searchElement(Integer arr[], Integer b){
        Arrays.sort(arr);
        return Search(arr, 0 , arr.length -1, b);
    }

    public Integer Search(Integer arr[], int left, int right, int b){
        int middle = left + ( right - left) / 2;
        if(b < arr[middle]){
            right = middle;
        } else if(b > arr[middle]) {
            left = middle;
        } else if( b == arr[middle]){
            return middle;
        }
        return Search(arr,left,right,b);

    }
}


// 1 2 3 4 5 6 7 8 9, 6
// l 9    5
// r 8    4
// lef 0  0
// m 4    2   right = 2
//
// left = 4
// newArray = 5 6 7 8 9
// 6