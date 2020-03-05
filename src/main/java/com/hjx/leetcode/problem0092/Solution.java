package com.hjx.leetcode.problem0092;

import com.hjx.leetcode.entity.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        // 计算需要逆置的节点个数
        int changeLen = n - m + 1;
        // 初始化开始逆置的节点的前驱
        ListNode preHead = null;
        // 最终转换后的链表头节点，非特殊情况即为head
        ListNode result = head;

        // 将head向前移动m-1个位置
        while (head != null && --m > 0) {
            // 记录head的前驱
            preHead = head;
            head = head.next;
        }
        // 将mofifyListTail指向当前的head，即逆置后的链表尾
        ListNode mofifyListTail = head;
        ListNode newHead = null;

        // 逆置changeLen个节点
        while (head != null && changeLen > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;

            head = next;
            // 每完成一个节点逆置，changeLen--
            changeLen--;
        }

        // 连接逆置后的链表尾与逆置段的后一个节点
        mofifyListTail.next = head;

        if (preHead != null) {
            // 如果preHead不空，说明不是从第一个节点开始逆置的 m>1
            preHead.next = newHead;
        } else {
            // 如果preHead为空，说明m == 1 从第一个节点开始逆置
            // 结果即为逆置后的头节点
            result = newHead;
        }

        return result;
    }

}
