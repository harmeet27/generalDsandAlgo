package com.preparation.ds.array;

/**
 * The Boyer-Moore algorithm is presented in this paper: Boyer-Moore Majority Vote Algorithm.
 * The algorithm uses O(1) extra space and O(N) time.
 * It requires exactly 2 passes over the input list. It's also quite simple to implement,
 * though a little trickier to understand how it works.
 * <p>
 * In the first pass, we generate a single candidate value which is the majority value if there
 * is a majority.
 * The second pass simply counts the frequency of that value to confirm.
 * The first pass is the interesting part.
 * <p>
 * In the first pass, we need 2 values:
 * A candidate value, initially set to any value.
 * A count, initially set to 0.
 * For each element in our input list, we first examine the count value.
 * If the count is equal to 0, we set the candidate to the value at the current element.
 * Next, first compare the element's value to the current candidate value.
 * If they are the same, we increment count by 1. If they are different, we decrement count by 1.
 * <p>
 * candidate = 0
 * count = 0
 * for value in input:
 * if count == 0:
 * candidate = value
 * if candidate == value:
 * count += 1
 * else:
 * count -= 1
 * At the end of all of the inputs, the candidate will be the majority value if a majority value exists.
 * A second O(N) pass can verify that the candidate is the majority element (an exercise left for the reader).
 * <p>
 * https://leetcode.com/problems/majority-element/submissions/
 */


public class MajorityElement {

    public int majorityElement(int[] nums) {

        int majorityElement = nums[0];
        int count = 1;
        int index = 0;

        while (++index < nums.length) {
            if (majorityElement == nums[index]) count += 1;
            else count -= 1;

            if (count == 0) {
                majorityElement = nums[index];
                count = 1;
            }
        }

        return majorityElement;
    }
}
