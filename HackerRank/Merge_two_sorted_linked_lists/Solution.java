package Merge_two_sorted_linked_lists;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
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

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode mergedHead = null;
    SinglyLinkedListNode mergedNode = null;
    SinglyLinkedListNode curNode1 = head1;
    SinglyLinkedListNode curNode2 = head2;

    while (curNode1 != null && curNode2 != null) {
      if (curNode1.data <= curNode2.data) {
        if (mergedHead == null) {
          mergedHead = mergedNode = curNode1;
        } else {
          mergedNode.next = curNode1;
          mergedNode = curNode1;
        }
        curNode1 = curNode1.next;
      } else {
        if (mergedHead == null) {
          mergedHead = mergedNode = curNode2;
        } else {
          mergedNode.next = curNode2;
          mergedNode = curNode2;
        }
        curNode2 = curNode2.next;
      }
    }

    if (curNode1 != null) {
      mergedNode.next = curNode1;
    } else if (curNode2 != null) {
      mergedNode.next = curNode2;
    }
    return mergedHead;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int tests = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      SinglyLinkedList llist1 = new SinglyLinkedList();

      int llist1Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist1Count; i++) {
        int llist1Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist1.insertNode(llist1Item);
      }

      SinglyLinkedList llist2 = new SinglyLinkedList();

      int llist2Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist2Count; i++) {
        int llist2Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist2.insertNode(llist2Item);
      }

      SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

//      printSinglyLinkedList(llist3, " ", bufferedWriter);
//      bufferedWriter.newLine();
    }

//    bufferedWriter.close();

    scanner.close();
  }
}
