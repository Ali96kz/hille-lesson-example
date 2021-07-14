package com.hillel.car.shop;

import java.util.Random;

public class ListNodeTask {

    public static void main(String[] args) {
        ListNode current = generateList(10);

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static ListNode generateList(int number) {
        ListNode head = new ListNode();
        ListNode current = head;

        Random random = new Random();
        for (int i = 0; i < number; i++) {
            ListNode node = new ListNode();
            node.val = random.nextInt(10);
            current.next = node;
            current = current.next;
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
