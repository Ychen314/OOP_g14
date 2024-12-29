package IBICS;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
 private InsuranceProvider insuranceProvider;
 private List<Treatment> treatments;

 public Patient(int id, String name, String contactInfo, InsuranceProvider insuranceProvider) {
     super(id, name, contactInfo);
     this.insuranceProvider = insuranceProvider;
     this.treatments = new ArrayList<>();
 }

 public InsuranceProvider getInsuranceProvider() {
     return insuranceProvider;
 }

 public void setInsuranceProvider(InsuranceProvider insuranceProvider) {
     this.insuranceProvider = insuranceProvider;
 }

 public List<Treatment> getTreatments() {
     return treatments;
 }

 public void addTreatment(Treatment treatment) {
     treatments.add(treatment);
 }

 public void removeTreatment(String treatmentName) {
     treatments.removeIf(t -> t.getTreatmentName().equalsIgnoreCase(treatmentName));
 }

 public void viewBillingHistory() {
     System.out.println("Billing History for Patient ID: " + getId());
     // Placeholder for actual billing history
 }

 public InsuranceProvider viewInsuranceDetails() {
     return insuranceProvider;
 }

 @Override
 public String toString() {
     return "Patient ID: " + getId() + ", Name: " + getName() + ", Contact: " + getContactInfo() +
            ", Insurance Provider: " + insuranceProvider.getName();
 }
}

