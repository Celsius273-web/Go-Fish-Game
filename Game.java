public class Game{
    private Stack<Card> deck;
    private DLList<Card> clientHand;
    private DLList<Card> serverHand;
    public Game(){
        deck = new Stack<Card>();
        clientHand = new DLList<Card>();
        serverHand = new DLList<Card>();

        deck.push(new Card("fish", "red"));
        deck.push(new Card("turtle", "red"));
        deck.push(new Card("eel", "red"));
        deck.push(new Card("seahorse", "red"));
        deck.push(new Card("shark", "red"));
        deck.push(new Card("lobster", "red"));
        deck.push(new Card("whale", "red"));
       
        deck.push(new Card("fish", "orange"));
        deck.push(new Card("turtle", "orange"));
        deck.push(new Card("eel", "orange"));
        deck.push(new Card("seahorse", "orange"));
        deck.push(new Card("shark", "orange"));
        deck.push(new Card("lobster", "orange"));
        deck.push(new Card("whale", "orange"));
        
        deck.push(new Card("fish", "blue"));
        deck.push(new Card("turtle", "blue"));
        deck.push(new Card("eel", "blue"));
        deck.push(new Card("seahorse", "blue"));
        deck.push(new Card("shark", "blue"));
        deck.push(new Card("lobster", "blue"));
        deck.push(new Card("whale", "blue"));
        
        deck.push(new Card("fish", "green"));
        deck.push(new Card("turtle", "green"));
        deck.push(new Card("eel", "green"));
        deck.push(new Card("seahorse", "green"));
        deck.push(new Card("shark", "green"));
        deck.push(new Card("lobster", "green"));
        deck.push(new Card("whale", "green"));
        
        shuffle();


        
        clientHand.add(deck.pop());
        clientHand.add(deck.pop());
        clientHand.add(deck.pop());
        clientHand.add(deck.pop());
        clientHand.add(deck.pop());

        serverHand.add(deck.pop());
        serverHand.add(deck.pop());
        serverHand.add(deck.pop());
        serverHand.add(deck.pop());
        serverHand.add(deck.pop());

        System.out.println("client" + clientHand.toString());


        System.out.println("server" + serverHand.toString());
  

    }

    public void shuffle(){
        deck.shuffleDeck();
    }
    public DLList<Card> getClientHand(){
        return clientHand;
    }
    public DLList<Card> getServerHand(){
        return serverHand;
    }

    public DLList<Card> goFish(DLList<Card> cards){
        cards.add(deck.pop());
        System.out.println("Adding card to hand: " + cards.toString());
        return cards;
    }   

    public void restart(DLList<Card> discard){
        for (int i = 0; i <discard.size(); i++){
            Card temp = discard.get(i);
            deck.push(temp);
            discard.removeloc(i);
        }
        for (int i = 0; i <clientHand.size(); i++){
            Card temp = clientHand.get(i);
            deck.push(temp);
            clientHand.removeloc(i);
        }
        for (int i = 0; i <serverHand.size(); i++){
            Card temp = serverHand.get(i);
            deck.push(temp);
            serverHand.removeloc(i);
        }
        shuffle();
        
        
    }
    

}