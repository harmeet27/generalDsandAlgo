package com.preparation.common.linkedlist;

public class ReverseNodesWithSizeK {

    public static void main(String[] args) {


        Node head = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(71);
        Node n7 = new Node(82);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;


        // printList(head);

        Node result = reverseLinkedListWithSize(head,3);

        printList(result);


    /*

    10 -> 20 -> 30 -> 1-> 2 -> 3 -> 71 -> 82

    30->20->10 1->2->3
    k =3

    30 -> 20 -> 10 -> 3-> 2 -> 1 -> 82 -> 71

    */


    }

    public static void printList(Node head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node reverseLinkedListWithSize(Node head, int k){
        Node curr = head;
        Node prev = null;
        Node temp = curr;
        int first=0;
        Node initial=null;
        Node start = curr;
        //end of prev  --> temp
        //start of next  --> curr
        while(curr!=null)
        {
            int count = 0;
            start=curr;
            while(curr!=null && k!=count){
                temp=curr;
                curr=curr.next;
                temp.next=prev;
                prev=temp;
                count++;
            }

            first=first+1;
            if(first==1){
                initial=start;
            }

            start.next=curr;
        }

        return initial;
    }


    public Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;
        Node temp = curr;
        while(curr!=null){
            temp=curr;
            temp.next=prev;
            prev=temp;
            curr=curr.next;

        }

        return temp;
    }


    static class Node{

        Node(int data){
            this.data=data;
            this.next=null;
        }

        Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
        int data;
        Node next;

    }
}
