package collections.one;

//Java program to demonstrate working of Collections.
//binarySearch()
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class GFG {

	public static void main(String[] args) {
		sample2();
	}

	private static void sample1() {
		System.out.println("--start----------- sample 1 ---------------------------");

		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(10);
		al.add(20);

		// 10 is present at index 3.
		int index = Collections.binarySearch(al, 10);
		System.out.println(index);

		// 13 is not present. 13 would have been inserted
		// at position 4. So the function returns (-4-1)
		// which is -5.
		index = Collections.binarySearch(al, 13);

		System.out.println(index);
		System.out.println("--end----------- sample 1 ---------------------------");
	}

	private static void sample2() {
		System.out.println("--start----------- sample 2 ---------------------------");

		List<Integer> al = new ArrayList<Integer>();

		al.add(30);
		al.add(50);
		al.add(8);
		al.add(10);
		al.add(2);
		al.add(100);

		Collections.sort(al);
		al.forEach(System.out::println);
		
		Comparator<Integer> comparator = (a1, a2) -> new Integer(a1).compareTo(new Integer(a2));
		
		// int index = Collections.binarySearch(al, 50, comparator);
		int index = Collections.binarySearch(al, 50, null);

		System.out.println("Found at index " + index);
		System.out.println("--end----------- sample 2 ---------------------------");
	}

	private static void sample3() {
		System.out.println("--start----------- sample 3 ---------------------------");

		List<Integer> al = new ArrayList<Integer>();

		al.add(2);
		al.add(8);
		al.add(10);
		al.add(30);
		al.add(50);
		al.add(100);

		al.forEach(System.out::println);

		int index = Collections.binarySearch(al, 50);

		System.out.println("Found at index " + index);
		System.out.println("--end----------- sample 3 ---------------------------");
	}

	private static void sample4() {
		System.out.println("--start----------- sample 4 ---------------------------");

		// Create a list
		List<Domain> l = new ArrayList<Domain>();
		l.add(new Domain(10, "quiz.geeksforgeeks.org"));
		l.add(new Domain(20, "practice.geeksforgeeks.org"));
		l.add(new Domain(30, "code.geeksforgeeks.org"));
		l.add(new Domain(40, "www.geeksforgeeks.org"));
		l.add(new Domain(5, "www.parenteIsGeek.org"));

		Comparator<Domain> c = new Comparator<Domain>() {
			public int compare(Domain u1, Domain u2) {
				return u1.getId().compareTo(u2.getId());
			}
		};
		
		

		// Searching a domain with key value 10. To search
		// we create an object of domain with key 10.
		int index = Collections.binarySearch(l, new Domain(40, null), (Domain u1, Domain u2) -> u1.getId().compareTo(u2.getId()));
		System.out.println("Found at index  " + index);
		
		int indexBis = Collections.binarySearch(l, new Domain(40, null), (Domain u1, Domain u2) -> u1.getId().compareTo(u2.getId()));
		System.out.println("Found at indexBis  " + indexBis);

		// Searching an item with key 5
		index = Collections.binarySearch(l, new Domain(5, null), c);
		System.out.println(index);

		System.out.println("--end----------- sample 4 ---------------------------");
	}

}

//A user-defined class to store domains with id and url
class Domain implements Comparable<Domain>{
	private int id;
	private String url;

// Constructor
	public Domain(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public Integer getId() {
		return Integer.valueOf(id);
	}

	@Override
	public int compareTo(Domain another) {
		return new Integer(this.id).compareTo(another.getId());
	}
}