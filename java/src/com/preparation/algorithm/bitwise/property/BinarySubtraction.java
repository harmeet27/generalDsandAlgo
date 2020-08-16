package com.preparation.algorithm.bitwise.property;

/**
 * Binary Subtraction Table
 * The subtraction of binary numbers is given by:
 *
 * Binary Number	Subtraction Value
 * 0 – 0	0
 * 1 – 0	1
 * 0 – 1	1 (Borrow 1 from next high order digit)
 * 1 – 1	0
 *
 *
 * Example:
 *
 * 1010
 * -101
 * 0101
 *
 * Step 1: First consider the 1’s column, and subtract the one’s column,( 0 – 1 ) and it gives the result 1 as per the condition of binary subtraction with a borrow of 1 from the 10’s place.
 * Step 2: After borrowed 1 from the 10’s column, the value 1 in the 10’s column is changed into the value 0
 * 1 Borrow
 * Step 3: So, subtract the value in the 10’s place, ( 0 – 0 ) = 0.
 * 1 Borrow
 *
 * 1 0 1 0
 *
 * (-) 1 0 1
 *
 * ——————
 *
 * 0 1
 *
 * Step 4: Now subtract the values in 100’s place. Borrow 1 from the 1000’s place ( 0 – 1 ) = 1.
 * 1 1 Borrow
 *
 */
public class BinarySubtraction {
}
