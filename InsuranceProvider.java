package IBICS;

public class InsuranceProvider {
    private int id;
    private String name;
    private String email;

    public InsuranceProvider(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    // Display insurance provider information
    public void displayInsuranceProvider() {
        System.out.println("\n--- Insurance Provider Information ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("--------------------------------------\n");
    }
}
