public class Main {
    static String file;

    public static void main(String[] args){
        String filePath= args[0];
        //System.out.println(filePath);

        try{
            InputFileReader input = new InputFileReader();
            file= input.readFile(filePath);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(file);

    }
}