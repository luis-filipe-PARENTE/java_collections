package collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MapProgram {

    public static void main(String[] args) {

    	Map<String, String> languages = new HashMap<>();
    	
    	languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        // languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        // languages.put("Lisp", "Therein lies madness");
        
        // System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));
        
        languages.computeIfAbsent("BASIC", k -> "Beginners All Purposes Symbolic Instruction Code " + k);
        
        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }
        
        
        Iterator<Map.Entry<String, String>> iterator = languages.entrySet().iterator();
                
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
    	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

        
        // Java 8
        languages.forEach((k, v) -> System.out.println((k + ":" + v)));
        
        languages.entrySet().stream()
        	.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
        
    	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

        for(String key : languages.keySet()) {
        	System.out.println(key + " : " + languages.get(key));
        }
        
        
        // remove and replace
        System.out.println("=== REMOVING BY KEY ===");
        System.out.println(languages.remove("Java"));
     	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

        System.out.println("=== REMOVING BY KEY AND VALUE (WRONG VALUE) ===");
        System.out.println(languages.remove("Python", "test 123")); // wrong value
     	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

     	System.out.println("=== REMOVING BY KEY AND VALUE (RIGHT VALUE) ===");
        System.out.println(languages.remove("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics")); // right value
       	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

       	
        System.out.println("=== REPLACE BY KEY ===");
        // System.out.println(languages.replace("Algol", "I love java")); // OK
        // System.out.println(languages.replace("Algol",  "an algorithmic language", "I love java")); // OK
        System.out.println(languages.replace("Algol",  "an algorithmic language 123", "I love java")); // KO
        iteratMap(languages);
        
        System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================\n");

    }
    
    private static void iteratMap(Map<? ,?> theMap) {
        for(Object key : theMap.keySet()) {
        	System.out.println(key + " : " + theMap.get(key));
        }
    }
}
