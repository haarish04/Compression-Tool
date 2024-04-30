import java.util.*;

public class Decoding {
    String originalText;
    public void decodeText(String code, Map<Character, String> encoding){
        
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
        originalText = decodedString.toString();
        System.out.println("\nDecoded text:\n " + originalText);
    }
    
    
}
