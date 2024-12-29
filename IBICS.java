package IBICS;
import java.util.Scanner;

public class IBICS {
    private Patient[] patients;
    private InsuranceProvider[] insuranceProviders;
    private Treatment[] treatments;
    private Claim[] claims;
    private Bill[] bills;

    private int patientCount;
    private int insuranceProviderCount;
    private int treatmentCount;
    private int claimCount;
    private int billCount;

    // Maximum capacities
    private static final int MAX_PATIENTS = 100;
    private static final int MAX_INSURANCE_PROVIDERS = 50;
    private static final int MAX_TREATMENTS = 100;
    private static final int MAX_CLAIMS = 200;
    private static final int MAX_BILLS = 200;

    // Constructor
    public IBICS() {
        patients = new Patient[MAX_PATIENTS];
        insuranceProviders = new InsuranceProvider[MAX_INSURANCE_PROVIDERS];
        treatments = new Treatment[MAX_TREATMENTS];
        claims = new Claim[MAX_CLAIMS];
        bills = new Bill[MAX_BILLS];

        patientCount = 0;
        insuranceProviderCount = 0;
        treatmentCount = 0;
        claimCount = 0;
        billCount = 0;
    }

    // Add Insurance Provider
    public void addInsuranceProvider(InsuranceProvider provider) {
        if (insuranceProviderCount < MAX_INSURANCE_PROVIDERS) {
            insuranceProviders[insuranceProviderCount++] = provider;
            System.out.println("Insurance provider added successfully.");
        } else {
            System.out.println("Insurance provider list is full.");
        }
    }

    // Search Insurance Provider by ID
    public InsuranceProvider searchInsuranceProvider(int id) {
        for (int i = 0; i < insuranceProviderCount; i++) {
            if (insuranceProviders[i].getId() == id) {
                return insuranceProviders[i];
            }
        }
        return null;
    }

    // Add Patient
    public void addPatient(Patient patient) {
        if (patientCount < MAX_PATIENTS) {
            patients[patientCount++] = patient;
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Patient list is full.");
        }
    }

