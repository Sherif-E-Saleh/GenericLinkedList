import java.util.Collection;

/**
 * 
 */

/**
 * @author Sherif
 *
 */
public interface List <E> {

	
	Node head = null;
	Node tail = null;
	int size = 0;
	
	//adding methods 
	void add (E element);
	void add (int index, E element);
	void addAll (Collection <Object> c);
	void addAll (int index, Collection <Object> c);
	void addFirst (E element);
	void addLast (E element);
	
	//removing methods
	void clear();
	E removeFirst();
	E removeLast();
	E removeByIndex (int index);
	boolean remove (E element);
	void removeGroup(Collection <E> c);
	void retainAll (Collection <E> c);
	
	//retrieving methods
	E get(int index);
	E getFirst();
	E getLast();
	int size();
	
	//indexing methods
	int indexOf(E element);
	int lastIndexOf(E element);
	
	//checking methods
	boolean contains(E element);
	boolean containsAll (Collection <E> C);
	boolean isEmpty();
	
	//copying
	LinkedList <E> clone();
	
	//Arraying 
	E [] toArray();
	
	//printing (iterator)
	void print();
	
	//editing 
	void set(int index, E element);
	
}
