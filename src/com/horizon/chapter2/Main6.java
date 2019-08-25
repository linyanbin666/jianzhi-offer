package com.horizon.chapter2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * title : 从尾到头打印链表
 * url : https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main6 {
    /*// 1.反转链表，修改了输入
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null)
            return res;

        // 反转链表
        ListNode curr = listNode, pre = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        ListNode p = pre;
        while (p != null) {
            res.add(p.val);
            p = p.next;
        }
        return res;
    }*/

     /*// 2.使用栈求解
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null)
            return res;
        ListNode p = listNode;
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }*/

    // 使用递归求解
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null)
            return res;
        printListFromTailToHeadCore(listNode, res);
        return res;
    }
    private void printListFromTailToHeadCore(ListNode listNode, ArrayList<Integer> res) {
        if (listNode == null)
            return;
        if (listNode.next != null) {
            printListFromTailToHeadCore(listNode.next, res);
        }
        res.add(listNode.val);
    }

}
