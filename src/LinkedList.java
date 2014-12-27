import java.util.Collection;

public class LinkedList <E> extends Node implements List <E>{
	
	private Node Head;
	private Node Tail;
	private int size;
	
	public LinkedList (){
		this.Head = null;
		this.Tail = null;
		this.size = 0;
	}

	public void add(E element) {
		// TODO Auto-generated method stub
		Node n = new Node ((Object)element);
		if (this.isEmpty()){
			this.Head = n;
			this.Tail = n;
		}
		else{
			this.Tail.setNext(n);
			this.Tail = n;
		}
		this.size++;
	}
	
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		Node n = new Node ((Object)element);
		if (index <= (this.size()-1)){
			if (index == 0)
				this.addFirst(element);
			else if (index == (this.size()-1))
				this.add(element);
			else{
				Node x = this.Head;
				for (int i = 0; i < index-1; i++) {
					x = x.getNext();
				}
				n.setNext(x.getNext());
				x.setNext(n);
				this.size++;
			}
		}
		else 
			add(element);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addAll(Collection <Object> c) {
		// TODO Auto-generated method stub
		Object [] temp = c.toArray();
		for (int i = 0; i < temp.length; i++) {
			this.add((E)temp[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addAll(int index, Collection <Object> c) {
		// TODO Auto-generated method stub
		Object [] temp = c.toArray();
		int tracker = index;
		for (int i = 0; i < temp.length; i++) {
			this.add(tracker,(E)temp[i]);
			tracker++;
		}
	}

	@Override
	public void addFirst(E element) {
		// TODO Auto-generated method stub
		Node n = new Node ((Object)element);
		n.setNext(this.Head);
		this.Head = n;
		this.size++;
	}

	@Override
	public void addLast(E element) {
		// TODO Auto-generated method stub
		this.add(element);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.Head = null;
		this.Tail = null;
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return null;
		else{
		Node n = new Node (this.Head.getValue());
		this.Head = (this.Head).getNext();
		n.setNext(null);
		this.size--;
		return (E) n.getValue();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return null;
		else{
			Node n = new Node (this.Tail.getValue());
			Node x = this.Head;
			for (int i = 0; i < (this.size)-2; i++) {
				x = x.getNext();
			}
			x.setNext(null);
			this.Tail = x;
			this.size--;
			return (E) n.getValue();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeByIndex (int index) {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return null;
		else{
			Node n = new Node();
			if (index == 0)
				removeFirst();
			else if (index == (this.size)-1)
				removeLast();			
			else if (index > 0 && index < (this.size)-1){
				Node x = this.Head;
				for (int i = 0; i < index-1; i++) {
					x = x.getNext();
				}
				n = x.getNext();
				x.setNext(n.getNext());
				n.setNext(null);
			}
			this.size--;
			return (E)n.getValue();
		}
	}

	@Override
	public boolean remove (Object element) {
		// TODO Auto-generated method stub
		boolean found = false;
		if (this.isEmpty())
			return found;
		else{
			if (this.Head.getValue().equals(element)){
				this.removeFirst();
				found = true;
			}
			else if(this.Tail.getValue().equals(element)){
				this.removeLast();
				found = true;
			}
			else{
				Node n = this.Head;
				Node x = this.Head;
				for (int i = 0; i < this.size()-1; i++) {
					if ((n.getNext().getValue()).equals(element)){
						found = true;
						n.setNext(n.getNext().getNext());
						x = x.getNext();
						x.setNext(null);
						this.size--;
						break;
					}
					else 
						found = false;
					n = n.getNext();
					x =x.getNext();
					}
			}
			return found;
		}
	}

	@Override
	public void removeGroup(Collection <E> c) {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return;
		else{
			Object [] container = c.toArray();
			for (int i = 0; i < container.length; i++) {
				this.remove(container[i]);
			}
		}
	}

	@Override
	public void retainAll(Collection <E> c) {
		// TODO Auto-generated method stub
		if(this.isEmpty() || this.size < c.size())
			return;
		else if (this.size >= c.size()){
			Node n = this.Head;
			while (!(n.getNext()==null)){
				
				if (!c.contains(n.getValue())){
					this.remove(n.getValue());
				}
				else{
					c.remove(n.getValue());
				}
				n = n.getNext();
			}

		}
		
			
			//wait for contain and contain all. 

	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		//shall we wait for "contain" ? ... No you shall not fucking wait for it, code on. 
		if (index == 0)
			return this.getFirst();
		else if (index == this.size()-1)
			return this.getLast();
		else{
			Node n = this.Head;
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}
			return (E) n.getValue();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return (E) this.Head.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return (E) this.Tail.getValue();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int indexOf(Object element) {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return -1;
		else if((this.Head.getValue()).equals(element))
			return 0;
		else if((this.Tail.getValue()).equals(element))
			return (this.size()-1);
		else{
			Node n = this.Head;
			int index = 0;
			while (!(n.getValue()).equals(element)){
				n = n.getNext();
				index++;
			}
			return index;
		}
	}

	@Override
	public int lastIndexOf(Object element) {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return -1;
		else {
			Node n = this.Head;
			int x = 0;
			int lastIndex = -1;
			while (n.getNext()!=null){
				if (n.getValue().equals(element)){
					lastIndex = x;
				}
					x++;
					n = n.getNext();
					
			}
		return lastIndex;
		}
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		boolean found = false;
		if(this.isEmpty())
			return false;
		else if(((Object)this.getFirst()).equals(element))
			return true;
		else if(((Object)this.getLast()).equals(element))
			return true;
		else{
			Node n = this.Head;
			for (int i = 0; i < this.size()-2; i++) {
				n = n.getNext();
				if (n.getValue().equals(element)){
					found = true;
					break;
				}
				else
					found = false;
			}
		}
		return found;
	}

	@Override
	public boolean containsAll(Collection <E> C) {
		// TODO Auto-generated method stub
		boolean itDoes = true;
		if (this.isEmpty() || this.size < C.size())
			return false;
		else if (C.size() < this.size){
			Object [] container = C.toArray();
			for (int i = 0; i < container.length; i++) {
				if (!(this.contains(container[i])))
					itDoes = false;
				else 
					itDoes = true;
			}
		}
		
		return itDoes;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size()==0)
			return true;
		else 
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E [] toArray() {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return null;
		else{
			Node n = this.Head;
			Object [] container = new Object [this.size];
			for (int i = 0; i < container.length && n.getNext() != null; i++) {
				container [i] = n.getValue();
				n = n.getNext();
			}
			return (E[]) container;
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Node current = this.Head;
		System.out.print("{");
		if (this.size >= 1){
			for (int i = 1; i<=size; i++) {
				System.out.print((current.getValue()));
				if (current.getNext()!=null)
					System.out.print(", ");
				if (current.getNext() == null)
					System.out.println("}");
				current = current.getNext();
			}
		}
		else 
			System.out.println("The List is Empty}");
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (this.isEmpty()||index > this.size-1)
			return;
		else if (this.size-1 == index)
			this.Tail.setValue(element);
		else if (index == 0)
			this.Head.setValue(element);
		else{
			Node n = this.Head;
			for (int i = 0; i < index; i++) {
				n = n.getNext();
			}
			n.setValue(element);
			}
		}

	@SuppressWarnings("unchecked")
	public LinkedList <E> clone() {
		if (this.isEmpty())
			return null;
		else{
			Node n = this.Head;
			LinkedList <E> newly = new LinkedList <E> ();
			while (n.getNext()!=null){
				newly.add((E)n.getValue());
				n = n.getNext();
			}
			newly.addLast((E)n.getValue());
			return newly;
		}
	}

}
