package com.horizon.chapter3;

import com.horizon.chapter2.ListNode;

/**
 *  title : 链表中倒数第k个结点
 *  url : https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode first = head;
        // 向前走k-1步
        while (first != null && k > 1) {
            first = first.next;
            k--;
        }
        // 节点数不够k个
        if (first == null) {
            return null;
        }
        ListNode second = head;
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }

}
