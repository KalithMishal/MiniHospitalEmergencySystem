import datastructures.EmergencyQueue;
import datastructures.PatientBST;
import datastructures.TreatmentStack;
import models.Patient;
import models.TreatmentRecord;
import models.VisitRecord;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM ===");
            System.out.println("1. Register Patient (BST Insert)");
            System.out.println("2. Search Patient (BST Search)");
            System.out.println("3. Delete Patient (BST Delete)");
            System.out.println("4. Display All Patients (BST In-Order)");
            System.out.println("5. Add Patient to Emergency Queue (Enqueue)");
            System.out.println("6. Treat Next Emergency Patient (Dequeue -> Stack Push)");
            System.out.println("7. View Emergency Queue");
            System.out.println("8. View Treatment History (Stack Display)");
            System.out.println("9. Undo / Remove Recent Treatment (Stack Pop)");
            System.out.println("10. Manage Patient Visit History (Linked List)");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter Patient ID (Integer): ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = sc.nextLine();

                    Patient p = new Patient(id, name, age, contact, condition);
                    if (bst.insert(p)) {
                        System.out.println("Patient registered successfully!");
                    } else {
                        System.out.println("Error: Patient ID already exists.");
                    }
                    break;

                case "2":
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    Patient found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter Patient ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    if (bst.delete(delId)) {
                        System.out.println("Patient deleted successfully from registry.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case "4":
                    System.out.println("Registered Patients (Sorted by ID):");
                    bst.inOrderTraversal();
                    break;

                case "5":
                    System.out.print("Enter Patient ID for Emergency Triage: ");
                    int qId = Integer.parseInt(sc.nextLine());
                    Patient qPatient = bst.search(qId);
                    if (qPatient != null) {
                        queue.enqueue(qPatient);
                        System.out.println(qPatient.getName() + " added to emergency queue.");
                    } else {
                        System.out.println("Patient not registered in BST. Please register first.");
                    }
                    break;

                case "6":
                    Patient treatedPatient = queue.dequeue();
                    if (treatedPatient != null) {
                        System.out.print("Enter Treatment Details for " + treatedPatient.getName() + ": ");
                        String tDetails = sc.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String tDate = sc.nextLine();

                        TreatmentRecord tr = new TreatmentRecord(treatedPatient.getPatientID(), treatedPatient.getName(), tDetails, tDate);
                        stack.push(tr);
                        System.out.println("Treatment completed and pushed to stack.");
                    } else {
                        System.out.println("No patients waiting in the emergency queue.");
                    }
                    break;

                case "7":
                    System.out.println("Current Emergency Queue:");
                    queue.displayQueue();
                    break;

                case "8":
                    System.out.println("Treatment History (LIFO):");
                    stack.displayStack();
                    break;

                case "9":
                    TreatmentRecord popped = stack.pop();
                    if (popped != null) {
                        System.out.println("Removed most recent treatment: " + popped);
                    } else {
                        System.out.println("Treatment stack is empty.");
                    }
                    break;

                case "10":
                    System.out.print("Enter Patient ID to manage visit history: ");
                    int vPatId = Integer.parseInt(sc.nextLine());
                    Patient vPat = bst.search(vPatId);
                    if (vPat == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    System.out.println("\n--- Visit History for " + vPat.getName() + " ---");
                    System.out.println("a. Add Visit");
                    System.out.println("b. Remove Visit");
                    System.out.println("c. Search Visit");
                    System.out.println("d. Display All Visits");
                    System.out.print("Choose sub-option: ");
                    String sub = sc.nextLine().toLowerCase();

                    if (sub.equals("a")) {
                        System.out.print("Enter Visit ID: ");
                        String vId = sc.nextLine();
                        System.out.print("Enter Visit Date: ");
                        String vDate = sc.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doc = sc.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = sc.nextLine();
                        System.out.print("Enter Treatment: ");
                        String treat = sc.nextLine();
                        vPat.getVisitHistory().addVisit(new VisitRecord(vId, vDate, doc, diag, treat));
                        System.out.println("Visit added successfully!");
                    } else if (sub.equals("b")) {
                        System.out.print("Enter Visit ID to remove: ");
                        String vId = sc.nextLine();
                        if (vPat.getVisitHistory().removeVisit(vId)) {
                            System.out.println("Visit removed successfully.");
                        } else {
                            System.out.println("Visit ID not found.");
                        }
                    } else if (sub.equals("c")) {
                        System.out.print("Enter Visit ID to search: ");
                        String vId = sc.nextLine();
                        VisitRecord vr = vPat.getVisitHistory().searchVisit(vId);
                        if (vr != null) {
                            System.out.println("Visit Found: " + vr);
                        } else {
                            System.out.println("Visit ID not found.");
                        }
                    } else if (sub.equals("d")) {
                        System.out.println("All visits for " + vPat.getName() + ":");
                        vPat.getVisitHistory().displayVisits();
                    }
                    break;

                case "0":
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}