package EXAMEN.model;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
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
        return firstName + lastName; 
    }

    public Department getDepartment() {
        return department;
    }
    
    public String getEmail() { 
        return email; 
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", department=" + department + '}';
    }

    
    @Override
    public String compareTo(Employee o) {
       return this.email.compareTo(o.email);
    }
    
    
}
