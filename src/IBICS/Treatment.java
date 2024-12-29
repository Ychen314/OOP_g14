package IBICS;

//Treatment.java
public class Treatment {
 private String treatmentName;
 private double treatmentCost;

 public Treatment(String treatmentName, double treatmentCost) {
     this.treatmentName = treatmentName;
     this.treatmentCost = treatmentCost;
 }

 // Getters and Setters
 public String getTreatmentName() {
     return treatmentName;
 }

 public double getTreatmentCost() {
     return treatmentCost;
 }

 public void setTreatmentName(String treatmentName) {
     this.treatmentName = treatmentName;
 }

 public void setTreatmentCost(double treatmentCost) {
     this.treatmentCost = treatmentCost;
 }

 @Override
 public String toString() {
     return treatmentName + " ($" + treatmentCost + ")";
 }
}

