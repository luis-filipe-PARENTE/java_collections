package hashcode.and.equals;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
    public static void main(String[] args) {
    	// equalsTestSample1();
    	equalsTestSample2();
    }
    
    private static void equalsTestSample1() {
    	
        Employee e1 = new Employee();
        Employee e2 = new Employee();
 
        e1.setId(100);
        e2.setId(100);
 
        System.out.println(e1.equals(e2));  //false
    }
    
    private static void equalsTestSample2() {
    	
        Employee e1 = new Employee();
        Employee e2 = new Employee();
 
        e1.setId(100);
        e2.setId(100);
    	
    	Set<Employee> employees = new HashSet<Employee>();
    	employees.add(e1);
    	employees.add(e2);
    	
    	System.out.println(employees);  //Prints two objects
    }
    
    

}
