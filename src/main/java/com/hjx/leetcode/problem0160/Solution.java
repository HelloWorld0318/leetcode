package com.hjx.leetcode.problem0160;

import com.hjx.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public ListNode getIntersectionNodeBySet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public int getListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode moveForward(int longLength, int shortLength, ListNode head) {
        int delat = longLength - shortLength;
        while (head != null && delat > 0) {
            head = head.next;
            delat--;
        }
        return head;
    }

    public ListNode getIntersectionNodeMethod3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = getListLength(nodeA);
        int lenB = getListLength(nodeB);

        if (lenA > lenB) {
            headA = moveForward(lenA, lenB, headA);
        } else {
            headB = moveForward(lenB, lenA, headB);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
