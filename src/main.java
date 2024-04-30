public class Main {
    static String file;

    public static void main(String[] args){
        String filePath= args[0];
        String operation = args[1];
        // System.out.println(filePath);
        // System.out.println(operation);

        String code;

        try{
            InputFileReader input = new InputFileReader();
            file= input.readFile(filePath);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


            
        Encoding encode= new Encoding();
        code = encode.createEncoding(file);
        System.out.println("\nThe encoded text is:");
        System.out.println(code +"\n");
    
            
        Decoding decode = new Decoding();
        decode.decodeText(code, encode.encoding);
            

    }
}