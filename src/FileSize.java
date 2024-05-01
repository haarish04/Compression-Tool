import java.nio.charset.StandardCharsets;

public class FileSize {
    public int getFileSize(String text){

        final byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }
    
}
