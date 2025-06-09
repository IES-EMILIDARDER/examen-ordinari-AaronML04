package EXAMEN.model;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Department department;

    public Employee(String fisrtName, String lastName, String email, Department department) {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    public String getFullName() { 
        return firstName + lastName; }

    public Department getDepartment() {
        return department;
    }
    
    public String getEmail() { 
        return email; }
    
}
