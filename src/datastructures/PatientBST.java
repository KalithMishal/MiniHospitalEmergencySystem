package datastructures;

import models.Patient;

public class PatientBST {
    private static class Node {
        Patient patient;
        Node left, right;
        Node(Patient patient) { this.patient = patient; }
    }

    private Node root;

    public boolean insert(Patient patient) {
        if (search(patient.getPatientID()) != null) return false;
        root = insertRec(root, patient);
        return true;
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) return new Node(patient);
        if (patient.getPatientID() < root.patient.getPatientID()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientID() > root.patient.getPatientID()) {
            root.right = insertRec(root.right, patient);
        }
        return root;
    }

    public Patient search(int id) {
        Node res = searchRec(root, id);
        return res != null ? res.patient : null;
    }

    private Node searchRec(Node root, int id) {
        if (root == null || root.patient.getPatientID() == id) return root;
        if (id < root.patient.getPatientID()) return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    public boolean delete(int id) {
        if (search(id) == null) return false;
        root = deleteRec(root, id);
        return true;
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return null;
        if (id < root.patient.getPatientID()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.patient.getPatientID()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientID());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient min = root.patient;
        while (root.left != null) {
            min = root.left.patient;
            root = root.left;
        }
        return min;
    }

    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("  No patient records in BST.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println("  " + root.patient);
            inOrderRec(root.right);
        }
    }
}