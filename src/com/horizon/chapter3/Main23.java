package com.horizon.chapter3;

import com.horizon.chapter2.ListNode;

/**
 *  title : 链表中环的入口结点
 *  url : https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;
        int nodesInLoop = 1;
        ListNode p = meetingNode.next;
        while (p != meetingNode) {
            nodesInLoop++;
            p = p.next;
        }
        // 两指针，一指针先移动环中结点数nodesInLoop步，后两个指针同时移动，相遇的点即为环的起点
        p = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            p = p.next;
        }
        ListNode other = pHead;
        while (p != other) {
            p = p.next;
            other = other.next;
        }
        return p;
    }

    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode pSlow = pHead;
        ListNode pFast = pSlow.next;
        while (pSlow != null && pFast != null) {
            if (pSlow == pFast)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }
        return null;
    }
}
