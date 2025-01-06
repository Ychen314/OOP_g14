package IBICS;

import java.util.Scanner;

public class IBICS {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

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
            System.out.println(GREEN + "Insurance provider added successfully." + RESET);
        } else {
            System.out.println(RED + "Insurance provider list is full." + RESET);
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
            System.out.println(GREEN + "Patient added successfully." + RESET);
        } else {
            System.out.println(RED + "Patient list is full." + RESET);
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
            System.out.println(GREEN + "Treatment added successfully." + RESET);
        } else {
            System.out.println(RED + "Treatment list is full." + RESET);
        }
    }

    // Display All Treatments
    public void displayAllTreatments() {
        if (treatmentCount == 0) {
            System.out.println(YELLOW + "No treatments to display." + RESET);
            return;
        }
        System.out.println(CYAN + "\n----- List of Treatments -----" + RESET);
        for (int i = 0; i < treatmentCount; i++) {
            System.out.print(BLUE + (i + 1) + ". " + RESET);
            treatments[i].displayTreatment();
        }
        System.out.println(CYAN + "------------------------------\n" + RESET);
    }

    // Assign Treatment to Patient
    public void assignTreatmentToPatient(int patientID, int treatmentIndex) {
        Patient patient = searchPatient(patientID);
        if (patient == null) {
            System.out.println(RED + "Patient not found." + RESET);
            return;
        }
        if (treatmentIndex < 1 || treatmentIndex > treatmentCount) {
            System.out.println(RED + "Invalid treatment selection." + RESET);
            return;
        }
        Treatment treatment = treatments[treatmentIndex - 1];
        patient.addTreatment(treatment);
        System.out.println(GREEN + "Treatment assigned successfully." + RESET);
    }

    // Submit Claim
    public void submitClaim(Claim claim) {
        if (claimCount < MAX_CLAIMS) {
            claims[claimCount++] = claim;
            System.out.println(GREEN + "Claim submitted successfully. Claim ID: " + claim.getClaimID() + RESET);
        } else {
            System.out.println(RED + "Claim list is full." + RESET);
        }
    }

    // Process Claim
    public void processClaim(int claimID) {
        for (int i = 0; i < claimCount; i++) {
            if (claims[i].getClaimID() == claimID) {
                if (!claims[i].getStatus().equalsIgnoreCase("Processed")) {
                    claims[i].processClaim();
                    System.out.println(GREEN + "Claim ID " + claimID + " has been processed." + RESET);
                } else {
                    System.out.println(YELLOW + "Claim ID " + claimID + " is already processed." + RESET);
                }
                return;
            }
        }
        System.out.println(RED + "Claim ID not found." + RESET);
    }

    // Add Bill
    public void addBill(Bill bill) {
        if (billCount < MAX_BILLS) {
            bills[billCount++] = bill;
            System.out.println(GREEN + "Bill generated successfully. Bill ID: " + bill.getBillID() + RESET);
        } else {
            System.out.println(RED + "Bill list is full." + RESET);
        }
    }

    // Display Welcome Screen
    private void displayWelcomeScreen() {
        System.out.println(PURPLE + "==========================================");
        System.out.println("   Welcome to the IBICS Management System  ");
        System.out.println("==========================================" + RESET);
        System.out.println(YELLOW + "              Insurance Billing           " + RESET);
        System.out.println();
        System.out.println("Press Enter to start the IBICS system...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Display Menu
    public void displayMenu() {
        System.out.println(GREEN + "=== IBICS Management System ===" + RESET);
        System.out.println("--------------------------------");
        System.out.println(BLUE + "1. Add Insurance Provider" + RESET);
        System.out.println(BLUE + "2. Add Treatment" + RESET);
        System.out.println(BLUE + "3. Add Patient" + RESET);
        System.out.println(BLUE + "4. Assign Treatment to Patient" + RESET);
        System.out.println(BLUE + "5. Display All Treatments" + RESET);
        System.out.println(BLUE + "6. Search Patient" + RESET);
        System.out.println(BLUE + "7. Submit Claim" + RESET);
        System.out.println(BLUE + "8. Process Claim" + RESET);
        System.out.println(BLUE + "9. Generate Bill" + RESET);
        System.out.println(BLUE + "10. Exit" + RESET);
        System.out.println("--------------------------------");
        System.out.print("Please select an option (1-10): ");
    }

    // Helper Method: Check if String is Numeric
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Helper Method: Check if String is a Valid Double
    private boolean isDouble(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    // Run the System
    public void run() {
        displayWelcomeScreen();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            displayMenu();
            String input = scanner.nextLine();
            if (!isNumeric(input)) {
                System.out.println(RED + "Invalid input. Please enter a number between 1 and 10." + RESET);
                continue;
            }
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    // Add Insurance Provider
                    System.out.println(CYAN + "\n--- Add Insurance Provider ---" + RESET);
                    System.out.print("Enter Insurance Provider ID: ");
                    String providerIDInput = scanner.nextLine();
                    if (!isNumeric(providerIDInput)) {
                        System.out.println(RED + "Invalid ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int providerID = Integer.parseInt(providerIDInput);
                    if (searchInsuranceProvider(providerID) != null) {
                        System.out.println(RED + "Insurance Provider with this ID already exists." + RESET);
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
                    System.out.println(CYAN + "\n--- Add Treatment ---" + RESET);
                    System.out.print("Enter Service Name: ");
                    String serviceName = scanner.nextLine();
                    System.out.print("Enter Cost: RM ");
                    String costInput = scanner.nextLine();
                    if (isDouble(costInput)) {
                        double cost = Double.parseDouble(costInput);
                        Treatment treatment = new Treatment(serviceName, cost);
                        addTreatment(treatment);
                    } else {
                        System.out.println(RED + "Invalid cost. Please enter a valid number." + RESET);
                    }
                    break;
                case 3:
                    // Add Patient
                    System.out.println(CYAN + "\n--- Add Patient ---" + RESET);
                    System.out.print("Enter Patient ID: ");
                    String patientIDInput = scanner.nextLine();
                    if (!isNumeric(patientIDInput)) {
                        System.out.println(RED + "Invalid Patient ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int patientID = Integer.parseInt(patientIDInput);
                    if (searchPatient(patientID) != null) {
                        System.out.println(RED + "Patient with this ID already exists." + RESET);
                        break;
                    }
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String patientEmail = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    String ageInput = scanner.nextLine();
                    if (!isNumeric(ageInput)) {
                        System.out.println(RED + "Invalid age. Please enter a valid number." + RESET);
                        break;
                    }
                    int age = Integer.parseInt(ageInput);
                    System.out.print("Enter Patient ID (e.g., P12345): ");
                    String extPatientID = scanner.nextLine();
                    System.out.print("Enter Insurance Provider ID: ");
                    String pProviderIDInput = scanner.nextLine();
                    if (!isNumeric(pProviderIDInput)) {
                        System.out.println(RED + "Invalid Insurance Provider ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int pProviderID = Integer.parseInt(pProviderIDInput);
                    InsuranceProvider pProvider = searchInsuranceProvider(pProviderID);
                    if (pProvider == null) {
                        System.out.println(RED + "Insurance Provider not found. Please add the provider first." + RESET);
                        break;
                    }

                    // Create Patient Object
                    Patient patient = new Patient(patientID, patientName, patientEmail, age, extPatientID, pProvider);
                    addPatient(patient);
                    break;
                case 4:
                    // Assign Treatment to Patient
                    System.out.println(CYAN + "\n--- Assign Treatment to Patient ---" + RESET);
                    System.out.print("Enter Patient ID: ");
                    String aPatientIDInput = scanner.nextLine();
                    if (!isNumeric(aPatientIDInput)) {
                        System.out.println(RED + "Invalid Patient ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int aPatientID = Integer.parseInt(aPatientIDInput);
                    Patient aPatient = searchPatient(aPatientID);
                    if (aPatient == null) {
                        System.out.println(RED + "Patient not found." + RESET);
                        break;
                    }
                    if (treatmentCount == 0) {
                        System.out.println(YELLOW + "No treatments available to assign." + RESET);
                        break;
                    }
                    System.out.println(CYAN + "\nAvailable Treatments:" + RESET);
                    for (int i = 0; i < treatmentCount; i++) {
                        System.out.println(BLUE + (i + 1) + ". " + treatments[i].getServiceName() + " (RM " + String.format("%.2f", treatments[i].getCost()) + ")" + RESET);
                    }
                    System.out.print("Select Treatment Number to assign: ");
                    String tIndexInput = scanner.nextLine();
                    if (!isNumeric(tIndexInput)) {
                        System.out.println(RED + "Invalid selection. Please enter a valid number." + RESET);
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
                    System.out.println(CYAN + "\n--- Search Patient ---" + RESET);
                    System.out.print("Enter Patient ID: ");
                    String sPatientIDInput = scanner.nextLine();
                    if (!isNumeric(sPatientIDInput)) {
                        System.out.println(RED + "Invalid Patient ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int sPatientID = Integer.parseInt(sPatientIDInput);
                    Patient sPatient = searchPatient(sPatientID);
                    if (sPatient != null) {
                        System.out.println(PURPLE + "\n--- Patient Information ---" + RESET);
                        sPatient.displayInfo();
                        System.out.println(PURPLE + "----------------------------\n" + RESET);
                    } else {
                        System.out.println(RED + "Patient not found." + RESET);
                    }
                    break;
                case 7:
                    // Submit Claim
                    System.out.println(CYAN + "\n--- Submit Claim ---" + RESET);
                    System.out.print("Enter Patient ID: ");
                    String cPatientIDInput = scanner.nextLine();
                    if (!isNumeric(cPatientIDInput)) {
                        System.out.println(RED + "Invalid Patient ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int cPatientID = Integer.parseInt(cPatientIDInput);
                    Patient cPatient = searchPatient(cPatientID);
                    if (cPatient == null) {
                        System.out.println(RED + "Patient not found." + RESET);
                        break;
                    }
                    System.out.print("Enter Claim Amount: RM ");
                    String amountInput = scanner.nextLine();
                    if (isDouble(amountInput)) {
                        double amount = Double.parseDouble(amountInput);
                        Claim claim = new Claim(cPatientID, amount);
                        submitClaim(claim);
                    } else {
                        System.out.println(RED + "Invalid claim amount. Please enter a valid number." + RESET);
                    }
                    break;
                case 8:
                    // Process Claim
                    System.out.println(CYAN + "\n--- Process Claim ---" + RESET);
                    System.out.print("Enter Claim ID: ");
                    String pClaimIDInput = scanner.nextLine();
                    if (!isNumeric(pClaimIDInput)) {
                        System.out.println(RED + "Invalid Claim ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int pClaimID = Integer.parseInt(pClaimIDInput);
                    processClaim(pClaimID);
                    break;
                case 9:
                    // Generate Bill
                    System.out.println(CYAN + "\n--- Generate Bill ---" + RESET);
                    System.out.print("Enter Patient ID: ");
                    String bPatientIDInput = scanner.nextLine();
                    if (!isNumeric(bPatientIDInput)) {
                        System.out.println(RED + "Invalid Patient ID. Please enter a valid number." + RESET);
                        break;
                    }
                    int bPatientID = Integer.parseInt(bPatientIDInput);
                    Patient bPatient = searchPatient(bPatientID);
                    if (bPatient == null) {
                        System.out.println(RED + "Patient not found." + RESET);
                        break;
                    }
                    double subtotal = bPatient.calculateTotalOwed();
                    double tax = subtotal * 0.06;
                    Bill bill = new Bill(bPatientID, subtotal, tax);
                    addBill(bill);
                    bill.displayBill();
                    break;
                case 10:
                    // Exit System
                    System.out.println(GREEN + "\nExiting IBICS Management System. Goodbye!" + RESET);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Please select a valid option (1-10)." + RESET);
            }
        }
    }
}
