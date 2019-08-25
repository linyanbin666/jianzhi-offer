package com.horizon.chapter3;

import com.horizon.chapter2.ListNode;

/**
 * title : 合并两个排序的链表
 * url : https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Main25 {

   /* public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = null, p = null, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                if (head == null) {
                    head = p1;
                    p = p1;
                } else {
                    p.next = p1;
                    p = p.next;
                }
                p1 = p1.next;
            } else {
                if (head == null) {
                    head = p2;
                    p = p2;
                } else {
                    p.next = p2;
                    p = p.next;
                }
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }*/

   // 递归
   public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = Merge(list1.next, list2);
        } else {
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
   }

}
