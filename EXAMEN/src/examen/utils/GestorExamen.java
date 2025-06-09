package examen.utils;

import EXAMEN.model.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GestorExamen {
    private Set<Department> departments = new HashSet<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Map<Department, List<Employee>> departmentsXemployees = new HashMap<>();
    
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);

    public void carregaDades()  throws SQLException {
        /* 1. Carregar les estructures:
            'departments'
            'empleats'
            (1,50 punts) Map<Department, List<Employee>> departmentsXempleats;
         */
        
            List<Department> departments = Arrays.asList(
            new Department(30, "Purchasing"),
            new Department(10, "Administration"),
            new Department(40, "Human Resources"),
            new Department(20, "Marketing")
            );
            
            List<Employee> employees = Arrays.asList(
            new Employee("Susan", "Baida", "sbaida@abc.com", departments.get(0)),
            new Employee("Kevin", "Colmenares", "kcolmenares@abc.com", departments.get(0)),
            new Employee("Gerald", "Himuro", "ghimuro@abc.com", departments.get(0)),
            new Employee("Alexander", "Khoo", "akhoo@abc.com", departments.get(0)),
            new Employee("Den", "Raphaely", "draphaely@abc.com", departments.get(0)),
            new Employee("Steven", "Tobias", "stobias@abc.com", departments.get(0)),
            new Employee("Jennifer", "Whalen", "jwhalen@abc.com", departments.get(0)),
            new Employee("Pat", "Fay", "pfay@abc.com", departments.get(0)),
            new Employee("Michael", "Hartstein", "mhartstein@abc.com", departments.get(0)),
            new Employee("Susan", "Mavris", "smavris@abc.com", departments.get(0))
            );
        
        
        
        
        
        String sql = """
                     SELECT email, first_name, last_name, e.department_id, department_name
                     FROM departments d, employees e
                     WHERE d.department_id = e.department_id
                     """;
        
    }

    
    public void mostraDepartments() {
        /*
           2. Mostra 'departments'
        */ 
        String sql = """
                     SELECT d.department_id, d.department_name
                     FROM departments d
                     """;
                     
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql, (Integer) 2020 ) ) { 
            
            while (resultSet.next()) 
                departments.add(new Department(
                                          resultSet.getInt("departmentId"),
                                          resultSet.getString("name")));
            
            departments.stream().forEach(System.out::println);
            
        } catch (SQLException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        }
        
        
        List<Department> departmentsOrdenados = departments.stream()
            .sorted(Comparator.comparingInt(Department::getId))
            .collect(Collectors.toList());
        
        
        System.out.println("DEPARTMENT");

    }   

    public void mostraEmployees() {
        /*
           2. Mostra 'employees'
        */
        
        
        
        System.out.println("EMPLOYEE");

    } 
    
    public void mostraDepartmentsXEmployees() {
        /*
           2. Mostra 'departmentsXemployees'
        */
        
        
        System.out.println("DEPARTMENTS X EMPLOYEES");

    } 
    
    public void desaDepartmentsXEmpleatsCSV(String path) {
        /*
           3. Emmagatzema 'departmentsXemployees' en un arxiu .csv amb el següent format:
              #departmentId, name, email1;email2;email3;...;
        */
        path = "c:\\temp\\departmentXEmpleats.csv";
        
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("#departmentId,name,emails\n");
            for (Department dept : departmentsOrdenados) {
                List<String> emails = deptEmails.getOrDefault(dept.getId(), new ArrayList<>());
                String emailString = String.join(";", emails);
                if (!emailString.isEmpty()) emailString += ";";
                writer.write(dept.getId() + "," + dept.getName() + "," + emailString + "\n");
            }
            System.out.println("Fitxer creat correctament.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

