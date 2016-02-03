

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/*
 * Program to implement union,Intersection and difference among two lists.
 */
public class ListOperations {
	/*
	 * Test Main.
	 */
	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> outList = null;
		Scanner scannerChoice = null;
		System.out.println("Please Enter the length of first list");
		Scanner limit1scanner = new Scanner(System.in);
		Integer limit1 = limit1scanner.nextInt();
		System.out.println("Please Enter elements of first list");
		Scanner element1Scanner = null;
		while (limit1 > 0) {
			element1Scanner = new Scanner(System.in);
			addElements(list1, element1Scanner.nextInt());
			--limit1;
		}
		System.out.println("Please Enter the length of second list");
		Scanner limit2scanner = new Scanner(System.in);
		Integer limit2 = limit2scanner.nextInt();
		System.out.println("Please Enter elements of second list");
		Scanner element2Scanner = null;
		while (limit2 > 0) {
			element2Scanner = new Scanner(System.in);
			addElements(list2, element2Scanner.nextInt());
			--limit2;
		}

		while (true) {

			while (true) {
				System.out.println("Please Enter your choice.");
				System.out.println(" 1 : Find Intersection of elements.");
				System.out.println(" 2 : Find union of elements.");
				System.out.println(" 3 : Find difference of elements(Elements present in List1 and not in List2)");
				System.out.println(" 4 : Exit");

				scannerChoice = new Scanner(System.in);
				String choice = scannerChoice.next();
				if (choice.trim().equals("1")) {
					outList = new ArrayList<>();
					intersect(list1, list2, outList);
					printElements(outList);

				} else if (choice.trim().equals("2")) {
					outList = new ArrayList<>();
					union(list1, list2, outList);
					printElements(outList);

				} else if (choice.trim().equals("3")) {
					outList = new ArrayList<>();
					difference(list1, list2, outList);
					printElements(outList);

				} else if (choice.trim().equals("4")) {

					break;
				} else {
					System.out.println("Invalid choice");
				}
			}

		}

	}

	/*
	 * The input list l1 and l2 will contain non duplicate elements in sorted
	 * order. outList is an empty list created by the calling program. The
	 * elements common to l1 and l2 are inserted into outList in sorted order.
	 * Since outputList implement set interface it should not contain duplicate
	 * elements.
	 */
	public static <T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) {
        //element1 - List1 element.
		//element2 - List2 element.
		//list1Iterator -Iterator for list1.
		//list2Iterator -Iterator for list2.
		T element1 = null;
		T element2 = null;
		Iterator<T> list1Iterator = null;
		Iterator<T> list2Iterator = null;
		if (null != l1) {
			list1Iterator = l1.listIterator();
		}
		if (null != l2) {
			list2Iterator = l2.listIterator();
		}

		element1 = nextElement(list1Iterator);
		element2 = nextElement(list2Iterator);

		while (element1 != null && element2 != null) {
			// if element1 and element2 are equal add it to the output list.
			if (element1.compareTo(element2) < 0) {

				element1 = nextElement(list1Iterator);
			} else if (element1.compareTo(element2) > 0) {

				element2 = nextElement(list2Iterator);
			} else {
				outList.add(element1); // Output is a set, so it should have no
										// duplicates.
				element1 = nextElement(list1Iterator);
				element2 = nextElement(list2Iterator);
			}
		}

	}

	/*
	 * The input list l1 and l2 will contain non duplicate elements in sorted
	 * order. outList is an empty list created by the calling program. All
	 * elements common to l1 and l2 are inserted into outList in sorted order.
	 * Since outputList implement set interface it should not contain duplicate
	 * elements.
	 */
	public static <T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
		//element1 - List1 element.
		//element2 - List2 element.
		//list1Iterator -Iterator for list1.
		//list2Iterator -Iterator for list2.
		T element1 = null;
		T element2 = null;
		Iterator<T> list1Iterator = null;
		Iterator<T> list2Iterator = null;
		if (null != l1) {
			list1Iterator = l1.listIterator();
		}
		if (null != l2) {
			list2Iterator = l2.listIterator();
		}

		element1 = nextElement(list1Iterator);
		element2 = nextElement(list2Iterator);

		while (element1 != null && element2 != null) {
			// Fetch nextElement once current element is added to the list.
			if (element1.compareTo(element2) < 0) {
				outList.add(element1);
				element1 = nextElement(list1Iterator);
			} else if (element1.compareTo(element2) > 0) {
				outList.add(element2);

				element2 = nextElement(list2Iterator);
			} else {
				outList.add(element1);
				element1 = nextElement(list1Iterator);
				element2 = nextElement(list2Iterator);
			}
		}
		// copy the remaining elements from list1.
		while (null != element1) {
			outList.add(element1);
			element1 = nextElement(list1Iterator);
		}
		// copy the remaining elements from list2.
		while (null != element2) {
			outList.add(element2);
			element2 = nextElement(list2Iterator);
		}

	}

	/*
	 * The input list l1 and l2 will contain non duplicate elements in sorted
	 * order. outList is an empty list created by the calling program. All
	 * elements which are present in l1 and not present in l2 are inserted into
	 * outList in sorted order. Since outputList implement set interface it
	 * should not contain duplicate elements.
	 */
	public static <T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
        //element1 - List1 element.
		//element2 - List2 element.
		//list1Iterator -Iterator for list1.
		//list2Iterator -Iterator for list2.
		T element1 = null;
		T element2 = null;
		Iterator<T> list1Iterator = null;
		Iterator<T> list2Iterator = null;
		if (null != l1) {
			list1Iterator = l1.listIterator();
		}
		if (null != l2) {
			list2Iterator = l2.listIterator();
		}

		element1 = nextElement(list1Iterator);
		element2 = nextElement(list2Iterator);

		while (element1 != null && element2 != null) {
			// if element1 < element2 add it to the list.
			if (element1.compareTo(element2) < 0) {
				outList.add(element1);
				element1 = nextElement(list1Iterator);
			} else if (element1.compareTo(element2) > 0) {

				element2 = nextElement(list2Iterator);
			} else {

				element1 = nextElement(list1Iterator);
				element2 = nextElement(list2Iterator);
			}
		}
		// copy the remaining elements from list1.
		while (null != element1) {
			outList.add(element1);
			element1 = nextElement(list1Iterator);
		}

	}

	/*
	 * This method will retrieve the next element in the list.
	 */
	public static <T extends Comparable<? super T>> T nextElement(Iterator<T> listIterator) {
		T element = null;
		if (null != listIterator && listIterator.hasNext()) {
			element = listIterator.next();
		}
		return element;
	}
	/*
	 * This method will print the elements of the array
	 */

	public static <T extends Comparable<? super T>> void printElements(List<T> list) {
		System.out.println("The output list is");
		if (list.size() == 0) {
			System.out.println("Sorry there is no element to show");
		} else {
			for (T element : list) {
				System.out.println(element); 
			}
		}
	}

	/*
	 * This method will add elements into the List.
	 */
	public static <T extends Comparable<? super T>> void addElements(List<T> list, T element) {
		list.add(element);
	}
}
