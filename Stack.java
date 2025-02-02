
public class Stack<E> {
    private DLList<E> stack;
    public Stack(){
        stack = new DLList<E>();
    }

    public void push(E data){
        stack.add(data);
    }
    public E pop(){
        E temp = this.peek();
        stack.removeitem(this.peek());
        return temp;
    }
   
    public E peek(){
        E temp = stack.getLastItem().getElement();
        //System.out.println("temp " + temp);
        return temp;
    }

    public int size(){
        return stack.size();
    }
    public boolean empty(){
        if (size() == 0){
            return true;
        } else {
            return false;
        }
    }

    public void shuffleDeck(){
        stack.shuffle(stack);
    }

    

    
}
