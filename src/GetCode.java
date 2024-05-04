import java.util.Map;

public class GetCode {
    public String getMap(Map<Character, String> encode){

        StringBuilder sb= new StringBuilder();
        for(Map.Entry<Character, String> entry : encode.entrySet()){
            Character key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + " --> " + value + "\n");
        }

        return sb.toString();
    }
}
