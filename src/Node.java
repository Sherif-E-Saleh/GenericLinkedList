
public class Node {

	private Object value;
	private Node next;
	
	Node(){
		this.value = null;
		this.next = null;
	}
	Node (Object x){
		this.value = x;
		this.next = null;	
	}
	//new addition
	Node (Object x, Node nextNode){
		this.value = x;
		this.next = nextNode;
	}
	void setNext (Node h){
		this.next = h;
	}
	Node getNext (){
		return next;
	}
	void setValue (Object x){
		this.value = x;
	}
	
	Object getValue (){
		return value;
	}
}
