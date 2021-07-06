package com.hillel.car.shop;

import java.util.Arrays;
import java.util.List;

public class Hw15 {

    public static void main(String[] args) {

    }

    public ListNode generate() {
        List<Integer> integers = Arrays.asList(2, 3, 4, 5, 5, 5, 2, 56, 123, 436, 67, 34, 2, 2, 234);
        ListNode head = new ListNode(-1);
        ListNode current = head;

        for (Integer integer : integers) {
            current.next = new ListNode(integer);
        }

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
