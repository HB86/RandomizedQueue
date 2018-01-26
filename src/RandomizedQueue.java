import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.Random;


import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable <Item>{
	public Node first; 
	public Node last; 
	int size; 

	
	public RandomizedQueue(){
		
		first = null; 
		size = 0; 
		
	}
	
	private class Node{
		
		
		Item item; 
		Node previous; 
		Node next; 
		
		
	}
	
	
public boolean isEmpty(){
		
		return first == null; 
		
		
	}


public int size(){
	
	
	return size; 
	
}
	

public void enqueue(Item item){
	
	if(size==0){
		first = new Node(); 
		first.item = item; 
		last = first; 
		}
	
	
	else{Node oldlast = last; 
	last = new Node(); 
	last.item = item;
	last.previous = oldlast;
	oldlast.next = last;
   }
	 size++;
}


public Item dequeue(){
	
	Node pointer = RandomPointer(); 
	Item item; 
	Node left;
	Node right;
	
	if(pointer == first) {
		item = first.item;
		first = first.next;
	    first.previous = null; 
		size--; 
		
	}
	
	else if(pointer == last){
		
		item = last.item;
		last = last.previous; 
		last.next = null; 
		size--; 
		
	}
	
	
	else{
		
		item = pointer.item; 
		left = pointer.previous;
		right = pointer.next; 
		right.previous = left; 
		left.next = right;
	    pointer = null; 
		size--;
		
		
	}
	
	
	return item;
}
	


public Item sample(){
	
	Node pointer = RandomPointer(); 
	
	return pointer.item; 
	
}


private Node RandomPointer(){
	
	int random = StdRandom.uniform(size + 1); 
	Node pointer = first;
	
	for(int i = 0; i<random;i++){
		
		pointer = pointer.next; 
		
	}
	
	return pointer; 
}
	

public class ListIterator implements Iterator<Item>{

	private Node current = first; 
	

	public boolean hasNext() {
		return current != null; 
	}

	public Item next() {
		Item item = current.item;
		current = current.next; 
		return item; 
		
	}
	
		
 }




public Iterator<Item> iterator() {

	
	return new ListIterator(); 
	
	
}

public static void main(String[]args){
	
	
	RandomizedQueue<Integer> q = new RandomizedQueue<Integer>(); 
	q.enqueue(2);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	for(Integer w: q)System.out.println(w);
	System.out.println(q.size); 
	System.out.println(q.dequeue()); 
	for(Integer w: q)System.out.println(w);
	
	 
	
	
	
	
}



}






