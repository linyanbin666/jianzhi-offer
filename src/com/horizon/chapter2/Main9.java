package com.horizon.chapter2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * title : 用两个栈实现队列
 * url : https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main9 {

    // 用两个栈实现队列，入队时间复杂度O(1)，出队时间复杂度O(1)
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void offer(int node) {
        stack1.push(node);
    }
    public int poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }


    // 扩展：用两个队列实现栈，入栈时间复杂度O(1)，出栈时间复杂度O(n)
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        // 若queue1为空，queue2不为空，则插入queue2，否则插入queue1
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.offer(node);
        } else {
            queue1.offer(node);
        }
    }
    public int pop() {
        // 将不为空的队列元素搬到另一队列中，返回最后搬出的元素
        while (!queue1.isEmpty() && queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        if (queue1.size() == 1)
            return queue1.poll();
        while (!queue2.isEmpty() && queue2.size() > 1) {
            queue1.offer(queue2.poll());
        }
        if (queue2.size() == 1)
            return queue2.poll();
        // 如果两个队列都为空
        throw new RuntimeException();
    }


}
