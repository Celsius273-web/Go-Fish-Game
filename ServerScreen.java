import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.net.*;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;

// 
// public class ServerScreen extends JPanel implements ActionListener{
// 	private ObjectOutputStream outObj;
//     private Game gameOBJ = new Game();
// 	private DLList<Card> svhand;
// 	private DLList<Card> clhand;
// 	private DLList<Card> discard;
// 	private JTextField done;
// 	private JButton goFish;
// 	private JButton newGame;
// 	private JTextArea list;
//     private JScrollPane scrollPane; 
// 	
// 	public ServerScreen(){
//         
//         this.setLayout(null);
//         setFocusable(true);
// 		svhand = gameOBJ.getServerHand();
// 		clhand = gameOBJ.getClientHand();
// 		discard = new DLList<Card>();
// 
// 		done = new JTextField(); 
// 		done.setBounds(10,10, 200, 30); 
// 		done.addActionListener(this);
// 		this.add(done);
//         this.setFocusable(true);
// 
// 		goFish = new JButton("Go Fish!!");
//         goFish.setBounds(5, 35, 100, 30); 
//         goFish.addActionListener(this); 
//         this.add(goFish);
// 
// 		newGame = new JButton("New Game");
//         newGame.setBounds(5, 65, 100, 30); 
//         newGame.addActionListener(this); 
//         this.add(newGame);
// 
// 		list = new JTextArea(); 
// 		list.setBounds(10,200,400,100);
// 		list.setEditable(false);
// 		list.setFont(new Font("Arial", Font.ITALIC, 16));
// 		list.setText("Go Fish is a game where players compete to get rid of their cards by making pairs. Each player starts with 5 cards and tries to make as many pairs as possible. Then a player asks another player if they have that card. This is done by typing the location of one card, on your screen starting from 0 going from left to right, in the text field and pressing enter. If they have the card they are required to give it. Or a player can choose to draw a Card( the Go Fish Button) This continues until one player runs out of cards (this person wins) or until the deck is finished (tie). The client always starts. Below the Go Fish button there is a new game button to restart (for server only).");
//         this.add(list);
//         scrollPane = new JScrollPane(list);
// 		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
// 		scrollPane.setBounds(10,200,300,100);
// 
// 		this.add(scrollPane);
// 
// 
// 	}
// 
// 
// 	public Dimension getPreferredSize() {
// 		return new Dimension(800,600);
// 	}
// 
// 	public void paintComponent(Graphics g) {
// 		super.paintComponent(g);
// 		g.setColor(Color.LIGHT_GRAY);
// 		g.fillRect(0,0,800,600);
// 		
//         for (int j = 0; j < svhand.getSize(); j++){
// 			Card cd = svhand.get(j);
// 			if (cd != null){
// 				drawMe(g, j*100 + 100, 40, cd);
// 			} 
// 
//         }
// 		Font font2 = new Font("Arial", Font.PLAIN, 50);
// 		g.setFont(font2);
// 		g.setColor(Color.black);
//         
// 	
// 
// 
//         if (svhand.size() == 0){
// 			g.drawString("Server Wins", 50, 400);
// 		} 
// 		if (clhand.size() == 0){
// 			g.drawString("Client Wins", 80, 400);
// 		} 
// 	} 
// 
// 	public void drawMe(Graphics g, int x, int y, Card cd){
//         g.setColor(Color.white);
//         g.fillRect(x,y,100,130);
//         g.setColor(Color.black);
//         g.drawRect(x,y,100,130);
// 		BufferedImage suitImage = null;
// 
// 		if( cd.getName().equals("fish") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/fish.png"));
// 			} catch (IOException e) {}
// 		}
//         if( cd.getName().equals("turtle") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/turtle.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("seahorse") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/seahorse.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("eel") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/eel.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("shark") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/shark.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("jellyfish") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/jellyfish.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("lobster") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/lobster.png"));
// 			} catch (IOException e) {}
// 		}
//         if ( cd.getName().equals("whale") ){
// 			try{
// 				suitImage = ImageIO.read(new File("images/whale.png"));
// 			} catch (IOException e) {}
// 		}
//         
//         g.drawImage(suitImage, x+2, y, 50, 50, null);  
//         Font font = new Font("Arial", Font.PLAIN, 15);
// 		g.setFont(font);
//         if( cd.getColor().equals("red") ){
//             g.setColor(Color.red);
//         }
//         if( cd.getColor().equals("green") ){
//             g.setColor(Color.green);
//         }
//         if( cd.getColor().equals("orange") ){
//             g.setColor(Color.orange);
//         }
//         if( cd.getColor().equals("blue") ){
//             g.setColor(Color.blue);
//         }
//         
//         g.drawString(cd.getName() + " ", x+15, y + 100);
// 		repaint();
//     }
// 
// 	public void checkMyPairs(DLList<Card> list){
// 		for (int i = 0; i<list.size(); i++){
// 			for (int j = i+1; j<list.size(); j++){
// 				//System.out.println("check pairs");
// 				if (list.get(i).compareTo(list.get(j)) == 0) {
// 					System.out.println("checked pairs");
// 					System.out.println("screen" + clhand.toString());
// 					discard.add(list.get(j));
// 					discard.add(list.get(i));
// 					list.removeitem(list.get(j));
// 					list.removeitem(list.get(i));
// 					break;
// 				}
// 			}
// 		}
// 	}
// 
// 	public void checkSVHand(DLList<Card> svcards, DLList<Card> clcards){
// 		//checking if 1 card from client hand is in server hand
// 		Card temp = clcards.get(0);
// 		for (int j = 0; j<svcards.size(); j++){
// 			if (temp.getName().equals(svcards.get(j).getName()) && temp.getColor().equals(svcards.get(j).getColor()) == false){
// 				System.out.println("check SV");
// 				discard.add(temp);
// 				discard.add(svcards.get(j));
// 				clcards.removeitem(temp);
// 				svcards.removeitem(svcards.get(j));
// 				break;
// 
// 				
// 			}
// 		}
// 	}
// 	private void sendGameState() {
// 	    try {
//     	    outObj.reset();
// 	        outObj.writeObject(svhand); // Send the server's hand
//         	outObj.writeObject(clhand); // Send the client's hand
//     	    System.out.println("Game state sent to client");
// 	    } catch (IOException e) {
//         	System.err.println("Error sending game state: " + e.getMessage());
//     	}
// 	}
// 	public void checkCLHand(DLList<Card> svcards, DLList<Card> clcards){
// 		//checking if 1 card from server hand is in client hand
// 		Card temp = svcards.get(0);
// 		for (int j = 0; j<clcards.size(); j++){
// 			if (temp.getName().equals(clcards.get(j).getName()) && temp.getColor().equals(clcards.get(j).getColor()) == false){
// 				System.out.println("check CL");
// 				discard.add(temp);
// 				discard.add(svcards.get(j));
// 				svcards.removeitem(temp);
// 				clcards.removeitem(clcards.get(j));
// 				break;
// 
// 			}
// 		}
// 	}
// 
// 	public void poll() throws IOException {
// 
// 		int portNumber = 1024;
// 
// 		ServerSocket serverSocket = new ServerSocket(portNumber); 
// 		Socket clientSocket = serverSocket.accept();
// 		outObj = new ObjectOutputStream(clientSocket.getOutputStream());
//         ObjectInputStream inObj = new ObjectInputStream(clientSocket.getInputStream());
// 		
// 		try {
// 			outObj.reset();
// 			outObj.writeObject("connection successful");
// 			outObj.reset();
// 			outObj.writeObject(clhand);
// 			
// 			
// 			while (true) {
// 				clhand = (DLList<Card>) inObj.readObject();
// 				System.out.println("read");
// 				checkMyPairs(clhand);
// 				checkSVHand(svhand, clhand);
// 				System.out.println("screen" + clhand.toString());
// 				sendGameState();
// 				
// 				repaint(); 
// 				
// 				
// 			}
// 
// 		} catch (IOException e) {
// 			System.err.println("Couldn't get I/O for the connection");
// 			System.exit(1);
//         } 	catch (ClassNotFoundException e) {
// 		 	System.err.println("Class does not exist" + e);
// 		 	System.exit(1);
// 		}
// 	}
// 
// 	public void actionPerformed(ActionEvent e){
// 		if (e.getSource() == done){ // this is for the server- it checks for pairs 
// 			int x = Integer.parseInt(done.getText());
// 			Card tem = svhand.get(x);
// 			Card tem0 = svhand.get(0);
// 			System.out.println("server" + svhand.toString());
// 			svhand.set(x, tem0);
// 			svhand.set(0, tem);
// 			checkMyPairs(svhand);
// 			checkCLHand(svhand, clhand);
// 			System.out.println("server" + svhand.toString());
// 			
// 
// 			try {
// 				System.out.println("sending?? :)");
// 				outObj.reset();
// 				outObj.writeObject(clhand);
// 			} catch (IOException m) {
// 				System.err.println("Couldn't get I/O for the connection");
// 				System.exit(1);
// 			}
// 			
// 		}
// 
// 		if (e.getSource() == goFish){
// 			if (svhand.getSize() > 0){
// 				svhand = gameOBJ.goFish(svhand);
// 			}
// 			sendGameState();
// 			repaint();
// 		}
// 		if (e.getSource() == newGame){
// 			// gameOBJ.restart(discard);
// 			// discard = null;
// 			gameOBJ = new Game();
// 			svhand = gameOBJ.getServerHand();
// 			clhand = gameOBJ.getClientHand();
// 
// 		}
// 		if (e.getSource() == newGame) {
// 			gameOBJ = new Game(); // Create a new game object
// 			sendGameState();
// 			svhand = gameOBJ.getServerHand(); // Reset server hand
// 			clhand = gameOBJ.getClientHand(); // Reset client hand
// 			discard = new DLList<>(); // Reset discard pile
// 			done.setText(""); // Clear input text field
// 			list.setText("Game reset. New game started."); // Update the instructions
// 			try {
// 				// Send updated state to client
// 				outObj.reset();
// 				outObj.writeObject(clhand);
// 			} catch (IOException ex) {
// 				System.err.println("Couldn't reset client state: " + ex.getMessage());
// 			}
//    			repaint(); // Refresh the screen
// 		}
// 		repaint();
// 	}
// 

