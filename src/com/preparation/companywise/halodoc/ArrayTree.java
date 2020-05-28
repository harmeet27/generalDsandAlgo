package com.preparation.companywise.halodoc;

/**
 * You are given an array of size N. The array is formed using a tree rooted at node 1.
 * Array Generation code:
 *
 * generate(node){
 *     if(node==1){
 *         insert node into the array
 *         visited[node]=true;
 *
 *         for(nodes : adjacencey luist of nodes){
 *             child = node in adj list
 *
 *             if(! child not visited ){
 *                 insert child into the array
 *                 generate(child)
 *                 insert onde into the array
 *             }
 *         }
 *     }
 * }
 *
 * Input format:
 * First line contains N
 * Then N integers follow denoting elements of the array.
 *
 * OUTPUT:
 * print k space seperated integer denoting the number of nodes in the subtree of each node (k is the number of nodes in the tree.)
 *
 * The firsst Integer in the ouput denotes the count of the subtree of node 1. Second integer corresponds to subtree count of node
 * 2, and so on.
 *
 * It is guaranteed that tree can be generated using given input.
 *
 * ex:
 * Input:
 * 3
 * 1 2 1
 *
 * OUPUT:
 * 2 1
 *
 *
 */
public class ArrayTree {
}
