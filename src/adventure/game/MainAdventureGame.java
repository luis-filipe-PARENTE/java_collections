package adventure.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainAdventureGame {
	
	private Map<Integer, Location> locations = new HashMap<Integer, Location>();
	private Map<String, String> vocabulary = new HashMap<String, String>();
	
	public MainAdventureGame() {
		Map<String, Integer> tmpExits = new HashMap<>();
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

		//  1
		tmpExits = new HashMap<>();
		tmpExits.put("W", 2);
		tmpExits.put("E", 3);
		tmpExits.put("S", 4);
		tmpExits.put("N", 5);
		tmpExits.put("Q", 0);
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tmpExits));

		//  2
		tmpExits.put("N", 5);
		tmpExits.put("Q", 0);
		locations.put(2, new Location(2, "You are at the top of a hill", tmpExits));

		//  3
		tmpExits.put("W", 1);
		tmpExits.put("Q", 0);
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tmpExits));

		//  4
		tmpExits.put("N", 1);
		tmpExits.put("W", 2);
		tmpExits.put("Q", 0);
		locations.put(4, new Location(4, "You are in a valley beside a stream", tmpExits));

		//  5
		tmpExits.put("S", 1);
		tmpExits.put("W", 2);
		tmpExits.put("N", 6); // BOOM java.lang.NullPointerException we don't have the location number 6!!!
		tmpExits.put("Q", 0);
		locations.put(5, new Location(5, "You are in the forest", tmpExits));
	}
	
	
    public void command() {
    	Scanner scanner = new Scanner(System.in);
    	
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        
        int loc = 1;

        while(true) {

            System.out.println(locations.get(loc).getDescription());
            
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
                

            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }

}
