// LeetCode Problem: 23 - Merge k Sorted Lists
// Difficulty: Hard
// Link: https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TODO:
 * 1. Understand the problem: Merge k sorted linked lists into one sorted list
 * 2. Identify the approach: PriorityQueue or Divide and Conquer
 * 3. Implement the solution
 * 4. Test with edge cases (empty lists, single list, null lists)
 * 5. Analyze time complexity: O(n log k) where n is total nodes
 * 6. Analyze space complexity: O(k) for priority queue
 * 7. Optimize if possible
 */


class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // add head of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {

        // TODO: Add your test cases here
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(8);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(5);
        head3.next.next.next.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{head, head2, head3};

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    int getVal() {
        return val;
    }

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