    // Search Patient by ID
    public Patient searchPatient(int id) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == id) {
                return patients[i];
            }
        }
        return null;
    }

    // Add Treatment
    public void addTreatment(Treatment treatment) {
        if (treatmentCount < MAX_TREATMENTS) {
            treatments[treatmentCount++] = treatment;
            System.out.println("Treatment added successfully.");
        } else {
            System.out.println("Treatment list is full.");
        }
    }

    // Display All Treatments
    public void displayAllTreatments() {
        if (treatmentCount == 0) {
            System.out.println("No treatments to display.");
            return;
        }
        System.out.println("\n----- List of Treatments -----");
        for (int i = 0; i < treatmentCount; i++) {
            System.out.print((i + 1) + ". ");
            treatments[i].displayTreatment();
        }
        System.out.println("------------------------------\n");
    }

    // Assign Treatment to Patient
    public void assignTreatmentToPatient(int patientID, int treatmentIndex) {
        Patient patient = searchPatient(patientID);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        if (treatmentIndex < 1 || treatmentIndex > treatmentCount) {
            System.out.println("Invalid treatment selection.");
            return;
        }
        Treatment treatment = treatments[treatmentIndex - 1];
        patient.addTreatment(treatment);
        System.out.println("Treatment assigned successfully.");
    }

    // Submit Claim
    public void submitClaim(Claim claim) {
        if (claimCount < MAX_CLAIMS) {
            claims[claimCount++] = claim;
            System.out.println("Claim submitted successfully. Claim ID: " + claim.getClaimID());
        } else {
            System.out.println("Claim list is full.");
        }
    }

    // Process Claim
    public void processClaim(int claimID) {
        for (int i = 0; i < claimCount; i++) {
            if (claims[i].getClaimID() == claimID) {
                if (!claims[i].getStatus().equalsIgnoreCase("Processed")) {
                    claims[i].processClaim();
                    System.out.println("Claim ID " + claimID + " has been processed.");
                } else {
                    System.out.println("Claim ID " + claimID + " is already processed.");
                }
                return;
            }
        }
        System.out.println("Claim ID not found.");
    }

    // Add Bill
    public void addBill(Bill bill) {
        if (billCount < MAX_BILLS) {
            bills[billCount++] = bill;
            System.out.println("Bill generated successfully. Bill ID: " + bill.getBillID());
        } else {
            System.out.println("Bill list is full.");
        }
    }

    // Display Welcome Screen
    private void displayWelcomeScreen() {
        System.out.println("==========================================");
        System.out.println("   Welcome to the IBICS Management System  ");
        System.out.println("==========================================");
        System.out.println("              Insurance Billing           ");
        System.out.println();
        System.out.println("Press Enter to start the IBICS system...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Display Menu
    public void displayMenu() {
        System.out.println("=== IBICS Management System ===");
        System.out.println("--------------------------------");
        System.out.println("1. Add Insurance Provider");
        System.out.println("2. Add Treatment");
        System.out.println("3. Add Patient");
        System.out.println("4. Assign Treatment to Patient");
        System.out.println("5. Display All Treatments");
        System.out.println("6. Search Patient");
        System.out.println("7. Submit Claim");
        System.out.println("8. Process Claim");
        System.out.println("9. Generate Bill");
        System.out.println("10. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please select an option (1-10): ");
    }

    // Helper method to check if a string is numeric (integer)
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Helper method to check if a string is a valid double
    private boolean isDouble(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    // Run the system
    public void run() {
        displayWelcomeScreen();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            displayMenu();
            String input = scanner.nextLine();
            if (!isNumeric(input)) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                continue;
            }
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    // Add Insurance Provider
                    System.out.println("\n--- Add Insurance Provider ---");
                    System.out.print("Enter Insurance Provider ID: ");
                    String providerIDInput = scanner.nextLine();
                    if (!isNumeric(providerIDInput)) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                        break;
                    }
                    int providerID = Integer.parseInt(providerIDInput);
                    if (searchInsuranceProvider(providerID) != null) {
                        System.out.println("Insurance Provider with this ID already exists.");
                        break;
                    }
                    System.out.print("Enter Insurance Provider Name: ");
                    String providerName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String providerEmail = scanner.nextLine();
                    InsuranceProvider provider = new InsuranceProvider(providerID, providerName, providerEmail);
                    addInsuranceProvider(provider);
                    break;
                case 2:
                    // Add Treatment
                    System.out.println("\n--- Add Treatment ---");
                    System.out.print("Enter Service Name: ");
                    String serviceName = scanner.nextLine();
                    System.out.print("Enter Cost: RM ");
                    String costInput = scanner.nextLine();
                    if (isDouble(costInput)) {
                        double cost = Double.parseDouble(costInput);
                        Treatment treatment = new Treatment(serviceName, cost);
                        addTreatment(treatment);
                    } else {
                        System.out.println("Invalid cost. Please enter a valid number.");
                    }
                    break;
                case 3:
                    // Add Patient
                    System.out.println("\n--- Add Patient ---");
                    System.out.print("Enter Patient ID: ");
                    String patientIDInput = scanner.nextLine();
                    if (!isNumeric(patientIDInput)) {
                        System.out.println("Invalid Patient ID. Please enter a valid number.");
                        break;
                    }
                    int patientID = Integer.parseInt(patientIDInput);
                    if (searchPatient(patientID) != null) {
                        System.out.println("Patient with this ID already exists.");
                        break;
                    }
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String patientEmail = scanner.nextLine();
                    System.out.print("Enter Insurance Provider ID: ");
                    String pProviderIDInput = scanner.nextLine();
                    if (!isNumeric(pProviderIDInput)) {
                        System.out.println("Invalid Insurance Provider ID. Please enter a valid number.");
                        break;
                    }
                    int pProviderID = Integer.parseInt(pProviderIDInput);
                    InsuranceProvider pProvider = searchInsuranceProvider(pProviderID);
                    if (pProvider == null) {
                        System.out.println("Insurance Provider not found. Please add the provider first.");
                        break;
                    }
                    Patient patient = new Patient(patientID, patientName, patientEmail, pProvider);
                    addPatient(patient);
                    break;
                case 4:
                    // Assign Treatment to Patient
                    System.out.println("\n--- Assign Treatment to Patient ---");
                    System.out.print("Enter Patient ID: ");
                    String aPatientIDInput = scanner.nextLine();
                    if (!isNumeric(aPatientIDInput)) {
                        System.out.println("Invalid Patient ID. Please enter a valid number.");
                        break;
                    }
                    int aPatientID = Integer.parseInt(aPatientIDInput);
                    Patient aPatient = searchPatient(aPatientID);
                    if (aPatient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    if (treatmentCount == 0) {
                        System.out.println("No treatments available to assign.");
                        break;
                    }
                    System.out.println("\nAvailable Treatments:");
                    for (int i = 0; i < treatmentCount; i++) {
                        System.out.println((i + 1) + ". " + treatments[i].getServiceName() + " (RM " + String.format("%.2f", treatments[i].getCost()) + ")");
                    }
                    System.out.print("Select Treatment Number to assign: ");
                    String tIndexInput = scanner.nextLine();
                    if (!isNumeric(tIndexInput)) {
                        System.out.println("Invalid selection. Please enter a valid number.");
                        break;
                    }
                    int tIndex = Integer.parseInt(tIndexInput);
                    assignTreatmentToPatient(aPatientID, tIndex);
                    break;
                case 5:
                    // Display All Treatments
                    displayAllTreatments();
                    break;
                case 6:
                    // Search Patient
                    System.out.println("\n--- Search Patient ---");
                    System.out.print("Enter Patient ID: ");
                    String sPatientIDInput = scanner.nextLine();
                    if (!isNumeric(sPatientIDInput)) {
                        System.out.println("Invalid Patient ID. Please enter a valid number.");
                        break;
                    }
                    int sPatientID = Integer.parseInt(sPatientIDInput);
                    Patient sPatient = searchPatient(sPatientID);
                    if (sPatient != null) {
                        System.out.println("\n--- Patient Information ---");
                        sPatient.displayInfo();
                        System.out.println("----------------------------\n");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 7:
                    // Submit Claim
                    System.out.println("\n--- Submit Claim ---");
                    System.out.print("Enter Patient ID: ");
                    String cPatientIDInput = scanner.nextLine();
                    if (!isNumeric(cPatientIDInput)) {
                        System.out.println("Invalid Patient ID. Please enter a valid number.");
                        break;
                    }
                    int cPatientID = Integer.parseInt(cPatientIDInput);
                    Patient cPatient = searchPatient(cPatientID);
                    if (cPatient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    System.out.print("Enter Claim Amount: RM ");
                    String amountInput = scanner.nextLine();
                    if (isDouble(amountInput)) {
                        double amount = Double.parseDouble(amountInput);
                        Claim claim = new Claim(cPatientID, amount);
                        submitClaim(claim);
                    } else {
                        System.out.println("Invalid claim amount. Please enter a valid number.");
                    }
                    break;
                case 8:
                    // Process Claim
                    System.out.println("\n--- Process Claim ---");
                    System.out.print("Enter Claim ID: ");
                    String pClaimIDInput = scanner.nextLine();
                    if (!isNumeric(pClaimIDInput)) {
                        System.out.println("Invalid Claim ID. Please enter a valid number.");
                        break;
                    }
                    int pClaimID = Integer.parseInt(pClaimIDInput);
                    processClaim(pClaimID);
                    break;
                case 9:
                    // Generate Bill
                    System.out.println("\n--- Generate Bill ---");
                    System.out.print("Enter Patient ID: ");
                    String bPatientIDInput = scanner.nextLine();
                    if (!isNumeric(bPatientIDInput)) {
                        System.out.println("Invalid Patient ID. Please enter a valid number.");
                        break;
                    }
                    int bPatientID = Integer.parseInt(bPatientIDInput);
                    Patient bPatient = searchPatient(bPatientID);
                    if (bPatient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    double subtotal = bPatient.calculateTotalOwed();
                    double tax = subtotal * 0.06;
                    Bill bill = new Bill(bPatientID, subtotal, tax);
                    addBill(bill);
                    bill.displayBill();
                    break;
                case 10:
                    // Exit
                    System.out.println("\nExiting IBICS Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-10).");
            }
        }
    }
}
