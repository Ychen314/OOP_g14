package IBICS;

import java.util.HashMap;
import java.util.Map;

public class Bill {
 private static int billCounter = 5000;
 private int billID;
 private int patientID;
 private double totalAmount;
 private Map<String, Double> breakdown;
 private String status;

 public Bill(int patientID) {
     this.billID = billCounter++;
     this.patientID = patientID;
     this.totalAmount = 0.0;
     this.breakdown = new HashMap<>();
     this.status = "Unpaid";
 }

 // Getters and Setters
 public int getBillID() {
     return billID;
 }

 public int getPatientID() {
     return patientID;
 }

 public double getTotalAmount() {
     return totalAmount;
 }

 public Map<String, Double> getBreakdown() {
     return breakdown;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }

 // Generate the bill based on treatments
 public boolean generate(Patient patient) {
     if (patient.getTreatments().isEmpty()) {
         System.out.println("No treatments to bill for Patient ID: " + patient.getId());
         return false;
     }
     for (Treatment treatment : patient.getTreatments()) {
         breakdown.put(treatment.getTreatmentName(), treatment.getTreatmentCost());
         totalAmount += treatment.getTreatmentCost();
     }
     System.out.println("Bill generated for Patient ID: " + patient.getId());
     return true;
 }

 // View bill details
 public String viewDetails() {
     StringBuilder sb = new StringBuilder();
     sb.append("Bill ID: ").append(billID)
       .append(", Patient ID: ").append(patientID)
       .append(", Total Amount: $").append(totalAmount)
       .append(", Status: ").append(status)
       .append("\nBreakdown:\n");
     for (Map.Entry<String, Double> entry : breakdown.entrySet()) {
         sb.append(" - ").append(entry.getKey()).append(": $").append(entry.getValue()).append("\n");
     }
     return sb.toString();
 }

 @Override
 public String toString() {
     return "Bill ID: " + billID + ", Patient ID: " + patientID +
            ", Total Amount: $" + totalAmount + ", Status: " + status;
 }
}
