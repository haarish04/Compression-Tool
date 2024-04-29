import java.util.*;

class Node{
    Character ch;
    Integer freq;
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
    public void createTree(String text){

        //Case where there is no content in the file
        if(text== null || text.length()==0)
            return;
        

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
        while(pq.size()!=1){

            //take the two smallest freq from queue and start constructing a tree
            Node left= pq.poll();
            Node right= pq.poll();
            Integer sum= left.freq + right.freq;

            //Create a new node with the sum of the two nodes freq and add it to the queue
            pq.add(new Node(null, sum, left, right));
        }




    }



    
}
