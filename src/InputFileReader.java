import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class InputFileReader {

    public String readFile(String filePath) throws IOException{

        Path path = Paths.get(filePath);
        BufferedReader br = null;

        try{
            br= Files.newBufferedReader(path);
            String content = br.lines().collect(Collectors.joining("\n"));
    
            //System.out.println(content);

            return content;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
        finally{
            if(br != null)
                br.close();
        }
    }
}
