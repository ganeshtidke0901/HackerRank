package datastructure;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrintElementOfLinkedList {


    static class SinglyLinkedListNode  {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }


    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        SinglyLinkedListNode first = llist;
        SinglyLinkedListNode previNode = null;

        for (int i = 0; i <= position - 1; i++) {
            previNode = llist;
            llist = llist.next;
        }
        if (previNode == null) {
            first = llist.next;
            return first;
        }

        previNode.next = llist.next;
        return first;
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {

        int counter = 0;
        SinglyLinkedListNode head = llist;
        while (llist != null) {
            counter++;
            llist = llist.next;
        }

        int index = counter - positionFromTail - 1;
        while (index != 0) {
            index--;
            head = head.next;
        }

        return head.data;

    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here

        SinglyLinkedListNode pointer = llist;
        while (pointer != null) {
            if (pointer.next != null && pointer.data == pointer.next.data) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return llist;
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist != null) {
            reversePrint(llist.next);
            System.out.println(llist.data);
        }


    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode nextNode = null;
        SinglyLinkedListNode prevNode = null;

        while (llist != null) {

            nextNode = llist.next;
            llist.next = prevNode;
            prevNode = llist;
            System.out.println("llist:" + llist.data);
            if (nextNode == null)
                break;
            llist = nextNode;
        }

        return llist;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null && head2 == null)
            return null;

        if (head1 == null && head2 != null)
            return head2;


        if (head1 != null && head2 == null)
            return head1;


        SinglyLinkedListNode mainHead = null;
        SinglyLinkedListNode mainPrevNode = head1;

        if (head1.data <= head2.data) {
            mainHead = head1;
            mainPrevNode = head1;
            head1 = head1.next;
        } else {
            mainHead = head2;
            mainPrevNode = head2;
            head2 = head2.next;
        }
        System.out.println(mainHead.data + " " + mainPrevNode.data);

        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    mainPrevNode.next = head1;
                    mainPrevNode = head1;
                    head1 = head1.next;
                } else {
                    mainPrevNode.next = head2;
                    mainPrevNode = head2;
                    head2 = head2.next;

                }


            } else if (head1 == null && head2 != null) {
                mainPrevNode.next = head2;
                mainPrevNode = head2;
                head2 = head2.next;
            } else if (head1 != null && head2 == null) {
                mainPrevNode.next = head1;
                mainPrevNode = head1;
                head1 = head1.next;
            }

        }
        return mainHead;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1=head1;
        SinglyLinkedListNode current2=head2;

        while(current1!=null)
        {
            while(current2!=null)
            {
                if(current2==current1)
                {
                    return current1.data;
                }
                current2=current2.next;
            }
            current2=head2;
            current1=current1.next;

        }


        return 0;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // while(head1!=null || head2!=null)
        // {
        //     if(head1==null && head2!=null)
        //     return false;

        //     if(head1!=null && head2==null)
        //     return false;


        //     if(head1.data!=head2.data)
        //     return false;

        //     head1=head1.next;
        //     head2=head2.next;

        // }
        // return true;

        if (head1 == null && head2 != null)
            return false;

        if (head1 != null && head2 == null)
            return false;


        if (head1 == null && head2 == null)
            return true;


        if (head1.data != head2.data)
            return false;

        return compareLists(head1.next, head2.next);


    }
    static boolean hasCycle(SinglyLinkedListNode head) {
        List<SinglyLinkedListNode> visitedNodes=new ArrayList<>();
        while(head!=null)
        {
            if(visitedNodes.contains(head))
            {
                return true;
            }

            visitedNodes.add(head);
            head=head.next;
        }
        return false;

    }


    // Complete the printLinkedList function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(SinglyLinkedListNode head) {

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount - 1) {
                    temp = temp.next;
                }
            }

            temp.next = extra;

            boolean result = hasCycle(llist.head);
            System.out.println(result?1:0);
        }
    }

}
