import java.io.Serializable;
public class Node<E> implements Serializable  {
	private E data;
	private Node<E> next;
	private Node<E> prev;
	public Node(E data) {
		this.data = data;
	}
	public E getElement() {
		return data;
	}
	public Node<E> next() {
		return next;
	}
	public Node<E> prev() {
		return prev;
	}
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
	public void setPrev(Node<E> newPrev) {
		prev = newPrev;
	}

	public void setElement(E dat){
		data = dat;
	}
	public String toString() {
		return data.toString();
	}
  
}