package IBICS;

// Import the other group's Patient class
import ShareGroup.Patient;

public class Patient extends ShareGroup.Patient {
    private int id;
    private String email;
    private InsuranceProvider insuranceProvider;
    private Treatment[] treatments;
    private int treatmentCount;
    private static final int MAX_TREATMENTS = 10;

    // Constructor
    public Patient(int id, String name, String email, int age, String patientID, InsuranceProvider insuranceProvider) {
        super(name, age, patientID); // Initialize the OtherGroup.Patient fields
        this.id = id;
        this.email = email;
        this.insuranceProvider = insuranceProvider;
        this.treatments = new Treatment[MAX_TREATMENTS];
        this.treatmentCount = 0;
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public InsuranceProvider getInsuranceProvider() {
        return insuranceProvider;
    }

    // Setter Methods
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInsuranceProvider(InsuranceProvider insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    // Add Treatment
    public void addTreatment(Treatment treatment) {
        if (treatmentCount < MAX_TREATMENTS) {
            treatments[treatmentCount++] = treatment;
            System.out.println("Treatment added to patient successfully.");
        } else {
            System.out.println("Treatment list is full for this patient.");
        }
    }

    // Calculate Total Owed
    public double calculateTotalOwed() {
        double total = 0.0;
        for (int i = 0; i < treatmentCount; i++) {
            total += treatments[i].getCost();
        }
        return total;
    }

    // Override displayInfo to include additional attributes
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display OtherGroup.Patient's information
        System.out.println("ID: " + id + ", Email: " + email);
        System.out.println("Insurance Provider: " + insuranceProvider.getName());
        if (treatmentCount > 0) {
            System.out.println("Treatments:");
            for (int i = 0; i < treatmentCount; i++) {
                System.out.println((i + 1) + ". " + treatments[i].getServiceName() + " (RM " + String.format("%.2f", treatments[i].getCost()) + ")");
            }
        } else {
            System.out.println("No treatments assigned.");
        }
        System.out.println("Total Amount Owed: RM " + String.format("%.2f", calculateTotalOwed()));
    }
}
