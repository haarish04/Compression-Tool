import java.util.*;

public class Decoding {
    public void decodeText( Map<Character, String> encoding, BitSet bSet){

        StringBuilder codeBuilder = new StringBuilder();
        for(int i=0; i<bSet.length()-1; i++){
            if(bSet.get(i))
                codeBuilder.append("1");
            else
                codeBuilder.append("0");
        }
        String code= codeBuilder.toString();
        System.out.println("Decoded binary:\n " + code);
        StringBuilder decodedString= new StringBuilder();

        int index=0;
        StringBuilder maxMatch = new StringBuilder();

        while(index< code.length()){
            int maxLength= 0;
            for(Map.Entry<Character, String> entry : encoding.entrySet()){
                String temp = entry.getValue();

                if(code.startsWith(temp, index) && temp.length() > maxLength){
                    maxLength = temp.length();
                    maxMatch.append(temp);
                }
            }

            decodedString.append(encoding.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxMatch.toString()))
                    .findFirst()
                    .get()
                    .getKey());

            index += maxLength;
            maxMatch.setLength(0);
        }
        System.out.println("\nDecoded text:\n " + decodedString.toString());
    }
    
    
}
