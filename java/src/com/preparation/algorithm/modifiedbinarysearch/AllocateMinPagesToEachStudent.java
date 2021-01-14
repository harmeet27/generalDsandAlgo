package com.preparation.algorithm.modifiedbinarysearch;

/**
 * Allocate minimum number of pages
 * Difficulty Level : Hard
 *  Last Updated : 25 Jul, 2019
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 *
 * Example :
 *
 * Input : pages[] = {12, 34, 67, 90}
 *         m = 2
 * Output : 113
 * Explanation:
 * There are 2 number of students. Books can be distributed
 * in following fashion :
 *   1) [12] and [34, 67, 90]
 *       Max number of pages is allocated to student
 *       2 with 34 + 67 + 90 = 191 pages
 *   2) [12, 34] and [67, 90]
 *       Max number of pages is allocated to student
 *       2 with 67 + 90 = 157 pages
 *   3) [12, 34, 67] and [90]
 *       Max number of pages is allocated to student
 *       1 with 12 + 34 + 67 = 113 pages
 *
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateMinPagesToEachStudent {
}
