package models;

public class TreatmentRecord {
    private int patientID;
    private String patientName;
    private String treatmentDetails;
    private String completionDate;

    public TreatmentRecord(int patientID, String patientName, String treatmentDetails, String completionDate) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completionDate = completionDate;
    }

    public int getPatientID() { return patientID; }
    public String getPatientName() { return patientName; }

    @Override
    public String toString() {
        return "Treatment [PatientID=" + patientID + ", Name=" + patientName +
                ", Details=" + treatmentDetails + ", Date=" + completionDate + "]";
    }
}