package com.preparation.algorithm.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
 */
public class PlaceAlphabetsSuchThatNo2AreTogether {

    public String reorganizeString(String S) {

        if(S==null || S.length()<=1){
            return S;
        }


        HashMap<Character,Integer> map = new HashMap();
        PriorityQueue<Node> maxHeap = new PriorityQueue(new QueueComparator());
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        }

        map.forEach((key,value)->maxHeap.add(new Node(value,key)));
        if(!maxHeap.isEmpty()){
            if(S.length()%2==0){
                if(maxHeap.peek().count>=S.length()/2+1){
                    return "";
                }
            }else{
                if(maxHeap.peek().count>S.length()/2+1){
                    return "";
                }
            }
        }

        String solution="";
        Node lastRemoved=null;
        while(!maxHeap.isEmpty()){

            Node removed = maxHeap.poll();
            solution=solution+removed.value;
            removed.count=removed.count-1;

            if(lastRemoved!=null && lastRemoved.count>0){
                maxHeap.add(lastRemoved);
            }

            lastRemoved=removed;
        }

        return solution;

    }

    static class Node{
        int count;
        char value;
        Node(int count, char value){
            this.count=count;
            this.value=value;
        }
    }
    class QueueComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2){
            if (node1.count < node2.count)
                return 1;
            else if (node1.count > node2.count)
                return -1;
            return 0;
        }
    }
}
