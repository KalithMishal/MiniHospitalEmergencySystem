package models;

public class VisitRecord {
    private String visitID;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public VisitRecord(String visitID, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitID = visitID;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getVisitID() { return visitID; }
    public String getVisitDate() { return visitDate; }
    public String getDoctorName() { return doctorName; }
    public String getDiagnosis() { return diagnosis; }
    public String getTreatment() { return treatment; }

    @Override
    public String toString() {
        return "Visit [ID=" + visitID + ", Date=" + visitDate + ", Doctor=" + doctorName +
                ", Diagnosis=" + diagnosis + ", Treatment=" + treatment + "]";
    }
}