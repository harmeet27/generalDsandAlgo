package com.preparation.coursera;

/**
 * Connected Component that
 * 1. if a is connected to b and b to c, the a is connected to c.
 * <p>
 * Time Complexity : for union : o(n)
 * isPath : o(1)
 * <p>
 * if we perform union operation n times --> total Time complexity : o(n*m);
 * <p>
 * <p>
 * Algorithm:
 * 1. Interpretation : p & q are connected if they have the same id.
 * 2. id[] of size N.
 * 3. To perform union of p & q , change all entries whose id equals id[p] to id[q].
 * like changing all children of q point to same parent of p.
 */
public class QuickFind {

    int id[];

    public QuickFind(int totalNodes) {
        id = new int[totalNodes];
        for (int i = 0; i < id.length; i++) {
            id[i] = i; //initialize each node with its own index as if stating all are intially disconnected.
        }
    }

    //add an edge between 2 nodes first and second
    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        //change all child of second to first id as well
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }

    }

    //check if it is connected directly/indirectly i.e. conected component.
    //2 nodes are connected if they have the same id.
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }


    public static void main(String... s) {
        QuickFind quickFind = new QuickFind(10); //0-9

        quickFind.union(3, 5);
        //3--5
        quickFind.union(4, 8);
        //4--8

        quickFind.union(3, 8);
        //4--8--3--5


        System.out.println(quickFind.isConnected(4, 5));
        System.out.println(quickFind.isConnected(3, 8));
        System.out.println(quickFind.isConnected(4, 8));


    }

}
