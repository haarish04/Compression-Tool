import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
    String fileName;
    OutputWriter(String fileName){
        this.fileName= fileName;
    }

    public void writeToFile(String content) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}