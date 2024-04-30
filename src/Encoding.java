import java.util.*;

class Node{
    Character ch;
    int freq;
    Node left=null;
    Node right= null;

    Node(Character ch, Integer freq){
        this.ch=ch;
        this.freq=freq;
    }

    public Node(Character ch, Integer freq, Node left, Node right)
    {
        this.ch=ch;
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}

public class Encoding {
    Map<Character, String> encoding= new HashMap<>();
    String code;

    public String createEncoding(String text){

        //Case where there is no content in the file
        if(text== null || text.length()==0)
            return "";
        

        //Create map of characters and frequencies
        Map<Character,Integer> freq= new HashMap<>();
        for(char ch: text.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

        
        //Create a priotity queue that stores nodes in the tree
        //Lowest frequency = Highest Priority
        PriorityQueue<Node> pq= new PriorityQueue<>(Comparator.comparingInt(node->node.freq));


        //Create nodes using the freq map and add them to the pq queue based on their freq
        for(var entry: freq.entrySet())
            pq.add(new Node(entry.getKey(), entry.getValue()));
        

        //Run loop until there is only one node left in the queue
        //Checking for I node in queue becoz all the nodes must pair up leaving only one node at the end which would be the root of the tree
        while(pq.size()!=1){

            //take the two smallest freq from queue and start constructing a tree
            Node left= pq.poll();
            Node right= pq.poll();
            Integer sum= left.freq + right.freq;

            //Create a new node with the sum of the two nodes freq and add it to the queue
            pq.add(new Node(null, sum, left, right));
        }

        //The node at the top will be the root
        Node root= pq.peek();


        //Create a map to store the encoding for each character

        //Iterate through the queue and create the bit encoding for each node in the tree
        encodeData(root, "", encoding);
        code= displayEncoding(encoding, text);

        return code;

    }

    public static void encodeData(Node root, String str, Map<Character, String> encoding){
        //Base case
        if(root== null)
            return;

        //If the node is a leaf node, add the encoding to the map
        if(root.left == null && root.right == null)
            encoding.put(root.ch, str.length()> 0 ? str : "1");
        
        encodeData(root.left, str + "0", encoding);
        encodeData(root.right, str + "1", encoding);
    }
    
    public static String displayEncoding(Map< Character, String> encoding, String text){
        //Iterate through the text and print the encoding for each character

        StringBuilder sb= new StringBuilder();
        for(char c: text.toCharArray())
            sb.append(encoding.get(c));
        return sb.toString();

    }

    
}
