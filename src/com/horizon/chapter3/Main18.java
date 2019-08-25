package com.horizon.chapter3;

import com.horizon.chapter2.ListNode;

/**
 *  title : 题目一：删除链表的节点
 *  detail : 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。链表节点与函数的定义如下：
 *           struct ListNode {
 *               int val;
 *               ListNode next;
 *           }
 *
 *  title ; 题目二：删除链表中重复的节点
 *  url : https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main18 {

    public void deleteNode(ListNode head, ListNode pToBeDeleted) {
        if (head == null || pToBeDeleted == null)
            return;
        // 要删除的节点不是尾节点
        if (pToBeDeleted.next != null) {
            ListNode next = pToBeDeleted.next;
            pToBeDeleted.val = next.val;
            pToBeDeleted.next = next.next;
        } else if (head == pToBeDeleted) {
            // 链表只有一个节点
            head = null;
        } else {
            // 链表有多个节点，顺序遍历
            ListNode curr = head;
            while (curr.next != pToBeDeleted) {
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            // 判断是否需要删除
            if (pNext != null && pNext.val == pNode.val) {
                needDelete = true;
            }
            // 不需要则往下走
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                // 需要删除，删除接下来相同的节点
                int val = pNode.val;
                ListNode pToBeDeleted = pNode;
                while (pToBeDeleted != null && pToBeDeleted.val == val) {
                    pNext = pToBeDeleted.next;
                    pToBeDeleted = pNext;
                }

                if (pPreNode != null) {
                    pPreNode.next = pNext;
                } else {
                    pHead = pNext;
                }
                // 下一个节点
                pNode = pNext;
            }
        }
        return pHead;
    }

}