// 
// }

public class ServerScreen extends JPanel implements ActionListener {
    private ObjectOutputStream outObj;
    private ObjectInputStream inObj;
    private Game gameOBJ;
    private DLList<Card> svhand;
    private DLList<Card> clhand;
    private DLList<Card> discard;
    private JButton goFish;
    private JButton newGame;
    private JTextArea log;

    public ServerScreen() {
        setLayout(null);
        setFocusable(true);

        gameOBJ = new Game();
        svhand = gameOBJ.getServerHand().clone();
        clhand = gameOBJ.getClientHand().clone();
        discard = new DLList<>();

        goFish = new JButton("Go Fish");
        goFish.setBounds(10, 10, 120, 30);
        goFish.addActionListener(this);
        add(goFish);

        newGame = new JButton("New Game");
        newGame.setBounds(10, 50, 120, 30);
        newGame.addActionListener(this);
        add(newGame);

        log = new JTextArea();
        log.setBounds(10, 100, 300, 400);
        log.setEditable(false);
        add(new JScrollPane(log));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw server hand
        if (svhand != null) {
            for (int i = 0; i < svhand.getSize(); i++) {
                Card card = svhand.get(i);
                drawCard(g, 150 + i * 120, 50, card);
            }
        }
    }

    private void drawCard(Graphics g, int x, int y, Card card) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 150);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 100, 150);
        g.drawString(card.getName(), x + 10, y + 20);
        g.drawString(card.getColor(), x + 10, y + 40);
    }

    private void sendGameState() {
        try {
            outObj.reset();
            outObj.writeObject(svhand.clone());
            outObj.writeObject(clhand.clone());
        } catch (IOException e) {
            log.append("Error sending game state to client.\n");
        }
    }

    public void poll() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        Socket clientSocket = serverSocket.accept();
        outObj = new ObjectOutputStream(clientSocket.getOutputStream());
        inObj = new ObjectInputStream(clientSocket.getInputStream());

        try {
            log.append("Client connected.\n");
            sendGameState();

            while (true) {
                clhand = (DLList<Card>) inObj.readObject();
                log.append("Client updated hand: " + clhand + "\n");

                repaint();
                sendGameState();
            }
        } catch (ClassNotFoundException e) {
            log.append("Class not found during client communication.\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goFish) {
            if (!gameOBJ.getDeck().isEmpty()) {
                svhand.add(gameOBJ.getDeck().pop());
                log.append("Server drew a card.\n");
            } else {
                log.append("Deck is empty.\n");
            }
            sendGameState();
            repaint();
        } else if (e.getSource() == newGame) {
            gameOBJ = new Game();
            svhand = gameOBJ.getServerHand().clone();
            clhand = gameOBJ.getClientHand().clone();
            discard = new DLList<>();
            log.append("New game started.\n");
            sendGameState();
            repaint();
        }
    }
}