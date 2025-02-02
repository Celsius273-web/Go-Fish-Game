import java.io.Serializable;
public class DLList<E> implements Serializable {
    private Node<E> head = new Node<E>(null);
    private Node<E> tail = new Node<E>(null);
    private int size;
    
    public DLList(){
        size = 0;
        head.setNext(tail);
        head.setPrev(null);
        tail.setNext(null);
        tail.setPrev(head);

    }

    public Node<E> getHead(){
        return head;
    }

    
    public void add(E data){
		Node<E> temp = new Node<E>(data);
		temp.setNext(tail);
		temp.setPrev(tail.prev());
		tail.prev().setNext(temp);
		tail.setPrev(temp);
        size++;

        //System.out.println("XXXX" + toString());
    }

    public void removeloc(int loc){
        Node<E> curr = head.next();
        int x = loc;
        while (x > 0){
            x--;
            curr = curr.next();
            
        }
        curr.prev().setNext(curr.next());
        curr.next().setPrev(curr.prev());
        size--;
    }

    public Node<E> getLastItem(){
        return tail.prev();
    }

    public void removeitem(E element){
        Node<E> curr = head.next();
        while (curr.getElement() != null){
            if (curr.getElement().equals(element)){
                curr.prev().setNext(curr.next());
                curr.next().setPrev(curr.prev());
                size--;
            }
            curr = curr.next();
        }
    }

    public void set(int index, E data){
        Node<E> temp = getNode(index);
        temp.setElement(data);
    }

    public int size(){
        return size;
    }

    public Node<E> getNode(int loc){
        Node<E> curr = head.next();
        int x = 0;
        while (x < loc){
            x++;
            curr = curr.next();
            
        }
        return curr;
    }

    public E get(int j){
        Node<E> curr = head.next();
        for (int i = 0; i<size; i++){
            if (i == j){
                return curr.getElement();
            }
            curr = curr.next();
        }
        return null;
    }
    public int getSize(){
        return size;
    }
    

    public boolean containsName(String s){
        Node<E> curr = head.next();
        while (curr != null) {
            if (curr.next() != null) {
                if (((Card) curr.getElement()).getName().equals(s)){
                   return true;
                }
            }
            curr = curr.next();
        }
        return false;
    }

    public void shuffle(DLList<E> deck){
        int ss = deck.getSize();
		for (int i = 0; i<ss; i++){
            int j = (int)(Math.random()*ss);
            int k = (int)(Math.random()*ss);
            E temp1 = deck.getNode(k).getElement();
            E temp2 = deck.getNode(j).getElement();

            deck.set(k, temp2);
            deck.set(j, temp1);

        }
	}
    @Override
	public DLList<Card> clone() {
   	 	DLList<Card> copy = new DLList<>();
   		for (Card card : this) { // Assuming DLList supports iteration
        	copy.add(new Card(card.getName(), card.getColor())); // Deep copy each card
    	}
    	return copy;
	}


    public String toString(){
        String s = " ";
        Node<E> curr = head.next();
        while (curr != null && curr != this.tail) {
            s += curr.getElement();
            if (curr.next() != null) {
                s += ", ";
            }
            curr = curr.next();
        }
        return s;
    }
}
