package IBICS;

public class Treatment {
 private String serviceName;
 private double cost;

 // Constructor
 public Treatment(String serviceName, double cost) {
     this.serviceName = serviceName;
     this.cost = cost;
 }

 // Accessors
 public String getServiceName() {
     return serviceName;
 }

 public double getCost() {
     return cost;
 }

 // Mutators
 public void setServiceName(String serviceName) {
     this.serviceName = serviceName;
 }

 public void setCost(double cost) {
     this.cost = cost;
 }

 // Display treatment information
 public void displayTreatment() {
     System.out.println("Service Name: " + serviceName + ", Cost: RM " + String.format("%.2f", cost));
 }
}
