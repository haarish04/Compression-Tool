import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;


public class InputFileReader {

    public String readFile(String filePath) throws IOException{

        Path path = Paths.get(filePath);
        BufferedReader br = null;

        try{
            br= Files.newBufferedReader(path);
            String line= br.readLine();
    
            //System.out.println(line);

            return line;
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
