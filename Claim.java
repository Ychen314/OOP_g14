package IBICS;

public class Claim {
 private static int claimCounter = 1000;
 private int claimID;
 private int patientID;
 private double amount;
 private String status;

 // Constructor
 public Claim(int patientID, double amount) {
     this.claimID = claimCounter++;
     this.patientID = patientID;
     this.amount = amount;
     this.status = "Submitted";
 }

 // Accessors
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

 // Mutator
 public void setStatus(String status) {
     this.status = status;
 }

 // Process the claim
 public void processClaim() {
     this.status = "Processed";
     System.out.println("Claim ID " + claimID + " has been processed.");
 }

 // Display claim information
 public void displayClaim() {
     System.out.println("Claim ID: " + claimID + ", Patient ID: " + patientID +
                        ", Amount: RM " + String.format("%.2f", amount) + ", Status: " + status);
 }
}
