package com.horizon.chapter3;

import com.horizon.chapter2.ListNode;
import com.sun.org.apache.regexp.internal.RE;

/**
 *  title : 反转链表
 *  url : https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main24 {
    public ListNode ReverseList(ListNode head) {
        // 一个结点或空链表时返回
        if (head == null || head.next == null)
            return head;
        // 获取链表头
        ListNode revNode = ReverseList(head.next);
        // 反转
        head.next.next = head;
        // 取消原先的连接
        head.next = null;
        // 一直返回反转后的表头
        return revNode;
    }
}
