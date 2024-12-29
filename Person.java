package IBICS;

public class Person {
 private int id;
 private String name;
 private String email;

 // Constructor
 public Person(int id, String name, String email, int age, String phoneNo) {
     this.id = id;
     this.name = name;
     this.email = email;
 }

 // Accessors (Getters)
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public String getEmail() {
     return email;
 }

 // Mutators (Setters)
 public void setName(String name) {
     this.name = name;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 // Display person information
 public void displayInfo() {
     System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);

 }
}
