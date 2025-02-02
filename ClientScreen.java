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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;


@SuppressWarnings("unused")
public class ClientScreen extends JPanel implements ActionListener{

	private ObjectOutputStream outObj;
    private DLList<Card> hand;
    private JTextField input;
    private JButton goFish;
    private Game gameOBJ = new Game();
    private JTextArea list;
    private JScrollPane scrollPane; 

	public ClientScreen()  {

		input = new JTextField(); 
		input.setBounds(10,10, 200, 30); 
		input.addActionListener(this);
		this.add(input);
        this.setFocusable(true); 
        
        goFish = new JButton("Go Fish!!");
        goFish.setBounds(5, 35, 100, 30);  
        goFish.addActionListener(this); 
        this.add(goFish);

		this.setLayout(null);
		
		list = new JTextArea(); 
		list.setBounds(10,200,400,100);
		list.setEditable(false);
		list.setFont(new Font("Arial", Font.ITALIC, 16));
		list.setText("Go Fish is a game where players compete to get rid of their cards by making pairs. Each player starts with 5 cards and tries to make as many pairs as possible. Then a player asks another player if they have that card. This is done by typing the location of one card, on your screen starting from 0 going from left to right, in the text field and pressing enter. If they have the card they are required to give it. Or a player can choose to draw a Card( the Go Fish Button) This continues until one player runs out of cards (this person wins) or until the deck is finished (tie). The client always starts. Below the Go Fish button there is a new game button to restart (for server only).");
        this.add(list);
        scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10,200,300,100);

		this.add(scrollPane);


	}



	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0,0,800,600);
		System.out.println(hand.toString());
		if (hand != null){
			for (int j = 0; j < hand.getSize(); j++){
				if (hand.get(j) != null){
					Card cd = hand.get(j);
					if (cd != null){
						drawMe(g, j*100 + 100, 40, cd);
					}
				}
				

        	}
    	}
    	
    	Font font2 = new Font("Arial", Font.PLAIN, 10);
		g.setFont(font2);
       





	}
	
	public void drawMe(Graphics g, int x, int y, Card cd){
        g.setColor(Color.white);
        g.fillRect(x,y,100,130);
        g.setColor(Color.black);
        g.drawRect(x,y,100,130);
		BufferedImage suitImage = null;

		if( cd.getName().equals("fish") ){
			try{
				suitImage = ImageIO.read(new File("images/fish.png"));
			} catch (IOException e) {}
		}
        if( cd.getName().equals("turtle") ){
			try{
				suitImage = ImageIO.read(new File("images/turtle.png"));
			} catch (IOException e) {}
		}
        if ( cd.getName().equals("seahorse") ){
			try{
				suitImage = ImageIO.read(new File("images/seahorse.png"));
			} catch (IOException e) {}
		}
        if ( cd.getName().equals("eel") ){
			try{
				suitImage = ImageIO.read(new File("images/eel.png"));
			} catch (IOException e) {}
		}
        if ( cd.getName().equals("shark") ){
			try{
				suitImage = ImageIO.read(new File("images/shark.png"));
			} catch (IOException e) {}
		}
       
        if ( cd.getName().equals("lobster") ){
			try{
				suitImage = ImageIO.read(new File("images/lobster.png"));
			} catch (IOException e) {}
		}
        if ( cd.getName().equals("whale") ){
			try{
				suitImage = ImageIO.read(new File("images/whale.png"));
			} catch (IOException e) {}
		}

		// if ( cd.getName().equals("jellyfish") ){
		// 	try{
		// 		suitImage = ImageIO.read(new File("images/jellyfish.png"));
		// 	} catch (IOException e) {}
		// }
        
        g.drawImage(suitImage, x+2, y, 50, 50, null);  
        Font font = new Font("Arial", Font.PLAIN, 15);
		g.setFont(font);
        if( cd.getColor().equals("red") ){
            g.setColor(Color.red);
        }
        if( cd.getColor().equals("green") ){
            g.setColor(Color.green);
        }
        if( cd.getColor().equals("orange") ){
            g.setColor(Color.orange);
        }
        if( cd.getColor().equals("blue") ){
            g.setColor(Color.blue);
        }
        
        g.drawString(cd.getName() + " ", x+15, y + 100);
    }


	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}


	public void poll() throws IOException {
		int portNumber = 1024;
		String hostName = "localhost";
		
		Socket serverSocket = new Socket(hostName, portNumber);
		outObj = new ObjectOutputStream(serverSocket.getOutputStream());
		ObjectInputStream inObj = new ObjectInputStream(serverSocket.getInputStream());

		try {
			String str = " ";
			str = (String) inObj.readObject();

        	System.out.println(str);
        	hand = (DLList<Card>) inObj.readObject();
        	//discard = (DLList<Card>) inObj.readObject();
        	repaint();
			// while (true) {
// 				System.out.println("waiting for cards from server");
// 				hand = (DLList<Card>) inObj.readObject();
// 				repaint();
// 
// 			}
			while (true) {
            // Read the updated hands from the server
            	hand = (DLList<Card>) inObj.readObject(); // Client's hand
            	DLList<Card> serverHand = (DLList<Card>) inObj.readObject(); // Server's hand

            	System.out.println("Updated hands received: " + hand.toString());
            	repaint(); // Refresh the client screen
        	}
		} catch (ClassNotFoundException e) {
			System.err.println("Class does not exist" + e);
			System.exit(1);
		} 
		catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == input){
			try{
				System.out.println("input ");
				int x = Integer.parseInt(input.getText());
				Card tem = hand.get(x);
				Card tem0 = hand.get(0);
				hand.set(x, tem0);
				hand.set(0, tem);
			
			//try {
				outObj.reset();
				outObj.writeObject(hand);
			} catch (IOException m) {
				System.err.println("Couldn't get I/O for the connection");
				System.exit(1);
			}

		}
		
		if (e.getSource() == goFish){
			if (hand.getSize() > 0){
				hand = gameOBJ.goFish(hand);
			}
		}
		repaint();

	}
	

    

}
