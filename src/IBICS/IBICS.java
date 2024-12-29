package IBICS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IBICS {
 private List<Patient> patients;
 private List<InsuranceProvider> insuranceProviders;
 private List<Claim> claims;
 private List<Bill> bills;

 public IBICS() {
     patients = new ArrayList<>();
     insuranceProviders = new ArrayList<>();
     claims = new ArrayList<>();
     bills = new ArrayList<>();
 }

 // --- Patient Operations ---

 public void addPatient(Patient patient) {
     patients.add(patient);
     System.out.println("Patient added successfully.");
 }

 public void removePatient(int patientID) {
     boolean removed = patients.removeIf(p -> p.getId() == patientID);
     if (removed) {
         System.out.println("Patient removed successfully.");
     } else {
         System.out.println("Patient not found.");
     }
 }

 public Patient searchPatient(int patientID) {
     for (Patient p : patients) {
         if (p.getId() == patientID) {
             return p;
         }
     }
     return null;
 }

 public void updatePatient(int patientID, String newName, String newContactInfo) {
     Patient patient = searchPatient(patientID);
     if (patient != null) {
         patient.setName(newName);
         patient.setContactInfo(newContactInfo);
         System.out.println("Patient updated successfully.");
     } else {
         System.out.println("Patient not found.");
     }
 }

 public void displayAllPatients() {
     if (patients.isEmpty()) {
         System.out.println("No patients to display.");
         return;
     }
     for (Patient p : patients) {
         System.out.println(p);
     }
 }

 // --- Insurance Provider Operations ---

 public void addInsuranceProvider(InsuranceProvider provider) {
     insuranceProviders.add(provider);
     System.out.println("Insurance Provider added successfully.");
 }

 public InsuranceProvider searchInsuranceProvider(int providerID) {
     for (InsuranceProvider ip : insuranceProviders) {
         if (ip.getId() == providerID) {
             return ip;
         }
     }
     return null;
 }

 public void displayAllInsuranceProviders() {
     if (insuranceProviders.isEmpty()) {
         System.out.println("No insurance providers to display.");
         return;
     }
     for (InsuranceProvider ip : insuranceProviders) {
         System.out.println("InsuranceProvider ID: " + ip.getId() + ", Name: " + ip.getName() +
                            ", Contact: " + ip.getContactInfo());
     }
 }

 // --- Claim Operations ---

 public void submitClaim(Claim claim) {
     claims.add(claim);
     InsuranceProvider provider = null;
     Patient patient = searchPatient(claim.getPatientID());
     if (patient != null) {
         provider = patient.getInsuranceProvider();
     }
     if (provider != null && provider.submitClaim(claim)) {
         System.out.println("Claim submitted successfully.");
     } else {
         System.out.println("Failed to submit claim.");
     }
 }

 public void processClaim(int claimID) {
     for (Claim c : claims) {
         if (c.getClaimID() == claimID) {
             c.process();
             return;
         }
     }
     System.out.println("Claim not found.");
 }

 public void displayAllClaims() {
     if (claims.isEmpty()) {
         System.out.println("No claims to display.");
         return;
     }
     for (Claim c : claims) {
         System.out.println(c);
     }
 }

 // --- Bill Operations ---

 public void generateBill(int patientID) {
     Patient patient = searchPatient(patientID);
     if (patient == null) {
         System.out.println("Patient not found.");
         return;
     }
     Bill bill = new Bill(patientID);
     if (bill.generate(patient)) {
         bills.add(bill);
         System.out.println(bill.viewDetails());
     }
 }

 public void displayAllBills() {
     if (bills.isEmpty()) {
         System.out.println("No bills to display.");
         return;
     }
     for (Bill b : bills) {
         System.out.println(b);
     }
 }

 // --- Additional Functionalities ---

 // Example: Calculate total charges for a patient
 public double calculateTotalCharges(int patientID) {
     Patient patient = searchPatient(patientID);
     if (patient == null) {
         System.out.println("Patient not found.");
         return 0.0;
     }
     double total = 0.0;
     for (Treatment t : patient.getTreatments()) {
         total += t.getTreatmentCost();
     }
     return total;
 }

 // --- Main Menu Interface ---

 public void start() {
     Scanner scanner = new Scanner(System.in);
     int choice = -1;

     while (choice != 0) {
         System.out.println("\n=== IBICS Management System ===");
         System.out.println("1. Add Patient");
         System.out.println("2. Remove Patient");
         System.out.println("3. Search Patient");
         System.out.println("4. Update Patient");
         System.out.println("5. Display All Patients");
         System.out.println("6. Add Insurance Provider");
         System.out.println("7. Display All Insurance Providers");
         System.out.println("8. Submit Claim");
         System.out.println("9. Process Claim");
         System.out.println("10. Display All Claims");
         System.out.println("11. Generate Bill for Patient");
         System.out.println("12. Display All Bills");
         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");

         // Input Validation
         if (scanner.hasNextInt()) {
             choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline
         } else {
             System.out.println("Invalid input. Please enter a number.");
             scanner.nextLine(); // Consume invalid input
             continue;
         }

         switch (choice) {
             case 1:
                 addPatientUI(scanner);
                 break;
             case 2:
                 removePatientUI(scanner);
                 break;
             case 3:
                 searchPatientUI(scanner);
                 break;
             case 4:
                 updatePatientUI(scanner);
                 break;
             case 5:
                 displayAllPatients();
                 break;
             case 6:
                 addInsuranceProviderUI(scanner);
                 break;
             case 7:
                 displayAllInsuranceProviders();
                 break;
             case 8:
                 submitClaimUI(scanner);
                 break;
             case 9:
                 processClaimUI(scanner);
                 break;
             case 10:
                 displayAllClaims();
                 break;
             case 11:
                 generateBillUI(scanner);
                 break;
             case 12:
                 displayAllBills();
                 break;
             case 0:
                 System.out.println("Exiting IBICS Management System. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please select a valid option.");
         }
     }

     scanner.close();
 }

 // --- User Interface Methods ---

 private void addPatientUI(Scanner scanner) {
     try {
         System.out.print("Enter Patient ID: ");
         int id = Integer.parseInt(scanner.nextLine());

         // Check if patient ID already exists
         if (searchPatient(id) != null) {
             System.out.println("Patient ID already exists.");
             return;
         }

         System.out.print("Enter Patient Name: ");
         String name = scanner.nextLine();

         System.out.print("Enter Contact Info: ");
         String contact = scanner.nextLine();

         System.out.print("Enter Insurance Provider ID: ");
         int providerID = Integer.parseInt(scanner.nextLine());
         InsuranceProvider provider = searchInsuranceProvider(providerID);
         if (provider == null) {
             System.out.println("Insurance Provider not found. Please add the provider first.");
             return;
         }

         Patient patient = new Patient(id, name, contact, provider);
         patients.add(patient);
         System.out.println("Patient added successfully.");
     } catch (NumberFormatException e) {
         System.out.println("Invalid input format. Please enter numeric values where required.");
     }
 }

 private void removePatientUI(Scanner scanner) {
     try {
         System.out.print("Enter Patient ID to remove: ");
         int id = Integer.parseInt(scanner.nextLine());
         removePatient(id);
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid Patient ID.");
     }
 }

 private void searchPatientUI(Scanner scanner) {
     try {
         System.out.print("Enter Patient ID to search: ");
         int id = Integer.parseInt(scanner.nextLine());
         Patient patient = searchPatient(id);
         if (patient != null) {
             System.out.println(patient);
         } else {
             System.out.println("Patient not found.");
         }
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid Patient ID.");
     }
 }

 private void updatePatientUI(Scanner scanner) {
     try {
         System.out.print("Enter Patient ID to update: ");
         int id = Integer.parseInt(scanner.nextLine());
         Patient patient = searchPatient(id);
         if (patient == null) {
             System.out.println("Patient not found.");
             return;
         }

         System.out.print("Enter new name (leave blank to keep current): ");
         String name = scanner.nextLine();
         if (!name.trim().isEmpty()) {
             patient.setName(name);
         }

         System.out.print("Enter new contact info (leave blank to keep current): ");
         String contact = scanner.nextLine();
         if (!contact.trim().isEmpty()) {
             patient.setContactInfo(contact);
         }

         System.out.println("Patient updated successfully.");
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid Patient ID.");
     }
 }

 private void addInsuranceProviderUI(Scanner scanner) {
     try {
         System.out.print("Enter Insurance Provider ID: ");
         int id = Integer.parseInt(scanner.nextLine());

         // Check if provider ID already exists
         if (searchInsuranceProvider(id) != null) {
             System.out.println("Insurance Provider ID already exists.");
             return;
         }

         System.out.print("Enter Provider Name: ");
         String name = scanner.nextLine();

         System.out.print("Enter Contact Info: ");
         String contact = scanner.nextLine();

         System.out.print("Enter API Endpoint: ");
         String apiEndpoint = scanner.nextLine();

         InsuranceProvider provider = new InsuranceProvider(id, name, contact, apiEndpoint);
         insuranceProviders.add(provider);
         System.out.println("Insurance Provider added successfully.");
     } catch (NumberFormatException e) {
         System.out.println("Invalid input format. Please enter numeric values where required.");
     }
 }

 private void submitClaimUI(Scanner scanner) {
     try {
         System.out.print("Enter Claim ID: ");
         // Claim ID is auto-generated, so skip user input

         System.out.print("Enter Patient ID: ");
         int patientID = Integer.parseInt(scanner.nextLine());

         Patient patient = searchPatient(patientID);
         if (patient == null) {
             System.out.println("Patient not found.");
             return;
         }

         System.out.print("Enter Claim Amount: ");
         double amount = Double.parseDouble(scanner.nextLine());

         Claim claim = new Claim(patientID, amount);
         submitClaim(claim);
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter numeric values where required.");
     }
 }

 private void processClaimUI(Scanner scanner) {
     try {
         System.out.print("Enter Claim ID to process: ");
         int claimID = Integer.parseInt(scanner.nextLine());
         processClaim(claimID);
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid Claim ID.");
     }
 }

 private void generateBillUI(Scanner scanner) {
     try {
         System.out.print("Enter Patient ID to generate bill: ");
         int patientID = Integer.parseInt(scanner.nextLine());
         generateBill(patientID);
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid Patient ID.");
     }
 }
}

