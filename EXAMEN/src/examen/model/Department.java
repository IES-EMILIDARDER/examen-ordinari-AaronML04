package EXAMEN.model;

public class Department {
    private int departmentId;
    private String name;
    
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
     // Getters
    public int getId() { 
        return departmentId; }
    
    public String getName() { 
        return name; } 
}
