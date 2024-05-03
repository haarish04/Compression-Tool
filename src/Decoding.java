import java.util.*;

public class Decoding {
    StringBuilder decodedString= new StringBuilder();

    public void decodeText( Map<Character, String> encoding, BitSet bSet){
        //Constructing the string using the bitSet, all the indices which are set in BitSet, signify the indices of 1 in the string, rest are 0 
        //BitSet.length()-1 as we have an additional 1 at the end to mark the end of bitSet
        //This is required when string length is below 64 bits as that is the minimum space allocated and we should not traverse full bitset in those conditions
        StringBuilder codeBuilder = new StringBuilder();
        for(int i=0; i<bSet.length()-1; i++){
            if(bSet.get(i))
                codeBuilder.append("1");
            else
                codeBuilder.append("0");
        }
        String code= codeBuilder.toString();
        //System.out.println("Decoded binary:\n" + code);
        int index=0;
        StringBuilder maxMatch = new StringBuilder();

        //Traverse through the string and pattern match for codes from the map to identify characters
        while(index< code.length()){
            int maxLength= 0;
            for(Map.Entry<Character, String> entry : encoding.entrySet()){
                String temp = entry.getValue();

                if(code.startsWith(temp, index) && temp.length() > maxLength){
                    maxLength = temp.length();
                    maxMatch.append(temp);
                }
            }
            //Append the character to the decoded string once found

            decodedString.append(encoding.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxMatch.toString()))
                    .findFirst()
                    .get()
                    .getKey());

            index += maxLength;
            maxMatch.setLength(0);
        }
    }

    public String getdecodedString(){
        return decodedString.toString();
    }
}