import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;


public class InputFileReader {

    public void readFile(String filePath) throws IOException{

        Path path = Paths.get(filePath);
        BufferedReader br = null;

        try{
            br= Files.newBufferedReader(path);
            String line= br.readLine();
    
            System.out.println(line);
        }
        finally{
            if(br != null)
                br.close();
        }

    }
    
}
