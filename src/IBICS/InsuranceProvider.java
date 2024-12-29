package IBICS;
//InsuranceProvider.java

public class InsuranceProvider extends Person {
 private String apiEndpoint;

 public InsuranceProvider(int id, String name, String contactInfo, String apiEndpoint) {
     super(id, name, contactInfo);
     this.apiEndpoint = apiEndpoint;
 }

 public String getApiEndpoint() {
     return apiEndpoint;
 }

 public void setApiEndpoint(String apiEndpoint) {
     this.apiEndpoint = apiEndpoint;
 }

 // Validate coverage for a patient
 public boolean validateCoverage(int patientID) {
     // Placeholder for actual validation logic
     System.out.println("Validating coverage for Patient ID: " + patientID);
     return true; // Assume always valid for simplicity
 }

 // Submit a claim to the insurance provider
 public boolean submitClaim(Claim claim) {
     // Placeholder for actual submission logic
     System.out.println("Submitting Claim ID: " + claim.getClaimID() + " to " + getName());
     return true; // Assume submission is successful
 }
}

