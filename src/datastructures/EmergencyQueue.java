package datastructures;

import models.Patient;

public class EmergencyQueue {
    private static class Node {
        Patient data;
        Node next;
        Node(Patient data) { this.data = data; }
    }

    private Node front, rear;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Patient dequeue() {
        if (isEmpty()) return null;
        Patient patient = front.data;
        front = front.next;
        if (front == null) rear = null;
        return patient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("  Emergency Queue is currently empty.");
            return;
        }
        Node curr = front;
        int pos = 1;
        while (curr != null) {
            System.out.println("  [" + pos++ + "] " + curr.data.getName() + " (ID: " + curr.data.getPatientID() + ", Condition: " + curr.data.getMedicalCondition() + ")");
            curr = curr.next;
        }
    }
}