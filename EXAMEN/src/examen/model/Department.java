package EXAMEN.model;

public class Department implements Comparable<Department>{
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
    
    
    public int getId() { 
        return departmentId; 
    }
    
    public String getName() { 
        return name; 
    } 

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public int compareTo(Department d) {
        if (this.departmentId > d.departmentId) return 1;
        else if (this.departmentId < d.departmentId) return -1;
        else return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.departmentId;
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
        final Department other = (Department) obj;
        return this.departmentId == other.departmentId;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", name=" + name + '}';
    }
    
    
}
