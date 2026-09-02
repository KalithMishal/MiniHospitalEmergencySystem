package datastructures;

import models.VisitRecord;

public class VisitLinkedList {
    private static class Node {
        VisitRecord data;
        Node next;
        Node(VisitRecord data) { this.data = data; }
    }

    private Node head;

    public void addVisit(VisitRecord visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public boolean removeVisit(String visitID) {
        if (head == null) return false;
        if (head.data.getVisitID().equalsIgnoreCase(visitID)) {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null && !curr.next.data.getVisitID().equalsIgnoreCase(visitID)) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public VisitRecord searchVisit(String visitID) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.getVisitID().equalsIgnoreCase(visitID)) return curr.data;
            curr = curr.next;
        }
        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("    No past visits recorded.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println("    -> " + curr.data);
            curr = curr.next;
        }
    }
}