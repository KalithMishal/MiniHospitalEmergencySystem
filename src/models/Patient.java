package models;

import datastructures.VisitLinkedList;

public class Patient {
    private int patientID;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private VisitLinkedList visitHistory;

    public Patient(int patientID, String name, int age, String contactNumber, String medicalCondition) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public int getPatientID() { return patientID; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalCondition() { return medicalCondition; }
    public VisitLinkedList getVisitHistory() { return visitHistory; }

    @Override
    public String toString() {
        return "Patient [ID=" + patientID + ", Name=" + name + ", Age=" + age +
                ", Contact=" + contactNumber + ", Condition=" + medicalCondition + "]";
    }
}