public class Main {
    static String file;

    public static void main(String[] args){
        String filePath= args[0];

        String code;

        try{
            InputFileReader input = new InputFileReader();
            file= input.readFile(filePath);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Encode the file to bits and write contents to output file

        Encoding encodeFile= new Encoding();
        code = encodeFile.createEncoding(file);
        OutputWriter out = new OutputWriter("output.txt");    
        out.writeToFile("The file has been encoded as:\n\n"+code);
        out.writeToFile("\n\n<------------------------------------------------------------------->");

        //Display the encoding scheme of the characters and their bit sequence
        GetCode gc = new GetCode();
        out.writeToFile("\n\nThe encoding scheme for the text file");
        out.writeToFile(gc.getMap(encodeFile.getEncoding()));
        out.writeToFile("\n\n<------------------------------------------------------------------->\n\n");
            

        //Decode the encoding and write contents to output file
        Decoding decodeFile = new Decoding();
        decodeFile.decodeText(encodeFile.getEncoding(), encodeFile.getBitSet());
        String decodedString= decodeFile.getdecodedString();
        out.writeToFile("\n\nThe file contents after decoding:\n\n"+decodedString);
        out.writeToFile("\n\n<------------------------------------------------------------------->\n\n");
        

        //Check if original input file and final decoded file match
        DataChecker check= new DataChecker();
        String checkIntegrity= check.dataCheck(file, decodedString);
        out.writeToFile(checkIntegrity);
        out.writeToFile("\n\n<------------------------------------------------------------------->\n\n");

        DataSize ds = new DataSize();
        out.writeToFile("The original file size: "+ds.getFileSize(file)+" bytes\n");
        out.writeToFile("The encoded file size: "+(ds.getFileSize(encodeFile.bitSet))/8+" bytes");

        System.out.println("\nEncoding/Decoding executed successfully\n");
    }
}