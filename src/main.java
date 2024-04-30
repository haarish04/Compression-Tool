public class Main {
    static String file;

    public static void main(String[] args){
        String filePath= args[0];
        String operation = args[1];
        System.out.println(filePath);
        System.out.println(operation);

        try{
            InputFileReader input = new InputFileReader();
            file= input.readFile(filePath);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        switch(operation){
            case "-e": 
            {
                Encoding encode= new Encoding();
                encode.createEncoding(file);
                break;
            }

            case "-d":
            {
                Decoding decode = new Decoding();
                break;
            }

            default:
                System.out.println("Invalid operation");
                break;
        }




    }
}