package IBICS;

public class Patient {
    private int id;
    private String name;
    private String email;
    private InsuranceProvider insuranceProvider;
    private Treatment[] treatments;
    private int treatmentCount;
    private static final int MAX_TREATMENTS = 10;

    public Patient(int id, String name, String email, InsuranceProvider insuranceProvider) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.insuranceProvider = insuranceProvider;
        this.treatments = new Treatment[MAX_TREATMENTS];
        this.treatmentCount = 0;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addTreatment(Treatment treatment) {
        if (treatmentCount < MAX_TREATMENTS) {
            treatments[treatmentCount++] = treatment;
            System.out.println("Treatment added to patient successfully.");
        } else {
            System.out.println("Treatment list is full for this patient.");
        }
    }

    public double calculateTotalOwed() {
        double total = 0.0;
        for (int i = 0; i < treatmentCount; i++) {
            total += treatments[i].getCost();
        }
        return total;
    }

    public void displayInfo() {
    	System.out.println("\n--- Patient Information ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
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
