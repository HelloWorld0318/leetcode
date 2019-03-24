package com.hjx.leetcode.problem0142;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode1 = head, quickNode = head;
        while (quickNode != null && quickNode.next != null) {
            slowNode1 = slowNode1.next;
            quickNode = quickNode.next.next;
            if (slowNode1 == quickNode) {
                ListNode slowNode2 = head;
                while (quickNode != slowNode2) {
                    quickNode = quickNode.next;
                    slowNode2 = slowNode2.next;
                }
                return quickNode;
            }
        }
        return null;
    }
}
