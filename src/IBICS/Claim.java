package IBICS;

public class Claim {
 private static int claimCounter = 1000;
 private int claimID;
 private int patientID;
 private double amount;
 private String status;

 public Claim(int patientID, double amount) {
     this.claimID = claimCounter++;
     this.patientID = patientID;
     this.amount = amount;
     this.status = "Submitted";
 }

 // Getters and Setters
 public int getClaimID() {
     return claimID;
 }

 public int getPatientID() {
     return patientID;
 }

 public double getAmount() {
     return amount;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }

 // Process the claim
 public boolean process() {
     // Placeholder for processing logic
     System.out.println("Processing Claim ID: " + claimID);
     this.status = "Processed";
     return true;
 }

 // Track the status of the claim
 public String trackStatus() {
     return status;
 }

 @Override
 public String toString() {
     return "Claim ID: " + claimID + ", Patient ID: " + patientID +
            ", Amount: $" + amount + ", Status: " + status;
 }
}
