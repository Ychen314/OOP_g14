package IBICS;

public class Bill {
    private static int billCounter = 5000;
    private int billID;
    private int patientID;
    private double subtotal;
    private double tax;
    private double totalAmount;
    private String status;

    // Constructor
    public Bill(int patientID, double subtotal, double tax) {
        this.billID = billCounter++;
        this.patientID = patientID;
        this.subtotal = subtotal;
        this.tax = tax;
        this.totalAmount = subtotal + tax;
        this.status = "Unpaid";
    }

    // Accessors
    public int getBillID() {
        return billID;
    }

    public int getPatientID() {
        return patientID;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    // Mutator
    public void setStatus(String status) {
        this.status = status;
    }

    // Display bill information
    public void displayBill() {
        System.out.println("\n--- Bill Information ---");
        System.out.println("Bill ID: " + billID);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Subtotal: RM " + String.format("%.2f", subtotal));
        System.out.println("Service Tax (6%): RM " + String.format("%.2f", tax));
        System.out.println("Total Amount: RM " + String.format("%.2f", totalAmount));
        System.out.println("Status: " + status);
        System.out.println("------------------------\n");
    }
}
