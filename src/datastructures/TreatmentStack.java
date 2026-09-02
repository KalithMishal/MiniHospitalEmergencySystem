package datastructures;

import models.TreatmentRecord;

public class TreatmentStack {
    private static class Node {
        TreatmentRecord data;
        Node next;
        Node(TreatmentRecord data) { this.data = data; }
    }

    private Node top;

    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) return null;
        TreatmentRecord record = top.data;
        top = top.next;
        return record;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("  Treatment Stack is currently empty.");
            return;
        }
        Node curr = top;
        int pos = 1;
        while (curr != null) {
            System.out.println("  [" + pos++ + "] " + curr.data);
            curr = curr.next;
        }
    }
}