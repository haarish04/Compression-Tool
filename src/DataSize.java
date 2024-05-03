import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class DataSize {
    public int getFileSize(Object data){
        if (data instanceof String) {
            final byte[] utf8Bytes = ((String) data).getBytes(StandardCharsets.UTF_8);
            return utf8Bytes.length;
        } else if (data instanceof BitSet) {
            return ((BitSet) data).size();
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }
}
