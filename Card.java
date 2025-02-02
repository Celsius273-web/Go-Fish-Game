import java.io.Serializable;
public class Card implements Comparable<Card>, Serializable {

    private String name;
    private String color; 
    public Card(String name, String col){
		this.name = name;
		this.color = col;
	
	}

    public String getColor(){
        return color;
    }
    public String getName(){
        return this.name;
    }

    public String toString(){
        return name + " " + color;

    }


    // public boolean equals(Object o) {
    //     Card cd = (Card)o;
    // 	if  (name.equals(cd.getName())){
    //         return true;
    //     }
    		
    //     return false;
    
    		
    // }
   

    public int compareTo(Card t){
        
        if (name.equals(t.getName())){
            return 0;
        }
        return -1;
       
    }
}
